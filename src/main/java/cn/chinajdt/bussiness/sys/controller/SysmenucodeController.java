package cn.chinajdt.bussiness.sys.controller;

import cn.chinajdt.bussiness.sys.model.Sysmenucode;
import cn.chinajdt.bussiness.sys.service.SysmenucodeService;
import cn.chinajdt.sys.ResponseBean;
import cn.chinajdt.sys.annotation.AuthorCode;
import cn.chinajdt.sys.exception.BsnException;
import cn.chinajdt.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by Jacky on 15/11/25.
 */
@RestController
@RequestMapping("sys/menucode")
public class SysmenucodeController {

    @Autowired
    private SysmenucodeService service ;

    @RequestMapping("index")
    @AuthorCode( AuthorCode.BLOWSER )
    public ModelAndView index(String sysmenuid ) throws BsnException {
        ModelAndView _mv = new ModelAndView("sys/menu/rightcode");
        List<Sysmenucode> _list = service.listByMenuid( sysmenuid ) ;
        _mv.addObject("codelist" , _list ) ;
        _mv.addObject("sysmenuid" , sysmenuid ) ;
        return _mv ;
    }

    @RequestMapping("add")
    @AuthorCode( AuthorCode.ADD )
    @ResponseBody
    public Object add(String sysmenuid ,String cname ,int ccode ) throws BsnException {
        Sysmenucode _code = new Sysmenucode() ;
        _code.setSysmenucodeid(StringUtil.getUUid());
        _code.setSysmenuid( sysmenuid );
        _code.setCname( cname);
        _code.setCcode( ccode);
        service.insert( _code ) ;
        return new ResponseBean( ResponseBean.SUCCESS);
    }

    @RequestMapping("delete")
    @AuthorCode( AuthorCode.DELE )
    @ResponseBody
    public Object delete(String sysmenucodeid ) throws BsnException {
        service.deleteCodes(sysmenucodeid.split(";"));
        return new ResponseBean( ResponseBean.SUCCESS );
    }

    @RequestMapping("edit")
    @AuthorCode( AuthorCode.UPDATE )
    @ResponseBody
    public Object edit(String sysmenucodeid,String cname ,int ccode ) throws BsnException {
        Sysmenucode _code = service.selectByPrimaryKey( sysmenucodeid ) ;
        _code.setCname(cname);
        _code.setCcode( ccode);
        service.updateByPrimaryKey( _code) ;
        return new ResponseBean( ResponseBean.SUCCESS );
    }
}
