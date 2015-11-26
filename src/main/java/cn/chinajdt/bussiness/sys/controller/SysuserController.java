package cn.chinajdt.bussiness.sys.controller;

import cn.chinajdt.bussiness.sys.model.Sysrole;
import cn.chinajdt.bussiness.sys.model.Sysuser;
import cn.chinajdt.bussiness.sys.model.Sysuserrole;
import cn.chinajdt.bussiness.sys.service.SysroleService;
import cn.chinajdt.bussiness.sys.service.SysuserService;
import cn.chinajdt.bussiness.sys.service.SysuserroleService;
import cn.chinajdt.sys.ResponseBean;
import cn.chinajdt.sys.annotation.AuthorCode;
import cn.chinajdt.sys.exception.BsnException;
import cn.chinajdt.utils.Common;
import cn.chinajdt.utils.DateUtil;
import cn.chinajdt.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

/**
 * Created by Jacky on 15/11/25.
 */
@RestController
@RequestMapping("sys/user")
public class SysuserController {

    @Autowired
    private SysuserService service ;
    @Autowired
    private SysroleService roleService ;
    @Autowired
    private SysuserroleService userroleService ;

    @RequestMapping("index")
    @AuthorCode( AuthorCode.BLOWSER )
    public ModelAndView index( @RequestParam(name = "pageno",defaultValue = "1") int pageno ,
                               @RequestParam(name = "pagesize",defaultValue = "10")int pagesize ){
        Map<String,Object> _map = new HashMap<String,Object>() ;
        _map.put("isdelete" , 0 ) ;
        List<Sysuser> _list = service.list( _map ,pageno , pagesize ) ;
        ModelAndView _mv = new ModelAndView("sys/user/index");
        _mv.addObject("userlist" , _list ) ;
        return _mv ;
    }

    @RequestMapping("toadd")
    @AuthorCode( AuthorCode.ADD )
    public ModelAndView toadd(){
        ModelAndView _mv = new ModelAndView("sys/user/add");
        return _mv ;
    }

    @RequestMapping(value = "add" , method = RequestMethod.POST)
    @AuthorCode( AuthorCode.ADD )
    @ResponseBody
    public Object add(String username ,String password,String realname,String mobile,String email,
                      String qq,String weixin,int sex ,String remark,int usertype, String address,
                      String image,String birthday,String identifyid ,String bussnumber) throws BsnException {
        Date createtime = new Date() ;
        Date regdate = createtime ;
        int status = 1 ;
        int isdelete = 0 ;
        int auditstatus = 0 ;
        int emailverify = 0 ;
        int realnameverify = 0 ;
        Date _birthday = DateUtil.parse2YMD( birthday ) ;
        Sysuser _user = new Sysuser() ;
        _user.setSysuserid(StringUtil.getUUid());
        _user.setAddress( address );
        _user.setAuditstatus( auditstatus);
        _user.setBirthday( _birthday);
        _user.setBussnumber( bussnumber);
        _user.setCreatetime( createtime);
        _user.setEmail(email);
        _user.setEmailverify( emailverify);
        _user.setIdentifyid(identifyid);
        _user.setImage(image);
        _user.setIsdelete(isdelete);
        _user.setMobile(mobile);
        _user.setPassword( StringUtil.MD5Encrypt( password ) );
        _user.setQq(qq);
        _user.setRealname( realname);
        _user.setSex( sex);
        _user.setRemark(remark);
        _user.setWeixin( weixin);
        _user.setUsername( username);
        _user.setUsertype( usertype);
        _user.setStatus( status);
        _user.setRealnameverify( realnameverify);
        _user.setRegdate( regdate);
        service.insert( _user ) ;
        return new ResponseBean( ResponseBean.SUCCESS ) ;
    }

    @RequestMapping("toedit")
    @AuthorCode( AuthorCode.UPDATE )
    public ModelAndView toedit( String id ){
        ModelAndView _mv = new ModelAndView("sys/user/edit");
        Sysuser _user = service.selectByPrimaryKey( id ) ;
        _mv.addObject( "user" , _user ) ;
        return _mv ;
    }

    @RequestMapping(value = "edit" , method = RequestMethod.POST )
    @AuthorCode( AuthorCode.UPDATE )
    @ResponseBody
    public Object edit( String sysuserid ,String username ,String password,String realname,String mobile,String email,
                             String qq,String weixin,int sex ,String remark, String address,
                             String image,String birthday,String identifyid ,String bussnumber) throws BsnException {
        Date _birthday = DateUtil.parse2YMD( birthday ) ;
        Sysuser _user = service.selectByPrimaryKey( sysuserid ) ;
//        _user.setSysuserid(StringUtil.getUUid());
        if(!Common.empty(address)) _user.setAddress( address );
        if(!Common.empty(_birthday))_user.setBirthday( _birthday);
        if(!Common.empty(bussnumber ))_user.setBussnumber( bussnumber);
        if(!Common.empty(email ))_user.setEmail(email);
        if(!Common.empty( identifyid))_user.setIdentifyid(identifyid);
        if(!Common.empty(image ))_user.setImage(image);
        if(!Common.empty( mobile))_user.setMobile(mobile);
        if(!Common.empty(password ))_user.setPassword( StringUtil.MD5Encrypt( password ) );
        if(!Common.empty( qq))_user.setQq(qq);
        if(!Common.empty(realname ))_user.setRealname( realname);
        if(!Common.empty( sex))_user.setSex( sex);
        if(!Common.empty(remark ))_user.setRemark(remark);
        if(!Common.empty(weixin ))_user.setWeixin( weixin);
        if(!Common.empty(username ))_user.setUsername( username);
//        if(!Common.empty( usertype))_user.setUsertype( usertype);
//        _user.setAuditstatus( auditstatus);
//        _user.setCreatetime( createtime);
//        _user.setEmailverify( emailverify);
//        _user.setIsdelete(isdelete);
//        _user.setStatus( status);
//        _user.setRealnameverify( realnameverify);
//        _user.setRegdate( regdate);
        service.updateByPrimaryKey( _user ) ;
        return new ResponseBean( ResponseBean.SUCCESS );
    }

    @RequestMapping(value = "delete" ,method = RequestMethod.POST )
    @AuthorCode( AuthorCode.DELE )
    @ResponseBody
    public Object delete( String id ) throws BsnException {
        service.deleteByPrimaryKey( id ) ;
        return new ResponseBean( ResponseBean.SUCCESS );
    }

    @RequestMapping("toauth")
    @AuthorCode( AuthorCode.AUTHOR )
    public ModelAndView toauth( String id ) throws BsnException {
        ModelAndView _mv = new ModelAndView("sys/user/auth");
        List<Sysrole> _roleList = roleService.list(null,1,10000) ;
        List<Sysuserrole> _userroleList = userroleService.all( id , null ) ;
        List<String> _roleidList = new ArrayList<String>() ;
        for( Sysuserrole _ur : _userroleList ){
            _roleidList.add( _ur.getSysroleid());
        }
        _mv.addObject("allrolelist" , _roleList) ;
        _mv.addObject("selectedroleidlist" ,  _roleidList ) ;
        _mv.addObject("sysuserid", id ) ;
        return _mv ;
    }

}
