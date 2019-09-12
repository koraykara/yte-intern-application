package yte.intern.application.model;

import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.*;

public class SuccessTest {

    @Test
    public void setId() {
        Success success = new Success();
        success.setId(1L);
        assertTrue(success.getId()==1L);
    }

    @Test
    public void setLocalDate() {
        Success success = new Success();
        success.setLocalDate(LocalDateTime.now());
        assertTrue(success.getLocalDate().equals( LocalDateTime.now()));
    }

    @Test
    public void setSuccess() {
        Success success = new Success();
        success.setSuccess(1);
        assertTrue(success.getSuccess()==1);
    }

    @Test
    public void setResponseTime() {
        Success success = new Success();
        success.setResponseTime(1);
        assertTrue(success.getResponseTime()==1);
    }

    @Test
    public void getId() {
        Success success = new Success();
        success.setId(1L);
        assertTrue(success.getId()==1L);
    }

    @Test
    public void getLocalDate() {
        Success success = new Success();
        success.setLocalDate(LocalDateTime.now());
        assertTrue(success.getLocalDate().equals( LocalDateTime.now()));
    }

    @Test
    public void getSuccess() {
        Success success = new Success();
        success.setSuccess(1);
        assertTrue(success.getSuccess()==1);
    }

    @Test
    public void getResponseTime() {
        Success success = new Success();
        success.setResponseTime(1);
        assertTrue(success.getResponseTime()==1);
    }
}