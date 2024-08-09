<%-- 
    Document   : location
    Created on : Aug 7, 2024, 2:24:30 PM
    Author     : Do Gia Huy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="col-10 container-fluid">
  <h1 class="text-center">LOCATION MANAGE</h1>
  <table class="table table-striped mt-3">
    <tr>
      <th>Id</th>
      <th>Location name</th>
      <th>Address</th>
      <th></th>
    </tr>
    <c:forEach items="${location}" var="l">
      <tr id="location${l.id}">
        <td>${l.id}</td>
        <td>${l.name}</td>
        <td>${l.address}</td>
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
