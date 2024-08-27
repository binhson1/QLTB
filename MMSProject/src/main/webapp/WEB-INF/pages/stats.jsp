<%-- 
    Document   : stats
    Created on : Aug 8, 2024, 4:10:56 PM
    Author     : ACER
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="col-10 container-fluid">    
    <h1 class="text-center text-primary mt-1">THỐNG KÊ BÁO CÁO</h1>
    <form>
        <div class="form-floating mb-3 mt-3">
            <input type="text" value="${param.year}" class="form-control" id="year" placeholder="Năm" name="year">
            <label for="year">Năm</label>
        </div>
        <div class="form-floating mb-3 mt-3">
            <select class="form-select" id="period" name="period">
                <option value="MONTH" selected>Theo tháng</option>
                <c:choose>
                    <c:when test="${param.period=='QUARTER'}">
                        <option value="QUARTER" selected>Theo quý</option>
                    </c:when>
                    <c:otherwise>
                        <option value="QUARTER">Theo quý</option>
                    </c:otherwise>
                </c:choose>
            </select>
            <label for="period" class="form-label">Chọn thời gian:</label>
        </div>
        <div class="form-floating mb-3 mt-3">
            <button class="btn btn-success">Lọc</button>
        </div>
    </form>
    <%@ page import="java.util.Date" %>
    <jsp:useBean id="now" class="java.util.Date" />
    <c:if test="${param.year != null}">
        <div class="alert alert-info">
            <h4>Năm: ${param.year}</h4>
            <h4>Thời gian: ${param.period}</h4>
        </div>
    </c:if>
    <table class="table table-striped">
        <tr>
            <th>Tháng/Quý</th>
            <th>Thiet bi</th>
            <th>Chi phi</th>
        </tr>
        <c:forEach items="${statsRepairCostDevice}" var="rP">
            <tr>
                <td>${rP[0]}</td>
                <td>${rP[2]}</td>
                <td>${rP[1]} VNĐ</td>
            </tr>
        </c:forEach>
    </table>
    <div class="row">
        <div class="col-md-5 col-12">
            <h3>Thông kê theo danh muc</h3>
            <table class="table">
                <tr>
                    <th>Category</th>
                    <th>So luong</th>                    
                </tr>
                <c:forEach items="${statsDeviceByCate}" var="c">
                    <tr>
                        <td>${c[1]}</td>
                        <td>${c[0]}</td>                        
                    </tr>
                </c:forEach>
            </table>
        </div>
        <div class="col-md-7 col-12">
            <canvas id="chart2"></canvas>
        </div>
    </div>
    <div class="row">
        <div class="col-md-5 col-12">
            <h3>Thông kê theo trang thai</h3>
            <table class="table">
                <tr>
                    <th>Trang thai</th>
                    <th>So luong</th>                    
                </tr>
                <c:forEach items="${statsDeviceByStatus}" var="s">
                    <tr>
                        <td>${s[1]}</td>
                        <td>${s[0]}</td>                        
                    </tr>
                </c:forEach>
            </table>
        </div>
        <div class="col-md-7 col-12">
            <canvas id="myChart"></canvas>
        </div>
    </div>
    <div class="row">
        <div class="col-md-5 col-12">
            <h3>Danh sach thiet bi</h3>
            <table class="table">
                <tr>
                    <th>Id</th>
                    <th>Tên sản phẩm</th>   
                    <th>Trang thai</th>
                </tr>
                <c:forEach items="${stats}" var="r">
                    <tr>
                        <td>${r[0]}</td>
                        <td>${r[1]}</td>           
                        <td>${r[2]}</td> 
                    </tr>
                </c:forEach>
            </table>
        </div>

    </div>


    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
    <script>

        let labels2 = [];
        let data2 = [];
        <c:forEach items="${statsDeviceByCate}" var="c">
        labels2.push('${c[1]}');
        data2.push(${c[0]});
        </c:forEach>

        let labels = [];
        let data = [];
        <c:forEach items="${statsDeviceByStatus}" var="s">
        labels.push('${s[1]}');
        data.push(${s[0]});
        </c:forEach>
        window.onload = function () {

            const ctx2 = document.getElementById('chart2');

            new Chart(ctx2, {
                type: 'doughnut',
                data: {
                    labels: labels2,
                    datasets: [{
                            label: "So luong",
                            data: data2,
                            backgroundColor: [
                                'rgb(255, 99, 132)',
                                'rgb(54, 162, 235)',
                                'rgb(255, 205, 86)'
                            ],
                            hoverOffset: 4
                        }]
                }
            });

            const ctx = document.getElementById('myChart');

            new Chart(ctx, {
                type: 'doughnut',
                data: {
                    labels: labels,
                    datasets: [{
                            label: "So luong",
                            data: data,
                            backgroundColor: [
                                'rgb(255, 99, 132)',
                                'rgb(54, 162, 235)',
                                'rgb(255, 205, 86)'
                            ],
                            hoverOffset: 4
                        }]
                }
            });
        }
    </script>
</div>