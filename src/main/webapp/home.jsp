<%-- 
    Document   : home
    Created on : Jun 5, 2024, 5:27:47 PM
    Author     : datld7
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="model.FileUpload"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home Page</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="css/home.css">
</head>
<body>

    <div id="nav">
	<%
	    if (session.getAttribute("user") != null) {
	%>
            Xin chào: ${sessionScope.user} <a href="/LogoutServlet"> Thoát</a>
	<%
            }
	%>
    </div>

    <div class="container">
        <!--Form for teacher to upload new exercise -->
        <h1>Đăng tải File</h1>
        <form id="uploadForm" method="POST" enctype="multipart/form-data">
            <div class="mb-20">
                <label for="title">Tiêu đề:</label>
                <input type="text" name="title" required 
                    oninvalid="this.setCustomValidity('Mời bạn điền tiêu đề ')" oninput="this.setCustomValidity('')">
            </div>
            <div class="mb-20">
                <label for="file">Chọn tệp:</label>
                <input type="file" id="file" name="file" required 
                    oninvalid="this.setCustomValidity('Mời bạn tải tệp lên')" oninput="this.setCustomValidity('')">
            </div>
            <div class="button-container">
                <button type="submit"><i class="fas fa-upload"></i> Tải</button>
            </div>
        </form>

        <!-- Exercise List -->
        <div id="exerciseList">
            <h2>Danh sách file đăng tải</h2>
            <ul id="list">
                <% 
                    ArrayList<FileUpload> fileList = (ArrayList<FileUpload>) request.getAttribute("fileList");
                    for (int i = 0; i < fileList.size(); i++) {
                %>                       
                    <li class="list-item">
                        <div>
                            <i class="fas fa-tasks"></i>
                            <div class="file-name"><%= fileList.get(i).getFileName() %></div>
                        </div>
                    </li>
                <% } %>
            </ul>
        </div>
    </div>

</body>
</html>
