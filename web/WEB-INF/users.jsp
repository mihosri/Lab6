
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
        
        <title>Users</title>
        
    </head>
    <body>   
        <div class="container">
            <div class="row">
                <div class="col">
                    <h1>Sri User Management System</h1>
                    <table class="table">
                        <thead>
                            <tr>
                                <th>E-mail</th>
                                <th>First Name</th>
                                <th>Last Name</th>
                                <th>Active</th>
                                <th>Actions</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="user" items="${users}">
                                <tr>
                                    <td>${user.email}</td>
                                    <td>${user.firstame}</td>
                                    <td>${user.lastName}</td>
                                    <td>${user.active ? "Y" : "N"}</td>
                                    <td>
                                        <a href="editForm? action=edit">Edit</a>
                                        <a href="">Delete</a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                    
                    <form action="editForm" method="post">
                            <label for="email">Email</label><br>
                            <input type="text" id="email" name="email" value="${user.email}"><br>
                            
                            <label for="fname">First Name</label><br>
                            <input type="text" id="fname" name="fname" value="${user.firstname}"><br>
                            
                            <label for="lname">Last Name</label><br>
                            <input type="text" id="lname" name="lname" value="${user.lastname}"><br>
                            
                            <label for="password">Password</label><br>
                            <input type="password" id="password" name="password" value="${user.password}"><br>
                            
                            <label for="role">Role ID</label><br>
                            <input type="number" id="role" name="role" value="${user.Role().getId()}"><br>
                            
                            <button type="submit"> Submit </button>
                    </form>                   
                </div>    
            </div>
        </div>     
    </body>
</html>
