package cn.chinajdt.sys.interceptors;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Jacky on 15/11/18.
 */
@Aspect
@Component
public class AuthorInterceptor implements Ordered {

    @Autowired
    private HttpServletRequest request;

    @Override
    public int getOrder() {
        return 1 ;
    }

    @Around("@annotation(cn.chinajdt.sys.annotation.AuthorCode)")
    public Object around(final ProceedingJoinPoint jp) throws Throwable{
        return jp.proceed() ;
    }

}
