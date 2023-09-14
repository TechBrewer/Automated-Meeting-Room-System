document.getElementById('meeting-room-form').addEventListener('submit', function (event) {
    event.preventDefault();

    document.getElementById('name-error').textContent = 'Invalid name';
    document.getElementById('capacity-error').textContent = 'Invalid capacity';
    document.getElementById('amenities-error').textContent = 'Invalid amenities';

    const nameInput = document.getElementById('room-name');
    const capacityInput = document.getElementById('seating-capacity');
    const amenitiesInputs = document.querySelectorAll('input[name="amenities"]:checked');
    const meetingTypeSelect = document.getElementById('meeting-type');
    const selectedMeetingType = meetingTypeSelect.value;

    let isValid = true;
    if (nameInput.value === '') {
        document.getElementById('name-error').textContent = 'Name is required.';
        isValid = false;
    }

    if (capacityInput.value === '' || capacityInput.value < 1) {
        document.getElementById('capacity-error').textContent = 'Seating Capacity must be at least 1.';
        isValid = false;
    }

    // Custom validation based on meeting type
    if (selectedMeetingType === 'classroom' && amenitiesInputs.length < 2) {
        document.getElementById('amenities-error').textContent = 'Classroom Training requires at least 2 amenities.';
        isValid = false;
    } else if (selectedMeetingType === 'online' && !amenitiesInputs.some(input => input.value === 'Projector' && input.checked) || !amenitiesInputs.some(input => input.value === 'Wi-Fi Connection' && input.checked)) {
        document.getElementById('amenities-error').textContent = 'Online Training requires Projector and Wi-Fi Connection.';
        isValid = false;
    } else if (selectedMeetingType === 'conference' && !amenitiesInputs.some(input => input.value === 'Conference call facility' && input.checked)) {
        document.getElementById('amenities-error').textContent = 'Conference Call requires Conference call facility.';
        isValid = false;
    } else if (selectedMeetingType === 'business' && !amenitiesInputs.some(input => input.value === 'Projector' && input.checked)) {
        document.getElementById('amenities-error').textContent = 'Business meeting requires Projector.';
        isValid = false;
    }

    if (isValid) {
        // Calculate charges (example calculation)
        const durationInHours = 2; // Replace this with actual duration calculation
        const charges = durationInHours * parseFloat(hourlyRateInput.value);

        // Generate a unique ID (example: timestamp + random number)
        const uniqueID = Date.now() + Math.floor(Math.random() * 10000);

        // Respond to the client
        alert(`Form submitted successfully. Charges: $${charges.toFixed(2)} USD, Unique ID: ${uniqueID}`);
    }

    const checkboxes = document.querySelectorAll('input[name="amenities"]:checked');

    if (checkboxes.length >= 2) {
        // At least two checkboxes are selected
        console.log("At least two checkboxes are selected.");
    } else {
        // Less than two checkboxes are selected
        console.log("Select at least two checkboxes.");
    }

});