`taro`
CREATE TABLE meeting_room (
    room_id INT AUTO_INCREMENT PRIMARY KEY,
    room_name VARCHAR(255) NOT NULL UNIQUE,
    seating_capacity INT,
    ratings DECIMAL(3, 2),
    amenities TEXT
);
