package cn.chinajdt.service.demo;

import cn.chinajdt.bussiness.demo.model.Demo;
import cn.chinajdt.bussiness.demo.service.SysUserService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

/**
 * Created by Jacky on 15/11/7.
 */
public class DemoServiceImplTest {

    private SysUserService service ;

    @Before
    public void setUp() throws Exception {
        ApplicationContext _ctx = new ClassPathXmlApplicationContext( new String[]{"spring-core-config.xml"}) ;
        this.service = (SysUserService) _ctx.getBean("sysuserService");
    }

    @Test
    public void testDeleteByPrimaryKey() throws Exception {

    }

    @Test
    public void testInsert() throws Exception {
        Demo _user = new Demo() ;
        _user.setId("111");
        _user.setAge(31);
        _user.setCreatetime(new Date());
        _user.setPassword("test");
        _user.setSalary( 100000D );
        _user.setUsername("testname");
        service.insert( _user ) ;
    }

    @Test
    public void testSelectByPrimaryKey() throws Exception {
        Demo _u = service.selectByPrimaryKey("111") ;
        System.out.println( _u.getAge() );
    }

    @Test
    public void testUpdateByPrimaryKey() throws Exception {
    }
}