<%-- Document : category Created on : Aug 5, 2024, 3:04:54 PM Author : ACER --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="col-10 container-fluid">
    <a href="<c:url value="/category/add"></c:url>"class="btn btn-success m-1">Thêm</a>    
        <div class="col-md-10 col-12">
            <table class="table table-striped">
                <tr>                
                    <th>Id</th>
                    <th>Tên</th>
                    <th>Điều chỉnh</th>
                </tr>
            <c:forEach items="${cates}" var="c">
                <tr id="cates${c.id}">
                    <td>${c.id}</td>
                    <td>${c.name}</td>
                    <td>
                        <c:url value="/categories/${c.id}" var="u" />
                        <a href="${u}" class="btn btn-success">&orarr;</a>

                        <c:url value="/api/category/delete/${c.id}" var="uD" />                       
                        <button
                            onclick="deletes('${uD}', ${c.id}, 'cates')"
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
<script src="<c:url value="/js/delete.js" />"></script>
        