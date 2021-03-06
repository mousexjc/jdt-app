package cn.chinajdt.bussiness.sys.service.impl;

import cn.chinajdt.bussiness.sys.dao.SysroleMapper;
import cn.chinajdt.bussiness.sys.dao.SysuserroleMapper;
import cn.chinajdt.bussiness.sys.model.Sysrole;
import cn.chinajdt.bussiness.sys.model.Sysuserrole;
import cn.chinajdt.bussiness.sys.service.SysroleService;
import cn.chinajdt.sys.exception.BsnException;
import cn.chinajdt.utils.Common;
import cn.chinajdt.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("sysroleService")
public class SysroleServiceImpl implements SysroleService {

    @Autowired
    private SysroleMapper dao ;
    @Autowired
    private SysuserroleMapper userroleDao ;

    public int deleteByPrimaryKey(String sysroleid) throws BsnException{
        userroleDao.deleteByRoleid( sysroleid );
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

    @Override
    public List<Sysrole> list(Map<String, Object> conditions, int pageno, int pagesize) {
        if( conditions == null ) conditions = new HashMap<String,Object>() ;
        conditions.put("pageno" , pageno ) ;
        conditions.put("pagesize" , pagesize) ;
        return dao.list( conditions ) ;
    }

    @Override
    public void authority(String[] useridArr, String[] roleidArr) throws BsnException {
        List<Sysuserrole> _list = new ArrayList<Sysuserrole>() ;
        for( String _userid : useridArr ){
            for( String _roleid : roleidArr ){
                Sysuserrole _ur = new Sysuserrole() ;
                _ur.setSysuserroleid(StringUtil.getUUid());
                _ur.setSysuserid( _userid);
                _ur.setSysroleid( _roleid);
                _list.add( _ur );
            }
        }
        if(!Common.empty( _list )) userroleDao.insertBatch( _list );
    }

    @Override
    public void unauthority(String userid, String roleid) throws BsnException {
        userroleDao.deleteByUseridAndRoleid(userid , roleid ) ;
    }
}