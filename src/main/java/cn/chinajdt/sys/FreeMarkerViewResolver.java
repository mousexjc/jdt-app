package cn.chinajdt.sys;

import freemarker.template.Configuration;
import freemarker.template.SimpleHash;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.apache.log4j.Logger;
import org.springframework.web.servlet.support.RequestContextUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Locale;
import java.util.Map;

/**
 * Created by Jacky on 15/11/10.
 */
public class FreeMarkerViewResolver extends FreeMarkerView {

    Logger _log = Logger.getLogger( FreeMarkerViewResolver.class ) ;

    @Override
    protected void doRender(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        // Expose model to JSP tags (as request attributes).
        exposeModelAsRequestAttributes(model, request);
        // Expose all standard FreeMarker hash models.
        SimpleHash fmModel = buildTemplateModel(model, request, response);
        // Grab the locale-specific version of the template.
        Locale locale = RequestContextUtils.getLocale(request);
        processTemplate(getTemplate(locale), fmModel, response);
        /*
         * 默认生成静态文件,除非在编写ModelAndView时指定CREATE_HTML = false,
         * 这样对静态文件生成的粒度控制更细一点
         * 例如：ModelAndView mav = new ModelAndView("search");
         *       mav.addObject("CREATE_HTML", false);
        if(Boolean.FALSE.equals(model.get("CREATE_HTML"))){
            processTemplate(getTemplate(locale), fmModel, response);
        }else{
            createHTML(getTemplate(locale), fmModel, request, response);
        }
        */
    }

    public void createHTML(Template template, SimpleHash model,HttpServletRequest request,
                           HttpServletResponse response) throws IOException, TemplateException, ServletException {
        //站点根目录的绝对路径
        String basePath = request.getSession().getServletContext().getRealPath("/");
        String requestHTML = this.getRequestHTML(request);
        String htmlPath = basePath + requestHTML;
        File htmlFile = new File(htmlPath);
        if(!htmlFile.getParentFile().exists())htmlFile.getParentFile().mkdirs();
        if(!htmlFile.exists())htmlFile.createNewFile();
        Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(htmlFile), "UTF-8"));
        template.process(model, out);
        out.flush();
        out.close();
        request.getRequestDispatcher(requestHTML).forward(request, response);
    }


    private String getRequestHTML(HttpServletRequest request){
        //web应用名称,部署在ROOT目录时为空
        String contextPath = request.getContextPath();
        //web应用/目录/文件.do
        String requestURI = request.getRequestURI();
        //basePath里面已经有了web应用名称，所以直接把它replace掉，以免重复
        requestURI = "demo/index.htm";
        return requestURI;
    }

}