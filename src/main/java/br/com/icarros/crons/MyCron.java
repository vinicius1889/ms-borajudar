package br.com.icarros.crons;


import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MyCron {

//h m s
    @Scheduled(cron = "* * 5 * * ?")
    public void syncCores(){
        System.out.println(" Scheduling" );
    }


}
