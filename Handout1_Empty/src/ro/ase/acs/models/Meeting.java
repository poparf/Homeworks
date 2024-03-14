package ro.ase.acs.models;

import java.util.*;

public class Meeting {
    private String name;
    private int startTime;
    private int endTime;
    private Priority priority;
    private String[] participants;

    public void print(){
        System.out.println("Name: " + name);
        System.out.println("startTime: " + startTime);
        System.out.println("endTime: " + endTime);
        System.out.println("priority: " + priority);
        System.out.println("Participants: ");
        for (String participant:
             participants) {
            System.out.println(participant + " ");
        }
    }

    public Meeting() {
        this.name = "";
        this.startTime = 0;
        this.endTime = 0;
        this.priority = Priority.low;
        this.participants = null;
    }

    public Meeting(String name, int startTime, int duration) {
        this.name = name;
        this.startTime = startTime;
        this.endTime = this.startTime + duration;
        this.priority = Priority.low;
        this.participants = null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getParticipants() {
        String[] newParticipants = new String[this.participants.length];
        for(int i = 0; i < newParticipants.length; i++) {
            newParticipants[i] = this.participants[i];
        }
        return newParticipants;
    }

    public void setParticipants(String[] participants) {
        this.participants = null;
        this.participants = new String[participants.length];
        for(int i = 0; i < participants.length; i++) {
            this.participants[i] = participants[i];
        }
    }

    @Override
    public Meeting clone() {
        Meeting newMeeting = new Meeting(this.name,this.startTime, this.endTime - this.startTime);
        newMeeting.setParticipants(this.participants);
        newMeeting.priority = this.priority;
        return newMeeting;
    }

    public boolean checkParticipant(String participant) {
        for(int i = 0; i < this.participants.length; i++) {
            if(Objects.equals(this.participants[i], participant)) {
                return true;
            }
        }
        return false;
    }

    public void concatenate(Meeting meeting) {
        this.name = this.name + "/" + meeting.name;
        this.startTime = Math.min(this.startTime, meeting.startTime);
        this.endTime = Math.max(this.endTime, meeting.endTime);

        if(this.priority.compareTo(meeting.priority) < 0) {
            this.priority = meeting.priority;
        }

        Map<String, Boolean> participantsMap = new HashMap<String, Boolean>();

        for (String participant:
             this.participants) {
                if(!participantsMap.containsKey(participant)) {
                    participantsMap.put(participant, true);
                }
        }

        for (String participant:
                meeting.participants) {
            if(!participantsMap.containsKey(participant)) {
                participantsMap.put(participant, true);
            }
        }

        this.participants = null;
        this.participants = new String[participantsMap.size()];
        int i = 0;
        for (Map.Entry<String,Boolean> entry : participantsMap.entrySet())
            participants[i++] = entry.getKey();
    }
}
