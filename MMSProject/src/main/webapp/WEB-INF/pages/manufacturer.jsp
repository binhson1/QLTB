<%-- 
    Document   : manufacturer
    Created on : Aug 5, 2024, 4:04:20 PM
    Author     : ACER
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<section class="container">
    <div class="col-md-10 col-12">
        <a href="<c:url value="/manufacturer/add"></c:url>"class="btn btn-success m-1">Thêm</a>        
        <table class="table table-striped">
            <tr>                
                <th>Id</th>
                <th>Tên</th>            
                <th>Sửa</th>
            </tr>
            <c:forEach items="${manu}" var="m">
                <tr id="manu${m.id}">                
                    <td>${m.id}</td>
                    <td>${m.name}</td>                
                    <td>
                        <c:url value="/manufacturer/${m.id}" var="u" />
                        <a href="${u}" class="btn btn-success">&orarr;</a>
                        <c:url value="#" var="uD" />
                        <button onclick="deleteProduct('${uD}', ${m.id})" class="btn btn-danger">&times;</button>
                    </td>
                </tr>
           </c:forEach>
        </table>
    </div>
</section>
