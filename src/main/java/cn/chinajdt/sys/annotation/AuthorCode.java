package cn.chinajdt.sys.annotation;

import java.lang.annotation.*;

/**
 * Created by Jacky on 15/11/18.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AuthorCode {

    int value() default 0 ;

    int LOGIN = 0 ;
    int BLOWSER = 1 ;
    int SEARCH = 2 ;
    int ADD = 3 ;
    int DELE = 4 ;
    int UPDATE = 5 ;
    int AUDIT = 6 ;
    int UNAUDIT = 7 ;
}
