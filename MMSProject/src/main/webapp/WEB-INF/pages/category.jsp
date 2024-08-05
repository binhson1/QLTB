<%-- Document : category Created on : Aug 5, 2024, 3:04:54 PM Author : ACER --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <%@page
contentType="text/html" pageEncoding="UTF-8"%>
<section class="container">
  <div class="col-md-10 col-12">
    <table class="table table-striped">
      <tr>
        <th></th>
        <th>Id</th>
        <th>Tên</th>
      </tr>
      <c:forEach items="${cates}" var="c">
        <tr id="cates${c.id}">
          <td>${c.id}</td>
          <td>${c.name}</td>
          <td>
            <c:url value="/products/${p.id}" var="u" />
            <a href="${u}" class="btn btn-success">&orarr;</a>

            <c:url value="/api/products/${p.id}" var="uD" />
            <button
              onclick="deleteProduct('${uD}', ${p.id})"
              class="btn btn-danger"
            >
              &times;
            </button>
          </td>
        </tr>
      </c:forEach>
    </table>
  </div>
</section>
