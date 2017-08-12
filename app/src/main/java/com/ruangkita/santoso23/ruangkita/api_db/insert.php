<?php

if($_SERVER['REQUEST_METHOD']=='POST'){
  $response = array();

  $username = $_POST['username'];
  $password = $_POST['password'];
  $email = $_POST['email'];
  $nama = $_POST['nama'];
  $jenis_kelamin = $_POST['jenis_kelamin'];

  require_once('config.php');

  $sql = "SELECT * FROM pengguna WHERE username = '$username'";
  $check = mysqli_fetch_array(mysqli_query($con,$sql));
  if(isset($check)){
    $response["value"] = 0;
    $response["message"] = "Oops ! nim sudah terdaftar!";
    echo json_encode($response);
  } else {
    $sql = "INSERT INTO pengguna(username, password, email, nama, jenis_kelamin) VALUES ('$username','$password','$email','$nama','$jenis_kelamin')";
    if(mysqli_query($con,$sql)){
      $response["value"] = 1;
      $response["message"] = "Sukses ! terdaftar!";
      echo json_encode($response);
    } else {
      $response["value"] = 0;
      $response["message"] = "Oops ! Coba lagi!";
      echo json_encode($response);
    }
  }

  mysqli_close($con);
} else {
  $response["value"] = 0;
  $response["message"] = "Oops ! Coba lagi!";
  echo json_encode($response);
}
 ?>
