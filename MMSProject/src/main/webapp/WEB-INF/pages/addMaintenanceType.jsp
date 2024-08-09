<%-- 
    Document   : addMaintenanceType
    Created on : Aug 6, 2024, 4:00:14 PM
    Author     : ACER
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div class="col-10 container-fluid">
    <div class="col-10 container-fluid">
        <h1 class="text-center text-primary mt-1">THÊM LOẠI BẢO TRÌ</h1>
        <c:url value="/maintenancetype/addOrUpdate" var="action" />
        <c:if test="${errMsg != null}">
            <div class="alert alert-danger">
                ${errMsg}
            </div>
        </c:if>

        <form:form method="post" enctype="multipart/form-data" action="${action}" modelAttribute="maintenancetype">
            <div class="mb-3 mt-3">
                <label for="name" class="form-label">Tên loại bảo trì:</label>
                <form:input path="name" type="text" class="form-control" id="name" placeholder="Tên loại bảo trì..." name="name" />        
            </div>
            <form:hidden path="id" />
            <button class="btn btn-success" type="submit">
                <c:choose>
                    <c:when test="${maintenancetype.id != null}"> Cập nhật </c:when>                   
                    <c:otherwise>
                        Thêm
                    </c:otherwise>
                </c:choose>
            </button>
        </form:form>

    </div>
</div>
