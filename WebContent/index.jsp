<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Line decoder</title>
<script src="javascript/jquery-1.11.2.min.js" ></script>
<script src="javascript/basic.js" ></script>
<link rel="stylesheet" href="css/basic.css" type="text/css" media="screen" />
</head>
<body> 
	<p class="large"> Decryption Tool for LINE database(Setting and Channel) </p>
	<form id="decryptData">
		<label for="decryptDate"> Encrypted text: </label>
		<input type="text" id="enigma" name="enigma" /> 
		<br>
		<label for="decryptDate"> Android Id: </label>
		<input type="text" id="Android_id" name="android_id" />
		<br>
		<input type="submit" />
	</form>
	<hr />
	<label> Result: </label>
	<p id ="displayData" />
	<hr />	
	<p class="small"> Here is how it works </p>
	<img src="images/designs.png" border=0 width="480px" height="120px" alt="Image Not found"/>
</body>
</html>