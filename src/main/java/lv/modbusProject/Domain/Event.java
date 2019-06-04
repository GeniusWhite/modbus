package lv.modbusProject.Domain;

import java.sql.Timestamp;

public class Event {

        private Timestamp eventDate;
        private Timestamp eventTime;
        private String eventInfo;

    public String getEventDateString() {
        return eventDateString;
    }

    public void setEventDateString(String eventDateString) {
        this.eventDateString = eventDateString;
    }

    public String getEventTimeString() {
        return eventTimeString;
    }

    public void setEventTimeString(String eventTimeString) {
        this.eventTimeString = eventTimeString;
    }

    private String eventDateString;
        private String eventTimeString;


    public Timestamp getEventDate() {
        return eventDate;
    }

    public void setEventDate(Timestamp eventDate) {
        this.eventDate = eventDate;
    }

    public Timestamp getEventTime() {
        return eventTime;
    }

    public void setEventTime(Timestamp eventTime) {
        this.eventTime = eventTime;
    }

    public String getEventInfo() {
        return eventInfo;
    }

    public void setEventInfo(String eventInfo) {
        this.eventInfo = eventInfo;
    }
}
