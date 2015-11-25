package cn.chinajdt.bussiness.sys.dao;

import cn.chinajdt.bussiness.sys.model.Sysmenucode;
import cn.chinajdt.sys.exception.BsnException;

import java.util.List;

public interface SysmenucodeMapper {

    int deleteByPrimaryKey(String sysmenucodeid);

    int insert(Sysmenucode record);

    int insertSelective(Sysmenucode record);

    Sysmenucode selectByPrimaryKey(String sysmenucodeid);

    int updateByPrimaryKeySelective(Sysmenucode record);

    int updateByPrimaryKey(Sysmenucode record);

    List<Sysmenucode> listByMenuid( String menuid ) ;

    void deleteCodes( String[] idArr)throws BsnException;

    void deleCodesByMenuid( String[] menuidArr )throws BsnException;

}