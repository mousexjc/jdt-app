package cn.chinajdt.service.demo.impl;

import cn.chinajdt.dao.demo.SysUserMapper;
import cn.chinajdt.model.demo.SysUser;
import cn.chinajdt.service.demo.SysUserService;
import cn.chinajdt.sys.exception.BsnException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Jacky on 15/11/7.
 */
@Service("sysuserService")
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserMapper dao ;

    public int deleteByPrimaryKey(String id) throws BsnException {
        return dao.deleteByPrimaryKey( id );
    }

    public int insert(SysUser record) throws BsnException {
        return dao.insert( record ) ;
    }

    public int insertSelective(SysUser record) throws BsnException {
        return dao.insertSelective( record );
    }

    public SysUser selectByPrimaryKey(String id) throws BsnException {
        return dao.selectByPrimaryKey( id );
    }

    public int updateByPrimaryKeySelective(SysUser record) throws BsnException {
        return dao.updateByPrimaryKeySelective( record );
    }

    public int updateByPrimaryKey(SysUser record) throws BsnException {
        return dao.updateByPrimaryKey( record );
    }
}
