package cn.chinajdt.bussiness.sys.controller;

import cn.chinajdt.bussiness.sys.model.Sysmenu;
import cn.chinajdt.bussiness.sys.service.SysmenuService;
import cn.chinajdt.sys.ResponseBean;
import cn.chinajdt.sys.annotation.AuthorCode;
import cn.chinajdt.sys.exception.BsnException;
import cn.chinajdt.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Jacky on 15/11/24.
 */
@RestController
@RequestMapping("sys/menu")
public class SysmenuController {

    @Autowired
    private SysmenuService menuSerevice ;

    @RequestMapping("index")
    @AuthorCode( AuthorCode.BLOWSER )
    public ModelAndView index(
            @RequestParam(name = "parentid",defaultValue = "0" )String parentid ,
            @RequestParam(name = "pageno",defaultValue = "1") int pageno ,
            @RequestParam(name = "pagesize",defaultValue = "10")int pagesize ) throws BsnException {
        Map<String,Object> _map = new HashMap<String,Object>() ;
        _map.put("parentid" , parentid) ;
        List<Sysmenu> _list = menuSerevice.list( _map ,pageno , pagesize ) ;
        ModelAndView _mv = new ModelAndView("sys/menu/index");
        _mv.addObject("menulist" , _list ) ;
        return _mv ;
    }

    @RequestMapping("toadd")
    @AuthorCode( AuthorCode.ADD )
    public ModelAndView toadd( @RequestParam( name = "parentid",defaultValue = "0" )String parentid ){
        ModelAndView _mv = new ModelAndView("sys/menu/add");
        _mv.addObject("parentid", parentid) ;
        return _mv ;
    }

    @RequestMapping("add")
    @AuthorCode( AuthorCode.ADD )
    @ResponseBody
    public Object add( String mname ,String parentid ,String controller ,
                             String linkurl ,String logo ,int morder ,String remark ) throws BsnException {
        Sysmenu _menu = new Sysmenu() ;
        _menu.setSysmenuid(StringUtil.getUUid());
        _menu.setMname(mname);
        _menu.setParentid(parentid);
        _menu.setController(controller);
        _menu.setLinkurl(linkurl);
        _menu.setLogo(logo);
        _menu.setMorder(morder);
        _menu.setRemark( remark );
        _menu.setIsdelete(0);
        menuSerevice.insert( _menu ) ;
        return new ResponseBean( ResponseBean.SUCCESS ) ;
    }

    @RequestMapping("toedit")
    @AuthorCode( AuthorCode.UPDATE )
    public ModelAndView toedit( String id ){
        ModelAndView _mv = new ModelAndView("sys/menu/edit");
        Sysmenu _menu = menuSerevice.selectByPrimaryKey( id ) ;
        _mv.addObject( "menu" , _menu ) ;
        return _mv ;
    }

    @RequestMapping("edit")
    @AuthorCode( AuthorCode.UPDATE )
    public ModelAndView edit(String sysmenuid , String mname ,String parentid ,String controller ,
                             String linkurl ,String logo ,int morder ,String remark ) throws BsnException {
        ModelAndView _mv = new ModelAndView("redirect:index");
        Sysmenu _menu = menuSerevice.selectByPrimaryKey( sysmenuid ) ;
        _menu.setMname( mname );
        _menu.setParentid(parentid);
        _menu.setController(controller);
        _menu.setLinkurl(linkurl);
        _menu.setLogo(logo);
        _menu.setMorder(morder);
        _menu.setRemark( remark );
//        _menu.setIsdelete(0);
        menuSerevice.updateByPrimaryKey( _menu ) ;
        return _mv ;
    }

    @RequestMapping("delete")
    @AuthorCode( AuthorCode.DELE )
    @ResponseBody
    public Object delete( String menuid ) throws BsnException {
        menuSerevice.deleteMenus( menuid.split(";") );
        return new ResponseBean( ResponseBean.SUCCESS );
    }

}
