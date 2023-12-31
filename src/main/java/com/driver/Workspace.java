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
        super(emailId, Integer.MAX_VALUE);
        calendar=new ArrayList<>();
    }

    public void addMeeting(Meeting meeting){
        //add the meeting to calendar
       if(calendar.size()<Integer.MAX_VALUE){
           calendar.add(meeting);
       }
    }

    public int findMaxMeetings(){
        // find the maximum number of meetings you can attend
        // 1. At a particular time, you can be present in at most one meeting
        // 2. If you want to attend a meeting, you must join it at its start time and leave at end time.
        // Example: If a meeting ends at 10:00 am, you cannot attend another meeting starting at 10:00 am

        if(calendar.size() == 0)return 0;

        ArrayList<Pair>maxMeeting=new ArrayList<>();

        for(int i=0; i<calendar.size(); i++){
           maxMeeting.add(Pair.of(calendar.get(i).getEndTime(),i));
        }

        Collections.sort(maxMeeting);


        LocalTime time_limit= (LocalTime) maxMeeting.get(0).getLeft();

        int ctn=1;

        for(int i=1; i<maxMeeting.size(); i++){

            if(calendar.get((Integer) maxMeeting.get(i).getRight()).getStartTime().compareTo(time_limit)>0){
                ctn++;
                time_limit= (LocalTime) maxMeeting.get(i).getLeft();
            }
        }

          return ctn;
    }
}
