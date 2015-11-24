package cn.chinajdt.bussiness.sys.service.impl;

import cn.chinajdt.bussiness.sys.dao.SysuserMapper;
import cn.chinajdt.bussiness.sys.model.Sysuser;
import cn.chinajdt.bussiness.sys.service.SysuserService;
import cn.chinajdt.sys.exception.BsnException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("sysuserService")
public class SysuserServiceImpl implements SysuserService {

    @Autowired
    private SysuserMapper dao ;

    public int deleteByPrimaryKey(Long sysuserid) throws BsnException{
        return dao.deleteByPrimaryKey( sysuserid ) ;
    }

    public int insert(Sysuser record) throws BsnException{
        return dao.insert( record ) ;
    }

    public int insertSelective(Sysuser record) throws BsnException{
        return dao.insertSelective( record ) ;
    }

    public Sysuser selectByPrimaryKey(Long sysuserid) throws BsnException{
        return dao.selectByPrimaryKey( sysuserid ) ;
    }

    public int updateByPrimaryKeySelective(Sysuser record) throws BsnException{
        return dao.updateByPrimaryKeySelective( record) ;
    }

    public int updateByPrimaryKey(Sysuser record) throws BsnException{
        return dao.updateByPrimaryKey( record ) ;
    }
}