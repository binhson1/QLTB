<%-- 
    Document   : addReportRepairHistory
    Created on : Aug 29, 2024, 3:28:26 PM
    Author     : Do Gia Huy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div class="col-10 container-fluid">
    <h1 class="text-center text-primary mt-1">ADD REPORT REPAIR</h1>
    <c:url value="/reportrepairhistory/addOrUpdate" var="action" />
    <c:if test="${errMsg != null}">
        <div class="alert alert-danger">
            ${errMsg}
        </div>
    </c:if>

    <form:form method="post" enctype="multipart/form-data" action="${action}" modelAttribute="reportRepair">
        <div class="mb-3 mt-3">
            <label for="severity" class="form-label">Title</label>
            <form:input path="title" type="text" class="form-control" id="title" placeholder="Title..." name="title" />        
        </div>
        <div class="mb-3 mt-3">
            <label for="description" class="form-label">Content</label>
            <form:textarea path="content" type="text" class="form-control" id="content" placeholder="Content..." name="content" />        
        </div>
        <div class="mb-3 mt-3">
            <label for="browser" class="form-label">Device </label>
            <form:select class="form-select" path="reportId" >
                <option></option>   
                <c:forEach items="${reports}" var="r">
                    <c:choose>
                        <c:when test="${reportRepair.reportId.id == r.id}">
                            <option value="${r.id}" selected>${r.id} - ${r.occurrenceDate} - ${r.deviceId.name}</option>
                        </c:when>
                        <c:otherwise>
                            <option value="${r.id}">${r.id} - ${r.occurrenceDate} - ${r.deviceId.name}</option>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </form:select>
        </div>
        <div class="mb-3 mt-3">
            <label for="browser" class="form-label">User </label>
            <form:select class="form-select" path="deviceCategoryId" >
                <option></option>
                <c:forEach items="${cates}" var="c">
                    <c:choose>
                        
                        <c:when test="${reportRepair.deviceCategoryId.id == c.id}">
                            <option value="${c.id}" selected>${c.name}</option>
                        </c:when>
                        <c:otherwise>
                            <option value="${c.id}">${c.name}</option>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </form:select>
        </div>
        
        <form:hidden path="id" />
        <button class="btn btn-success form-control" type="submit">
            <c:choose>
                <c:when test="${reportRepair.id != null}"> UPDATE </c:when>                   
                <c:otherwise>
                    ADD
                </c:otherwise>
            </c:choose>
        </button>
    </form:form>
</div>
