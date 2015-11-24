package cn.chinajdt.bussiness.demo.service.impl;

import cn.chinajdt.bussiness.demo.dao.DemoMapper;
import cn.chinajdt.bussiness.demo.model.Demo;
import cn.chinajdt.bussiness.demo.service.SysUserService;
import cn.chinajdt.sys.exception.BsnException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Jacky on 15/11/7.
 */
@Service("sysdemoService")
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private DemoMapper dao ;

    public int deleteByPrimaryKey(String id) throws BsnException {
        return dao.deleteByPrimaryKey( id );
    }

    public int insert(Demo record) throws BsnException {
        return dao.insert( record ) ;
    }

    public int insertSelective(Demo record) throws BsnException {
        return dao.insertSelective( record );
    }

    public Demo selectByPrimaryKey(String id) throws BsnException {
        return dao.selectByPrimaryKey( id );
    }

    public int updateByPrimaryKeySelective(Demo record) throws BsnException {
        return dao.updateByPrimaryKeySelective( record );
    }

    public int updateByPrimaryKey(Demo record) throws BsnException {
        return dao.updateByPrimaryKey( record );
    }

    public List<Demo> all(){
        return dao.all() ;
    }

    public List<Demo> queryPage( int pageNo,int pageSize){
        return dao.queryPage( pageNo, pageSize) ;
    }
}
