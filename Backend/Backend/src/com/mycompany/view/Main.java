package com.mycompany.view;

import com.mycompany.buisness.UserManager;


import com.mycompany.exceptions.BusinessException;
import com.mycompany.exceptions.DataAccessException;
import com.mycompany.buisness.User;
import com.mycompany.buisness.MeetingManager;
import com.mycompany.buisness.MeetingRoom; // Import the MeetingRoom class
import com.mycompany.buisness.MeetingRoomManager;


public class Main {
    public static void main(String[] args) {
        // Initialize your application here
        
        // Example: Create a user with UserManager's createUser method
        UserManager userManager = new UserManager();
        try {
            // Create a User object with the required information
            User newUser = new User("john_doe", "John Doe", "john@example.com", "1234567890", 100, "Member");
            userManager.createUser(newUser); // Create the user
        } catch (BusinessException e) {
            e.printStackTrace();
        }

        // Example: Create a meeting room with MeetingRoomManager's createMeetingRoom method
        MeetingRoomManager roomManager = new MeetingRoomManager();
        try {
            // Create a MeetingRoom object with the required information
            MeetingRoom newMeetingRoom = new MeetingRoom("Room A", 10, true, true, false, true, true, false, true);
            roomManager.createMeetingRoom(newMeetingRoom); // Create the meeting room
        } catch (BusinessException e) {
            e.printStackTrace();
        }

        // Example: Organize a meeting
//        MeetingManager meetingManager = new MeetingManager();
//        try {
//            meetingManager.organizeMeeting("Project Kickoff", "2023-09-10", "10:00", "11:30", "Business");
//        } catch (BusinessException | DataAccessException e) {
//            e.printStackTrace();
//        }
    }
}

