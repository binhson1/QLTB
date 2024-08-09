<%-- 
    Document   : scheduleRepair
    Created on : Aug 9, 2024, 2:51:09 PM
    Author     : ACER
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="col-10 container-fluid">
    <h1 class="text-center">Scheduling Repair Management</h1>
    <div class="col-md-10 col-12">
        <table class="table table-striped">
            <tr>                
                <th>Id</th>
                <th>Date</th>
                <th>Cost</th>
                <th>Repair Type</th>                    
            </tr>
            <c:forEach items="${schedulerepair}" var="c">
                <tr id="schedulerepair${c.id}">
                    <td>${c.id}</td>
                    <td>${c.date}</td>
                    <td>${c.cost}</td>
                    <td>${c.repairTypeId.name}</td>
                    <td>
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
</div>
