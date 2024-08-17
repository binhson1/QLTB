<%-- 
    Document   : addLocation
    Created on : Aug 7, 2024, 2:37:27 PM
    Author     : Do Gia Huy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div class="col-10 container-fluid">
    <h1 class="text-center text-primary">LOCATION</h1>
    <c:url value="/location/addOrUpdate" var="action" />
    <c:if test="${errMsg != null}">
        <div class="alert alert-danger">
            ${errMsg}
        </div>
    </c:if>
    <form:form method="post" enctype="multipart/form-data" modelAttribute="location" action="${action}">
        <div class="mb-3 mt-3">
            <label for="name" class="form-label">Location name:</label>
            <form:input path="name" type="text" class="form-control" id="name" placeholder="Location name..." name="name" />
        </div>
        <div class="mb-3 mt-3">
            <label for="Address" class="form-label">Address:</label>
            <form:textarea path="address" type="text" class="form-control" id="Address" placeholder="Address..." name="Address" />
        </div>
        <div class="mb-3 mt-3 text-center form-control">
            <form:hidden path="id" />
            <button class="btn btn-success" type="submit">
                Thêm sản phẩm
            </button>
        </div>
    </form:form>
</div>
