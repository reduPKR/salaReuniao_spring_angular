package com.sala_reuniao.salaDeReuniao.exception;

import java.util.Date;

public class ErrorDetails {
    private Date data;
    private String message;
    private String details;

    public ErrorDetails(Date data, String message, String details) {
        super();
        this.data = data;
        this.message = message;
        this.details = details;
    }

    public Date getData() {
        return data;
    }

    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }
}
