<%-- 
    Document   : manufacturer
    Created on : Aug 5, 2024, 4:04:20 PM
    Author     : ACER
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<section class="container">
    <div class="col-md-10 col-12">
        <table class="table table-striped">
            <tr>
                <th></th>
                <th>Id</th>
                <th>Tên</th>            
            </tr>
            <c:forEach items="${manu}" var="m">
                <tr id="manu${m.id}">                
                    <td>${m.id}</td>
                    <td>${m.name}</td>                
                    <td>
                        <c:url value="/products/${m.id}" var="u" />
                        <a href="${u}" class="btn btn-success">&orarr;</a>

                        <c:url value="/api/products/${m.id}" var="uD" />
                        <button onclick="deleteProduct('${uD}', ${m.id})" class="btn btn-danger">&times;</button>
                    </td>
                </tr>
           </c:forEach>
        </table>
    </div>
</section>
