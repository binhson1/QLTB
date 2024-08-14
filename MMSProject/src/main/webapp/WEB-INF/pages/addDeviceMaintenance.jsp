<%-- 
    Document   : addDeviceMaintenance
    Created on : Aug 13, 2024, 6:27:42 PM
    Author     : Do Gia Huy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="col-10 container-fluid">
    <h1 class="text-center text-primary mt-1">ADD DEVICE MAINTENANCE</h1>
    <c:if test="${errMsg != null}">
        <div class="alert alert-danger">
            ${errMsg}
        </div>
    </c:if>

    <form:form method="post" enctype="multipart/form-data" action="${action}" modelAttribute="deviceMaintenace">
        <div class="mb-3 mt-3">
            <label for="browser" class="form-label">Device: </label>
            <form:select class="form-select" path="deviceId" >
                <c:forEach items="${devices}" var="d">
                    <c:choose>
                        <c:when test="${d.id == deviceMaintenace.deviceId.id}">
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
            <label for="browser" class="form-label">Schedule maintenance: </label>
            <form:select class="form-select" path="scheduleMaintenanceId" >
                <option value="${scheduleMaintenance.id}">${scheduleMaintenance.name}</option>
            </form:select>
        </div>
        <form:hidden path="id" />
        <button class="btn btn-success" type="submit">
            <c:choose>
                <c:when test="${category.id != null}"> UPDATE </c:when>                   
                <c:otherwise>
                    ADD
                </c:otherwise>
            </c:choose>
        </button>
    </form:form>
</div>