package yte.intern.application.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import yte.intern.application.model.Alert;
import yte.intern.application.model.Success;
import yte.intern.application.services.AlertService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(AlertController.class)
@RunWith(SpringRunner.class)
public class AlertControllerTest {

    @MockBean
    AlertService alertServiceMock;

    @Autowired
    MockMvc mockMvc;

    List<Alert> alertList = new ArrayList<>();



    @Test
    public void getAlerts() throws Exception {
        mockMvc.perform(get("/listAlert"))
                .andExpect(status().isOk());
    }

    @Test
    public void getById() throws Exception {
        Alert alert = new Alert();
        alert.setId(1L);

        given(alertServiceMock.getAlertById(1L)).willReturn(alert);


        System.out.println(mockMvc);
        mockMvc.perform(get("/success/1"))
                .andExpect(status().isOk());

        then(alertServiceMock).should().getAlertById(1L);
    }

    @Test
    public void getAlert() throws Exception {
        Alert alert = new Alert();
        alert.setId(1L);

        given(alertServiceMock.getAlertById(1L)).willReturn(alert);


        System.out.println(mockMvc);
        mockMvc.perform(get("/alert/1"))
                .andExpect(status().isOk());

        then(alertServiceMock).should().getAlertById(1L);
    }


    public static String objectToString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    public void addAlert() throws Exception{
        Alert alert = new Alert();
        alert.setId(1l);
        alert.setName("bilge");
        alert.setUrl("http://www.google.com");
        alert.setHttpMethod(HttpMethod.GET);
        alert.setControlPeriod(5);

        mockMvc.perform(post("/addAlert")
                .contentType(MediaType.APPLICATION_JSON)
                .content(AlertControllerTest.objectToString(alert))
        )
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void deleteAlert() throws Exception{
        Alert alert = new Alert();
        alert.setId(1L);
        //voidlere bdd uygulanmıyor

        mockMvc.perform(delete("/deleteAlert/1"))
                .andExpect(status().isOk());
    }

    @Test
    public void updateAlert() {
    }
}