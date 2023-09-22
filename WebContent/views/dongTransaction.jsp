<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.*, java.io.*" %>

<html lang="kr">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
      crossorigin="anonymous"
    />
    <link
      rel="stylesheet"
      href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css"
    />
    <script src="script/key.js"></script>
</head>
<body>
	<header>
		<c:import url="commonHeader.jsp"></c:import>
	</header>
		<c:import url="commonMid.jsp"></c:import>
    <!-- 중앙 content start -->
    <div class="container">
      <div style="height: 70px"></div>
      <div class="col-md-9">
        <div class="alert alert-success mt-3 text-center fw-bold" role="alert">아파트 정보</div>
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
            <select class="form-select bg-dark text-light" id="year"></select>
          </div>
          <div class="form-group col-md-2">
            <select class="form-select bg-dark text-light" id="month">
              <option value="">매매월선택</option>
            </select>
          </div>
          <div class="form-group col-md-2">
            <button type="button" id="list-btn" class="btn btn-outline-primary">
              아파트매매정보
            </button>
          </div>
        </div>
        <!-- kakao map start -->
        <div id="map" class="mt-3" style="width: 100%; height: 400px"></div>
        <!-- kakao map end -->
        <table class="table table-hover text-center" style="display: none">
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
    <!-- 중앙 content end -->

    <!-- 하단 footer start -->
    <footer class="navbar navbar-expand-lg navbar-light bg-light container justify-content-end">
      <div class="row">
        <ul class="navbar-nav">
          <li><a href="#" class="nav-link text-secondary">카페소개</a></li>
          <li><a href="#" class="nav-link text-secondary">개인정보처리방침</a></li>
          <li><a href="#" class="nav-link text-secondary">이용약관</a></li>
          <li><a href="#" class="nav-link text-secondary">오시는길</a></li>
          <li><label class="nav-link text-secondary">&copy; SSAFY Corp.</label></li>
        </ul>
      </div>
    </footer>

    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
      crossorigin="anonymous"
    ></script>
    
    <script
      type="text/javascript"
      src="//dapi.kakao.com/v2/maps/sdk.js?appkey=80c17aa9864e9f2fd9cf66409468fc7b&libraries=services,clusterer,drawing"
    ></script>
    <script>
      ///////////////////////// select box 설정 (지역, 매매기간) /////////////////////////
      let date = new Date();

      let yearEl = document.querySelector("#year");
      let yearOpt = `<option value="">매매년도선택</option>`;
      let year = date.getFullYear();
      for (let i = year; i > year - 20; i--) {
        yearOpt += `<option value="${i}">${i}년</option>`;
      }
      yearEl.innerHTML = yearOpt;

      // 브라우저가 열리면 시도정보 얻기.
      sendRequest("sido", "*00000000");

      document.querySelector("#year").addEventListener("change", function () {
        let month = date.getMonth() + 1;
        let monthEl = document.querySelector("#month");
        let monthOpt = `<option value="">매매월선택</option>`;
        let yearSel = document.querySelector("#year");
        let m = yearSel[yearSel.selectedIndex].value == date.getFullYear() ? month : 13;
        for (let i = 1; i < m; i++) {
          monthOpt += `<option value="${i < 10 ? "0" + i : i}">${i}월</option>`;
        }
        monthEl.innerHTML = monthOpt;
      });
      
      document.querySelector("#sido").addEventListener("change", function () {
        if (this[this.selectedIndex].value) {
          let regcode = this[this.selectedIndex].value.substr(0, 2) + "*00000";
          sendRequest("gugun", regcode);
        } else {
          initOption("gugun");
          initOption("dong");
        }
      });

      // 구군이 바뀌면 동정보 얻기.
      document.querySelector("#gugun").addEventListener("change", function () {
        if (this[this.selectedIndex].value) {
          let regcode = this[this.selectedIndex].value.substr(0, 5) + "*";
          sendRequest("dong", regcode);
        } else {
          initOption("dong");
        }
      });

      function sendRequest(selid, regcode) {
        const url = "https://grpc-proxy-server-mkvo6j4wsq-du.a.run.app/v1/regcodes";
        let params = "regcode_pattern=" + regcode + "&is_ignore_zero=true";
        fetch(`${url}?${params}`)
          .then((response) => response.json())
          .then((data) => addOption(selid, data));
      }

      function addOption(selid, data) {
        let opt = ``;
        initOption(selid);
        switch (selid) {
          case "sido":
            opt += `<option value="">시도선택</option>`;
            data.regcodes.forEach(function (regcode) {
              opt += `
                <option value="${regcode.code}">${regcode.name}</option>
                `;
            });
            break;
          case "gugun":
            opt += `<option value="">구군선택</option>`;
            for (let i = 0; i < data.regcodes.length; i++) {
              if (i != data.regcodes.length - 1) {
                if (
                  data.regcodes[i].name.split(" ")[1] == data.regcodes[i + 1].name.split(" ")[1] &&
                  data.regcodes[i].name.split(" ").length !=
                    data.regcodes[i + 1].name.split(" ").length
                ) {
                  data.regcodes.splice(i, 1);
                  i--;
                }
              }
            }
            let name = "";
            data.regcodes.forEach(function (regcode) {
              if (regcode.name.split(" ").length == 2) name = regcode.name.split(" ")[1];
              else name = regcode.name.split(" ")[1] + " " + regcode.name.split(" ")[2];
              opt += `
                <option value="${regcode.code}">${name}</option>
                `;
            });
            break;
          case "dong":
            opt += `<option value="">동선택</option>`;
            let idx = 2;
            data.regcodes.forEach(function (regcode) {
              if (regcode.name.split(" ").length != 3) idx = 3;
              opt += `
                <option value="${regcode.code}">${regcode.name.split(" ")[idx]}</option>
                `;
            });
        }
        document.querySelector(`#${selid}`).innerHTML = opt;
      }

      function initOption(selid) {
        let options = document.querySelector(`#${selid}`);
        options.length = 0;
      }

      ///////////////////////// 아파트 매매 정보 /////////////////////////
      document.querySelector("#list-btn").addEventListener("click", function () {
        let url = 
          "http://openapi.molit.go.kr/OpenAPI_ToolInstallPackage/service/rest/RTMSOBJSvc/getRTMSDataSvcAptTradeDev";
        let gugunSel = document.querySelector("#gugun");
        let regCode = gugunSel[gugunSel.selectedIndex].value.substr(0, 5);
        let yearSel = document.querySelector("#year");
        let year = yearSel[yearSel.selectedIndex].value;
        let monthSel = document.querySelector("#month");
        let month = monthSel[monthSel.selectedIndex].value;
        let dealYM = year + month;
        let queryParams = encodeURIComponent("serviceKey") + "=" + serviceKey; /*Service Key*/
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
          .then((response) => {
            console.log(response)
            return response.text();
          })
          .then((data) => makeList(data));
      });
      
      function makeList(data) {
        document.querySelector("table").setAttribute("style", "display: ;");
        let tbody = document.querySelector("#aptlist");
        let parser = new DOMParser();
        const xml = parser.parseFromString(data, "application/xml");
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

      function initTable() {
        let tbody = document.querySelector("#aptlist");
        let len = tbody.rows.length;
        for (let i = len - 1; i >= 0; i--) {
          tbody.deleteRow(i);
        }
      }
    </script>
  </body>
</html>