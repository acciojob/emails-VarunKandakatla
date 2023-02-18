package com.driver;

import java.text.DateFormat;
import java.util.Date;

public class Mail {

    Date date;
    String sender;
    String Message;

    public Mail(Date date, String sender, String message) {
        this.date = date;
        this.sender = sender;
        Message = message;
    }
}
