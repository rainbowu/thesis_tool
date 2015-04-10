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
	<p class="large"> How to decrypt LINE database </p>
	<form id="decryptData">
		<label for="decryptDate"> What do you want decrypt? </label>
		<input type="text" id="enigma" name="enigma" />
		<input type="submit" />
	</form>
	<p id ="displayData" />
	<p class="small"> Here is how it works </p>
	
</body>
</html>