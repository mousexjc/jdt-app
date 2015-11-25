package cn.chinajdt.bussiness.sys.service.impl;

import cn.chinajdt.bussiness.sys.dao.SysmenuMapper;
import cn.chinajdt.bussiness.sys.dao.SysmenucodeMapper;
import cn.chinajdt.bussiness.sys.model.Sysmenu;
import cn.chinajdt.bussiness.sys.service.SysmenuService;
import cn.chinajdt.sys.exception.BsnException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("sysmenuService")
public class SysmenuServiceImpl implements SysmenuService {

    @Autowired
    private SysmenuMapper dao ;
    @Autowired
    private SysmenucodeMapper codeDao ;

    public int deleteByPrimaryKey(String sysmenuid)throws BsnException{
        return dao.deleteByPrimaryKey( sysmenuid) ;
    }

    public int insert(Sysmenu record)throws BsnException{
        return dao.insert( record ) ;
    }

    public int insertSelective(Sysmenu record)throws BsnException{
        return dao.insertSelective( record ) ;
    }

    public Sysmenu selectByPrimaryKey(String sysmenuid){
        return dao.selectByPrimaryKey( sysmenuid) ;
    }

    public int updateByPrimaryKeySelective(Sysmenu record)throws BsnException{
        return dao.updateByPrimaryKeySelective( record) ;
    }

    public int updateByPrimaryKey(Sysmenu record)throws BsnException{
        return dao.updateByPrimaryKey( record ) ;
    }

    public List<Sysmenu> list( Map<String,Object> conditions , int pageno , int pagesize ){
        if(conditions==null ) conditions = new HashMap<String,Object>() ;
        conditions.put("pageno" , pageno) ;
        conditions.put("pagesize" , pagesize) ;
        return dao.list( conditions) ;
    }

    @Override
    public void deleteMenus(String[] idArr) throws BsnException {
        dao.deleteMenus( idArr );
        codeDao.deleCodesByMenuid( idArr );
    }
}