<%-- 
    Document   : report
    Created on : Aug 8, 2024, 3:52:51 PM
    Author     : Do Gia Huy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="col-10 container-fluid">
    <h1 class="text-center">REPORT MANAGE</h1>
    <c:url value="/report" var="action" />
    <form action="${action}">
        <div class="mb-3 mt-3">
            <label for="kw" class="form-label">Keyword:</label>
            <input type="text" class="form-control" id="kw" placeholder="Keyword..." name="q">
        </div>

        <div class="mb-3 mt-3">
            <button class="btn btn-info" type="submit">Find</button>
        </div>
    </form>
    <table class="table table-striped mt-3">
        <tr>
            <th>Id</th>
            <th>Description</th>
            <th>Occurrence Date</th>
            <th>Severity</th>
            <th>Device</th>
            <th>User</th>
            <th>Status</th>
            <th></th>
        </tr>
        <c:forEach items="${reports}" var="r">
            <tr id="report${r.id}">
                <td>${r.id}</td>
                <td>${r.description}</td>
                <td>${r.occurrenceDate}</td>
                <td>${r.severity}</td>
                <td>${r.deviceId.name}</td>
                <td>${r.userId.username}</td>
                <td>${r.status}</td>
                <td>
                    <c:url value="/report/${r.id}" var="u" />
                    <a href="${u}" class="btn btn-success">&orarr;</a>

                    <c:url value="/api/report/delete/${r.id}" var="uD" />
                    <button
                        onclick="deletes('${uD}', ${r.id}, 'report')"
                        class="btn btn-danger"
                        >
                        &times;
                    </button>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>

