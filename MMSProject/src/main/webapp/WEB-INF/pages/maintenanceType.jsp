<%-- 
    Document   : maintenancetype
    Created on : Aug 6, 2024, 3:42:17 PM
    Author     : ACER
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<section class="container">
    <a href="<c:url value="/maintenancetype/add"></c:url>"class="btn btn-success m-1">Thêm</a>
        <div class="col-md-10 col-12">
            <table class="table table-striped">
                <tr>
                    <th></th>
                    <th>Id</th>
                    <th>Tên</th>            
                </tr>
            <c:forEach items="${maintenancetyp}" var="m">
                <tr id="maintenancetyp${m.id}">                
                    <td>${m.id}</td>
                    <td>${m.name}</td>                
                    <td>
                        <c:url value="#" var="u" />
                        <a href="#" class="btn btn-success">&orarr;</a>
                        <c:url value="#" var="uD" />
                        <button onclick="deleteProduct('${uD}', ${m.id})" class="btn btn-danger">&times;</button>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</section>