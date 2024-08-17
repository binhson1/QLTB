<%-- 
    Document   : addScheduleMaintenance
    Created on : Aug 13, 2024, 1:38:59 PM
    Author     : Do Gia Huy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div class="col-10 container-fluid">
    <h1 class="text-center text-primary">SCHEDULE MAINTENANCE</h1>
    <c:url value="/maintenance/addOrUpdate" var="action" />
    <c:if test="${errMsg != null}">
        <div class="alert alert-danger">
            ${errMsg}
        </div>
    </c:if>
    <form:form method="post" enctype="multipart/form-data" modelAttribute="maintenance" action="${action}">
        <div class="mb-3 mt-3">
            <label for="name" class="form-label">Maintenance name:</label>
            <form:input path="name" type="text" class="form-control" id="name" placeholder="Maintenance name..." name="name" />
        </div>
        <div class="mb-3 mt-3">
            <label for="nextMaintenanceDate" class="form-label">Next date expected: </label>
            <form:input path="nextMaintenanceDate" type="date" class="form-control" id="nextMaintenanceDate" name="nextMaintenanceDate" />
        </div>
        <div class="mb-3 mt-3">
            <label for="intervalMonth" class="form-label">Interval month: </label>
            <form:input path="intervalMonth" type="number" class="form-control" id="intervalMonth" name="intervalMonth" />
        </div>
        <div class="mb-3 mt-3">
            <label for="maintenanceTypeId" class="form-label">Maintenance type: </label>
            <form:select class="form-select" path="maintenanceTypeId" id="maintenanceTypeId" >
                <c:forEach items="${maintenanceType}" var="mT">
                    <c:choose>
                        <c:when test="${mT.id == maintenance.maintenanceTypeId.id}">
                            <option value="${mT.id}" selected>${mT.name}</option>
                        </c:when>
                        <c:otherwise>
                            <option value="${mT.id}">${mT.name}</option>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </form:select>
        </div>
        <div class="mb-3 mt-3 text-center form-control">
            <form:hidden path="id" />
            <c:choose>
                <c:when test="${maintenance.id != null}"> UPDATE </c:when>                   
                <c:otherwise>
                    ADD
                </c:otherwise>
            </c:choose>
        </div>
    </form:form>
</div>
