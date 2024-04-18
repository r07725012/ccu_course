<?php 
header("Content-Type:text/html; charset=utf-8");

     if($_SERVER['REQUEST_METHOD']=='POST'){
     
         //Getting values
         
         $account = $_POST['account'];
         //$password = $_POST['password'];
         $name = $_POST['name'];
         $sex = $_POST['sex'];
         $phone = $_POST['phone'];
         $email = $_POST['email'];
        
         //importing database connection script 
         require_once('dbConnect.php');
         //$sql = "select * from member where member_account='$account'"; //use account as id to update info
         //$value = mysqli_fetch_array(mysqli_query($con,$sql));


         //TO DO
         if($name!=NULL || $sex!=NULL || $phone!=NULL || $email!=NULL)
         {
            

            //Creating an sql query
            $sql = "UPDATE member SET name = '$name', sex = '$sex', phone = '$phone', mail = '$email' WHERE member_account = '$account';";
            
            if(mysqli_query($con,$sql))
            {
               echo '更新成功';

               /*
               $sql = "SELECT * FROM member WHERE memberID=33";
               $row = mysqli_query($con,$sql);
               $value = mysqli_fetch_array($row);
               echo $value['name'];
   */
            }
            else
            {
               echo '更新失敗';
            }

            

         }
         else
         {
            // cannot work????
            echo '無資料更新';
         }        
         
         //Closing the database 
         mysqli_close($con);

      }


      
?>