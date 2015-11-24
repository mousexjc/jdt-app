package cn.chinajdt.bussiness.sys.service.impl;

import cn.chinajdt.bussiness.sys.dao.SysuserroleMapper;
import cn.chinajdt.bussiness.sys.model.Sysuserrole;
import cn.chinajdt.bussiness.sys.service.SysuserroleService;
import cn.chinajdt.sys.exception.BsnException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("sysuserroleService")
public class SysuserroleServiceImpl implements SysuserroleService {

    @Autowired
    private SysuserroleMapper dao ;

    public int deleteByPrimaryKey(String sysuserroleid) throws BsnException{
        return dao.deleteByPrimaryKey( sysuserroleid ) ;
    }

    public int insert(Sysuserrole record) throws BsnException{
        return dao.insert( record ) ;
    }

    public int insertSelective(Sysuserrole record) throws BsnException{
        return dao.insertSelective( record) ;
    }

    public Sysuserrole selectByPrimaryKey(String sysuserroleid) throws BsnException{
        return dao.selectByPrimaryKey( sysuserroleid) ;
    }

    public int updateByPrimaryKeySelective(Sysuserrole record) throws BsnException{
        return dao.updateByPrimaryKeySelective( record) ;
    }

    public int updateByPrimaryKey(Sysuserrole record) throws BsnException{
        return dao.updateByPrimaryKey( record ) ;
    }
}