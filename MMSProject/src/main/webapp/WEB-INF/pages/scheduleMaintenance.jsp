<%-- 
    Document   : scheduleMaintenance
    Created on : Aug 13, 2024, 1:06:39 PM
    Author     : Do Gia Huy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="col-10 container-fluid">
    <h1 class="text-center">SCHEDULE MAINTENANCE MANAGE</h1>
    <c:url value="/maintenance" var="action" />
    <form action="${action}">
        <div class="mb-3 mt-3 d-flex justify-content-center align-items-center">
            <label for="kw" class="form-label">Keyword:</label>
            <input type="text" class="form-control ms-3" style="width: 60%" id="kw" placeholder="Keyword..." name="q">
            <button class="btn btn-info ms-3" type="submit">Find</button>
            <a href="<c:url value="/maintenance/add"></c:url>"class="btn btn-success ms-3">ADD SCHEDULE MAINTENANCE</a> 
        </div>
    </form>
    <table class="table table-striped mt-3">
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Last maintenance</th>
            <th>Next maintenance</th>
            <th>Interval month</th>
            <th>Maintenance type</th>
            <th></th>
        </tr>
        <c:forEach items="${maintenances}" var="s">
            <tr id="maintenance{
                    s.id
                }">
                <td>${s.id}</td>
                <td>${s.name}</td>
                <td>${s.lastMaintenanceDate}</td>
                <td>${s.nextMaintenanceDate}</td>
                <td>${s.intervalMonth}</td>
                <td>${s.maintenanceTypeId.name}</td>
                <td>
                    <c:url value="/maintenance/${s.id}/job" var="job" />
                    <a href="${job}" class="btn btn-secondary">jobs</a>
                    
                    <c:url value="/maintenance/${s.id}/job/add" var="addJob" />
                    <a href="${addJob}" class="btn btn-warning">++Job</a>
                    
                    <c:url value="/maintenance/${s.id}/device" var="i" />
                    <a href="${i}" class="btn btn-info">i</a>

                    <c:url value="/maintenance/${s.id}" var="u" />
                    <a href="${u}" class="btn btn-success">&orarr;</a>

                    <c:url value="/api/maintenance/delete/${s.id}" var="uD" />
                    <button
                        onclick="deletes('${uD}', ${s.id}, 'location')"
                        class="btn btn-danger"
                        >
                        &times;
                    </button>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
