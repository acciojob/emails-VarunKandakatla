package com.driver;

import org.apache.commons.lang3.tuple.Pair;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Workspace extends Gmail{

    private ArrayList<Meeting> calendar; // Stores all the meetings

    public Workspace(String emailId) {
        // The inboxCapacity is equal to the maximum value an integer can store.
        super(emailId);
        calendar=new ArrayList<>();

    }

    public void addMeeting(Meeting meeting){
        //add the meeting to calendar
//        if(!calendar.contains(meeting)){
            calendar.add(meeting);
//        }

    }
//    public int findMaxMeetings(){
//        Collections.sort(calendar,(a,b)->{
//            return a.getStartTime()-b.getEndTime();
//        });
//        return 0;
//    }

    public int findMaxMeetings(){
        // find the maximum number of meetings you can attend
        // 1. At a particular time, you can be present in at most one meeting
        // 2. If you want to attend a meeting, you must join it at its start time and leave at end time.
        // Example: If a meeting ends at 10:00 am, you cannot attend another meeting starting at 10:00 am
      List<meeting> meetingsList=new ArrayList<>();
      int i=1;

      for(Meeting m : calendar)
      {
          String startingTime[]=m.getStartTime().toString().split(":");
          String endTime[]=m.getEndTime().toString().split(":");
          int sTime=Integer.parseInt(startingTime[0])*100+Integer.parseInt(startingTime[1]);
          int eTime=Integer.parseInt(endTime[0])*100+Integer.parseInt(endTime[1]);
          meetingsList.add(new meeting(sTime,eTime,i));
          i++;
      }

      Collections.sort(meetingsList,(a,b)->{
          if(a.end<b.end)
              return -1;
          else if(a.end> b.end)
              return 1;
          else if(a.pos<b.pos)
              return -1;
          return 1;
      });

      for( i=1;i<meetingsList.size();i++)
      {
          if(meetingsList.get(i-1).end>meetingsList.get(i).start)
          {
              meetingsList.remove(i);
          }
      }

      return meetingsList.size();

    }


}

class meeting{
    int start;
    int end;
    int pos;

    meeting(int a,int b, int c)
    {
        start=a;
        end=b;
        pos=c;
    }
}
