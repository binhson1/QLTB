<%-- 
    Document   : addJobRepair
    Created on : Aug 17, 2024, 3:58:42 PM
    Author     : Do Gia Huy
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="col-10 container-fluid">
    <h1 class="text-center text-primary mt-1">ADD JOB</h1>
    <c:url value="/job/addOrUpdate" var="action" />
    <c:if test="${errMsg != null}">
        <div class="alert alert-danger">
            ${errMsg}
        </div>
    </c:if>

    <form:form method="post" enctype="multipart/form-data" action="${action}" modelAttribute="job">
        <div class="mb-3 mt-3">
            <label for="name" class="form-label">Job name:</label>
            <form:input path="name" type="text" class="form-control" id="name" placeholder="Job name..." name="name" />
        </div>
        <div class="mb-3 mt-3">
            <label for="name" class="form-label">Start date</label>
            <form:input path="startDate" type="datetime-local" class="form-control" id="startDate" placeholder="Start date..." name="startDate" value="${job.startDate}"  />        
        </div>
        <div class="mb-3 mt-3">
            <label for="Cccd" class="form-label">End date</label>
            <form:input path="endDate" type="datetime-local" class="form-control" id="endDate" placeholder="End date..." name="endDate" value="${job.endDate}" />        
        </div>
        <div class="mb-3 mt-3">
            <label for="browser" class="form-label">Status: </label>
            <form:select class="form-select" path="status" >
                <c:forEach items="${status}" var="s">
                    <c:choose>
                        <c:when test="${job.status == s}">
                            <option value="${s}" selected>${s}</option>
                        </c:when>
                        <c:otherwise>
                            <option value="${s}">${s}</option>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </form:select>
        </div>
        <div class="mb-3 mt-3">
            <label for="browser" class="form-label">Employee: </label>
            <form:select class="form-select" path="employeeId" >
                <c:forEach items="${employees}" var="e">
                    <c:choose>
                        <c:when test="${e.id == job.employeeId.id}">
                            <option value="${e.id}" selected>${e.name}</option>
                        </c:when>
                        <c:otherwise>
                            <option value="${e.id}">${e.name}</option>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </form:select>
        </div>
        <div class="mb-3 mt-3">
            <label for="browser" class="form-label">Repair</label>
            <form:input path="repairId" type="text" class="form-control" id="repairId"  name="repairId" value="${job.repairId.id}" readonly="true" />        
        </div>
        <form:hidden path="id" />
        <form:hidden path="maintenanceId" />
        <button class="btn btn-success form-control" type="submit">
            <c:choose>
                <c:when test="${job.id != null}"> UPDATE </c:when>                   
                <c:otherwise>
                    ADD
                </c:otherwise>
            </c:choose>
        </button>
    </form:form>

</div>
