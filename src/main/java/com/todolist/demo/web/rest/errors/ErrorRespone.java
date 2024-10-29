package com.todolist.demo.web.rest.errors;

import java.time.LocalDateTime;
import java.util.List;

public class ErrorRespone {

    private String message;
    private Boolean success;
    private LocalDateTime date;
    private List<String> details;

    public ErrorRespone() {
        super();
    }

    public ErrorRespone(String message, List<String> details ) {
        super();
        this.message = message;
        this.details  = details;
        this.success = Boolean.FALSE;
        this.date = LocalDateTime.now();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public List<String> getDetails() {
        return details;
    }

    public void setDetails(List<String> details) {
        this.details = details;
    }
}
