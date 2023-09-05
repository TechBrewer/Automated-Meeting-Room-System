CREATE TABLE Meeting (
    meeting_id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    organized_by_user_id INT NOT NULL,
    meeting_date DATE NOT NULL,
    start_time TIME NOT NULL,
    end_time TIME NOT NULL,
    meeting_type VARCHAR(50),
    attendees TEXT,
    meeting_room_booking_info TEXT
);
