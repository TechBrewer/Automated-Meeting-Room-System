package com.mycompany.buisness;
import com.mycompany.buisness.Meeting;
import com.mycompany.persistence.MeetingDao;
import com.mycompany.exceptions.BusinessException;
import com.mycompany.exceptions.DataAccessException;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public class MeetingManager {
    private MeetingDao meetingDao;

    public MeetingManager(MeetingDao meetingDao) {
        this.meetingDao = meetingDao;
    }

    public Meeting getMeetingById(String meetingId) throws BusinessException {
        try {
            Meeting meeting = meetingDao.getMeetingById(meetingId);
            if (meeting == null) {
                throw new BusinessException("Meeting not found with ID: " + meetingId);
            }
            return meeting;
        } catch (DataAccessException e) {
            throw new BusinessException("Error fetching meeting by ID", e);
        }
    }

    public List<Meeting> getAllMeetings() throws BusinessException {
        try {
            return meetingDao.getAllMeetings();
        } catch (DataAccessException e) {
            throw new BusinessException("Error fetching all meetings", e);
        }
    }

    public Meeting createMeeting(Meeting meeting) throws BusinessException {
        try {
            // Validate meeting input
            validateMeeting(meeting);

            // Generate a unique meeting ID (You can use a UUID or any other method)
            meeting.setMeetingId(generateUniqueMeetingId());

            // Create the meeting
            Meeting createdMeeting = meetingDao.createMeeting(meeting);

            return createdMeeting;
        } catch (DataAccessException e) {
            throw new BusinessException("Error creating meeting", e);
        }
    }

    public Meeting updateMeeting(Meeting meeting) throws BusinessException {
        try {
            // Validate meeting input
            validateMeeting(meeting);

            // Update the meeting
            Meeting updatedMeeting = meetingDao.updateMeeting(meeting);

            return updatedMeeting;
        } catch (DataAccessException e) {
            throw new BusinessException("Error updating meeting", e);
        }
    }

    public void deleteMeeting(String meetingId) throws BusinessException {
        try {
            meetingDao.deleteMeeting(meetingId);
        } catch (DataAccessException e) {
            throw new BusinessException("Error deleting meeting", e);
        }
    }

    // Other business methods for meeting management

    // Helper method to validate meeting input
    private void validateMeeting(Meeting meeting) throws BusinessException {
        if (meeting == null || meeting.getTitle() == null || meeting.getTitle().isEmpty()
                || meeting.getOrganizedBy() == null || meeting.getMeetingDate() == null
                || meeting.getStartTime() < 0 || meeting.getEndTime() <= meeting.getStartTime()) {
            throw new BusinessException("Invalid meeting data.");
        }
    }

    // Helper method to generate a unique meeting ID (you can replace this with your own logic)
    private String generateUniqueMeetingId() {
        // Generate a unique meeting ID (e.g., using UUID.randomUUID().toString())
        return UUID.randomUUID().toString();
    }
}
