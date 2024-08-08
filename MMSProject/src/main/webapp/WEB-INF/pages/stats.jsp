<%-- 
    Document   : stats
    Created on : Aug 8, 2024, 4:10:56 PM
    Author     : ACER
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="col-10 container-fluid">    
    <h1 class="text-center text-primary mt-1">THỐNG KÊ BÁO CÁO</h1>
    <div class="row">
        <div class="col-md-5 col-12">
            <table class="table">
                <tr>
                    <th>Id</th>
                    <th>Tên sản phẩm</th>                    
                </tr>
                <c:forEach items="${stats}" var="r">
                    <tr>
                        <td>${r[0]}</td>
                        <td>${r[1]}</td>                        
                    </tr>
                </c:forEach>
            </table>
        </div>
        <div class="col-md-7 col-12">
            <canvas id="myChart"></canvas>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
    <script>
        let labels = [];
        let data = [];
        <c:forEach items="${stats}" var="r">
        labels.push('${r[1]}');
        data.push(${r[0]});
        </c:forEach>

        window.onload = function () {
            const ctx = document.getElementById('myChart');

            new Chart(ctx, {
                type: 'doughnut',
                data: {
                    labels: labels,
                    datasets: [{
                            label: '# Các sản phẩm',
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