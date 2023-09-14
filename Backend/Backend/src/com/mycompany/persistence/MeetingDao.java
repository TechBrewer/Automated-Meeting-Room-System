package com.mycompany.persistence;

import com.mycompany.buisness.Meeting;
import com.mycompany.exceptions.DataAccessException;

import java.util.Date;
import java.util.List;

public interface MeetingDao {
    Meeting getMeetingById(String meetingId) throws DataAccessException;

    List<Meeting> getAllMeetings() throws DataAccessException;

    Meeting createMeeting(Meeting meeting) throws DataAccessException;

    Meeting updateMeeting(Meeting meeting) throws DataAccessException;

    void deleteMeeting(String meetingId) throws DataAccessException;

    List<Meeting> getMeetingsByUser(String userId) throws DataAccessException;

    List<Meeting> getMeetingsByRoom(String roomId) throws DataAccessException;

    List<Meeting> getMeetingsForDate(Date date) throws DataAccessException;

    List<Meeting> getMeetingsForTimeRange(Date date, int startTime, int endTime) throws DataAccessException;

    boolean isMeetingTimeSlotAvailable(String roomId, Date date, int startTime, int duration) throws DataAccessException;
}
