<jsp:include page="${contextPath}/common/header.jsp"/>
<div class="container">
  
  <jsp:include page="${contextPath}/common/sider.jsp"/>

<div class="main">
  <p><h2>Welcome ${pageContext.request.userPrincipal.name}</h2></p>
</div>
</div>
<jsp:include page="${contextPath}/common/footer.jsp"/>