<%-- 
    Document   : addProduct
    Created on : Aug 5, 2024, 3:11:59 PM
    Author     : Do Gia Huy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="col-10 container-fluid">
    <form:form method="post" enctype="multipart/form-data" modelAttribute="device">

        <div class="mb-3 mt-3">
            <label for="name" class="form-label">Device name:</label>
            <form:input path="name" type="text" class="form-control" id="name" placeholder="Device name..." name="name" />
        </div>
        <div class="mb-3 mt-3">
            <label for="descriptions" class="form-label">Descriptions:</label>
            <form:textarea path="descriptions" type="text" class="form-control" id="descriptions" placeholder="Description..." name="descriptions" />
        </div>
        <div class="mb-3 mt-3">
            <label for="boughtDate" class="form-label">Bought date:</label>
            <form:input path="boughtDate" type="date" class="form-control" id="boughtDate" placeholder="Bought date..." name="boughtDate" />
        </div>
        <div class="mb-3 mt-3">
            <label for="file" class="form-label">Image:</label>
            <form:input path="file" type="file" accept=".jpg,.png" class="form-control" id="file" name="file" />
        </div>
        
        <div class="mb-3 mt-3">
            <label for="browser" class="form-label">Category: </label>
            <form:select class="form-select" path="deviceCategoryId" >
                
            </form:select>
        </div>
        <div class="mb-3 mt-3">
            <label for="browser" class="form-label">Status: </label>
            <form:select class="form-select" path="status" >
                
            </form:select>
        </div>
        <div class="mb-3 mt-3 text-center">
            <form:hidden path="id" />
            <form:hidden path="image" />
            <button class="btn btn-success" type="submit">
                Thêm sản phẩm
            </button>
        </div>
    </form:form>
</div>
