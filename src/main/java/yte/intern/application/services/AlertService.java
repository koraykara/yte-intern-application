package yte.intern.application.services;

import lombok.RequiredArgsConstructor;
import yte.intern.application.model.Alert;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yte.intern.application.model.Success;
import yte.intern.application.repository.AlertRepository;

import java.util.List;


@Service
@RequiredArgsConstructor
@Transactional
public class AlertService {


    private final AlertRepository alertRepository;

    public Alert addAlert(final Alert alert){
        return alertRepository.save(alert);
    }

    public Alert getAlertById(Long id){
        return alertRepository.findById(id).get();
    }


    public List<Alert> getAlerts(){
        return alertRepository.findAll();
    }

    public void deleteAlert(final Long id){
        alertRepository.deleteById(id);
    }

    public Alert updateAlert(final Alert alert , final String name){
        Alert alertFromDB = alertRepository.findByName(name);
        if(alertFromDB != null){
            Long id = alertFromDB.getId();
            alert.setId(id);
            return alertRepository.save(alert);
        }
        return null;
    }

    public List<Success> getById(Long id){

        return alertRepository.getById(id);

    }


}
