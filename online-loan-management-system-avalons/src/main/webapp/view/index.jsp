<%@page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">
   <head>
      <title>Customer Login</title>
      <meta name="description" content="A demo of a card payment on Stripe" />
      <meta name="viewport" content="width=device-width, initial-scale=1" />
      <link
         href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css"
         rel="stylesheet" id="bootstrap-css">
      <script
         src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
      <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
      <script src="../static/js/customer.js"></script>
      <link rel="stylesheet" href="../static/css/global.css" />
      <link rel="stylesheet" href="../static/css/customer.css" />
      <script
         src="https://polyfill.io/v3/polyfill.min.js?version=3.52.1&features=fetch"></script>
   </head>
   <body>
      <div class="container">
         <div class="row">
            <div class="col-md-6 col-md-offset-3">
               <div class="panel panel-login">
                  <div class="panel-heading">
                     <div class="row">
                        <div class="col-xs-6">
                           <a href="#" class="active" id="login-form-link">Login</a>
                        </div>
                        <div class="col-xs-6">
                           <a href="#" id="register-form-link">Register</a>
                        </div>
                     </div>
                     <hr>
                  </div>
                  <div class="panel-body">
                     <div class="row">
                        <div class="col-lg-12">
                           <form id="login-form" action="https://phpoll.com/login/process"
                              method="post" role="form" style="display: block;">
                              <div class="form-group">
                                 <input type="text" name="username" id="username" tabindex="1"
                                    class="form-control" placeholder="Username" value="">
                              </div>
                              <div class="form-group">
                                 <input type="password" name="password" id="password"
                                    tabindex="2" class="form-control" placeholder="Password">
                              </div>
                              <div class="form-group">
                                 <div class="row">
                                    <div class="col-sm-6 col-sm-offset-3">
                                       <input type="submit" name="login-submit" id="login-submit"
                                          tabindex="4" class="form-control btn btn-login"
                                          value="Log In">
                                    </div>
                                 </div>
                              </div>
                           </form>
                           <form id="register-form"
                              action="https://phpoll.com/register/process" method="post"
                              role="form" style="display: none;">
                              <div class="form-group">
                                 <input type="text" name="username" id="username" tabindex="1"
                                    class="form-control" placeholder="Username" value="">
                              </div>
                              <div class="form-group">
                                 <input type="email" name="email" id="email" tabindex="1"
                                    class="form-control" placeholder="Email Address" value="">
                              </div>
                              <div class="form-group">
                                 <input type="password" name="password" id="password"
                                    tabindex="2" class="form-control" placeholder="Password">
                              </div>
                              <div class="form-group">
                                 <input type="password" name="confirm-password"
                                    id="confirm-password" tabindex="2" class="form-control"
                                    placeholder="Confirm Password">
                              </div>
                              <div class="form-group">
                                 <div class="row">
                                    <div class="col-sm-6 col-sm-offset-3">
                                       <input type="submit" name="register-submit"
                                          id="register-submit" tabindex="4"
                                          class="form-control btn btn-register" value="Register Now">
                                    </div>
                                 </div>
                              </div>
                           </form>
                        </div>
                     </div>
                  </div>
               </div>
            </div>
         </div>
      </div>
   </body>
</html>