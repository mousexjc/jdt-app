package cn.chinajdt.bussiness.sys.service;

import cn.chinajdt.bussiness.sys.model.Sysmenu;
import cn.chinajdt.bussiness.sys.model.Sysmenucode;
import cn.chinajdt.sys.exception.BsnException;

import java.util.List;

public interface SysmenucodeService {

    int deleteByPrimaryKey(String sysmenucodeid)throws BsnException;

    int insert(Sysmenucode record)throws BsnException;

    int insertSelective(Sysmenucode record)throws BsnException;

    Sysmenucode selectByPrimaryKey(String sysmenucodeid);

    int updateByPrimaryKeySelective(Sysmenucode record)throws BsnException;

    int updateByPrimaryKey(Sysmenucode record)throws BsnException;

    List<Sysmenucode> listByMenuid( String menuid ) ;

    void deleteCodes( String[] idArr)throws BsnException ;
}