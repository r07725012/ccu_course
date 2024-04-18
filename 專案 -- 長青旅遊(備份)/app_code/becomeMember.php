<?php 
header("Content-Type:text/html; charset=utf-8");

     if($_SERVER['REQUEST_METHOD']=='POST'){
     
         //Getting values
         $account = $_POST['account'];
         $password = $_POST['password'];
         $name = $_POST['name'];
         $sex = $_POST['sex'];
         $phone = $_POST['phone'];
         $email = $_POST['email'];

         //Importing our db connection script
         require_once('dbConnect.php');
         
         if($account!=NULL && $password!=NULL && $name!=NULL && $sex!=NULL && $phone!=NULL && $email!=NULL)
         {
               if (preg_match('/^([.0-9a-z]+)@([0-9a-z]+).([.0-9a-z]+)$/i',$email) == true) 
               {   
                  $sql = "select * from member where member_account='$account'";
                  $row = mysqli_query($con,$sql);

                  if(mysqli_num_rows($row) == 0)
                  {
                     //Creating an sql query
                     $sql = "INSERT INTO `member` (`member_account`, `member_password`, `name`, `sex`, `phone`, `mail`, `point`) VALUES ('$account','$password','$name','$sex','$phone','$email', NULL);";
                     
                     if(mysqli_query($con,$sql))
                     {
                        echo '成功加入會員';

                        /*//fetch one value
                        $sql = "SELECT * FROM member WHERE memberID=1";
                        $row = mysqli_query($con,$sql);
                        $value = mysqli_fetch_array($row);
                        echo $value['name'];
            */
                     }
                     else
                     {
                        echo '資料庫輸入失敗';
                     }

                    
                  }
                  else
                  {
                     echo "此帳號已被使用，請重新註冊";
                  }

                  //Closing the database 
                  mysqli_close($con);
               }
               else
               {
                  echo "email 格式不正確";
               }

         }      
         else
         {
            echo '註冊失敗，每一欄均須填寫';
         }        
         
            
      }



?>