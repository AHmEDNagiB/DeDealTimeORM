$(document).ready(function () {
    $("#edit_profile_btn").click(function () {
        $(':input[type="text"]').prop('disabled', false);

        $(':input[type="password"]').prop('disabled', false);
        $(':input[type="date"]').prop('disabled', false);

        $("#save_changes_btn").prop('disabled', false);
        $("#edit_profile_btn").prop('disabled', true);
    });
});

$(document).ready(function () {
    $("#save_changes_btn").click(function () {

        $("#edit_profile_btn").prop('disabled', false);
    });
});

$(window).load(function () {
    $(':input[type="text"]').not('#searchInput , #email-modal').prop('disabled', true);
    $(':input[type="password"]').not('#password-modal').prop('disabled', true);
    $(':input[type="date"]').prop('disabled', true);

    $("#save_changes_btn").prop('disabled', true);
    $("#edit_profile_btn").prop('disabled', false);
});

var password = document.getElementById("password")
        , confirm_password = document.getElementById("confirm_password");
function validatePassword() {

    if (password.value.length < 8 || confirm_password.value.length < 8) {
        confirm_password.setCustomValidity("Passwords Must be 8 characters at least!");

    } else if (password.value != confirm_password.value) {
        confirm_password.setCustomValidity("Passwords Don't Match");

    } else {
        confirm_password.setCustomValidity('');
    }
}

password.onchange = validatePassword;
confirm_password.onkeyup = validatePassword;