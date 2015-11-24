package cn.chinajdt.utils;

import cn.chinajdt.sys.exception.BsnException;
import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Jacky on 15/11/20.
 */
public abstract class FileUtil {

    public static final String UPLOAD_DERECTORY_DEFAULT = "/resources/upload/" ;


    public static List<String> uploadMultipartRequest( HttpServletRequest request ) throws BsnException {
        return uploadMultipartRequest( request , null ) ;
    }

    public static List<String> uploadMultipartRequest( HttpServletRequest request ,String directory ) throws BsnException{
        if( directory == null || directory.trim().equals("")) directory = UPLOAD_DERECTORY_DEFAULT ;
        List<String> _pathlist = new ArrayList<String>();
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
        if(multipartResolver.isMultipart(request)){
            MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
            Iterator<String> iter = multipartRequest.getFileNames();
            while(iter.hasNext()){
                MultipartFile file = multipartRequest.getFile((String)iter.next());
                if( file.getSize() <= 0) continue ;
                String fileName =file.getOriginalFilename();
                String path = request.getSession().getServletContext().getRealPath("")+ directory.trim() + fileName ;
                File localFile = new File(path);
                try {
                    file.transferTo(localFile);
                    _pathlist.add(path);
                } catch (IllegalStateException e) {
//                    e.printStackTrace();
                    throw new BsnException("文件上传出错!") ;
                } catch (IOException e) {
//                    e.printStackTrace();
                    throw new BsnException("文件上传出错!") ;
                }
            }
        }
        return _pathlist ;
    }

    public static ResponseEntity<byte[]> getResponseEntity( HttpServletRequest request , String filePath , String fileName ) throws BsnException {
        String _houzhui = filePath.substring( filePath.lastIndexOf(".")) ;
        if( fileName==null || fileName.trim().equals(""))
            fileName = filePath.substring(filePath.lastIndexOf("/")+1,filePath.lastIndexOf(".") ) ;
        fileName += _houzhui ;
        try {
            fileName = new String( fileName.getBytes("UTF-8"),"iso-8859-1"); //为了解决中文名称乱码问题
        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
            throw new BsnException("文件名转码出错!") ;
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM );
        headers.setContentDispositionFormData("attachment", fileName);
        File _file = new File( request.getSession().getServletContext().getRealPath("")+ filePath );
        try {
            return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(_file),
                    headers, HttpStatus.CREATED);
        } catch (IOException e) {
//            e.printStackTrace();
            throw new BsnException("文件出错!") ;
        }
    }

    public static ResponseEntity<byte[]> getResponseEntity( HttpServletRequest request , String filePath ) throws BsnException {
        return getResponseEntity( request , filePath , null ) ;
    }

}
