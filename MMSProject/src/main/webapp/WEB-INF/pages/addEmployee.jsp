<%-- 
    Document   : addEmployee
    Created on : Aug 7, 2024, 10:11:56 AM
    Author     : ACER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="col-10 container-fluid">
    <h1 class="text-center text-primary mt-1">THÊM NHÂN VIÊN</h1>
    <%--<c:url value="/category" var="action" />--%>
    <c:if test="${errMsg != null}">
        <div class="alert alert-danger">
            ${errMsg}
        </div>
    </c:if>

    <form:form method="post" enctype="multipart/form-data" modelAttribute="employee">
        <div class="mb-3 mt-3">
            <label for="name" class="form-label">Tên nhân viên:</label>
            <form:input path="name" type="text" class="form-control" id="name" placeholder="Tên nhân viên..." name="name" />        
        </div>
        <div class="mb-3 mt-3">
            <label for="Cccd" class="form-label">CCCD:</label>
            <form:input path="Cccd" type="text" class="form-control" id="Cccd" placeholder="CCCD..." name="name" />        
        </div>
        <div class="mb-3 mt-3">
            <label for="phone" class="form-label">Số điện thoại:</label>
            <form:input path="phone" type="text" class="form-control" id="phone" placeholder="Số điện thoại..." name="name" />        
        </div>
        
        <button class="btn btn-success" type="submit">
            Thêm 
        </button>
    </form:form>

</div>