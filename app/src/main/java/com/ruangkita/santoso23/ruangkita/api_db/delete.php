<?php
require_once('config.php');
if($_SERVER['REQUEST_METHOD']=='POST') {

   $response = array();
   // untuk mendapatkan data

   $username = $_POST['username'];

   $sql = "DELETE FROM pengguna WHERE username = '$username'";
  
   if(mysqli_query($con,$sql)){
     $response["value"] = 1;
     $response["message"] = "Berhasil Di Hapus";
     echo json_encode($response);
   } else {
       $response["value"] = 0;
       $response["message"] = "Opps, Gagal Dihapus";
       echo json_encode($response);
   }
   // tutup database
   mysqli_close($con);
}
