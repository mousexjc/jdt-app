package cn.chinajdt.bussiness.sys.dao;

import cn.chinajdt.bussiness.sys.model.Sysmenu;
import cn.chinajdt.sys.exception.BsnException;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface SysmenuMapper {

    int deleteByPrimaryKey(String sysmenuid);

    int insert(Sysmenu record);

    int insertSelective(Sysmenu record);

    Sysmenu selectByPrimaryKey(String sysmenuid);

    int updateByPrimaryKeySelective(Sysmenu record);

    int updateByPrimaryKey(Sysmenu record);

    List<Sysmenu> list( Map<String,Object> conditions ) ;

    void deleteMenus(String[] idArr) throws BsnException ;
}