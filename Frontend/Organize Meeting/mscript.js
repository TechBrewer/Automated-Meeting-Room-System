document.addEventListener("DOMContentLoaded", function () {
    // Get a reference to the form
    const meetingForm = document.getElementById("meetingForm");

    // Add an event listener for form submission
    meetingForm.addEventListener("submit", function (event) {
        event.preventDefault(); // Prevent the default form submission
        
        // Get form values
        const title = document.getElementById("title").value;
        const meetingDate = new Date(document.getElementById("meetingDate").value);
        const startTime = document.getElementById("startTime").value;
        const duration = parseInt(document.getElementById("duration").value);
        const meetingType = document.getElementById("meetingType").value;

        // Validate the form
        if (validateForm(title, meetingDate, startTime, duration, meetingType)) {
            // Deduct credits (you can implement this function)
            if (deductCredits()) {
                // If credits were deducted successfully, submit the form
                meetingForm.submit();
            } else {
                alert("Insufficient credits to book the meeting.");
            }
        } else {
            alert("Please fill in all fields correctly and meet the business rules.");
        }
    });

    function validateForm(title, meetingDate, startTime, duration, meetingType) {
        const currentDate = new Date();
        
        // Check if all fields are filled
        if (!title || !meetingDate || !startTime || !duration || !meetingType) {
            return false;
        }

        // Check if meeting date is in the future
        if (meetingDate <= currentDate) {
            return false;
        }

        // Check if meeting room is available (you can implement this)
        if (!isMeetingRoomAvailable(meetingDate, startTime, duration)) {
            return false;
        }

        // Check if seating capacity is sufficient (you can implement this)
        if (!isSeatingCapacitySufficient(duration)) {
            return false;
        }

        // Check if the project manager has enough credits (you can implement this)
        if (!hasEnoughCredits()) {
            return false;
        }

        // Validate amenities based on meeting type (you can implement this)
        if (!validateAmenities(meetingType)) {
            return false;
        }
        

        return true;
    }

    function addSelectedMember(memberName) {
        const selectedMembersList = document.getElementById("selectedMembersList");
        const listItem = document.createElement("li");
        listItem.className = "list-group-item";
        listItem.textContent = memberName;
        selectedMembersList.appendChild(listItem);
    }
    
    function searchMembers() {
        const searchInput = document.getElementById("searchMembers");
        const searchResults = document.getElementById("searchResults");
    
        // Replace this with your actual logic to search for members and get member names
        const memberNames = ["Member 1", "Member 2", "Member 3"];
    
        // Clear previous search results
        searchResults.innerHTML = "";
    
        // Display search results and allow selecting members
        memberNames.forEach(memberName => {
            const listItem = document.createElement("li");
            listItem.className = "list-group-item";
            listItem.textContent = memberName;
            listItem.addEventListener("click", () => {
                addSelectedMember(memberName);
            });
            searchResults.appendChild(listItem);
        });
    }
    

    function isMeetingRoomAvailable(meetingDate, startTime, duration) {
        // Implement logic to check meeting room availability
        // Return true if available, false otherwise
    }

    function isSeatingCapacitySufficient(duration) {
        // Implement logic to check seating capacity
        // Return true if sufficient, false otherwise
    }

    function hasEnoughCredits() {
        // Implement logic to check if the project manager has enough credits
        // Return true if enough credits, false otherwise
    }

    function validateAmenities(meetingType) {
        // Implement logic to validate amenities based on meeting type
        // Return true if valid, false otherwise
    }

    function deductCredits() {
        // Implement logic to deduct credits
        // Return true if successful, false otherwise
    }
});
