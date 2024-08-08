<%-- 
    Document   : addReport
    Created on : Aug 8, 2024, 4:18:46 PM
    Author     : Do Gia Huy
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="col-10 container-fluid">
    <h1 class="text-center text-primary mt-1">Add Report</h1>
    <c:url value="/category/addOrUpdate" var="action" />
    <c:if test="${errMsg != null}">
        <div class="alert alert-danger">
            ${errMsg}
        </div>
    </c:if>

    <form:form method="post" enctype="multipart/form-data" action="${action}" modelAttribute="report">
        <div class="mb-3 mt-3">
            <label for="description" class="form-label">Description</label>
            <form:textarea path="description" type="text" class="form-control" id="description" placeholder="Description..." name="description" />        
        </div>
        <div class="mb-3 mt-3">
            <label for="severity" class="form-label">Severity</label>
            <form:input path="severity" type="text" class="form-control" id="severity" placeholder="Severity..." name="severity" />        
        </div>
        <div class="mb-3 mt-3">
            <label for="occurrenceDate" class="form-label">Occurrence date</label>
            <form:input path="occurrenceDate" type="datetime-local" class="form-control" id="occurrenceDate" placeholder="Occurrence date..." name="occurrenceDate" />        
        </div>
        <form:hidden path="id" />
        <button class="btn btn-success" type="submit">
            <c:choose>
                <c:when test="${category.id != null}"> Cập nhật </c:when>                   
                <c:otherwise>
                    Thêm
                </c:otherwise>
            </c:choose>
        </button>
    </form:form>
</div>
