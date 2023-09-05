CREATE TABLE Schedules (
    schedule_id INT AUTO_INCREMENT PRIMARY KEY,
    meeting_room_id INT NOT NULL,
    DATE DATE NOT NULL,
    start_time TIME NOT NULL,
    end_time TIME NOT NULL,
    booked_by_user_id INT NOT NULL,
    FOREIGN KEY (meeting_room_id) REFERENCES meeting_room(room_id),
    FOREIGN KEY (booked_by_user_id) REFERENCES Users(user_id)
);
