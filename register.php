<?php

include 'DatabaseConfig.php' ;
 
 $con = mysqli_connect($HostName,$HostUser,$HostPass,$DatabaseName);
 //mysql_query($con,"SET NAMES UTF8");
 //mysqli_set_charset($conn, 'utf8');
 
 $name = $_POST['name'];
 $email = $_POST['email'];
 $kategori=$_POST['kategori'];

 $Sql_Query = "insert into linkler (aciklama,link,kategori) values ('$name','$email','$kategori')";
 
 if(mysqli_query($con,$Sql_Query)){
 
 echo 'Data Submit Successfully';
 
 }
 else{
 
 echo 'Try Again';
 
 }
 mysqli_close($con);
?>