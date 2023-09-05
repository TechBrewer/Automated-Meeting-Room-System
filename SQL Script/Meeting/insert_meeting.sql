-- Inserting dummy data into the Meeting table
INSERT INTO Meeting (title, organized_by_user_id, meeting_date, start_time, end_time, meeting_type, attendees, meeting_room_booking_info)
VALUES
    ('Enterprise Technology', 1, '2023-09-06', '10:00:00', '11:30:00', 'Team Meeting', '2,3,4', 'Conference Room 1, Booking ID: 12345, Projector available'),
    ('MSS', 2, '2023-09-07', '14:00:00', '15:30:00', 'Management Meeting', '1,3,5', 'Boardroom A, Booking ID: 56789, Video conferencing available'),
    ('Treasury', 3, '2023-09-08', '09:30:00', '10:30:00', 'Finance Meeting', '1,2,4', 'Theater Room, Booking ID: 98765, Whiteboard available'),
    ('Cyber Security', 4, '2023-09-09', '13:00:00', '14:30:00', 'Sales Meeting', '2,3,5', 'mall Meeting Room, Booking ID: 54321, Catering available'),
    ('Training Session', 5, '2023-09-10', '11:30:00', '13:00:00', 'Training Meeting', '1,4,5', 'Lounge Area, Booking ID: 24680, Classroom seating available');
