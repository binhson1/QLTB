<%-- 
    Document   : job
    Created on : Aug 9, 2024, 2:53:44 PM
    Author     : Do Gia Huy
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="col-10 container-fluid">
  <h1 class="text-center">JOB MANAGE</h1>
  <table class="table table-striped mt-3">
    <tr>
      <th>Id</th>
      <th>Start date</th>
      <th>End date</th>
      <th>Update date</th>
      <th>status</th>
      <th>Employee</th>
      <th>Maintenance</th>
      <th>Repair</th>
    </tr>
    <c:forEach items="${job}" var="j">
      <tr id="job{j.id}">
        <td>${j.id}</td>
        <td>${j.startDate}</td>
        <td>${j.endDate}</td>
        <td>${j.updatedDate}</td>
        <td>${j.status}</td>
        <td>${j.employeeId.name}</td>
        <td>${j.maintenanceId.id}</td>
        <td>${j.repairId.id}</td>
        <td>
          <c:url value="/location/${l.id}" var="u" />
          <a href="${u}" class="btn btn-success">&orarr;</a>

          <c:url value="/api/location/delete/${l.id}" var="uD" />
          <button
            onclick="deletes('${uD}', ${l.id}, 'location')"
            class="btn btn-danger"
          >
            &times;
          </button>
        </td>
      </tr>
    </c:forEach>
  </table>
</div>
