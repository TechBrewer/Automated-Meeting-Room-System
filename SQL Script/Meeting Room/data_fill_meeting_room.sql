-- Inserting dummy data into the meeting_room table
INSERT INTO meeting_room (room_name, seating_capacity, ratings, amenities)
VALUES
    ('Conference Room 1', 20, 4.5, 'Projector'),
    ('Boardroom A', 12, 4.0, 'Wi-Fi Connection'),
    ('Small Meeting Room', 6, 3.8, 'Whiteboard'),
    ('Executive Suite', 8, 4.7, 'Water Dispenser, TV'),
    ('Training Room', 30, 4.2, 'Projector, Whiteboard, Coffee Machine'),
    ('Theater Room', 50, 4.8, 'Coffee Machine, Projector'),
    ('Lounge Area', NULL, 4.6, 'Coffee Machine, Wi-Fi Connection');