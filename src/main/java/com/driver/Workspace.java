package com.driver;

import org.apache.commons.lang3.tuple.Pair;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

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
    public int findMaxMeetings(){
        Collections.sort(calendar,(a,b)->{
            return a.getStartTime()-b.getEndTime();
        });
        return 0;
    }

//    public int findMaxMeetings(){
//        // find the maximum number of meetings you can attend
//        // 1. At a particular time, you can be present in at most one meeting
//        // 2. If you want to attend a meeting, you must join it at its start time and leave at end time.
//        // Example: If a meeting ends at 10:00 am, you cannot attend another meeting starting at 10:00 am
//       ArrayList<meeting> meet=new ArrayList<>();
//        for (int i = 0; i < calendar.size(); i++) {
//
//            // Creating object of meeting
//            // and adding in the list
//
//            meet.add(new meeting(calendar.get(i).getStartTime(), calendar.get(i).getEndTime(),i));
//
//        }
//
//        // Function call
//        return maxMeeting(meet, meet.size());
////        return 0;
//
//    }
//    class mycomparator implements Comparator<meeting> {
//        @Override public int compare(meeting o1, meeting o2)
//        {
//            int s1=StringtoInt(o1.end.toString());
//            int s2=StringtoInt(o1.end.toString());
//            if (s1 < s2) {
//
//                // Return -1 if second object is
//                // bigger than first
//                return -1;
//            }
//            else if (s1 > s2)
//
//                // Return 1 if second object is
//                // smaller than first
//                return 1;
//
//            return 0;
//        }
//    }
//
//    // Custom class for storing starting time,
//// finishing time and position of meeting.
//    class meeting {
//        LocalTime start;
//        LocalTime end;
//        int pos;
//
//        meeting(LocalTime start, LocalTime end, int pos)
//        {
//            this.start = start;
//            this.end = end;
//            this.pos = pos;
//        }
//    }
//
//
//
//        // Function for finding maximum meeting in one room
//        public  int maxMeeting(ArrayList<meeting> al,
//                                      int s) {
//
//            // Initialising an arraylist for storing answer
//            ArrayList<Integer> m = new ArrayList<>();
//
//            int time_limit = 0;
//
//            mycomparator mc = new mycomparator();
//
//            // Sorting of meeting according to
//            // their finish time.
//            Collections.sort(al, mc);
//
//            // Initially select first meeting.
//            m.add(al.get(0).pos);
//
//            // time_limit to check whether new
//            // meeting can be conducted or not.
////            time_limit = al.get(0).end;
//            time_limit=StringtoInt(al.get(0).end.toString());
//
//            // Check for all meeting whether it
//            // can be selected or not.
//            for (int i = 1; i < al.size(); i++) {
////                if (al.get(i).start > time_limit) {
//                    if(StringtoInt(al.get(i).start.toString())> time_limit){
//                    // Add selected meeting to arraylist
//                    m.add(al.get(i).pos);
//
//                    // Update time limit
////                    time_limit = al.get(i).end;
//                        time_limit=StringtoInt(al.get(i).end.toString());
//                }
//            }
//            return m.size();
//
//        }
//
//        public int StringtoInt(String name){
//            String ans="";
//            for(int i=0;i<name.length();i++){
//                char ch=name.charAt(i);
//                if(ch>='0' && ch<='9'){
//                    ans+=ch;
//                }
//            }
//
//            return Integer.parseInt(ans);
//        }

}
