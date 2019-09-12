package yte.intern.application.controller;

import lombok.RequiredArgsConstructor;


import org.springframework.web.bind.annotation.*;

import yte.intern.application.model.Alert;
import yte.intern.application.model.Success;
import yte.intern.application.services.AlertService;

import java.util.List;
import java.util.Set;


@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
public class AlertController {
    private final AlertService alertService;

    @GetMapping("/listAlert")
    public List<Alert> getAlerts() {
        return alertService.getAlerts();
    }



    @GetMapping("/success/{id}")
    public Set<Success> getById(@PathVariable final Long id){
        return alertService.getAlertById(id).getSuccesses();
    }

    @GetMapping("/alert/{id}")
    public Alert getAlert(@PathVariable final Long id){
        return alertService.getAlertById(id);
    }


    @PostMapping("/addAlert")
    public Alert addAlert(@RequestBody final Alert alert){
        return alertService.addAlert(alert);
    }


    @DeleteMapping("/deleteAlert/{id}")
    public void deleteAlert(@PathVariable final Long id){
        alertService.deleteAlert(id);
        System.out.println("deleted");
    }

    @PutMapping("/updateAlert")
    public Alert updateAlert(@RequestBody final Alert alert , @RequestParam String name){
        return alertService.updateAlert(alert , name);
    }


}
