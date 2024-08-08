<%-- Document : index Created on : Aug 5, 2024, 11:48:38 AM Author : Do Gia Huy
--%> <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <%@page
contentType="text/html" pageEncoding="UTF-8"%>
<div class="col-10 container-fluid">
  <h1 class="text-center">DEVICE MANAGE</h1>
  <table class="table table-striped mt-3">
    <tr>
      <th></th>
      <th>Id</th>
      <th>Device name</th>
      <th>Bought date</th>
      <th>Location</th>
      <th>Category</th>
      <th>Manufacturer</th>
      <th>Status</th>
      <th></th>
    </tr>
    <c:forEach items="${devices}" var="d">
      <tr id="device${d.id}">
        <td>
          <img src="${d.image}" width="120" />
        </td>
        <td>${d.id}</td>
        <td>${d.name}</td>
        <td>${d.boughtDate}</td>
        <td>
          <c:forEach items="${d.locationhistorySet}" var="l">
            <c:if test="${l.active == true}"> ${l.locationId.name} </c:if>
          </c:forEach>
        </td>
        <td>${d.deviceCategoryId.name}</td>
        <td>${d.manufacturerId.name}</td>
        <th>${d.status}</th>
        <td>
          <c:url value="/device/${d.id}" var="u" />
          <a href="${u}" class="btn btn-success">&orarr;</a>

          <c:url value="/api/devices/delete/${d.id}" var="uD" />
          <button
            onclick="deletes('${uD}', ${d.id}, 'device')"
            class="btn btn-danger"
          >
            &times;
          </button>
        </td>
      </tr>
    </c:forEach>
  </table>
</div>
