-- Inserting dummy data into the Schedules table
INSERT INTO Schedules (meeting_room_id, DATE, start_time, end_time, booked_by_user_id)
VALUES
    (1, '2023-09-06', '10:00:00', '11:30:00', 1),
    (2, '2023-09-07', '14:00:00', '15:30:00', 2),
    (3, '2023-09-08', '09:30:00', '10:30:00', 3),
    (1, '2023-09-09', '13:00:00', '14:30:00', 4),
    (4, '2023-09-10', '11:30:00', '13:00:00', 5);
SELECT * FROM Schedules;