<%-- 
    Document   : employee
    Created on : Aug 7, 2024, 10:08:14 AM
    Author     : ACER
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<section class="container">
    <a href="<c:url value="/employee/add"></c:url>"class="btn btn-success m-1">Thêm</a>    
        <div class="col-md-10 col-12">
            <table class="table table-striped">
                <tr>                
                    <th>Id</th>
                    <th>Tên</th>
                    <th>CCCD</th>
                    <th>Điện thoại</th>
                    <th>Điều chỉnh</th>
                </tr>
            <c:forEach items="${employee}" var="c">
                <tr id="employee${c.id}">
                    <td>${c.id}</td>
                    <td>${c.name}</td>
                    <td>${c.cccd}</td>
                    <td>${c.phone}</td>
                    <td>
                        <c:url value="/products/${p.id}" var="u" />
                        <a href="${u}" class="btn btn-success">&orarr;</a>

                        <c:url value="/api/products/${p.id}" var="uD" />
                        <button
                            onclick="deleteProduct('${uD}', ${p.id})"
                            class="btn btn-danger"
                            >
                            &times;
                        </button>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</section>
