package cn.chinajdt.bussiness.sys.service.impl;

import cn.chinajdt.bussiness.sys.dao.SysmenucodeMapper;
import cn.chinajdt.bussiness.sys.model.Sysmenucode;
import cn.chinajdt.bussiness.sys.service.SysmenucodeService;
import cn.chinajdt.sys.exception.BsnException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Jacky on 15/11/25.
 */
@Service("sysmenucodeService")
public class SysmenucodeServiceImpl implements SysmenucodeService {

    @Autowired
    private SysmenucodeMapper dao ;

    @Override
    public int deleteByPrimaryKey(String sysmenucodeid) throws BsnException {
        return dao.deleteByPrimaryKey( sysmenucodeid) ;
    }

    @Override
    public int insert(Sysmenucode record) throws BsnException {
        return dao.insert( record );
    }

    @Override
    public int insertSelective(Sysmenucode record) throws BsnException {
        return dao.insertSelective( record );
    }

    @Override
    public Sysmenucode selectByPrimaryKey(String sysmenucodeid) {
        return dao.selectByPrimaryKey( sysmenucodeid );
    }

    @Override
    public int updateByPrimaryKeySelective(Sysmenucode record) throws BsnException {
        return dao.updateByPrimaryKeySelective( record );
    }

    @Override
    public int updateByPrimaryKey(Sysmenucode record) throws BsnException {
        return dao.updateByPrimaryKey( record);
    }

    @Override
    public List<Sysmenucode> listByMenuid(String menuid) {
        return dao.listByMenuid( menuid );
    }

    @Override
    public void deleteCodes(String[] idArr) throws BsnException {
        dao.deleteCodes( idArr );
    }
}
