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
  #geo3 > #map {
    width: 100%;
    height: 500px;
  }
</style>

<script>
  let geo3 = {
    map:null,
    lat: 37.5449352,
    lng: 127.0566045,
    init:function() {
      var mapContainer = document.getElementById('map'), // 지도를 표시할 div
              mapOption = {
                center: new kakao.maps.LatLng(geo3.lat, geo3.lng), // 지도의 중심좌표
                level: 8 // 지도의 확대 레벨
              };

      // 지도를 표시할 div와  지도 옵션으로  지도를 생성합니다
      geo3.map = new kakao.maps.Map(mapContainer, mapOption);
      geo3.getshop();

    },
    getshop: function() {
      $.ajax({
        url:'<c:url value="/geo/getdata"/>',
        success: function(datas) {
          geo3.display(datas);
        }
      });

      var market_position  = new kakao.maps.LatLng(37.5449352, 127.0566045);
      var marker = new kakao.maps.Marker({
        position: market_position
      });
      marker.setMap(geo3.map);
      geo3.display(datas);
    },
    display:function(datas){
      var imageSrc = 'https://t1.daumcdn.net/localimg/localimages/07/2012/img/marker_p.png';
      $(datas).each(function(index, item){
        // marker 생성
        // window 생성
        // event
        var imageSize = new kakao.maps.Size(30, 30);
        var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize);
        var marketPosition = new kakao.maps.LatLng(item.lat,item.lng);
        var marker = new kakao.maps.Marker({
          map: geo3.map,
          position: marketPosition,
          title:item.title,
          image: markerImage
        });
        // infowindow
        console.log(item);
        var infoContent ='<p>'+item.title+'</p>';
        infoContent+='<img style="width:50px;" src="<c:url value="/img/'+item.img+'"/>">';
        var infowindow = new kakao.maps.InfoWindow({
          content:infoContent,
          position:marketPosition
        });
        kakao.maps.event.addListener(marker, 'mouseover', mouseoverHandler(marker, infowindow));
        kakao.maps.event.addListener(marker, 'mouseout', mouseoutHandler(marker, infowindow));
        kakao.maps.event.addListener(marker, 'click', mouseclickHandler(item.id));

        function mouseoverHandler(marker, infowindow) {
          return function(){
            infowindow.open(geo3.map, marker);
          }
        }
        function mouseoutHandler(marker, infowindow) {
          return function(){
            infowindow.close();
          }
        }
        function mouseclickHandler(target) {
          return function(){
            location.href = '<c:url value="/geo/shopdetail?shopid='+target+'"/>'
          }
        }

      });
    }

  }

  $(function() {
    geo3.init();
  });
</script>

<div class="container" id="geo3">
  <h2>GEO3 Page</h2>
  <div id="map">

  </div>
</div>
