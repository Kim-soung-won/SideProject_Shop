const loginBtn = document.querySelector(".login-btn");
const closeBtn = document.querySelector(".close-btn");
const login = document.querySelector(".login-overlay");
loginBtn.addEventListener("click", function () {
    login.classList.add("open-modal");
    console.log(login.classList);
});
closeBtn.addEventListener("click", function () {
    login.classList.remove("open-modal");
});

