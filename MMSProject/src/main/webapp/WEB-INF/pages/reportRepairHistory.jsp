<%-- 
    Document   : reportRepairHistory
    Created on : Aug 29, 2024, 1:44:27 PM
    Author     : Do Gia Huy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="col-10 container-fluid">
    <h1 class="text-center">REPORT REPAIR HISTORY MANAGE</h1>
    <c:url value="/reportrepairhistory" var="action" />
    <form action="${action}">
        <div class="mb-3 mt-3 d-flex justify-content-center align-items-center">
            <label for="kw" class="form-label">Keyword:</label>
            <input type="text" class="form-control ms-3" style="width: 60%" id="kw" placeholder="Keyword..." name="q">
            <button class="btn btn-info ms-3" type="submit">Find</button>
            <a href="<c:url value="/reportrepairhistory/add"></c:url>"class="btn btn-success ms-3">ADD REPORT REPAIR HISTORY</a> 
        </div>
    </form>
    <table class="table table-striped mt-3">
        <tr>
            <th>Id</th>
            <th>Title</th>
            <th>Device Category</th>
            <th>Report</th>
            <th>Created date</th>
            <th></th>
        </tr>
        <c:forEach items="${reports}" var="r">
            <tr id="report${r.id}">
                <td>${r.id}</td>
                <td>${r.title}</td>
                <td>${r.deviceCategoryId.name}</td>
                <td>${r.reportId.id}</td>
                <td>${r.createdDate}</td>
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
