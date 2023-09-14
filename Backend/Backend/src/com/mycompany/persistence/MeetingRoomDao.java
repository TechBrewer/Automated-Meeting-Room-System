package com.mycompany.persistence;

import com.mycompany.buisness.MeetingRoom;
import com.mycompany.exceptions.DataAccessException;
import java.util.Date;
import java.util.List;

public interface MeetingRoomDao {
    MeetingRoom getMeetingRoomById(String roomId) throws DataAccessException;

    MeetingRoom getMeetingRoomByName(String roomName) throws DataAccessException;

    List<MeetingRoom> getAllMeetingRooms() throws DataAccessException;

    MeetingRoom createMeetingRoom(MeetingRoom meetingRoom) throws DataAccessException;

    MeetingRoom updateMeetingRoom(MeetingRoom meetingRoom) throws DataAccessException;

    void deleteMeetingRoom(String roomId) throws DataAccessException;

    List<MeetingRoom> getMeetingRoomsByCapacity(int minCapacity, int maxCapacity) throws DataAccessException;

    MeetingRoom getMeetingRoomWithMinimumCost() throws DataAccessException;

    List<MeetingRoom> getAvailableMeetingRoomsForMeeting(Date date, int startTime, int duration) throws DataAccessException;
}
