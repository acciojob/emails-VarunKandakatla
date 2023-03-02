package com.driver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashSet;

public class Gmail extends Email {

    int inboxCapacity; //maximum number of mails inbox can store
    //Inbox: Stores mails. Each mail has date (Date), sender (String), message (String).
    // It is guaranteed that message is distinct for all mails.
    //Trash: Stores mails. Each mail has date (Date), sender (String), message (String)
//    LinkedHashSet<Email> Inbox=new LinkedHashSet<>();
    ArrayList<Mail>Inbox;
//    <Email> Trash=new LinkedHashSet<>();
    ArrayList<Mail> Trash;
    public Gmail(String emailId){
        super(emailId);
    }
    public Gmail(String emailId, int inboxCapacity) {
            super((emailId));
            Trash=new ArrayList<>();
            Inbox=new ArrayList<>();
           this.inboxCapacity=inboxCapacity;
    }

    public void receiveMail(Date date, String sender, String message){
        // If the inbox is full, move the oldest mail in the inbox to trash and add the new mail to inbox.
        // It is guaranteed that:
        // 1. Each mail in the inbox is distinct.
        // 2. The mails are received in non-decreasing order. This means that the date of a new mail
        // is greater than equal to the dates of mails received already.
        Mail mail=new Mail(date,sender,message);
        if(Inbox.size()==inboxCapacity){
            Trash.add(Inbox.remove(0));
        }
        Inbox.add(mail);
//        Collections.sort(I);

    }

    public void deleteMail(String message){
        // Each message is distinct
        // If the given message is found in any mail in the inbox, move the mail to trash, else do nothing
        for(Mail mail: Inbox){
            if(mail.Message.equals(message)){
                Inbox.remove(mail);
                Trash.add(mail);
                break;
            }
        }

    }

    public String findLatestMessage(){
        // If the inbox is empty, return null
        // Else, return the message of the latest mail present in the inbox
        if(Inbox.size()==0) return null;

        return Inbox.get(Inbox.size()-1).Message;

    }

    public String findOldestMessage(){
        // If the inbox is empty, return null
        // Else, return the message of the oldest mail present in the inbox
        if(Inbox.size()==0) return null;

        return Inbox.get(0).Message;

    }

    public int findMailsBetweenDates(Date start, Date end){
        //find number of mails in the inbox which are received between given dates
        //It is guaranteed that start date <= end date
        int count=0;
        int i=0;
        int j=0;

        boolean a=true,b=true;

        for(Mail m :Inbox){
            if(m.date.equals(start) && a){
                i=Inbox.indexOf(m);
                a=false;
            }

            if(m.date.equals(end) ){
                j=Inbox.indexOf(m);
                b=false;
            }
        }

        return j-i+1;

    }

    public int getInboxSize(){
        // Return number of mails in inbox
        return Inbox.size();

    }

    public int getTrashSize(){
        // Return number of mails in Trash
        return Trash.size();

    }

    public void emptyTrash(){
        // clear all mails in the trash
        Trash.clear();

    }

    public int getInboxCapacity() {
        // Return the maximum number of mails that can be stored in the inbox
        return inboxCapacity;
    }
}
