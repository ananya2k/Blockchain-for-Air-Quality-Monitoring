<jsp:include page="${contextPath}/common/header.jsp"/>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div class="container">
  
  <jsp:include page="${contextPath}/common/sider.jsp"/>

<div class="main">
  <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
  
  <div class="container">
  <div class="row">
  <div class="col-sm-12">
  <form:form method="POST">
  <button class="btn btn-primary center-block" type="submit">Validate Block Chain</button>
  </form:form>
  </div>
  <c:if test="${verify}">
  <div class="row">
	<div class="col-sm-4">${MerkleRoot}</div>
    <div class="col-sm-4"><img src="${contextPath}/resources/images/verified-stamp.webp"/></div>
  </div>
</c:if>
  </div>
  </div>
</div>
</div>
<jsp:include page="${contextPath}/common/footer.jsp"/>