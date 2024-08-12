<%-- 
    Document   : addJob
    Created on : Aug 9, 2024, 3:08:28 PM
    Author     : Do Gia Huy
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

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
            <label for="browser" class="form-label">Maintenance</label>
            <form:select class="form-select" path="maintenanceId" >
                <option></option>
                <c:forEach items="${maintenances}" var="m">
                    <c:choose>
                        <c:when test="${m.id == job.maintenanceId.id}">
                            <option value="${m.id}" selected>${m.id}</option>
                        </c:when>
                        <c:otherwise>
                            <option value="${m.id}">${m.id}</option>
                        </c:otherwise>
                    </c:choose>

                </c:forEach>
            </form:select>
        </div>
        <h3>OR</h3>
        <div class="mb-3 mt-3">
            <label for="browser" class="form-label">Repair</label>
            <form:select class="form-select" path="repairId" >
                <option></option>
                <c:forEach items="${scheduleRepair}" var="r">
                    <c:choose>
                        <c:when test="${r.id == job.repairId.id}">
                            <option value="${r.id}" selected>${r.id}</option>
                        </c:when>
                        <c:otherwise>
                            <option value="${r.id}">${r.id}</option>
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