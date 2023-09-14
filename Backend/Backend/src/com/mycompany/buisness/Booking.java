package com.mycompany.buisness;


import java.util.Date;

public class Booking {
    private String bookingId;
    private String meetingRoomId;
    private Date date;
    private int startTime;
    private int endTime;
    private String bookedById;

    public Booking() {
        // Default constructor
    }

    public Booking(String bookingId, String meetingRoomId, Date date, int startTime, int endTime, String bookedById) {
        this.bookingId = bookingId;
        this.meetingRoomId = meetingRoomId;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.bookedById = bookedById;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public String getMeetingRoomId() {
        return meetingRoomId;
    }

    public void setMeetingRoomId(String meetingRoomId) {
        this.meetingRoomId = meetingRoomId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    public String getBookedById() {
        return bookedById;
    }

    public void setBookedById(String bookedById) {
        this.bookedById = bookedById;
    }
}
