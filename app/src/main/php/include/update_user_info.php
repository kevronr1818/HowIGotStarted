<?php

/**
Functions in this class are from https://www.androidtutorialpoint.com/androidwithphp/android-login-and-registration-with-php-mysql/
*/

class update_user_info {

    private $conn;

    // constructor
    function __construct() {
        require_once 'login_connect.php';
        // connecting to database
        $db = new db();
        $this->conn = $db->connect();
    }

    // destructor
    function __destruct() {

    }

    /**
     * Storing new user
     * returns user details
     */
    public function StoreUserInfo($name, $email, $password) {
        $hash = $this->hashFunction($password);
        $encrypted_password = $hash["encrypted"]; // encrypted password
        $salt = $hash["salt"]; // salt

        $stmt = $this->conn->prepare("INSERT INTO users(name, email, encrypted_password, salt) VALUES(?, ?, ?, ?)");
        $stmt->bind_param("ssssss", $name, $email, $encrypted_password, $salt);
        $result = $stmt->execute();
        $stmt->close();

        // check for successful store
        if ($result) {
            $stmt = $this->conn->prepare("SELECT name, email, encrypted_password, salt FROM users WHERE email = ?");
            $stmt->bind_param("s", $email);
            $stmt->execute();
            $stmt-> bind_result($token2,$token3,$token4,$token5);
            while ( $stmt-> fetch() ) {
               $user["name"] = $token2;
               $user["email"] = $token3;
               
            }
            $stmt->close();
            return $user;
        } else {
          return false;
        }
    }
	
	public function StoreQuestionsInfo($question_one, $question_two, $question_three, $question_four, 
	$question_five, $question_six, $question_seven, $question_eight, $question_nine, $question_ten) 
	{
       
        $stmt = $this->conn->prepare("INSERT INTO questions(question_one, question_two, question_three, question_four, 
		question_five, question_six, question_seven, question_eight, question_nine, question_ten) VALUES(What was your household size growing up?, 
		How are you when it comes to setting and achieving goals?, Which of the following do you get most of your inspiration from?, 
		When faced with a problem what are your tendencies to solve it?, Which best describes when you generally show up to where you need to be?, 
		How are you when it comes to going about your day?, If you had to take a vacation for a week where would you go out of these choices?, 
		How is your approach when dealing with people?, Which best describes how others would others describe you?, 
		While taking this assessment which best describes your general thoughts?)");
        $stmt->bind_param("ssssss", $question_one, $question_two, $question_three, $question_four, 
	$question_five, $question_six, $question_seven, $question_eight, $question_nine, $question_ten);
        $result = $stmt->execute();
        $stmt->close();

       
    }

    /**
     * Get user by email and password
     */
    public function VerifyUserAuthentication($email, $password) {

        $stmt = $this->conn->prepare("SELECT name, email, encrypted_password, salt FROM users WHERE email = ?");

        $stmt->bind_param("s", $email);

        if ($stmt->execute()) {
            $stmt-> bind_result($token2,$token3,$token4,$token5);

            while ( $stmt-> fetch() ) {
               $user["name"] = $token2;
               $user["email"] = $token3;
               $user["encrypted_password"] = $token4;
               $user["salt"] = $token5;
              
            }

            $stmt->close();

            // verifying user password
            $salt = $token5;
            $encrypted_password = $token4;
            $hash = $this->CheckHashFunction($salt, $password);
            // check for password equality
            if ($encrypted_password == $hash) {
                // user authentication details are correct
                return $user;
            }
        } else {
            return NULL;
        }
    }

    /**
     * Check user is existed or not
     */
    public function CheckExistingUser($email) {
        $stmt = $this->conn->prepare("SELECT email from users WHERE email = ?");

        $stmt->bind_param("s", $email);

        $stmt->execute();

        $stmt->store_result();

        if ($stmt->num_rows > 0) {
            // user existed 
            $stmt->close();
            return true;
        } else {
            // user not existed
            $stmt->close();
            return false;
        }
    }

    /**
     * Encrypting password
     * @param password
     * returns salt and encrypted password
     */
    public function hashFunction($password) {

        $salt = sha1(rand());
        $salt = substr($salt, 0, 10);
        $encrypted = base64_encode(sha1($password . $salt, true) . $salt);
        $hash = array("salt" => $salt, "encrypted" => $encrypted);
        return $hash;
    }

    /**
     * Decrypting password
     * @param salt, password
     * returns hash string
     */
    public function checkHashFunction($salt, $password) {
        $hash = base64_encode(sha1($password . $salt, true) . $salt);
        return $hash;
    }

}

?>