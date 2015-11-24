package cn.chinajdt.sys.interceptors;

import cn.chinajdt.sys.annotation.AuthorCode;
import cn.chinajdt.sys.exception.BsnException;
import cn.chinajdt.utils.SessionUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        String _controllerName = jp.getTarget().getClass().getName() ;
        MethodSignature _signature = (MethodSignature) jp.getSignature();
        AuthorCode _authorCode = _signature.getMethod().getAnnotation( AuthorCode.class ) ;
        if( _authorCode == null ) return jp.proceed() ;
        int _val = _authorCode.value() ;
        if( _val == AuthorCode.LOGIN ){
            HttpSession _session = request.getSession() ;
            Object _obj = _session.getAttribute(SessionUtil.SESSION_USERID) ;
            if( _obj ==null ) throw new BsnException("请先登陆!") ;
            return jp.proceed() ;
        }
        Object _obj = request.getSession().getAttribute( SessionUtil.SESSION_AUTHOR ) ;
        if(null!= _obj ){
            Map<String,List<Integer>> _authorMap = (Map<String,List<Integer>>) _obj ;
            if ( _authorMap.containsKey( _controllerName )
                    && _authorMap.get( _controllerName ).contains( _val )){
                return jp.proceed() ;
            }
        }
        throw new BsnException("无权限!") ;
    }

}
