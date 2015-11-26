package cn.chinajdt.bussiness.sys.controller;

import cn.chinajdt.bussiness.sys.model.Sysrole;
import cn.chinajdt.bussiness.sys.model.Sysuser;
import cn.chinajdt.bussiness.sys.service.SysroleService;
import cn.chinajdt.bussiness.sys.service.SysuserService;
import cn.chinajdt.sys.ResponseBean;
import cn.chinajdt.sys.annotation.AuthorCode;
import cn.chinajdt.sys.exception.BsnException;
import cn.chinajdt.utils.Common;
import cn.chinajdt.utils.DateUtil;
import cn.chinajdt.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Jacky on 15/11/25.
 */
@RestController
@RequestMapping("sys/role")
public class SysroleController {

    @Autowired
    private SysroleService service ;

    @RequestMapping("index")
    @AuthorCode( AuthorCode.BLOWSER )
    public ModelAndView index(
            @RequestParam( defaultValue = "0")String parentid ,
            @RequestParam(name = "pageno",defaultValue = "1") int pageno ,
            @RequestParam(name = "pagesize",defaultValue = "10")int pagesize ){
        Map<String,Object> _map = new HashMap<String,Object>() ;
        _map.put("isdelete" , 0 ) ;
        if( !Common.empty(parentid))_map.put("parentid" , parentid ) ;
        List<Sysrole> _list = service.list( _map ,pageno , pagesize ) ;
        ModelAndView _mv = new ModelAndView("sys/role/index");
        _mv.addObject("rolelist" , _list ) ;
        return _mv ;
    }

    @RequestMapping("toadd")
    @AuthorCode( AuthorCode.ADD )
    public ModelAndView toadd( String parentid ){
        ModelAndView _mv = new ModelAndView("sys/role/add");
        _mv.addObject("parentid" , parentid) ;
        return _mv ;
    }

    @RequestMapping(value = "add" , method = RequestMethod.POST)
    @AuthorCode( AuthorCode.ADD )
    @ResponseBody
    public Object add( @RequestParam( defaultValue = "0")String parentid , String rname , String remark , int rorder ) throws BsnException {
        Date _createtime = new Date() ;
        int _isdelete = 0 ;
        Sysrole _role = new Sysrole() ;
        _role.setSysroleid( StringUtil.getUUid() );
        _role.setIsdelete( _isdelete );
        _role.setCreatetime( _createtime );
        _role.setParentid( parentid );
        _role.setRname( rname );
        _role.setRemark( remark );
        _role.setRorder( rorder );
        service.insert( _role ) ;
        return new ResponseBean( ResponseBean.SUCCESS ) ;
    }

    @RequestMapping("toedit")
    @AuthorCode( AuthorCode.UPDATE )
    public ModelAndView toedit( String id ) throws BsnException {
        ModelAndView _mv = new ModelAndView("sys/role/edit");
        Sysrole _role = service.selectByPrimaryKey( id ) ;
        _mv.addObject( "role" , _role ) ;
        return _mv ;
    }

    @RequestMapping(value = "edit" , method = RequestMethod.POST )
    @AuthorCode( AuthorCode.UPDATE )
    @ResponseBody
    public Object edit( String sysroleid,String parentid, String rname , String remark , int rorder ) throws BsnException {
        Sysrole _role = service.selectByPrimaryKey( sysroleid ) ;
        if(!Common.empty(parentid))_role.setParentid( parentid);
        if(!Common.empty(rname))_role.setRname( rname );
        _role.setRemark( remark );
        if(!Common.empty(rorder))_role.setRorder( rorder );
        service.updateByPrimaryKey( _role ) ;
        return new ResponseBean( ResponseBean.SUCCESS );
    }

    @RequestMapping(value = "delete" ,method = RequestMethod.POST )
    @AuthorCode( AuthorCode.DELE )
    @ResponseBody
    public Object delete( String id ) throws BsnException {
        service.deleteByPrimaryKey( id ) ;
        return new ResponseBean( ResponseBean.SUCCESS );
    }

}
