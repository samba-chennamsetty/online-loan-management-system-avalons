<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Online Loan Management System</title>
<meta name="description" content="A demo of a card payment on Stripe" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js"></script>
<script src="../static/js/customer.js"></script>
<link rel="stylesheet" href="../static/css/global.css" />

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" />
<style type="text/css">
body {
	/* 	color: #000;
	overflow-x: hidden;
	height: 100%;
	background-color: #B0BEC5;
	background-repeat: no-repeat; */
	
}

.card0 {
	/* box-shadow: 0px 4px 8px 0px #757575; */
	border-radius: 0px;
}

.card2 {
	margin: 0px 40px;
}

.logo {
	width: 200px;
	height: 100px;
	margin-top: 20px;
	margin-left: 35px;
}

.image {
	width: 360px;
	height: 280px;
}

.border-line {
	border-right: 1px solid #EEEEEE;
}

.line {
	height: 1px;
	width: 45%;
	background-color: #E0E0E0;
	margin-top: 10px;
}

.or {
	width: 10%;
	font-weight: bold;
}

.text-sm {
	font-size: 14px !important;
}

::placeholder {
	color: #BDBDBD;
	opacity: 1;
	font-weight: 300
}

:-ms-input-placeholder {
	color: #BDBDBD;
	font-weight: 300
}

::-ms-input-placeholder {
	color: #BDBDBD;
	font-weight: 300
}

input, textarea {
	padding: 10px 12px 10px 12px;
	border: 1px solid lightgrey;
	border-radius: 2px;
	margin-bottom: 5px;
	margin-top: 2px;
	width: 100%;
	box-sizing: border-box;
	color: #2C3E50;
	font-size: 14px;
	letter-spacing: 1px;
}

input:focus, textarea:focus {
	-moz-box-shadow: none !important;
	-webkit-box-shadow: none !important;
	box-shadow: none !important;
	border: 1px solid #304FFE;
	outline-width: 0;
}

button:focus {
	-moz-box-shadow: none !important;
	-webkit-box-shadow: none !important;
	box-shadow: none !important;
	outline-width: 0;
}

a {
	color: inherit;
	cursor: pointer;
}

.btn-blue {
	background-color: #1A237E;
	width: 150px;
	color: #fff;
	border-radius: 2px;
	font-size: 14px;
}

.btn-blue:hover {
	background-color: #000;
	cursor: pointer;
	color: #fff;
}

.bg-blue {
	color: #fff;
	background-color: #1A237E;
}

.card {
	justify-content: center;
	height: calc(100% - 80px);
}

@media screen and (max-width: 991px) {
	.logo {
		margin-left: 0px;
	}
	.image {
		width: 300px;
		height: 220px;
	}
	/* .border-line {
		border-right: none;
	}
	.card2 {
		border-top: 1px solid #EEEEEE !important;
		margin: 0px 15px;
	} */
}

@media ( min-width : 0px) .pl-xl-5 , . px-xl-5 {
	padding-left
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	:
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	0
	rem
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	!
	important
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	;
}

@media ( min-width : 0px) .pr-xl-5 , . px-xl-5 {
	padding-right
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	:
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	0
	rem
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	!
	important
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	;
}
</style>
<script
	src="https://polyfill.io/v3/polyfill.min.js?version=3.52.1&features=fetch"></script>
</head>
<body>
	<div class="container-fluid px-1 px-md-5 px-lg-1 px-xl-5 py-5 mx-auto">
		<h1 class="text-center">Online Loan Management System [OLMS]</h1>
		<div class="card card0 border-0">
			<div class="row d-flex">
				<div class="col-md-6">
					<div class="card1 pb-5">
						<div class="row"></div>
						<div class="row px-3 justify-content-center mt-4 mb-5 border-line">
							<img src="../images/bank-loan.jpg" class="image">
						</div>
					</div>
				</div>
				<div class="col-md-6">
					<div class="card2 card border-0 px-4 py-5">


						<div class="row mb-3 px-3">
							<a class="btn btn-blue text-center"
								href="/employee-login/display">Employee Login</a>
						</div>
						<div class="row mb-3 px-3">
							<a class="btn btn-blue text-center" href="/customer/display">Customer
								Login</a>
						</div>

					</div>
				</div>
			</div>

		</div>
		<div class="bg-blue py-4">
			<div class="">
				<h5 class="text-center">A project By Avalons Team..! (Arif
					Pasha, Jagadishwar Reddy, Samba Chennamsetty, Siva Rama Krishna,
					Teja Sri & Vamsi Kiran..)</h5>
			</div>
		</div>
	</div>

</body>
</html>