<%-- 
    Document   : sidebar
    Created on : Aug 5, 2024, 12:38:36 PM
    Author     : Do Gia Huy
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="container-fluid col-2 ms-auto h-100">
    <div class="row flex-nowrap">
        <div class="px-sm-2 px-0 bg-dark">
            <div class="d-flex flex-column align-items-center align-items-sm-start px-3 pt-2 text-white min-vh-100">
                <a href="/" class="d-flex align-items-center pb-3 mb-md-0 me-md-auto text-white text-decoration-none">
                    <span class="fs-5 d-none d-sm-inline">Menu</span>
                </a>
                <ul class="nav nav-pills flex-column mb-sm-auto mb-0 align-items-center align-items-sm-start w-100" id="menu">
                    <li class="border-bottom border-white w-100">
                        <a href="#deviceMenu" data-bs-toggle="collapse" class="nav-link px-0 align-middle">
                            <i class="fs-4 bi-speedometer2"></i> <span class="ms-1 d-none d-sm-inline text-white">Device</span> </a>
                        <ul class="collapse nav flex-column ms-1 border-bottom ms-3" id="deviceMenu" data-bs-parent="#menu">
                            <li class="w-100 border-bottom border-white">
                                <c:url value="/" var="d1" />
                                <a href="${d1}" class="nav-link px-0 text-white"> <span class="d-none d-sm-inline">List devices</span> </a>
                            </li>
                            <li class="w-100 border-bottom border-white">
                                <c:url value="/device/add" var="d2" />
                                <a href="${d2}" class="nav-link px-0 text-white"> <span class="d-none d-sm-inline">Add device</span> </a>
                            </li>
                            <li class="w-100 border-bottom border-white">
                                <c:url value="/category" var="c1" />
                                <a href="${c1}" class="nav-link px-0 text-white"> <span class="d-none d-sm-inline">List category</span> </a>
                            </li>
                            <li class="w-100 border-bottom border-white">
                                <c:url value="/category/add" var="c2" />
                                <a href="${c2}" class="nav-link px-0 text-white"> <span class="d-none d-sm-inline">Add category</span> </a>
                            </li>
                            <li class="w-100 border-bottom border-white">
                                <c:url value="/manufacturer" var="m1" />
                                <a href="${m1}" class="nav-link px-0 text-white"> <span class="d-none d-sm-inline">List manufacturer</span> </a>
                            </li>
                            <li>
                                <c:url value="/manufacturer/add" var="m2" />
                                <a href="${m2}" class="nav-link px-0 text-white"> <span class="d-none d-sm-inline">Add manufacturer</span> </a>
                            </li>
                        </ul>
                    </li>
                    <li class="border-bottom border-white w-100">
                        <a href="#locationMenu" data-bs-toggle="collapse" class="nav-link px-0 align-middle text-white ">
                            <i class="fs-4 bi-speedometer2"></i> <span class="ms-1 d-none d-sm-inline">Location</span> </a>
                        <ul class="collapse nav flex-column ms-3" id="locationMenu" data-bs-parent="#menu">
                            <li class="w-100 border-bottom border-white">
                                <c:url value="/location" var="l1" />
                                <a href="${l1}" class="nav-link px-0 text-white"> <span class="d-none d-sm-inline">List location</span> </a>
                            </li>
                            <li>
                                <c:url value="/location/add" var="l2" />
                                <a href="${l2}" class="nav-link px-0 text-white"> <span class="d-none d-sm-inline">Add location</span> </a>
                            </li>
                        </ul>
                    </li>
                    <li class="border-bottom border-white w-100">
                        <a href="#employeeMenu" data-bs-toggle="collapse" class="nav-link px-0 align-middle text-white ">
                            <i class="fs-4 bi-speedometer2"></i> <span class="ms-1 d-none d-sm-inline">Employee</span> </a>
                        <ul class="collapse nav flex-column ms-3" id="employeeMenu" data-bs-parent="#menu">
                            <li class="w-100 border-bottom border-white">
                                <c:url value="/employee" var="e1" />
                                <a href="${e1}" class="nav-link px-0 text-white"> <span class="d-none d-sm-inline">List employee</span> </a>
                            </li>
                            <li>
                                <c:url value="/employee/add" var="e2" />
                                <a href="${e2}" class="nav-link px-0 text-white"> <span class="d-none d-sm-inline">Add employee</span> </a>
                            </li>
                        </ul>
                    </li>
                    <li class="border-bottom border-white w-100">
                        <a href="#maintenanceMenu" data-bs-toggle="collapse" class="nav-link px-0 align-middle text-white ">
                            <i class="fs-4 bi-speedometer2"></i> <span class="ms-1 d-none d-sm-inline">Maintenance</span> </a>
                        <ul class="collapse nav flex-column ms-3" id="maintenanceMenu" data-bs-parent="#menu">
                            <li class="w-100 border-bottom border-white">
                                <c:url value="/maintenance" var="e3" />
                                <a href="${e3}" class="nav-link px-0 text-white"> <span class="d-none d-sm-inline">List schedule</span> </a>
                            </li>
                            <li class="w-100 border-bottom border-white">
                                <c:url value="/maintenance/add" var="e4" />
                                <a href="${e4}" class="nav-link px-0 text-white"> <span class="d-none d-sm-inline">Add schedule</span> </a>
                            </li>
                            <li class="w-100 border-bottom border-white">
                                <c:url value="/maintenancetype" var="e1" />
                                <a href="${e1}" class="nav-link px-0 text-white"> <span class="d-none d-sm-inline">List types</span> </a>
                            </li>
                            <li>
                                <c:url value="/maintenancetype/add" var="e2" />
                                <a href="${e2}" class="nav-link px-0 text-white"> <span class="d-none d-sm-inline">Add type</span> </a>
                            </li>
                        </ul>
                    </li>
                    <li class="border-bottom border-white w-100">
                        <a href="#repairMenu" data-bs-toggle="collapse" class="nav-link px-0 align-middle text-white ">
                            <i class="fs-4 bi-speedometer2"></i> <span class="ms-1 d-none d-sm-inline">Repair</span> </a>
                        <ul class="collapse nav flex-column ms-3" id="repairMenu" data-bs-parent="#menu">
                            <li class="w-100 border-bottom border-white">
                                <c:url value="/schedulerepair" var="r1" />
                                <a href="${r1}" class="nav-link px-0 text-white"> <span class="d-none d-sm-inline">List schedule repair</span> </a>
                            </li>
                            <li class="w-100 border-bottom border-white">
                                <c:url value="/schedulerepair/add" var="r2" />
                                <a href="${r2}" class="nav-link px-0 text-white"> <span class="d-none d-sm-inline">Add schedule repair</span> </a>
                            </li>
                            <li class="w-100 border-bottom border-white">
                                <c:url value="/repairtype" var="r3" />
                                <a href="${r3}" class="nav-link px-0 text-white"> <span class="d-none d-sm-inline">List types</span> </a>
                            </li>
                            <li>
                                <c:url value="/repairtype/add" var="r4" />
                                <a href="${r4}" class="nav-link px-0 text-white"> <span class="d-none d-sm-inline">Add type</span> </a>
                            </li>

                        </ul>
                    </li>
                    <li class="border-bottom border-white w-100">
                        <a href="#reportMenu" data-bs-toggle="collapse" class="nav-link px-0 align-middle text-white ">
                            <i class="fs-4 bi-speedometer2"></i> <span class="ms-1 d-none d-sm-inline">Report</span> </a>
                        <ul class="collapse nav flex-column ms-3" id="reportMenu" data-bs-parent="#menu">
                            <li class="w-100 border-bottom border-white">
                                <c:url value="/report" var="rp1" />
                                <a href="${rp1}" class="nav-link px-0 text-white"> <span class="d-none d-sm-inline">List report</span> </a>
                            </li>
                            <li>
                                <c:url value="/report/add" var="rp2" />
                                <a href="${rp2}" class="nav-link px-0 text-white"> <span class="d-none d-sm-inline">Add report</span> </a>
                            </li>
                            <li class="w-100 border-bottom border-white">
                                <c:url value="/reportrepairhistory" var="rp3" />
                                <a href="${rp3}" class="nav-link px-0 text-white"> <span class="d-none d-sm-inline">List report repair history</span> </a>
                            </li>
                            <li class="w-100 border-bottom border-white">
                                <c:url value="/reportrepairhistory/add" var="rp4" />
                                <a href="${rp4}" class="nav-link px-0 text-white"> <span class="d-none d-sm-inline">Add report repair history</span> </a>
                            </li>
                        </ul>
                    </li>
                    <li class="border-bottom border-white w-100">
                        <c:url value="/job" var="job" />
                        <a href="${job}" class="nav-link px-0 align-middle text-white">
                            <i class="fs-4 bi-people"></i> <span class="ms-1 d-none d-sm-inline">Job</span> </a>
                    </li>
                    <li class="border-bottom border-white w-100">
                        <c:url value="/stats" var="stats" />
                        <a href="${stats}" class="nav-link px-0 align-middle text-white">
                            <i class="fs-4 bi-people"></i> <span class="ms-1 d-none d-sm-inline">Stats</span> </a>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</div>
