<?php
/**
The following php code is responsible for grouping the users in the table together who answered questions similarly. 
A portion of java code will retreive this code in order to display the matches to the user
*/

//Connects to database
$dbhost = 'mysql13.000webhost.com';
$dbuser = 'a2588782_kevron';
$dbpass = '********';
$conn = mysql_connect($dbhost, $dbuser, $dbpass);

//If there is no connection or fails to connect, display error message
if(!$conn)
{
  die('Could not connect: ' . mysql_error());
}
//gets the id of the user who is currently logged in
$id = $_GET['id'];
/*SQL statement that groups the users in the "users" table together who answered the same questions.
For example, if user A answers 5 questions the same as user B, user A and B will be joined together
*/
$sql = 'SELECT 
			u.id AS similar_user_id, 
			count(*) as same_answer_count 
        FROM users u 
			JOIN user_question_answers a ON u.id = a.id
			JOIN user_question_answers a2 ON a.question_id = a2.question_id
        WHERE a2.id = "$id" AND
			 a2.`choice_id` = a.`choice_id` AND
			 u.id != a2.id
        GROUP BY u.id
        HAVING same_answer_count >= 5
        ORDER BY same_answer_count DESC';
		
//Gets the database
mysql_select_db('a2588782_higsDB');
$retval = mysql_query( $sql, $conn ); //retval = return value 

/*If there is no return value between the SQL statement and the established database connection,
show that data could not be retreived.
*/
if(!$retval)
{
  die('Could not get data: ' . mysql_error());
}

//Gets each user from what is returned in "$retval"
while($row = mysql_fetch_array($retval, MYSQL_ASSOC))
{
    $response = "User ID :{$row['id']}  <br> ".
         "Name: {$row['name']} <br> ".
         "Email: {$row['email']} <br> ".
         "Gender: {$row['gender']} <br> ".
         "--------------------------------<br>";
} 

//Shows each user from what is returned in "$retval" 
echo json_encode($response);
echo "Matches successfully retreived\n";
mysql_close($conn);
?>