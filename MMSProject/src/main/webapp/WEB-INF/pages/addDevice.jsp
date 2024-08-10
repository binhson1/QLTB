<%-- 
    Document   : addProduct
    Created on : Aug 5, 2024, 3:11:59 PM
    Author     : Do Gia Huy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="col-10 container-fluid">
    <h1 class="text-center text-primary">DEVICE</h1>
    <c:url value="/device/addOrUpdate" var="action" />
    <c:if test="${errMsg != null}">
        <div class="alert alert-danger">
            ${errMsg}
        </div>
    </c:if>
    <form:form method="post" enctype="multipart/form-data" modelAttribute="device" action="${action}">
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
            <c:if test="${device.image != null}">
                <img class="mt-1" src="${device.image}" alt="${device.image}" width="120" />
            </c:if>
        </div>

        <div class="mb-3 mt-3">
            <label for="browser" class="form-label">Category: </label>
            <form:select class="form-select" path="deviceCategoryId" >
                <c:forEach items="${categories}" var="c">
                    <c:choose>
                        <c:when test="${c.id == device.deviceCategoryId.id}">
                            <option value="${c.id}" selected>${c.name}</option>
                        </c:when>
                        <c:otherwise>
                            <option value="${c.id}">${c.name}</option>
                        </c:otherwise>
                    </c:choose>

                </c:forEach>
            </form:select>
        </div>
        <div class="mb-3 mt-3">
            <label for="browser" class="form-label">Location: </label>
            <form:select class="form-select" path="location" >
                <c:forEach items="${locations}" var="l">
                    <c:choose>
                        <c:when test="${l.id == device.location.id}">
                            <option value="${l.id}" selected>${l.name}</option>
                        </c:when>
                        <c:otherwise>
                            <option value="${l.id}">${l.name}</option>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </form:select>
        </div>
        <div class="mb-3 mt-3">
            <label for="browser" class="form-label">Manufacturer: </label>
            <form:select class="form-select" path="manufacturerId" >
                <c:forEach items="${manus}" var="m">
                    <c:choose>
                        <c:when test="${device.manufacturerId.id == m.id}">
                            <option value="${m.id}" selected>${m.name}</option>
                        </c:when>
                        <c:otherwise>
                            <option value="${m.id}">${m.name}</option>
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
                        <c:when test="${device.status == s.value}">
                            <option value="${s.value}" selected>${s}</option>
                        </c:when>
                        <c:otherwise>
                            <option value="${s.value}">${s}</option>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </form:select>
        </div>
        <div class="mb-3 mt-3 text-center">
            <form:hidden path="id" />
            <form:hidden path="image" />
            <button class="btn btn-success" type="submit">
                <c:choose>
                    <c:when test="${device.id != null}"> UPDATE </c:when>                   
                    <c:otherwise>
                        ADD
                    </c:otherwise>
                </c:choose>
            </button>
        </div>
    </form:form>
</div>
