<%-- Document : index Created on : Aug 5, 2024, 11:48:38 AM Author : Do Gia Huy
--%> <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <%@page
    contentType="text/html" pageEncoding="UTF-8"%>
    <div class="col-10 container-fluid">
        <c:forEach items="${scheduleRepair}" var="r" >
            <div class="alert alert-primary alert-dismissible fade show mt-2" role="alert">
                Sap den ${r.name} - ${r.date}
                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
            </div>
            
        </c:forEach>
        <c:forEach items="${scheduleMaintenance}" var="m" >
            <div class="alert alert-primary alert-dismissible fade show mt-2" role="alert">
                Sap den ${m.name} - ${m.nextMaintenanceDate}
                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
            </div>
        </c:forEach>
        <h1 class="text-center">DEVICE MANAGE</h1>
        <c:url value="/" var="action" />
        <form action="${action}">
            <div class="mb-3 mt-3 d-flex justify-content-center align-items-center">
                <label for="kw" class="form-label">Keyword:</label>
                <input type="text" class="form-control ms-3" style="width: 60%" id="kw" placeholder="Keyword..." name="q">
                <button class="btn btn-info ms-3" type="submit">Find</button>
                <a href="<c:url value="/device/add"></c:url>"class="btn btn-success ms-3">ADD DEVICE</a> 
                </div>
            </form>
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
                        <c:url value="/device/${d.id}/location_history" var="lh" />
                        <a href="${lh}" class="btn btn-info">i</a>  

                        <c:url value="/device/${d.id}" var="u" />
                        <a href="${u}" class="btn btn-success">&orarr;</a>

                        <c:url value="/api/device/delete/${d.id}" var="uD" />
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
