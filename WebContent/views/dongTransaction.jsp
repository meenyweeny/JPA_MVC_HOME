<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*, java.io.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Document</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
	crossorigin="anonymous" />
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css" />
<script src="script/key.js"></script>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
	<header>
		<c:import url="commonHeader.jsp"></c:import>
	</header>
	<c:import url="commonMid.jsp"></c:import>
	<div class="col-md-9">
		<div class="alert alert-success mt-3 text-center fw-bold" role="alert">아파트
			정보</div>
		<!-- 아파트 매매 정보 검색 start -->
		<div class="row col-md-12 justify-content-center mb-2">
			<div class="form-group col-md-2">
				<select class="form-select bg-secondary text-light" id="sido">
					<option value="">시도선택</option>
				</select>
			</div>
			<div class="form-group col-md-2">
				<select class="form-select bg-secondary text-light" id="gugun">
					<option value="">구군선택</option>
				</select>
			</div>
			<div class="form-group col-md-2">
				<select class="form-select bg-secondary text-light" id="dong">
					<option value="">동선택</option>
				</select>
			</div>
			<div class="form-group col-md-2">
				<select class="form-select bg-dark text-light" id="dYear">
					<option value="">매매년도선택</option>
				</select>
			</div>
			<div class="form-group col-md-2">
				<select class="form-select bg-dark text-light" id="dMonth">
					<option value="">매매월선택</option>
				</select>
			</div>
			<div class="form-group col-md-2">
				<button type="button" id="list-btn" class="btn btn-outline-primary">
					아파트매매정보</button>
			</div>
		</div>
		<!-- kakao map start -->
		<div id="map" class="mt-3" style="width: 100%; height: 400px"></div>
		<!-- kakao map end -->
		<table class="table table-hover text-center" style="display: none"
			id="myTable">
			<tr>
				<th>아파트이름</th>
				<th>층</th>
				<th>면적</th>
				<th>법정동</th>
				<th>거래금액</th>
			</tr>
			<tbody id="aptlist"></tbody>
		</table>
		<!-- 아파트 매매 정보 검색 end -->
	</div>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
		crossorigin="anonymous"></script>
	<script src="scripts/js/main.js"></script>
	<script type="text/javascript"
		src="//dapi.kakao.com/v2/maps/sdk.js?appkey=092e31bc345f4912d3730f41ce046ad8&libraries=services,clusterer,drawing"></script>
	<script>
    //브라우저 로딩 완료시 셀렉트박스 채우기
    $(document).ready(function(){
		$.ajax({//시도
			type: "POST",
			url: "sido.mvc",
			dataType: "json",
			success: function(response){
	            let sidoT = "<option value=''>시도선택 </option>";
	            for (let i = 0; i < response.length; i++) {
	                sidoT += `<option value=`+response[i]+`>`+response[i]+`</option>`;
	            }
	            $("#sido").html(sidoT);
			},
	        error: function(xhr, status, error) {
	            // 오류 처리 로직을 여기에 작성
	            console.error(error);
	        }
		});
		
		$.ajax({//년도
			type: "POST",
			url: "dYear.mvc",
			dataType: "json",
			success: function(response){
	            let dYearT = "<option value=''>매매년도선택 </option>";
	            for (let i = 0; i < response.length; i++) {
	            	dYearT += `<option value=`+response[i]+`>`+response[i]+`</option>`;
	            }
	            $("#dYear").html(dYearT);
			},
	        error: function(xhr, status, error) {
	            // 오류 처리 로직을 여기에 작성
	            console.error(error);
	        }
		});
		//월
		let dMonthT= "<option value=''>매매월선택 </option>"
		for (let i=1; i<=12; i++){
			dMonthT+=`<option value=`+i+`>`+i+` </option>`
		}
        $("#dMonth").html(dMonthT);
        
        $("#sido").change(function() {//시도 변경시 구군 가져오기
            $.ajax({
                type: "POST", 
                url: "gugun.mvc",
                data: { "sido": $(this).val() },
                dataType: "json", 
                success: function(response) {
    	            let gugunT = "<option value=''>구군선택 </option>";
    	            for (let i = 0; i < response.length; i++) {
    	            	gugunT += `<option value=`+response[i]+`>`+response[i]+`</option>`;
    	            }
    	            $("#gugun").html(gugunT);
                },
                error: function(xhr, status, error) {
                    // 오류 처리 로직을 여기에 작성
                    console.error(error);
                }
            });
        });
        
        $("#gugun").change(function() {//구군 변경시 동 가져오기
            $.ajax({
                type: "POST", 
                url: "dong.mvc",
                data: { "gugun": $(this).val() },
                dataType: "json", 
                success: function(response) {
    	            let dongT = "<option value=''>동선택 </option>";
    	            for (let i = 0; i < response.length; i++) {
    	            	dongT += `<option value=`+response[i]+`>`+response[i]+`</option>`;
    	            }
    	            $("#dong").html(dongT);
                },
                error: function(xhr, status, error) {
                    // 오류 처리 로직을 여기에 작성
                    console.error(error);
                }
            });
        });
	});


      ///////////////////////// 아파트 매매 정보 /////////////////////////
      document.querySelector("#list-btn").addEventListener("click", function () {
    	  document.querySelector("#myTable").setAttribute("style", "display: block;");
          $.ajax({
              type: "POST", // 또는 "POST", 요청 메서드 선택
              url: "searchDeal.mvc", // 데이터를 처리하는 JSP 또는 서블릿 URL
              data: { "dong": $("#dong").val(), "dYear": $("#dYear").val(), "dMonth": $("#dMonth").val()},
              dataType: "json", // 응답 데이터 유형 (JSON, XML, 등)
              success: function(response) {
            	  makeList(response)
              },
              error: function(xhr, status, error) {
                console.error(error);
              }
            });
        
    <%--    let queryParams = encodeURIComponent("serviceKey") + "=" + serviceKey; /*Service Key*/
        let url =
          "http://openapi.molit.go.kr/OpenAPI_ToolInstallPackage/service/rest/RTMSOBJSvc/getRTMSDataSvcAptTradeDev";
        let gugunSel = document.querySelector("#gugun");
        let regCode = gugunSel[gugunSel.selectedIndex].value.substr(0, 5);
        let yearSel = document.querySelector("#dYear");
        let year = yearSel[yearSel.selectedIndex].value;
        let monthSel = document.querySelector("#dMonth");
        let month = monthSel[monthSel.selectedIndex].value;
        let dealYM = year + month;
        queryParams +=
          "&" +
          encodeURIComponent("LAWD_CD") +
          "=" +
          encodeURIComponent(regCode); /*아파트소재 구군*/
        queryParams +=
          "&" + encodeURIComponent("DEAL_YMD") + "=" + encodeURIComponent(dealYM); /*조회년월*/
        queryParams +=
          "&" + encodeURIComponent("pageNo") + "=" + encodeURIComponent("1"); /*페이지번호*/
        queryParams +=
          "&" + encodeURIComponent("numOfRows") + "=" + encodeURIComponent("30"); /*페이지당건수*/

        fetch(`${url}?${queryParams}`)
          .then((response) => response.text())
          .then((data) => makeList(data));
          --%>
      });

      function makeList(data) {
    	    document.querySelector("table").setAttribute("style", "display: ;");
    	    let tbody = document.querySelector("#aptlist");
    	    initTable();
    	    
    	    // JSON 데이터 파싱
    	    //let jsonData = JSON.parse(data);

    	    data.forEach((apt) => {
    	        let tr = document.createElement("tr");

    	        apt.forEach((cellData) => {
    	            let td = document.createElement("td");
    	            td.appendChild(document.createTextNode(cellData));
    	            tr.appendChild(td);
    	        });

    	        tbody.appendChild(tr);
    	    });
    	}
      function initTable() {
          let tbody = document.querySelector("#aptlist");
          let len = tbody.rows.length;
          for (let i = len - 1; i >= 0; i--) {
            tbody.deleteRow(i);
          }
        }
      <%--
      function makeList(data) {
        document.querySelector("table").setAttribute("style", "display: ;");
        let tbody = document.querySelector("#aptlist");
        let parser = new DOMParser();
        const xml = parser.parseFromString(data, "application/xml");
        // console.log(xml);
        initTable();
        let apts = xml.querySelectorAll("item");
        apts.forEach((apt) => {
          let tr = document.createElement("tr");

          let nameTd = document.createElement("td");
          nameTd.appendChild(document.createTextNode(apt.querySelector("아파트").textContent));
          tr.appendChild(nameTd);

          let floorTd = document.createElement("td");
          floorTd.appendChild(document.createTextNode(apt.querySelector("층").textContent));
          tr.appendChild(floorTd);

          let areaTd = document.createElement("td");
          areaTd.appendChild(document.createTextNode(apt.querySelector("전용면적").textContent));
          tr.appendChild(areaTd);

          let dongTd = document.createElement("td");
          dongTd.appendChild(document.createTextNode(apt.querySelector("법정동").textContent));
          tr.appendChild(dongTd);

          let priceTd = document.createElement("td");
          priceTd.appendChild(
            document.createTextNode(apt.querySelector("거래금액").textContent + "만원"),
          );
          priceTd.classList.add("text-end");
          tr.appendChild(priceTd);

          let address =
            apt.querySelector("중개사소재지").textContent +
            " " +
            apt.querySelector("법정동").textContent +
            " " +
            apt.querySelector("지번").textContent;
          tr.addEventListener("click", () =>
            viewMap(apt.querySelector("아파트").textContent, address),
          );

          tbody.appendChild(tr);
        });
      }

      // 카카오지도
      var mapContainer = document.getElementById("map"), // 지도를 표시할 div
        mapOption = {
          center: new kakao.maps.LatLng(37.500613, 127.036431), // 지도의 중심좌표
          level: 3, // 지도의 확대 레벨
        };

      // 지도를 표시할 div와  지도 옵션으로  지도를 생성합니다
      var map = new kakao.maps.Map(mapContainer, mapOption);

      var marker, infowindow;
      function viewMap(apt, address) {
        if (marker != null && infowindow != null) {
          marker.setMap(null);
          infowindow.close();
        }
        // 주소-좌표 변환 객체를 생성합니다
        var geocoder = new kakao.maps.services.Geocoder();

        // 주소로 좌표를 검색합니다
        geocoder.addressSearch(address, function (result, status) {
          // 정상적으로 검색이 완료됐으면
          if (status === kakao.maps.services.Status.OK) {
            var coords = new kakao.maps.LatLng(result[0].y, result[0].x);

            // 결과값으로 받은 위치를 마커로 표시합니다
            marker = new kakao.maps.Marker({
              map: map,
              position: coords,
            });

            // 인포윈도우로 장소에 대한 설명을 표시합니다
            infowindow = new kakao.maps.InfoWindow({
              content: `<div style="width:150px;text-align:center;padding:6px 0;">${apt}</div>`,
            });
            infowindow.open(map, marker);

            // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
            map.setCenter(coords);
          }
        });
      }
      --%>
    </script>
</body>
</html>

