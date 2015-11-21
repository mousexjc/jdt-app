package cn.chinajdt.bussiness.demo.controller;

import cn.chinajdt.bussiness.demo.model.SysUser;
import cn.chinajdt.bussiness.demo.service.SysUserService;
import cn.chinajdt.sys.annotation.AuthorCode;
import cn.chinajdt.sys.exception.BsnException;
import cn.chinajdt.utils.FileUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Jacky on 15/11/8.
 */
@RestController
@RequestMapping("demo/sysuser")
public class SysuserController {

    @Autowired
    private SysUserService userService;

    @RequestMapping("index")
    @AuthorCode(AuthorCode.LOGIN)
    public ModelAndView index(HttpServletRequest request) throws Exception {
//        WebApplicationContext _ctx = (WebApplicationContext) request.getSession().getServletContext()
//                .getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
        ModelAndView _mv = new ModelAndView("demo/index");
        SysUser _user = new SysUser();
        _user.setId("112");
//        userService.insert( _user ) ;
        _mv.addObject("name", "Jacky");
        Logger _log = Logger.getLogger(this.getClass());
        _log.info("==================hahaha~~ LOG SUCCESS!!!");
//        _mv.addObject("CREATE_HTML",false) ;
        return _mv;
    }

    @RequestMapping(value = "/index2", method = RequestMethod.POST)
    @ResponseBody
    public Object doindex() throws Exception {
        SysUser _user = userService.selectByPrimaryKey("111");
        _user.setAge(24);
        userService.updateByPrimaryKey(_user);
        return _user;
    }

    @RequestMapping(value = "/index3", method = RequestMethod.POST)
    @ResponseBody
    public Object index3(HttpServletRequest request, String uaername) throws BsnException {
        FileUtil.uploadMultipartRequest(request);
        return uaername;
    }

    @RequestMapping("download")
    public ResponseEntity<byte[]> download( HttpServletRequest request ) throws BsnException {
        return FileUtil.getResponseEntity( request ,FileUtil.UPLOAD_DERECTORY_DEFAULT + "IMG_3238.jpg" ) ;
    }

}
