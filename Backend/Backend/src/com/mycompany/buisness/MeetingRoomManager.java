package com.mycompany.buisness;


import com.mycompany.persistence.MeetingRoomDao;
import com.mycompany.exceptions.BusinessException;
import com.mycompany.exceptions.DataAccessException;

import java.util.List;
import java.util.UUID;

public class MeetingRoomManager {
    private MeetingRoomDao meetingRoomDao;

    public MeetingRoomManager(MeetingRoomDao meetingRoomDao) {
        this.meetingRoomDao = meetingRoomDao;
    }

    public MeetingRoomManager() {
		// TODO Auto-generated constructor stub
	}

	public MeetingRoom getMeetingRoomByName(String roomName) throws BusinessException {
        try {
            MeetingRoom meetingRoom = meetingRoomDao.getMeetingRoomByName(roomName);
            if (meetingRoom == null) {
                throw new BusinessException("Meeting room not found with name: " + roomName);
            }
            return meetingRoom;
        } catch (DataAccessException e) {
            throw new BusinessException("Error fetching meeting room by name", e);
        }
    }

    public List<MeetingRoom> getAllMeetingRooms() throws BusinessException {
        try {
            return meetingRoomDao.getAllMeetingRooms();
        } catch (DataAccessException e) {
            throw new BusinessException("Error fetching all meeting rooms", e);
        }
    }

    public MeetingRoom createMeetingRoom(MeetingRoom meetingRoom) throws BusinessException {
        try {
            // Validate meeting room input
            validateMeetingRoom(meetingRoom);

            // Generate a unique meeting room ID (You can use a UUID or any other method)
            meetingRoom.setRoomId(generateUniqueRoomId());

            // Create the meeting room
            MeetingRoom createdRoom = meetingRoomDao.createMeetingRoom(meetingRoom);

            return createdRoom;
        } catch (DataAccessException e) {
            throw new BusinessException("Error creating meeting room", e);
        }
    }

    public MeetingRoom updateMeetingRoom(MeetingRoom meetingRoom) throws BusinessException {
        try {
            // Validate meeting room input
            validateMeetingRoom(meetingRoom);

            // Update the meeting room
            MeetingRoom updatedRoom = meetingRoomDao.updateMeetingRoom(meetingRoom);

            return updatedRoom;
        } catch (DataAccessException e) {
            throw new BusinessException("Error updating meeting room", e);
        }
    }

    public void deleteMeetingRoom(String roomId) throws BusinessException {
        try {
            meetingRoomDao.deleteMeetingRoom(roomId);
        } catch (DataAccessException e) {
            throw new BusinessException("Error deleting meeting room", e);
        }
    }

    // Other business methods for meeting room management

    // Helper method to validate meeting room input
    private void validateMeetingRoom(MeetingRoom meetingRoom) throws BusinessException {
        if (meetingRoom == null || meetingRoom.getName() == null || meetingRoom.getName().isEmpty()
                || meetingRoom.getSeatingCapacity() <= 0) {
            throw new BusinessException("Invalid meeting room data.");
        }
    }

    // Helper method to generate a unique meeting room ID (you can replace this with your own logic)
    private String generateUniqueRoomId() {
        // Generate a unique room ID (e.g., using UUID.randomUUID().toString())
        return UUID.randomUUID().toString();
    }
}
