package cn.chinajdt.utils;

import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

/**
 * Created by Jacky on 15/11/24.
 */
public abstract class StringUtil {

    public static String getUUid(){
        return UUID.randomUUID().toString().replaceAll("-","") ;
    }

    public static String MD5Encrypt(String str) {
        BASE64Encoder base64en = new BASE64Encoder();
        try {
            MessageDigest _md5 = MessageDigest.getInstance("MD5");
            String _result = base64en.encode( _md5.digest(str.getBytes("utf-8")));
            return _result ;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null ;
    }

}
