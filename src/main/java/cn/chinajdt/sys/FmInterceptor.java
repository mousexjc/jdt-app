package cn.chinajdt.sys;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Jacky on 15/11/10.
 */
public class FmInterceptor implements HandlerInterceptor {

    private static final Map<String,String> HTML_MAPPING = new HashMap<String,String>();

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        String _url = httpServletRequest.getServletPath();
        String htmlUrl = HTML_MAPPING.get(_url);
        if(null != htmlUrl && htmlUrl.length() > 0)
        {
            File file = new File(httpServletRequest.getSession().getServletContext().getRealPath("")+htmlUrl);
            if(file.exists()){
                httpServletRequest.getRequestDispatcher(htmlUrl).forward(httpServletRequest,httpServletResponse);
            }
            return false;
        }else{
            return true;
        }
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
