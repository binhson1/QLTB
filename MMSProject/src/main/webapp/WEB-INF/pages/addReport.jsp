<%-- 
    Document   : addReport
    Created on : Aug 8, 2024, 4:18:46 PM
    Author     : Do Gia Huy
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="col-10 container-fluid">
    <h1 class="text-center text-primary mt-1">ADD REPORT</h1>
    <c:url value="/report/addOrUpdate" var="action" />
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
        <div class="mb-3 mt-3">
            <label for="browser" class="form-label">Device </label>
            <form:select class="form-select" path="deviceId" >
                <c:forEach items="${devices}" var="d">
                    <c:choose>
                        <c:when test="${report.deviceId.id == d.id}">
                            <option value="${d.id}" selected>${d.name}</option>
                        </c:when>
                        <c:otherwise>
                            <option value="${d.id}">${d.name}</option>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </form:select>
        </div>
        <div class="mb-3 mt-3">
            <label for="browser" class="form-label">User </label>
            <form:select class="form-select" path="userId" >
                <c:forEach items="${users}" var="u">
                    <c:choose>
                        <c:when test="${report.userId.id == u.id}">
                            <option value="${u.id}" selected>${u.username}</option>
                        </c:when>
                        <c:otherwise>
                            <option value="${u.id}">${u.username}</option>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </form:select>
        </div>
        <div class="mb-3 mt-3">
            <label for="browser" class="form-label">Status: </label>
            <form:select class="form-select" path="status" >
                <c:forEach items="${status}" var="s">
                    <c:choose>
                        <c:when test="${report.status == s}">
                            <option value="${s}" selected>${s}</option>
                        </c:when>
                        <c:otherwise>
                            <option value="${s}">${s}</option>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </form:select>
        </div>
        <form:hidden path="id" />
        <button class="btn btn-success" type="submit">
            <c:choose>
                <c:when test="${report.id != null}"> UPDATE </c:when>                   
                <c:otherwise>
                    ADD
                </c:otherwise>
            </c:choose>
        </button>
    </form:form>
</div>
