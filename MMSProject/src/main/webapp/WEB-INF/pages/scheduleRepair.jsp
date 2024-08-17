<%-- 
    Document   : scheduleRepair
    Created on : Aug 9, 2024, 2:51:09 PM
    Author     : ACER
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="col-10 container-fluid">
    <h1 class="text-center">Scheduling Repair Management</h1>
    <c:url value="/schedulerepair" var="action" />
    <form action="${action}">
        <div class="mb-3 mt-3 d-flex justify-content-center align-items-center">
            <label for="kw" class="form-label">Keyword:</label>
            <input type="text" class="form-control ms-3" style="width: 60%" id="kw" placeholder="Keyword..." name="q">
            <button class="btn btn-info ms-3" type="submit">Find</button>
            <a href="<c:url value="/schedulerepair/add"></c:url>"class="btn btn-success ms-3">ADD SCHEDULE REPAIR</a> 
        </div>
    </form>
    <table class="table table-striped text-center">
        <tr>                 
            <th>Id</th>
            <th>Name</th>
            <th>Date</th>
            <th>Cost</th>
            <th>Repair Type</th>      
            <th>Report Id</th>
            <th></th>
        </tr>
        <c:forEach items="${schedulerepair}" var="c">
            <tr id="schedulerepair${c.id}">
                <td>${c.id}</td>
                <td>${c.name}</td>
                <td>${c.date}</td>
                <td>${c.cost}</td>
                <td>${c.repairTypeId.name}</td>
                <td>${c.reportId.id}</td>
                <td>
                    <c:url value="/schedulerepair/${c.id}/job" var="job" />
                    <a href="${job}" class="btn btn-secondary">jobs</a>
                    
                    <c:url value="/schedulerepair/${c.id}/job/add" var="addJob" />
                    <a href="${addJob}" class="btn btn-warning">++Job</a>
                    
                    <c:url value="/schedulerepair/${c.id}" var="u" />
                    <a href="${u}" class="btn btn-success">&orarr;</a>

                    <c:url value="/api/schedulerepair/delete/${c.id}" var="uD" />
                    <button
                        onclick="deletes('${uD}', ${c.id}, 'schedulerepair')"
                        class="btn btn-danger"
                        >
                        &times;
                    </button>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
