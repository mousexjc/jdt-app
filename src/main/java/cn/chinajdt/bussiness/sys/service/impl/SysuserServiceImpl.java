package cn.chinajdt.bussiness.sys.service.impl;

import cn.chinajdt.bussiness.sys.dao.SysuserMapper;
import cn.chinajdt.bussiness.sys.model.Sysuser;
import cn.chinajdt.bussiness.sys.service.SysuserService;
import cn.chinajdt.sys.exception.BsnException;
import freemarker.ext.beans.HashAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service("sysuserService")
public class SysuserServiceImpl implements SysuserService {

    @Autowired
    private SysuserMapper dao ;

    public int deleteByPrimaryKey(String sysuserid) throws BsnException{
        Sysuser _user = dao.selectByPrimaryKey( sysuserid ) ;
        _user.setIsdelete( 1 );
        return dao.updateByPrimaryKey( _user ) ;
    }

    public int insert(Sysuser record) throws BsnException{
        return dao.insert( record ) ;
    }

    public int insertSelective(Sysuser record) throws BsnException{
        return dao.insertSelective( record ) ;
    }

    public Sysuser selectByPrimaryKey(String sysuserid){
        return dao.selectByPrimaryKey( sysuserid ) ;
    }

    public int updateByPrimaryKeySelective(Sysuser record) throws BsnException{
        return dao.updateByPrimaryKeySelective( record) ;
    }

    public int updateByPrimaryKey(Sysuser record) throws BsnException{
        return dao.updateByPrimaryKey( record ) ;
    }

    public List<Sysuser> list( Map<String,Object> conditions , int pageno , int pagesize ){
        if( conditions == null ) conditions = new HashMap<String,Object>() ;
        conditions.put("pageno",pageno) ;
        conditions.put("pagesize",pagesize) ;
        return dao.list( conditions ) ;
    }
}