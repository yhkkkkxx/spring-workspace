<%--
  Created by IntelliJ IDEA.
  User: hayoung
  Date: 2024/03/27
  Time: 9:37 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script>
  let chart3 = {
    init: function () {

      $('#get').click(() => {
        this.get();
      });
      setInterval(() => {this.get();}, 5000);
    },
    get: function() {
      $.ajax({
        url:'<c:url value="/chart3"/>',
        success: (data) => {
          this.chart(data);
        }
      })
    },
    chart: function(data) {
      Highcharts.chart('container', {
        chart: {
          type: 'spline'
        },
        title: {
          text: 'Monthly Average Temperature'
        },
        subtitle: {
          text: 'Source: ' +
                  '<a href="https://en.wikipedia.org/wiki/List_of_cities_by_average_temperature" ' +
                  'target="_blank">Wikipedia.com</a>'
        },
        xAxis: {
          categories: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun',
            'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'],
          accessibility: {
            description: 'Months of the year'
          }
        },
        yAxis: {
          title: {
            text: 'Temperature'
          },
          labels: {
            format: '{value}°'
          }
        },
        tooltip: {
          crosshairs: true,
          shared: true
        },
        plotOptions: {
          spline: {
            marker: {
              radius: 4,
              lineColor: '#666666',
              lineWidth: 1
            }
          }
        },
        series: data
      });
    }
  };
  $(function () {
    chart3.init();
  });
</script>
<html>
<head>
  <title>Title</title>
</head>
<body>
<div>
  <h2>CHART3 Page</h2>
  <div id="container"></div>
</div>
</body>
</html>