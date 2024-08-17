<%-- 
    Document   : maintenancetype
    Created on : Aug 6, 2024, 3:42:17 PM
    Author     : ACER
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="col-10 container-fluid">
    <h1 class="text-center">MAINTENANCE TYPE MANAGE</h1>
    <a href="<c:url value="/maintenancetype/add"></c:url>"class="btn btn-success m-1 form-control">ADD MAINTENANCE TYPE</a>
        <div class="col-md-10 col-12">
            <table class="table table-striped">
                <tr>
                    <th>Id</th>
                    <th>Name</th>      
                    <th></th>
                </tr>
            <c:forEach items="${maintenancetyp}" var="m">
                <tr id="maintenancetyp${m.id}">                
                    <td>${m.id}</td>
                    <td>${m.name}</td>                
                    <td>
                        <c:url value="/maintenancetype/${m.id}" var="u" />
                        <a href="${u}" class="btn btn-success">&orarr;</a>
                        <c:url value="/api/maintenancetype/delete/${m.id}" var="uD" />
                        <button onclick="deletes('${uD}', ${m.id}, 'maintenancetyp')" class="btn btn-danger">&times;</button>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</section>
<script src="<c:url value="/js/delete.js" />"></script>        
