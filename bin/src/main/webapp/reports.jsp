<jsp:include page="${contextPath}/common/header.jsp"/>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<div class="container">
  
  <jsp:include page="${contextPath}/common/sider.jsp"/>

<div class="main">
  <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
  
  <div class="container" style="padding: 5px;">
  <div class="table-responsive">
  <!--Table-->
  <table class="table table-striped table-bordered" id="airDataTable">
                <thead>
                  <tr>
                  <th>Id</th>
                    <th>Station Id</th>
                    <th>Pollutant</th>
                    <th>Date</th>
                    <th>H01</th>
                    <th>H02</th>
                    <th>H03</th>
                    <th>H04</th>
                    <th>H05</th>
                    <th>H06</th>
                    <th>H07</th>
                    <th>H08</th>
                    <th>H09</th>
                    <th>H10</th>
                    <th>H11</th>
                    <th>H12</th>
                    <th>H13</th>
                    <th>H14</th>
                    <th>H15</th>
                    <th>H16</th>
                    <th>H17</th>
                    <th>H18</th>
                    <th>H19</th>
                    <th>H20</th>
                    <th>H21</th>
                    <th>H22</th>
                    <th>H23</th>
                    <th>H24</th>
                   </tr>
                </thead>
                <tbody>
                    <c:forEach var="airData" items="${airDataList}">
                      <tr>
                      <td>${airData.id}</td>
                        <td>${airData.station_id}</td>
                        <td>${airData.pollutant}</td>
                        <td>${airData.date}</td>
                        <td>${airData.h01}</td>
                        <td>${airData.h02}</td>
                        <td>${airData.h03}</td>
                        <td>${airData.h04}</td>
                        <td>${airData.h05}</td>
                        <td>${airData.h06}</td>
                        <td>${airData.h07}</td>
                        <td>${airData.h08}</td>
                        <td>${airData.h09}</td>
                        <td>${airData.h10}</td>
                        <td>${airData.h11}</td>
                        <td>${airData.h12}</td>
                        <td>${airData.h13}</td>
                        <td>${airData.h14}</td>
                        <td>${airData.h15}</td>
                        <td>${airData.h16}</td>
                        <td>${airData.h17}</td>
                        <td>${airData.h18}</td>
                        <td>${airData.h19}</td>
                        <td>${airData.h20}</td>
                        <td>${airData.h21}</td>
                        <td>${airData.h22}</td>
                        <td>${airData.h23}</td>
                        <td>${airData.h24}</td> 
                      </tr>
                    </c:forEach>
                </tbody>
              </table>
  </div>
<ul class="pagination pagination-lg">
<c:forEach begin="0" end="${totalPages-1}" var="page">
<li class="page-item"><a class="page-link" href="${contextPath}/reports?page=${page}&size=${size}">${page+1}</a></li>
</c:forEach>
</ul>
  </div>
</div>
</div>
<jsp:include page="${contextPath}/common/footer.jsp"/>