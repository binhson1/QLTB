<%-- 
    Document   : locationHistory
    Created on : Aug 12, 2024, 11:49:12 AM
    Author     : Do Gia Huy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="col-10 container-fluid">
    <h1 class="text-center">LOCATION HISTORY</h1>
    <table class="table table-striped mt-3">
        <tr>
            <th>Id</th>
            <th>Device</th>
            <th>Location</th>
            <th>Begin date</th>
            <th>End date</th>
            <th>Active</th>
        </tr>
        <c:forEach items="${locationHistory}" var="l">
            <tr id="locationHistory${l.id}">
                <td>${l.id}</td>
                <td>${l.deviceId.name}</td>
                <td>${l.locationId.name}</td>
                <td>${l.beginDate}</td>
                <td>${l.endDate}</td>
                <td>${l.active}</td>
            </tr>
        </c:forEach>
    </table>
</div>
