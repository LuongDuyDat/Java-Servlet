<%-- 
    Document   : login
    Created on : Jun 5, 2024, 4:36:30 PM
    Author     : datld7
--%>

<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login Page</title>
    <link rel="stylesheet" href='css/login.css'>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
    <div class="text-logo">Learning Management</div>
    <% 
    String error_login = (String) request.getAttribute("error_login");
    if (error_login != null) {
    %>
    <div class="error-login"><p>${error_login}</p></div>
    <% } %>
    <div class="login-container">
        <h2>Đăng nhập</h2>
        <form class="login-form" method="POST" >
            <!--htmlspecialchars: make all input of user to literal -->
            <input name="username" type="text" placeholder="Tên đăng nhập" value=${username}>
            <div class="password-container">
                <input name="password" id="password" type="password" placeholder="Mật khẩu" value=${password}>
                <i class="fa fa-eye password-toggle" onclick="togglePasswordVisibility()"></i>
            </div>
            <button type="submit">Đăng nhập</button>
            
        </form>
    </div>
    <script>
        //change password visible
        function togglePasswordVisibility() {
            var passwordField = document.getElementById('password');
            var passwordToggle = document.querySelector('.password-toggle');

            if (passwordField.type === 'password') {
                passwordField.type = 'text';
                passwordToggle.classList.remove('fa-eye');
                passwordToggle.classList.add('fa-eye-slash');
            } else {
                passwordField.type = 'password';
                passwordToggle.classList.remove('fa-eye-slash');
                passwordToggle.classList.add('fa-eye');
            }
        }
    </script>
</body>
</html>
