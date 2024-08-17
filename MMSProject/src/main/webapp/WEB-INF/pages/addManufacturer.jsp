<%-- 
    Document   : addManufacturer
    Created on : Aug 5, 2024, 5:34:29 PM
    Author     : ACER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div class="col-10 container-fluid">
    <div class="col-10 container-fluid">
        <h1 class="text-center text-primary mt-1">ADD MANUFACTURER</h1>
        <c:url value="/manufacturer/addOrUpdate" var="action" />
        <c:if test="${errMsg != null}">
            <div class="alert alert-danger">
                ${errMsg}
            </div>
        </c:if>

        <form:form method="post" enctype="multipart/form-data" action="${action}" modelAttribute="manufacturer">
            <div class="mb-3 mt-3">
                <label for="name" class="form-label">Manufacturer name:</label>
                <form:input path="name" type="text" class="form-control" id="name" placeholder="Manufacturer name..." name="name" />        
            </div>
            <form:hidden path="id" />
            <button class="btn btn-success form-control" type="submit">
                <c:choose>
                    <c:when test="${manufacturer.id != null}"> UPDATE </c:when>                   
                    <c:otherwise>
                        ADD
                    </c:otherwise>
                </c:choose>
            </button>
        </form:form>
    </div>
</div>
