<%-- 
    Document   : addEmployee
    Created on : Aug 7, 2024, 10:11:56 AM
    Author     : ACER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="col-10 container-fluid">
    <h1 class="text-center text-primary mt-1">ADD EMPLOYEE</h1>
    <c:url value="/employee/addOrUpdate" var="action" />
    <c:if test="${errMsg != null}">
        <div class="alert alert-danger">
            ${errMsg}
        </div>
    </c:if>

    <form:form method="post" enctype="multipart/form-data" action="${action}" modelAttribute="employee">
        <div class="mb-3 mt-3">
            <label for="name" class="form-label">Employee name:</label>
            <form:input path="name" type="text" class="form-control" id="name" placeholder="Employee name..." name="name" />        
        </div>
        <div class="mb-3 mt-3">
            <label for="Cccd" class="form-label">CCCD:</label>
            <form:input path="Cccd" type="text" class="form-control" id="Cccd" placeholder="CCCD..." name="name" />        
        </div>
        <div class="mb-3 mt-3">
            <label for="phone" class="form-label">Phone numbers:</label>
            <form:input path="phone" type="text" class="form-control" id="phone" placeholder="Phone numbers..." name="name" />        
        </div>
        <form:hidden path="id" />
        <button class="btn btn-success form-control" type="submit">
            <c:choose>
                <c:when test="${employee.id != null}"> UPDATE </c:when>                   
                <c:otherwise>
                    ADD
                </c:otherwise>
            </c:choose>
        </button>
    </form:form>

</div>