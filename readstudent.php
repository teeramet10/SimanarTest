<?php

$con =mysqli_connect("localhost","root","","student");
$sql="select * from student";
$result=mysqli_query($con,$sql);
while($row=mysqli_fetch_assoc($result)){
	$output[]=$row;
}
print(json_encode($output));
mysqli_close($con);
?>