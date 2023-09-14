// Sample meeting room data
// const meetingRooms = [

//     {
//         name: "Meeting Room 3",
//         capacity: 5,
//         totalMeetings: 10,
//         ratings: 4
//     }   
    
// ];

// Function to generate meeting room cards
// function generateMeetingRoomCards() {
//     const meetingRoomsContainer = document.querySelector(".meeting-rooms");
    
//     meetingRooms.forEach(room => {
//         const card = document.createElement("div");
//         card.classList.add("meeting-room-card");
        
//         card.innerHTML = `
//             <h2>${room.name}</h2>
//             <p>Seating Capacity: ${room.capacity}</p>
//             <p>Total Meetings: ${room.totalMeetings}</p>
//             <p>Ratings: ${room.ratings}</p>
//         `;
        
//         meetingRoomsContainer.appendChild(card);
//     });
// }
<script>
    
    var button = document.getElementById("myButton");

    button.addEventListener("click", function () {
        // Redirect to another HTML page
        window.location.href = "user.html";
    });
</script>

// Generate meeting room cards on page load
window.addEventListener("load", generateMeetingRoomCards);
