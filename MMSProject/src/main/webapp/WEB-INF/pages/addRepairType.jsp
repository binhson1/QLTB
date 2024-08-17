<%-- 
    Document   : addRepairType
    Created on : Aug 6, 2024, 3:57:23 PM
    Author     : ACER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div class="col-10 container-fluid">
    <div class="col-10 container-fluid">
        <h1 class="text-center text-primary mt-1">ADD REPAIR TYPE</h1>
        <c:url value="/repairtype/addOrUpdate" var="action" />
        <c:if test="${errMsg != null}">
            <div class="alert alert-danger">
                ${errMsg}
            </div>
        </c:if>

        <form:form method="post" enctype="multipart/form-data" action="${action}" modelAttribute="repairtype">
            <div class="mb-3 mt-3">
                <label for="name" class="form-label">Repair type:</label>
                <form:input path="name" type="text" class="form-control" id="name" placeholder="Repair type..." name="name" />        
            </div>
            <form:hidden path="id" />
            <button class="btn btn-success form-control" type="submit">
                <c:choose>
                    <c:when test="${repairtype.id != null}"> UPDATE </c:when>                   
                    <c:otherwise>
                        ADD
                    </c:otherwise>
                </c:choose>
            </button>
        </form:form>
    </div>
</div>
