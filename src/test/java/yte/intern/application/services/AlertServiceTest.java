package yte.intern.application.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import yte.intern.application.model.Alert;
import yte.intern.application.repository.AlertRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;

@RunWith(SpringJUnit4ClassRunner.class)
public class AlertServiceTest {

    @Mock
    AlertRepository alertRepository;


    @InjectMocks
    AlertService alertService;

    @Test
    public void addAlert() {
        Alert alert = new Alert();
        given(alertRepository.save(any(Alert.class))).willReturn(alert);

        //when
        Alert savedAlerts = alertService.addAlert(new Alert());

        //then
        then(alertRepository).should().save(any(Alert.class));
        assertNotNull(savedAlerts);
    }

    @Test
    public void getAlertById() {
        //given
        Alert alert = new Alert();
        given(alertRepository.findById(1L)).willReturn(Optional.of(alert));

        //when
        Alert foundAlert = alertService.getAlertById(1L);


        //then
        then(alertRepository).should().findById(anyLong());

        assertNotNull(foundAlert);
    }

    @Test
    public void getAlerts() {
        Alert alert = new Alert();
        List<Alert> alerts = new ArrayList<Alert>();
        alerts.add(alert);
        given(alertRepository.findAll()).willReturn(alerts);
        //when(alertRepository.findAll()).thenReturn(alerts);

        //when
        List<Alert> foundAlerts = alertService.getAlerts();

        //then
        then(alertRepository).should().findAll();
        //verify(alertRepository).findAll();
        assertEquals(1,foundAlerts.size());

    }

    @Test
    public void deleteAlert() {
        alertService.deleteAlert(1L);
        alertService.deleteAlert(1l);

        //then
        //verify(alertRepository).deleteById(anyLong());
        then(alertRepository).should(times(2)).deleteById(anyLong());
    }

    @Test
    public void updateAlert() {
        
    }

    @Test
    public void getById() {
    }
}