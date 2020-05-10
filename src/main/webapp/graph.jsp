<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<jsp:include page="${contextPath}/common/header.jsp"/>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<div class="container">
  
  <jsp:include page="${contextPath}/common/sider.jsp"/>

<div class="main">
  <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
  
  <div class="container">
  <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
  <form:form method="GET" modelAttribute="airDataForm" class="form-signin">
  <br/><br/>
  <div class="row">
  <div class="col-sm-2">
  <label for="date">Please select a date:</label>
  </div>
  <div class="col-sm-4">
  <spring:bind path="date">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="date" path="date" class="form-control" placeholder="Date"
                                autofocus="true"></form:input>
                    <form:errors path="date"></form:errors>
                </div>
      </spring:bind>
  </div>
  <div class="col-sm-1"><button class="btn btn-primary center-block" type="submit">Submit</button></div>
  </div>
  </form:form>
  <div id="chart_wrap">
    <div id="piechart"></div>
</div>
</div>
</div>
</div>
<jsp:include page="${contextPath}/common/footer.jsp"/>
<script type="text/javascript" src="https://www.google.com/jsapi"></script>
<script type="text/javascript">
    // Load the Visualization API and the piechart package.
    google.load('visualization', '1.0', {
        'packages' : [ 'corechart' ]
    });
    // Set a callback to run when the Google Visualization API is loaded.
    google.setOnLoadCallback(drawChart);
    // Callback that creates and populates a data table,
    // instantiates the pie chart, passes in the data and
    // draws it.
    function drawChart() {
        // Create the data table.    
        var data = google.visualization.arrayToDataTable([
                                                              ['Pollutant', 'Hour'],
                                                              <c:forEach items="${pieDataList}" var="entry">
                                                                  [ '${entry.key}', ${entry.value} ],
                                                              </c:forEach>
                                                        ]);
        // Set chart options
        var options = {
            'title' : 'Pollutant Data',
            is3D : true,
            pieSliceText: 'value-and-percentage',
            tooltip :  {showColorCode: true},
            'width' : 900,
            'height' : 500
        };
        // Instantiate and draw our chart, passing in some options.
        var chart = new google.visualization.PieChart(document.getElementById('piechart'));
        chart.draw(data, options);
    }
</script>