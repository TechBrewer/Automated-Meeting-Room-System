// Sample data for scheduled meetings (replace with actual data)
const meetings = [
    { name: 'Meeting 1', room: 'Room A', startDate: '2023-09-12', startTime: '10:00 AM', duration: '2 hours' },
    { name: 'Meeting 2', room: 'Room B', startDate: '2023-09-13', startTime: '2:00 PM', duration: '1.5 hours' },
    // Add more meeting objects here
];

// Function to display scheduled meetings
function displayMeetings() {
    const meetingList = document.getElementById('meeting-list');
    meetingList.innerHTML = '';

    meetings.forEach((meeting) => {
        const listItem = document.createElement('li');
        listItem.textContent = `Meeting Name: ${meeting.name}, Meeting Room: ${meeting.room}, Start Date and Time: ${meeting.startDate} ${meeting.startTime}, Duration: ${meeting.duration}`;
        meetingList.appendChild(listItem);
    });
}

// Event listener for the "Organize Meeting" button (replace with your logic)
const organizeMeetingBtn = document.getElementById('organize-meeting-btn');
organizeMeetingBtn.addEventListener('click', () => {
    // Add your logic for organizing a meeting here
    window.location.href = "../Organize Meeting/manager.html";
});

// Display scheduled meetings when the page loads
window.addEventListener('load', displayMeetings);
