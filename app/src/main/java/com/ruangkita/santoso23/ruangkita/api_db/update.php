<?php

if($_SERVER['REQUEST_METHOD']=='POST'){
  $response = array();

  $username = $_POST['username'];
  $password = $_POST['password'];
  $email = $_POST['email'];
  $nama = $_POST['nama'];
  $jenis_kelamin = $_POST['jenis_kelamin'];

  require_once('config.php');

  $sql = "UPDATE pengguna SET password = '$password', email='$email', nama='$nama', jenis_kelamin = '$jenis_kelamin' WHERE username = '$username'";

  if(mysqli_query($con, $sql)){
    $response["value"] = 1;
    $response["message"] = "Berhasil di perbaharui!";
    echo json_encode($response);
  } else {
    $response["value"] = 0;
    $response["message"] = "Oops ! Coba lagi!";
    echo json_encode($response);
  }

  mysqli_close($con);
}
 ?>
