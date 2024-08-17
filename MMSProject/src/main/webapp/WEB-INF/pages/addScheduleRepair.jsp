<%-- 
    Document   : addScheduleRepair
    Created on : Aug 9, 2024, 3:11:06 PM
    Author     : ACER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="col-10 container-fluid">
    <h1 class="text-center text-primary mt-1">ADD SCHEDULE REPAIR</h1>
    <c:url value="/schedulerepair/addOrUpdate" var="action" />
    <c:if test="${errMsg != null}">
        <div class="alert alert-danger">
            ${errMsg}
        </div>
    </c:if>

    <form:form method="post" enctype="multipart/form-data" action="${action}" modelAttribute="schedulerepair">
        <div class="mb-3 mt-3">
            <label for="name" class="form-label">Name:</label>
            <form:input path="name" type="text" class="form-control" id="name" placeholder="Name..." name="name" />        
        </div>
        <div class="mb-3 mt-3">
            <label for="date" class="form-label">Date:</label>
            <form:input path="date" type="date" class="form-control" id="date" placeholder="Date..." name="name" />        
        </div>
        <div class="mb-3 mt-3">
            <label for="cost" class="form-label">Cost:</label>
            <form:input path="cost" type="text" class="form-control" id="cost" placeholder="Cost..." name="name" />        
        </div>            

        <div class="mb-3 mt-3">
            <label for="browser" class="form-label">Repair Type: </label>
            <form:select class="form-select" path="repairTypeId" >
                <c:forEach items="${repairtype}" var="r">
                    <c:choose>
                        <c:when test="${r.id == scheduleRepair.repairTypeId.id}">
                            <option value="${r.id}" selected>${r.name}</option>
                        </c:when>
                        <c:otherwise>
                            <option value="${r.id}">${r.name}</option>
                        </c:otherwise>
                    </c:choose>

                </c:forEach>
            </form:select>
        </div>

        <div class="mb-3 mt-3">
            <label for="browser" class="form-label">Report Id: </label>
            <form:select class="form-select" path="reportId" >
                <c:forEach items="${report}" var="c">
                    <c:choose>
                        <c:when test="${c.id == scheduleRepair.reportId.id}">
                            <option value="${c.id}" selected>${c.id}</option>
                        </c:when>
                        <c:otherwise>
                            <option value="${c.id}">${c.id}</option>
                        </c:otherwise>
                    </c:choose>

                </c:forEach>
            </form:select>
        </div>

        <form:hidden path="id" />
        <button class="btn btn-success form-control" type="submit">
            <c:choose>
                <c:when test="${schedulerepair.id != null}"> Cập nhật </c:when>                   
                <c:otherwise>
                    Thêm
                </c:otherwise>
            </c:choose>
        </button>
    </form:form>

</div>
