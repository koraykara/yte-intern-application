package yte.intern.application.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import yte.intern.application.model.Alert;
import yte.intern.application.model.Success;
import yte.intern.application.repository.AlertRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Service
public class RestTemplateAlertController {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private AlertRepository alertRepository;


    @Async
    public void controllUrl(Alert alert, LocalDateTime localDate){
        StopWatch stopWatch = new StopWatch("My Stop Watch");
            try {

                stopWatch.start("initializing");

                ResponseEntity<String> response = restTemplate.exchange(alert.getUrl(), alert.getHttpMethod() , null , String.class);
                stopWatch.stop();

                System.out.println(stopWatch.prettyPrint());
                System.out.println(stopWatch.getTotalTimeMillis());





                if (response.getStatusCodeValue() == 200 ){
                    System.out.println("istek:"+localDate);
                    Success success = new Success(null,localDate,1, (int) stopWatch.getTotalTimeMillis());

                    alert.getSuccesses().add(success);
                    alert.setTimer( alert.getControlPeriod());
                    System.out.println("Control Period : " + alert.getControlPeriod());

                }else{
                    Success success = new Success(null,localDate,0,(int) stopWatch.getTotalTimeMillis());
                    System.out.println("aaaaa");
                    alert.getSuccesses().add(success);
                }


            }
            catch (Exception e){
                stopWatch.stop();
                Success success = new Success(null,localDate,0,(int) stopWatch.getTotalTimeMillis());

                alert.getSuccesses().add(success);
                alert.setTimer( alert.getControlPeriod());
                System.out.println("HATAA : " + e.getMessage());


            }
            alertRepository.save(alert);


        }





    }

