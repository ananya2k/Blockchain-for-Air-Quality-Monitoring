<jsp:include page="${contextPath}/common/header.jsp"/>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<div class="container">
  
  <jsp:include page="${contextPath}/common/sider.jsp"/>

<div class="main">
  <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
  
  <div class="container">
  <div class="table-responsive">
  <!--Table-->
  <table class="table table-striped table-bordered" id="airDataTable">
                <thead>
                  <tr>
                  <th>Index</th>
                  <th>Time Stamp</th>
                  <th>Hash</th>
                  <th>Previous Hash</th>
                   </tr>
                </thead>
                <tbody>
                    <c:forEach var="blockChain" items="${blockChainList}">
                      <tr>
                      <td>${blockChain.index}</td>
                      <td>${blockChain.timeStamp}</td>
                      <td>${blockChain.hash}</td>
                      <td>${blockChain.previousHash}</td>
                      </tr>
                    </c:forEach>
                </tbody>
              </table>
  </div>
<ul class="pagination pagination-lg">
<c:forEach begin="0" end="${totalPages}" var="page">
<li class="page-item"><a class="page-link" href="${contextPath}/show_block_chain?page=${page}&size=${size}">${page+1}</a></li>
</c:forEach>
</ul>
  </div>
</div>
</div>
<jsp:include page="${contextPath}/common/footer.jsp"/>