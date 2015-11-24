package cn.chinajdt.sys.tasks;

import cn.chinajdt.bussiness.demo.model.Demo;
import cn.chinajdt.bussiness.demo.service.SysUserService;
import cn.chinajdt.sys.exception.BsnException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by Jacky on 15/11/13.
 */
@Component
public class DemoSchedule {

    Logger log = Logger.getLogger(DemoSchedule.class) ;
    @Autowired
    private SysUserService userService ;

    /**
     * fixedRate X毫秒执行一次
     * cron
     * "0/5 * * * * ? " 每5秒
     "0 0 12 * * ?"    每天中午十二点触发
     "0 15 10 ? * *"    每天早上10：15触发
     "0 15 10 * * ?"    每天早上10：15触发
     "0 15 10 * * ? *"    每天早上10：15触发
     "0 15 10 * * ? 2005"    2005年的每天早上10：15触发
     "0 * 14 * * ?"    每天从下午2点开始到2点59分每分钟一次触发
     "0 0/5 14 * * ?"    每天从下午2点开始到2：55分结束每5分钟一次触发
     "0 0/5 14,18 * * ?"    每天的下午2点至2：55和6点至6点55分两个时间段内每5分钟一次触发
     "0 0-5 14 * * ?"    每天14:00至14:05每分钟一次触发
     "0 10,44 14 ? 3 WED"    三月的每周三的14：10和14：44触发
     "0 15 10 ? * MON-FRI"    每个周一、周二、周三、周四、周五的10：15触发
     */
    @Scheduled( fixedRate = 60*60*1000 )
    public void demoTask() throws BsnException {
        Demo _user = userService.selectByPrimaryKey("111");
        System.out.println("task runs ....." + _user.getUsername() );
        log.info("Demo Task runs successfully...congratulations,Jacky~");
    }
}
