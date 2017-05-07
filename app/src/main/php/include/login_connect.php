<?php

/**
Functions in this class are from https://www.androidtutorialpoint.com/androidwithphp/android-login-and-registration-with-php-mysql/
*/
class login_connect {
    private $conn;

    // Connecting to database
    public function connect() {
        require_once 'Config.php';

        // Connecting to mysql database
        $this->conn = new mysqli(DB_HOST, DB_USER, DB_PASSWORD, DB_NAME);
        // return database object
        return $this->conn;
    }
}

?>