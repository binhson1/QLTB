<%-- 
    Document   : manufacturer
    Created on : Aug 5, 2024, 4:04:20 PM
    Author     : ACER
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="col-10 container-fluid">
    <h1 class="text-center">MANUFACTURER MANAGE</h1>
    <a href="<c:url value="/manufacturer/add"></c:url>"class="btn btn-success m-1">ADD</a>        
        <table class="table table-striped mt-3 text-center">
            <tr>                
                <th>Id</th>
                <th>Name</th>  
                <th></th>
            </tr>
        <c:forEach items="${manu}" var="m">
            <tr id="manu${m.id}">                
                <td>${m.id}</td>
                <td>${m.name}</td>                
                <td>
                    <c:url value="/manufacturer/${m.id}/device" var="mD" />
                    <a href="${mD}" class="btn btn-info">i</a>
                    <c:url value="/manufacturer/${m.id}" var="u" />
                    <a href="${u}" class="btn btn-success">&orarr;</a>
                    <c:url value="/api/manufacturer/delete/${m.id}" var="uD" />
                    <button onclick="deletes('${uD}', ${m.id}, 'manu')" class="btn btn-danger">&times;</button>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
<script src="<c:url value="/js/delete.js" />"></script>
