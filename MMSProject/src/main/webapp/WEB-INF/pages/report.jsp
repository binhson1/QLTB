<%-- 
    Document   : report
    Created on : Aug 8, 2024, 3:52:51 PM
    Author     : Do Gia Huy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="col-10 container-fluid">
  <h1 class="text-center">LOCATION MANAGE</h1>
  <table class="table table-striped mt-3">
    <tr>
      <th>Id</th>
      <th>Description</th>
      <th>Occurrence Date</th>
      <th>Severity</th>
      <th>Device</th>
      <<th>User</th>
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
        <td>
          <c:url value="/location/${r.id}" var="u" />
          <a href="${u}" class="btn btn-success">&orarr;</a>

          <c:url value="/api/products/${r.id}" var="uD" />
          <button
            onclick="deleteProduct('${uD}', ${r.id})"
            class="btn btn-danger"
          >
            &times;
          </button>
        </td>
      </tr>
    </c:forEach>
  </table>
</div>

