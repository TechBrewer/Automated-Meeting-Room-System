package com.mycompany.persistence;

import com.mycompany.buisness.Booking;
import com.mycompany.exceptions.DataAccessException;

import java.util.Date;
import java.util.List;

public interface BookingDao {
    Booking getBookingById(String bookingId) throws DataAccessException;

    List<Booking> getAllBookings() throws DataAccessException;

    Booking createBooking(Booking booking) throws DataAccessException;

    Booking updateBooking(Booking booking) throws DataAccessException;

    void deleteBooking(String bookingId) throws DataAccessException;

    List<Booking> getBookingsByMeetingRoom(String roomId) throws DataAccessException;

    List<Booking> getBookingsByUser(String userId) throws DataAccessException;

    List<Booking> getBookingsForMeeting(Date date, int startTime, int duration) throws DataAccessException;

    boolean isMeetingRoomAvailable(String roomId, Date date, int startTime, int duration) throws DataAccessException;
}
