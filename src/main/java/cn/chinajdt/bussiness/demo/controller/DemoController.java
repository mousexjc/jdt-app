package cn.chinajdt.bussiness.demo.controller;

import cn.chinajdt.bussiness.demo.model.Demo;
import cn.chinajdt.bussiness.demo.service.SysUserService;
import cn.chinajdt.bussiness.sys.controller.SysmenuController;
import cn.chinajdt.sys.annotation.AuthorCode;
import cn.chinajdt.sys.exception.BsnException;
import cn.chinajdt.utils.FileUtil;
import cn.chinajdt.utils.SessionUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Jacky on 15/11/8.
 */
@RestController
@RequestMapping("demo/sysuser")
public class DemoController {

    @Autowired
    private SysUserService userService;

    @RequestMapping("index")
    public ModelAndView index(HttpServletRequest request) throws Exception {
//        WebApplicationContext _ctx = (WebApplicationContext) request.getSession().getServletContext()
//                .getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
        ModelAndView _mv = new ModelAndView("demo/index");
        Demo _user = new Demo();
        _user.setId("112");
//        userService.insert( _user ) ;
        _mv.addObject("name", "Jacky");
        Logger _log = Logger.getLogger(this.getClass());
        _log.info("==================hahaha~~ LOG SUCCESS!!!");
//        _mv.addObject("CREATE_HTML",false) ;
        List<Demo> _list = userService.queryPage(3,2) ;
        _mv.addObject("userList", _list) ;
        Map<String,List<Integer>> _map = new HashMap<>() ;
        List<Integer> _lista=  new ArrayList<>() ;
        _lista.add( AuthorCode.LOGIN);
        _lista.add( AuthorCode.ADD );
        _lista.add( AuthorCode.BLOWSER );
        _map.put(SysmenuController.class.getName(),_lista) ;
        request.getSession().setAttribute(SessionUtil.SESSION_AUTHOR,_map);
        return _mv;
    }

    @RequestMapping(value = "/index2", method = RequestMethod.POST)
    @ResponseBody
    public Object doindex() throws Exception {
        Demo _user = userService.selectByPrimaryKey("111");
        _user.setAge(24);
        userService.updateByPrimaryKey(_user);

        return _user;
    }

    @RequestMapping(value = "/index3", method = RequestMethod.POST)
    @ResponseBody
    public Object index3(HttpServletRequest request, String uaername) throws BsnException {
        FileUtil.uploadMultipartRequest(request);
//        Object _obj = request.getSession().getAttribute(SessionUtil.SESSION_AUTHOR) ;
        return uaername;
    }

    @RequestMapping("download")
    @ResponseBody
    public ResponseEntity<byte[]> download( HttpServletRequest request ) throws BsnException {
        return FileUtil.getResponseEntity( request ,FileUtil.UPLOAD_DERECTORY_DEFAULT + "IMG_3238.jpg" ) ;
    }

}
