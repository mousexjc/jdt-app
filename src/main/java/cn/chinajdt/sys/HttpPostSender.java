package cn.chinajdt.sys;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Map;

import com.google.gson.Gson;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.log4j.Logger;

public class HttpPostSender {
	
	public static final String  SERV_ENCODING_DEFAULT = "UTF-8";
    public static final Integer CONN_TIMEOUT_DEFAULT = 80000;

    /**
     * post 方式请求http接口
     * @return
     * @throws Exception
     */
    public static String post(HttpClient client,String reqUrl,Map<String,String> param,String servEncoding,Integer connTimeout )throws Exception {
        NameValuePair[] _nvps = null ;
        if( null!=param && param.size()>0 )
        {
        	_nvps = new NameValuePair[param.size()] ;
        	int _index = 0 ;
        	for( Iterator<String> it = param.keySet().iterator() ;it.hasNext() ;)
        	{
        		String _key = it.next() ;
        		_nvps[_index] = new NameValuePair( _key , param.get(_key)) ;
        		_index ++ ;
        	}
        }
        return post(client, reqUrl, _nvps, servEncoding, connTimeout ) ;
    }
    
    public static String post(HttpClient client,String reqUrl,NameValuePair[] nvps,String servEncoding,Integer connTimeout )throws Exception {
    	client.getHttpConnectionManager().getParams().setConnectionTimeout( connTimeout!=null?connTimeout : CONN_TIMEOUT_DEFAULT);
    	PostMethod _method = new PostMethod(reqUrl);
    	_method.setRequestBody(nvps);
        try {
        	_method.getParams().setContentCharset( (null!=servEncoding && !servEncoding.trim().equals(""))?servEncoding:SERV_ENCODING_DEFAULT);
            int _reqStatus = client.executeMethod(_method);
            if (200 != _reqStatus) {
                throw new Exception("HTTPPost请求出错URL:[" + reqUrl + "]请求状态[" + _reqStatus + "]");
            }
            InputStream _in = _method.getResponseBodyAsStream();
            BufferedReader _reader = new BufferedReader(new InputStreamReader(_in));
            StringBuffer _strBuffer = new StringBuffer();
            String _str = "";
            while (null != (_str = _reader.readLine())) {
                _strBuffer.append(_str);
            }
            Logger.getLogger(HttpPostSender.class).info("HTTP_LOG:"+ new Gson().toJson(nvps)+"|Result:"+_strBuffer);
            return _strBuffer.toString();
        } catch (IOException e) {
            throw new Exception("HTTPPost求情出错URL:[" + reqUrl + "]" + e.toString());
        } finally {
            _method.releaseConnection();
        }
    }

}
