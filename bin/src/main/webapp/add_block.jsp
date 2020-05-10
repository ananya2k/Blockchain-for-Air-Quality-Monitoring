<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<jsp:include page="${contextPath}/common/header.jsp"/>
<div class="container">
  
  <jsp:include page="${contextPath}/common/sider.jsp"/>

<div class="main">
  <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
  <form:form method="POST" modelAttribute="airDataForm" class="form-signin">
            <h2 class="form-signin-heading">Add Block</h2>
            
  <div class="row">
  <div class="col-sm-4">
  <spring:bind path="date">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                <label for="date">Date</label>
                    <form:input type="date" path="date" class="form-control" placeholder="Date"
                                autofocus="true"></form:input>
                    <form:errors path="date"></form:errors>
                </div>
            </spring:bind>
    </div>
    <div class="col-sm-4">
    <spring:bind path="station_id">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                <label for="station_id">Station Id</label>
                    <form:input type="text" path="station_id" class="form-control" placeholder="Station Id"
                                autofocus="true"></form:input>
                    <form:errors path="station_id"></form:errors>
                </div>
            </spring:bind>
    </div>
    <div class="col-sm-4">
  <spring:bind path="pollutant">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                <label for="pollutant">pollutant</label>
                <form:select path="pollutant" items="${PollutantList}" class="form-control"/>
                    <form:errors path="pollutant"></form:errors>
                </div>
            </spring:bind>
    </div>
  </div>
  <div class="row">
  <div class="col-sm-1">
  <spring:bind path="h01">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                <label for="h01">H01</label>
                    <form:input type="text" path="h01" class="form-control" placeholder="H01"
                                autofocus="true"></form:input>
                    <form:errors path="h01"></form:errors>
                </div>
            </spring:bind>
    </div>
    <div class="col-sm-1">
  <spring:bind path="h02">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                <label for="h02">H02</label>
                    <form:input type="text" path="h02" class="form-control" placeholder="H02"
                                autofocus="true"></form:input>
                    <form:errors path="h02"></form:errors>
                </div>
            </spring:bind>
    </div>
    <div class="col-sm-1">
  <spring:bind path="h03">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                <label for="h03">H03</label>
                    <form:input type="text" path="h03" class="form-control" placeholder="H03"
                                autofocus="true"></form:input>
                    <form:errors path="h03"></form:errors>
                </div>
            </spring:bind>
    </div>
    <div class="col-sm-1">
  <spring:bind path="h04">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                <label for="h04">H04</label>
                    <form:input type="text" path="h04" class="form-control" placeholder="H04"
                                autofocus="true"></form:input>
                    <form:errors path="h04"></form:errors>
                </div>
            </spring:bind>
    </div>
    <div class="col-sm-1">
  <spring:bind path="h05">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                <label for="h03">H05</label>
                    <form:input type="text" path="h05" class="form-control" placeholder="H05"
                                autofocus="true"></form:input>
                    <form:errors path="h05"></form:errors>
                </div>
            </spring:bind>
    </div>
    <div class="col-sm-1">
  <spring:bind path="h06">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                <label for="h06">H06</label>
                    <form:input type="text" path="h06" class="form-control" placeholder="H06"
                                autofocus="true"></form:input>
                    <form:errors path="h06"></form:errors>
                </div>
            </spring:bind>
    </div>
    <div class="col-sm-1">
  <spring:bind path="h07">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                <label for="h07">H07</label>
                    <form:input type="text" path="h07" class="form-control" placeholder="H07"
                                autofocus="true"></form:input>
                    <form:errors path="h07"></form:errors>
                </div>
            </spring:bind>
    </div>
    <div class="col-sm-1">
  <spring:bind path="h08">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                <label for="h08">H08</label>
                    <form:input type="text" path="h08" class="form-control" placeholder="H08"
                                autofocus="true"></form:input>
                    <form:errors path="h08"></form:errors>
                </div>
            </spring:bind>
    </div>
    <div class="col-sm-1">
  <spring:bind path="h09">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                <label for="h09">H09</label>
                    <form:input type="text" path="h09" class="form-control" placeholder="H09"
                                autofocus="true"></form:input>
                    <form:errors path="h09"></form:errors>
                </div>
            </spring:bind>
    </div>
    <div class="col-sm-1">
  <spring:bind path="h10">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                <label for="h10">H10</label>
                    <form:input type="text" path="h10" class="form-control" placeholder="H10"
                                autofocus="true"></form:input>
                    <form:errors path="h10"></form:errors>
                </div>
            </spring:bind>
    </div>
    <div class="col-sm-1">
  <spring:bind path="h11">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                <label for="h11">H11</label>
                    <form:input type="text" path="h11" class="form-control" placeholder="H11"
                                autofocus="true"></form:input>
                    <form:errors path="h11"></form:errors>
                </div>
            </spring:bind>
    </div>
    <div class="col-sm-1">
  <spring:bind path="h12">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                <label for="h12">H12</label>
                    <form:input type="text" path="h12" class="form-control" placeholder="H12"
                                autofocus="true"></form:input>
                    <form:errors path="h12"></form:errors>
                </div>
            </spring:bind>
    </div>
    </div>
  <div class="row">
  <div class="col-sm-1">
  <spring:bind path="h13">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                <label for="h13">H13</label>
                    <form:input type="text" path="h13" class="form-control" placeholder="H13"
                                autofocus="true"></form:input>
                    <form:errors path="h13"></form:errors>
                </div>
            </spring:bind>
    </div>
    <div class="col-sm-1">
  <spring:bind path="h14">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                <label for="h14">H14</label>
                    <form:input type="text" path="h14" class="form-control" placeholder="H14"
                                autofocus="true"></form:input>
                    <form:errors path="h14"></form:errors>
                </div>
            </spring:bind>
    </div>
    <div class="col-sm-1">
  <spring:bind path="h15">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                <label for="h15">H15</label>
                    <form:input type="text" path="h15" class="form-control" placeholder="H15"
                                autofocus="true"></form:input>
                    <form:errors path="h15"></form:errors>
                </div>
            </spring:bind>
    </div>
    <div class="col-sm-1">
  <spring:bind path="h16">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                <label for="h16">H16</label>
                    <form:input type="text" path="h16" class="form-control" placeholder="H16"
                                autofocus="true"></form:input>
                    <form:errors path="h16"></form:errors>
                </div>
            </spring:bind>
    </div>
    <div class="col-sm-1">
  <spring:bind path="h17">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                <label for="h17">H17</label>
                    <form:input type="text" path="h17" class="form-control" placeholder="H17"
                                autofocus="true"></form:input>
                    <form:errors path="h17"></form:errors>
                </div>
            </spring:bind>
    </div>
    <div class="col-sm-1">
  <spring:bind path="h18">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                <label for="h18">H18</label>
                    <form:input type="text" path="h18" class="form-control" placeholder="H18"
                                autofocus="true"></form:input>
                    <form:errors path="h18"></form:errors>
                </div>
            </spring:bind>
    </div>
    <div class="col-sm-1">
  <spring:bind path="h19">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                <label for="h19">H19</label>
                    <form:input type="text" path="h19" class="form-control" placeholder="H19"
                                autofocus="true"></form:input>
                    <form:errors path="h19"></form:errors>
                </div>
            </spring:bind>
    </div>
    <div class="col-sm-1">
  <spring:bind path="h20">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                <label for="h20">H20</label>
                    <form:input type="text" path="h20" class="form-control" placeholder="H20"
                                autofocus="true"></form:input>
                    <form:errors path="h20"></form:errors>
                </div>
            </spring:bind>
    </div>
    <div class="col-sm-1">
  <spring:bind path="h21">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                <label for="h21">H21</label>
                    <form:input type="text" path="h21" class="form-control" placeholder="H21"
                                autofocus="true"></form:input>
                    <form:errors path="h21"></form:errors>
                </div>
            </spring:bind>
    </div>
    <div class="col-sm-1">
  <spring:bind path="h22">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                <label for="h22">H22</label>
                    <form:input type="text" path="h22" class="form-control" placeholder="H22"
                                autofocus="true"></form:input>
                    <form:errors path="h22"></form:errors>
                </div>
            </spring:bind>
    </div>
    <div class="col-sm-1">
  <spring:bind path="h23">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                <label for="h23">H23</label>
                    <form:input type="text" path="h23" class="form-control" placeholder="H23"
                                autofocus="true"></form:input>
                    <form:errors path="h23"></form:errors>
                </div>
            </spring:bind>
    </div>
    <div class="col-sm-1">
  <spring:bind path="h24">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                <label for="h24">H24</label>
                    <form:input type="text" path="h24" class="form-control" placeholder="H24"
                                autofocus="true"></form:input>
                    <form:errors path="h24"></form:errors>
                </div>
            </spring:bind>
    </div>
    </div>
  
  <div class="row">
  <div class="col-sm-12"><button class="btn btn-primary center-block" type="submit">Submit</button></div>
  </div>
  </form:form>
  </div>

</div>
<jsp:include page="${contextPath}/common/footer.jsp"/>