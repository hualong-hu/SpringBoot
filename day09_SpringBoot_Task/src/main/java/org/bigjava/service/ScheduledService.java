package org.bigjava.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * @ProjectName: JavaEESenior
 * @ClassName: ScheduledService
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-10-29 14:50
 * @Version v1.0
 */
@Service
public class ScheduledService {

    /**
     * second(秒), minute（分）, hour（时）, day of month（日）, month（月）, and day of week（周几）
     * 0 * * * * MON-FRI
     * @data: 2020-10-29-14:51
     * @method: hello
     * @params: []
     * @return: void
     */
//    @Scheduled(cron = "0 * * * * MON-THU")
//    @Scheduled(cron = "0,1,2,3,4 * * * * MON-THU")
//    @Scheduled(cron = "0/4 * * * * MON-THU")
    @Scheduled(cron = "0,1,2,3,4 * * * * MON-THU")
    public void hello(){
        System.out.println("hello.....");
    }

}
