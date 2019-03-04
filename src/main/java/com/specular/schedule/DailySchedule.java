package com.specular.schedule;


import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author jzx
 * @date 2019/01/31 10:44
 * @Description:
 */

@Component
@Slf4j
public class DailySchedule {
    
    /**
     * 发送给管理人员
     */
    @Scheduled(cron = "0 0 22 * * ?")
    public void siteReport(){
        log.info("siteReport repo");
    }
    
    /**
     * 发送给客户
     */
    @Scheduled(cron = "0 0 8 * * ?")
    public void dailyReport(){
        log.info("dailyReport repo");
    }
}
