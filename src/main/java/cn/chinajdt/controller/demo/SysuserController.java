package cn.chinajdt.controller.demo;

import cn.chinajdt.model.demo.SysUser;
import cn.chinajdt.service.demo.SysUserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Jacky on 15/11/8.
 */
@Controller
@RequestMapping("sysuser")
public class SysuserController{

    @Autowired
    private SysUserService userService ;

    @RequestMapping("index")
    public ModelAndView index( HttpServletRequest request )throws Exception{
//        WebApplicationContext _ctx = (WebApplicationContext) request.getSession().getServletContext()
//                .getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
        ModelAndView _mv = new ModelAndView("demo/index") ;
        SysUser _user = new SysUser() ;
        _user.setId("112");
        userService.insert( _user ) ;
        _mv.addObject("name","Jacky") ;
        Logger _log = Logger.getLogger(this.getClass()) ;
        _log.info("==================hahaha~~ LOG SUCCESS!!!") ;
        return _mv ;
    }

}
