<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.*, java.io.*" %>

<html lang="kr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet"/>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">

    <script>
        let dinfos;
        let infos;
        let infoOs;
        let dmap;
        function mapinit(){
            infos =[["극동", 32500, 84.83, "2019-12-03"]];
            infos.push(infos[0]);
            infos.push(infos[0]);
            infos.push(infos[0]);
            dinfos = document.getElementById("dinfos");
            if (infos.length>0){
                createWithInfo(infos[0]);
                for (let i=1; i<infos.length; i++){
                    dinfos.appendChild(document.createElement('hr'));
                    createWithInfo(infos[i]);
                }
            }
        }
        
        function createWithInfo(info){
            let aName = document.createElement('a');
            aName.setAttribute('href', '#');
            aName.setAttribute('style','font-size: 130%; text-decoration-line: none; color: black');
            aName.appendChild(document.createTextNode(info[0]));
            dinfos.appendChild(aName);
            
            let dPrice = document.createElement('div');
            dPrice.appendChild(document.createTextNode('거래금액:'+info[1].toLocaleString()+'만원'));
            dinfos.appendChild(dPrice);
            
            let darea = document.createElement('div');
            darea.appendChild(document.createTextNode('면적:'+info[2].toLocaleString()));
            dinfos.appendChild(darea);

            let idate = document.createElement('i');
            idate.setAttribute('class', 'bi bi-calendar');
            dinfos.appendChild(idate);
            let dDate = document.createElement('span');
            dDate.appendChild(document.createTextNode(info[3]));
            dinfos.appendChild(dDate);
        }
        
        </script>
    <style>
        /* #map{
            position: absolute;
            left: 300px;
            top: 300px;
        } */
        
        </style>
        <script src="//dapi.kakao.com/v2/maps/sdk.js?appkey=80c17aa9864e9f2fd9cf66409468fc7b"></script>
</head>
<body onload="mapinit()">
    <div class="mapCon">
    </div>
    <!-- <i class="bi bi-calendar" style="margin-top: -100px;float: left;"></i> -->
    <div id="dinfos" style="width: 200px; height: 460px; border: black 1px solid; overflow: auto; display: inline-block;">
        <h2>거래정보</h2>
    </div>

    
    
    <div id="mapborder" style="width:760px; height: 370px; border: red 1px solid; overflow: auto; display: inline-block;">
        <div id="map" style="width:750px;height:350px;"></div>

	<script>
		var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
		    mapOption = {
		        center: new kakao.maps.LatLng(37.56344, 126.96543), // 지도의 중심좌표
		        level: 3, // 지도의 확대 레벨
		        mapTypeId : kakao.maps.MapTypeId.ROADMAP // 지도종류
		    }; 

		// 지도를 생성한다 
		var map = new kakao.maps.Map(mapContainer, mapOption); 

		// 지도에 확대 축소 컨트롤을 생성한다
		var zoomControl = new kakao.maps.ZoomControl();

		// 지도의 우측에 확대 축소 컨트롤을 추가한다
		map.addControl(zoomControl, kakao.maps.ControlPosition.RIGHT);
		// 마커 이미지의 주소
		var markerImageUrl = 'https://t1.daumcdn.net/localimg/localimages/07/2012/img/marker_p.png', 
		    markerImageSize = new kakao.maps.Size(40, 42), // 마커 이미지의 크기
		    markerImageOptions = { 
		        offset : new kakao.maps.Point(20, 42)// 마커 좌표에 일치시킬 이미지 안의 좌표
		    };

		// 마커 이미지를 생성한다
		var markerImage = new kakao.maps.MarkerImage(markerImageUrl, markerImageSize, markerImageOptions);

		// 지도에 마커를 생성하고 표시한다
		var marker = new kakao.maps.Marker({
		    position: new kakao.maps.LatLng(37.56344, 126.96407), // 마커의 좌표
		    image : markerImage, // 마커의 이미지
		    map: map // 마커를 표시할 지도 객체
		});

	</script>
        <!-- <iframe
            width="600"
            height="450"
            style="border:0"
            loading="lazy"
            allowfullscreen
            referrerpolicy="no-referrer-when-downgrade"
            src="https://www.google.com/maps/embed/v1/place?key=AIzaSyDlimgHwjhdbDXnXbH6MKXs2RhfX_6SAWg&q=멀티캠퍼스&region=KR">
        </iframe> -->
    </div>
</body>
</html>