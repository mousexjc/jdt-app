package cn.chinajdt.utils;

import java.util.Collection;

/**
 * Created by Jacky on 15/11/25.
 */
public class Common {

    public static boolean empty(Object obj ){
        boolean _res = false ;
        if( obj == null ) return true ;
        if( obj instanceof String ){
            if(((String) obj).trim().equals("") ) _res = true ;
        }else if( obj instanceof Collection ){
            if( ((Collection) obj).size()<= 0 ) _res = true ;
        }
        return _res ;
    }
}
