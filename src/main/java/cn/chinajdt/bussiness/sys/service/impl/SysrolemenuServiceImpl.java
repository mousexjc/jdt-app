package cn.chinajdt.bussiness.sys.service.impl;

import cn.chinajdt.bussiness.sys.dao.SysrolemenuMapper;
import cn.chinajdt.bussiness.sys.model.Sysrolemenu;
import cn.chinajdt.bussiness.sys.service.SysrolemenuService;
import cn.chinajdt.sys.exception.BsnException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("sysrolemenuService")
public class SysrolemenuServiceImpl implements SysrolemenuService {

    @Autowired
    private SysrolemenuMapper dao ;

    public int deleteByPrimaryKey(String sysrolemenuid) throws BsnException{
        return dao.deleteByPrimaryKey( sysrolemenuid ) ;
    }

    public int insert(Sysrolemenu record) throws BsnException{
        return dao.insert( record ) ;
    }

    public int insertSelective(Sysrolemenu record) throws BsnException{
        return dao.insertSelective( record ) ;
    }

    public Sysrolemenu selectByPrimaryKey(String sysrolemenuid) throws BsnException{
        return dao.selectByPrimaryKey( sysrolemenuid ) ;
    }

    public int updateByPrimaryKeySelective(Sysrolemenu record) throws BsnException{
        return dao.updateByPrimaryKeySelective( record ) ;
    }

    public int updateByPrimaryKey(Sysrolemenu record) throws BsnException{
        return dao.updateByPrimaryKey( record ) ;
    }
}