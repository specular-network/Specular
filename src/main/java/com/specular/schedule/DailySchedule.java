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
    
    @Scheduled(cron = "0 0 0/1 * * ?")
    public void doSomething(){
        log.info("daily job");
    }

}
