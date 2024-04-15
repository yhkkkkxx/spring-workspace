<%--
  Created by IntelliJ IDEA.
  User: hayoung
  Date: 2024/03/27
  Time: 9:37 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
  #container {
    width: 700px;
    height: 500px;
  }
</style>
<script>
  let chart1 = {
    init:function(){
      // Data retrieved https://en.wikipedia.org/wiki/List_of_cities_by_average_temperature
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
        series: [{
          name: 'Tokyo',
          marker: {
            symbol: 'square'
          },
          // data: [5.2, 5.7, 8.7, 13.9, 18.2, 21.4, 25.0, {
          //   y: 26.4,
          //   marker: {
          //     symbol: 'url(https://www.highcharts.com/samples/graphics/sun.png)'
          //   },
          //   accessibility: {
          //     description: 'Sunny symbol, this is the warmest point in the chart.'
          //   }
          // }, 22.8, 17.5, 12.1, 7.6]
          data: [1, 2, 3, 4, 5, 6, 4, 4 ,3 ,2 ,1, 0]

        }, {
          name: 'Bergen',
          marker: {
            symbol: 'diamond'
          },
          data: [1.5, 1.6, 3.3, 5.9, 10.5, 13.5, 14.5, 14.4, 11.5, 8.7, 4.7, 2.6]
        }, {
          name: 'Korea',
          marker: {
            symbol: 'circle'
          },
          data: [-2.5, -1.4, 2.3, 10.5, 13.6, 18.7, 35.9, 30.1, 24.2, 10.4, 5.7, 0.3]
        }]
      });

    }
  };
  $(function(){
    chart1.init();
  });
</script>

<div class="container">
  <h2>CHART1 Page</h2>
  <div id="container">

  </div>
</div>
