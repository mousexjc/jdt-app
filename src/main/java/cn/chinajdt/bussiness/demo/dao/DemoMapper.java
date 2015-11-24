package cn.chinajdt.bussiness.demo.dao;

import cn.chinajdt.bussiness.demo.model.Demo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DemoMapper {
    int deleteByPrimaryKey(String id);

    int insert(Demo record);

    int insertSelective(Demo record);

    Demo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Demo record);

    int updateByPrimaryKey(Demo record);

    List<Demo> all() ;

    List<Demo> queryPage(@Param("pageNo")int pageNo,@Param("pageSize") int pageSize) ;

}
