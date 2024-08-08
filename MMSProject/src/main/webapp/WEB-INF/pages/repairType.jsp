<%-- 
    Document   : repairtype
    Created on : Aug 6, 2024, 3:43:20 PM
    Author     : ACER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<section class="container">
    <div class="col-md-10 col-12">
        <a href="<c:url value="/repairtype/add"></c:url>"class="btn btn-success m-1">Thêm</a>
        <table class="table table-striped">
            <tr>                
                <th>Id</th>
                <th>Tên</th>            
                <th>Sửa</th>
            </tr>
            <c:forEach items="${repairtype}" var="m">
                <tr id="repairtype${m.id}">                
                    <td>${m.id}</td>
                    <td>${m.name}</td>                
                    <td>
                        <c:url value="/repairtype/${m.id}" var="u" />
                        <a href="${u}" class="btn btn-success">&orarr;</a>
                        <c:url value="#" var="uD" />
                        <button onclick="deleteProduct('${uD}', ${m.id})" class="btn btn-danger">&times;</button>
                    </td>
                </tr>
           </c:forEach>
        </table>
    </div>
</section>