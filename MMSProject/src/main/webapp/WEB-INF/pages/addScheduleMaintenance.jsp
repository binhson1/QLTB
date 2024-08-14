<%-- 
    Document   : addScheduleMaintenance
    Created on : Aug 13, 2024, 1:38:59 PM
    Author     : Do Gia Huy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div class="col-10 container-fluid">
    <h1 class="text-center text-primary">SCHEDULE MAINTENANCE</h1>
    <c:url value="/maintenance/addOrUpdate" var="action" />
    <c:if test="${errMsg != null}">
        <div class="alert alert-danger">
            ${errMsg}
        </div>
    </c:if>
    <form:form method="post" enctype="multipart/form-data" modelAttribute="maintenance" action="${action}">
        <div class="mb-3 mt-3">
            <label for="name" class="form-label">Maintenance name:</label>
            <form:input path="name" type="text" class="form-control" id="name" placeholder="Maintenance name..." name="name" />
        </div>
        <div class="mb-3 mt-3">
            <label for="nextMaintenanceDate" class="form-label">Next date expected: </label>
            <form:input path="nextMaintenanceDate" type="date" class="form-control" id="nextMaintenanceDate" name="nextMaintenanceDate" />
        </div>
        <div class="mb-3 mt-3">
            <label for="intervalMonth" class="form-label">Interval month: </label>
            <form:input path="intervalMonth" type="number" class="form-control" id="intervalMonth" name="intervalMonth" />
        </div>
        <div class="mb-3 mt-3">
            <label for="maintenanceTypeId" class="form-label">Maintenance type: </label>
            <form:select class="form-select" path="maintenanceTypeId" id="maintenanceTypeId" >
                <c:forEach items="${maintenanceType}" var="mT">
                    <c:choose>
                        <c:when test="${mT.id == maintenance.maintenanceTypeId.id}">
                            <option value="${mT.id}" selected>${mT.name}</option>
                        </c:when>
                        <c:otherwise>
                            <option value="${mT.id}">${mT.name}</option>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </form:select>
        </div>
        <div class="mb-3 mt-3 text-center">
            <form:hidden path="id" />
            <button class="btn btn-success" type="submit">
                ADD
            </button>
        </div>
    </form:form>
</div>
<!--<script>
    let deviceCount = 1;

    async function addDevice() {
        deviceCount++;
        const selectElement = document.getElementById('deviceSelect1');
        const device = selectElement.value; // Không cần await ở đây
        console.log('Selected device value:', device); // Kiểm tra giá trị device

        // Kiểm tra xem selectElement có giá trị hợp lệ không
        if (!device) {
            console.error('No device selected.');
            return;
        }
            <div id="devicesContainer">
            <div class="deviceSelect">
                <label for="deviceSelect1">Device list:</label>
                <select class="form-select" id="deviceSelect1" name="list" >
                    
                </select>
            </div>
            <button type="button" class="btn btn-success form-control mt-3" onclick="addDevice()">Add Another Device</button>
        </div>
        <br>
        const container = document.getElementById('devicesContainer');

        // Tạo phần tử div
        const newDeviceRow = document.createElement('div');
        newDeviceRow.className = 'deviceRow d-flex justify-content-around mt-3 p-2';

        // Tạo phần tử input
        const input = document.createElement('input');
        input.type = 'text';
        input.className='input form-control';
        input.readOnly = true;
        input.name = 'devices[]';
        input.value = device;
        input.width = '90%';

        // Tạo phần tử button
        const button = document.createElement('button');
        button.className = 'btn btn-danger';
        button.textContent = 'X';
        button.type = 'button'; // Ngăn chặn hành vi mặc định của button trong form
        button.addEventListener('click', () => removeDevice(button));

        // Thêm các phần tử vào newDeviceRow
        newDeviceRow.appendChild(input);
        newDeviceRow.appendChild(button);

        // Thêm newDeviceRow vào container
        container.appendChild(newDeviceRow);
    }

    function removeDevice(button) {
        button.parentElement.remove();
    }
</script>-->