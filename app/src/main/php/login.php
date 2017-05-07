<?php
/**
Functions in this class are from https://www.androidtutorialpoint.com/androidwithphp/android-login-and-registration-with-php-mysql/
*/
require_once 'include/update_user_info.php';
$db = new update_user_info();

// json response array
$response = array("error" => FALSE);

if (isset($_POST['email']) && isset($_POST['password'])) {

    // receiving the post params
    $email = $_POST['email'];
    $password = $_POST['password'];

    // get the user by email and password
    $user = $db->VerifyUserAuthentication($email, $password);

    if ($user != false) {
        // user is found
        $response["error"] = FALSE;
        $response["user"]["name"] = $user["name"];
        $response["user"]["email"] = $user["email"];
        
        echo json_encode($response);
    } else {
        // user is not found with the credentials
        $response["error"] = TRUE;
        $response["error_msg"] = "Login credentials are wrong. Please try again!";
        echo json_encode($response);
    }
} 
else {
    // required post params is missing
    $response["error"] = TRUE;
    $response["error_msg"] = "Required parameters email or password is missing!";
    echo json_encode($response);
}
?>