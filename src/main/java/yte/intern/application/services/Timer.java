package yte.intern.application.services;


import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import yte.intern.application.model.Alert;
import yte.intern.application.repository.AlertRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class Timer {

    @Autowired
    private AlertRepository alertRepository;

    @Autowired
    private RestTemplateAlertController restTemplateAlertController;

    @Scheduled(fixedDelay = 1000)
    public void timerScheduler(){

        List<Alert> alerts = alertRepository.findAll();

        for(Alert alert : alerts){

            if(alert.getTimer()==1){

                LocalDateTime localDate = LocalDateTime.now();

                restTemplateAlertController.controllUrl(alert,localDate);

            }
            else{
                alert.setTimer(alert.getTimer()-1);
                alertRepository.save(alert);
            }






        }



    }


}
