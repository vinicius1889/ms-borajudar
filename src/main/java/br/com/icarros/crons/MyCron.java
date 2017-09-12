package br.com.icarros.crons;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class MyCron {

//h m s
    @Scheduled(cron = "* * * * * ?")
    public void syncCores(){
        Logger logger = LoggerFactory.getLogger(getClass());
        logger.debug("Teste agora em debug -> "+new Date().getTime());
        logger.error("Teste agora em error -> "+new Date().getTime());

    }


}
