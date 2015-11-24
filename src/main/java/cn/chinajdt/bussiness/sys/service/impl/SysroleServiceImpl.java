package cn.chinajdt.bussiness.sys.service.impl;

import cn.chinajdt.bussiness.sys.dao.SysroleMapper;
import cn.chinajdt.bussiness.sys.model.Sysrole;
import cn.chinajdt.bussiness.sys.service.SysroleService;
import cn.chinajdt.sys.exception.BsnException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("sysroleService")
public class SysroleServiceImpl implements SysroleService {

    @Autowired
    private SysroleMapper dao ;

    public int deleteByPrimaryKey(String sysroleid) throws BsnException{
        return dao.deleteByPrimaryKey( sysroleid) ;
    }

    public int insert(Sysrole record) throws BsnException{
        return dao.insert( record ) ;
    }

    public int insertSelective(Sysrole record) throws BsnException{
        return dao.insertSelective( record ) ;
    }

    public Sysrole selectByPrimaryKey(String sysroleid) throws BsnException{
        return dao.selectByPrimaryKey( sysroleid) ;
    }

    public int updateByPrimaryKeySelective(Sysrole record) throws BsnException{
        return dao.updateByPrimaryKeySelective( record) ;
    }

    public int updateByPrimaryKey(Sysrole record) throws BsnException{
        return dao.updateByPrimaryKey( record ) ;
    }
}