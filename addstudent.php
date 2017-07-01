<?php
	$connect =mysqli_connect("localhost","root","","student");
	$post = json_decode(file_get_contents('php://input'),true);
	$id =$post['id'];
	$name=$post['name'];

	echo $id;
	echo $name; 
	$sql ="insert into student (id,name) values ('$id','$name')";
	$result =mysqli_query($connect,$sql);
	mysqli_close($connect);

	if($result){
		print(json_encode('1'));
	}else{
		print(json_encode($id+$name));
	}
	
	
?>