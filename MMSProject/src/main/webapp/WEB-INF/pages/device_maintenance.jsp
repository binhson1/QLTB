<%-- 
    Document   : device_maintenance
    Created on : Aug 13, 2024, 4:29:17 PM
    Author     : Do Gia Huy
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="col-10 container-fluid">
        <h1 class="text-center">DEVICE MAINTENANCE</h1>
         <a href="<c:url value="/maintenance/${scheduleMaintenanceId}/device/add"></c:url>"class="btn btn-success m-1 form-control">ADD DEVICES</a> 
        <table class="table table-striped mt-3">
            <tr>
                <th></th>
                <th>Id</th>
                <th>Device</th>
                <th>Schedule maintenance</th>
                <th></th>
            </tr>
            <c:forEach items="${device_maintenance}" var="d">
                <tr id="device${d.id}">
                    <td>
                        <img src="${d.deviceId.image}" width="120" />
                    </td>
                    <td>${d.id}</td>
                    <td>${d.deviceId.id} - ${d.deviceId.name}</td>
                    <td>${d.scheduleMaintenanceId.id} - ${d.scheduleMaintenanceId.name}</td>
                    <td>
                        <c:url value="/device/${d.id}/location_history" var="lh" />
                        <a href="${lh}" class="btn btn-info">i</a>  

                        <c:url value="/device/${d.id}" var="u" />
                        <a href="${u}" class="btn btn-success">&orarr;</a>

                        <c:url value="/api/devicemaintenance/delete/${d.id}" var="uD" />
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
