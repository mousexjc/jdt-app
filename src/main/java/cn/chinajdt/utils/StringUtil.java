package cn.chinajdt.utils;

import java.util.UUID;

/**
 * Created by Jacky on 15/11/24.
 */
public abstract class StringUtil {

    public static String getUUid(){
        return UUID.randomUUID().toString().replaceAll("-","") ;
    }

}
