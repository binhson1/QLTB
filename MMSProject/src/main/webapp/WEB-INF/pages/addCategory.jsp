<%-- 
    Document   : addcCategory
    Created on : Aug 5, 2024, 5:34:19 PM
    Author     : ACER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="col-10 container-fluid">
    <h1 class="text-center text-primary mt-1">THÊM DANH MỤC</h1>
    <c:url value="/category/addOrUpdate" var="action" />
    <c:if test="${errMsg != null}">
        <div class="alert alert-danger">
            ${errMsg}
        </div>
    </c:if>

    <form:form method="post" enctype="multipart/form-data" action="${action}" modelAttribute="category">
        <div class="mb-3 mt-3">
            <label for="name" class="form-label">Tên danh mục:</label>
            <form:input path="name" type="text" class="form-control" id="name" placeholder="Tên danh mục..." name="name" />        
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