<?php

require_once('config.php');

if($_SERVER['REQUEST_METHOD'] == 'GET'){
  $sql = "SELECT * FROM pengguna ORDER BY nama ASC ";
  $res = mysqli_query($con, $sql);
  $result = array();

  while($row = mysqli_fetch_array($res)){
    array_push($result, array(
      'username' => $row[0],
      'password' => $row[1],
      'email' => $row[2],
      'nama' => $row[3],
      'jenis_kelamin' => $row[4]
    ));
  }

  echo json_encode(array(
    "value" => 1,
    "result" => $result
  ));
  mysqli_close($con);
}
 ?>
