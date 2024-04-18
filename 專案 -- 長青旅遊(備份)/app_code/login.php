<?php 
header("Content-Type:text/html; charset=utf-8");

	 if($_SERVER['REQUEST_METHOD']=='POST')
	 {
	 
		 //Getting values
	 	$account = $_POST['account'];
		$password = $_POST['password']; 
		$login = $_POST['login'];

		 //Importing our db connection script
		require_once('dbConnect.php');

		if( strcmp($login,"logined") != 0 ) // first round to login
		{
		 	//Creating an sql query
	  		$sql = "select * from member where member_account='$account' and member_password='$password'";
			$row = mysqli_query($con,$sql); //ask for database

			if(mysqli_num_rows($row)>0){ 
			 	echo '登入成功';
			}else{
			 	echo '登入失敗';
			}

		}
		else  // second round to get name
		{	
			$sql = "select * from member where member_account='$account'";
			$row = mysqli_query($con,$sql);
			$value = mysqli_fetch_array($row);
			echo $value['name'];

		}

		 //Executing query to database
		 
		 //Closing the database 
		mysqli_close($con);
	}
		 
?>