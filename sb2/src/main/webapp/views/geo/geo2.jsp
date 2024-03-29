<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
  #geo2 > #map{
    width:100%;
    height:500px;
  }
</style>
<script>
  let geo2 = {
    map:null,
    // initialize
    init:function(){
      this.mapdisplay();
      $('#btn_s').click(()=>{
        this.go(37.5447611,127.0564625);
      });
      $('#btn_b').click(()=>{
        this.go(35.1290483,129.0446982);
      });
      $('#btn_j').click(()=>{
        this.go(33.3846216,126.5534925);
      });
    },
    // map 객체 생성
    mapdisplay:function(){
      var mapContainer = document.getElementById('map'), // 지도를 표시할 div
              mapOption = {
                center: new kakao.maps.LatLng(37.6497442, 126.8509859), // 지도의 중심좌표
                level: 3 // 지도의 확대 레벨
              };
      this.map = new kakao.maps.Map(mapContainer, mapOption);
      this.go(37.6497442, 126.8509859);
    },
    // 이동
    go:function(lat, lng){
      var moveLatLon = new kakao.maps.LatLng(lat, lng);
      this.map.panTo(moveLatLon);

      var mapContainer = document.getElementById('map'), // 지도를 표시할 div
              mapOption = {
                center: new kakao.maps.LatLng(lat, lng), // 지도의 중심좌표
                level: 8 // 지도의 확대 레벨
              };
      this.map = new kakao.maps.Map(mapContainer, mapOption);
      var market_position = new kakao.maps.LatLng(lat, lng);
      var marker = new kakao.maps.Marker({
        position: market_position
      });
      marker.setMap(this.map);
      geo2.getgeodata(lat, lng);
    },
    // 이동하는 지역의 데이터를 가지고 온다.
    getgeodata: function(lat, lng){
      $.ajax({
        url:'<c:url value="/geo/getshopdata"/>',
        data:{'lat':lat, 'lng':lng},
        success: function(datas) {
          geo2.display(datas);
        }
      });
    },
    display:function(datas){
      console.log(datas);

      var imageSrc = 'https://t1.daumcdn.net/localimg/localimages/07/2012/img/marker_p.png';
      $(datas).each(function(index, item) {
        console.log(item);
        var imageSize = new kakao.maps.Size(30, 30);
        var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize);
        var marketPosition = new kakao.maps.LatLng(item.lat, item.lng);
        var marker = new kakao.maps.Marker({
          map: geo2.map,
          position: marketPosition,
          title: item.title,
          image: markerImage
        });

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
            infowindow.open(geo2.map, marker);
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
  $(function(){
    geo2.init();
  });
</script>
<div class="container" id="geo2">
  <h2>GEO2 page</h2>
  <button id="btn_s" type="button" class="btn btn-primary">Seoul</button>
  <button id="btn_b" type="button" class="btn btn-primary">Busan</button>
  <button id="btn_j" type="button" class="btn btn-primary">Jeju</button>

  <div id="map"></div>

</div>