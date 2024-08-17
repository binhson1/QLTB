<%-- 
    Document   : user
    Created on : Aug 17, 2024, 4:24:22 PM
    Author     : Do Gia Huy
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="col-10 container-fluid">
    <h1 class="text-center">USER MANAGE</h1>
    <c:url value="/user" var="action" />
    <form action="${action}">
        <div class="mb-3 mt-3 d-flex justify-content-center align-items-center">
            <label for="kw" class="form-label">Keyword:</label>
            <input type="text" class="form-control ms-3" style="width: 60%" id="kw" placeholder="Keyword..." name="q">
            <button class="btn btn-info ms-3" type="submit">Find</button>
        </div>
    </form>
    <table class="table table-striped mt-3">
        <tr>
            <<th></th>
            <th>Id</th>
            <th>Username</th>
            <th>First name</th>
            <th>Last name</th>
            <th>Email</th>
            <th>Phone</th>
            <th>Role</th>
            <th></th>
        </tr>
        <c:forEach items="${users}" var="u">
            <tr id="u{
                    u.id
                }">
                <td>
                    <img src="${u.image}" width="120" />
                </td>
                <td>${u.id}</td>
                <td>${u.name}</td>
                <td>${u.username}</td>
                <td>${u.firstName}</td>
                <td>${u.lastName}</td>
                <td>${u.email}</td>
                <td>${u.phone}</td>
                <td>${u.userRole}</td>
                
            </tr>
        </c:forEach>
    </table>
</div>
