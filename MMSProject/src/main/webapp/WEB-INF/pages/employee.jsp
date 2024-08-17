<%-- 
    Document   : employee
    Created on : Aug 7, 2024, 10:08:14 AM
    Author     : ACER
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="col-10 container-fluid">
    <h1 class="text-center">EMPLOYEE MANAGE</h1>
    <c:url value="/employee" var="action" />
    <form action="${action}">
        <div class="mb-3 mt-3">
            <label for="kw" class="form-label">Keyword:</label>
            <input type="text" class="form-control" id="kw" placeholder="Keyword..." name="q">
        </div>

        <div class="mb-3 mt-3">
            <button class="btn btn-info" type="submit">Find</button>
        </div>
    </form>
    <a href="<c:url value="/employee/add"></c:url>"class="btn btn-success m-1">ADD</a>    

        <table class="table table-striped">
            <tr>                
                <th>Id</th>
                <th>Name</th>
                <th>CCCD</th>
                <th>Phone</th>    
                <th></th>
            </tr>
        <c:forEach items="${employee}" var="c">
            <tr id="employee${c.id}">
                <td>${c.id}</td>
                <td>${c.name}</td>
                <td>${c.cccd}</td>
                <td>${c.phone}</td>
                <td>
                    <c:url value="/employee/${c.id}" var="u" />
                    <a href="${u}" class="btn btn-success">&orarr;</a>

                    <c:url value="/api/employee/delete/${c.id}" var="uD" />
                    <button
                        onclick="deletes('${uD}', ${c.id}, 'employee')"
                        class="btn btn-danger"
                        >
                        &times;
                    </button>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
<script src="<c:url value="/js/delete.js" />"></script>