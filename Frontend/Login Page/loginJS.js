
const sampleUsers = [
    {
        userId: "admin1",
        email: "admin1@example.com",
        userType: "admin",
    },
    {
        userId: "manager1",
        email: "manager1@example.com",
        userType: "manager",
    },
    {
        userId: "member1",
        email: "member1@example.com",
        userType: "member",
    },
    {
        userId: "admin2",
        email: "admin2@example.com",
        userType: "admin",
    },
    {
        userId: "manager2",
        email: "manager2@example.com",
        userType: "manager",
    },
    {
        userId: "member2",
        email: "member2@example.com",
        userType: "member",
    },
];

    // document.getElementById("myButton").addEventListener("click", login);

function login() {
    const userId = document.getElementById("user-id").value;
    const email = document.getElementById("email").value;
    console.log("Inside login");
    const emailPattern = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;
    
    if (userId === "" || email === "" || !emailPattern.test(email)) {
        document.getElementById("error-message").textContent = "Please enter valid User ID and Email.";
    } else {
        let userFound = false;

        for (const user of sampleUsers) {
            if (user.userId === userId && user.email === email) {
                userFound = true;
                console.log("Inside login");
                if (user.userType === "admin") {
                    
                    window.location.href = "../User/Admin.html";
                    
                } else if (user.userType === "manager") {
                    window.location.href = "../Manager/manager.html";
                } else {
                    window.location.href = "../Member/member.html";
                }
                break; 
            }
        }

        if (!userFound) {
            document.getElementById("error-message").textContent = "User not found. Please check your credentials.";
        }
        
    }
}
