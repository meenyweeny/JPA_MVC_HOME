<!DOCTYPE html>
<html lang="kr">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Home</title>
    <link rel="stylesheet" href="./css/common.css" />
    <link rel="stylesheet" href="./css/index.css" />
    <script></script>
  </head>
  <body>
    <ul class="navbar">
      <li class="nav-item"><a href="#">Login</a></li>
      <li class="nav-item"><a href="#">Sign Up</a></li>
    </ul>
    <br /><br />

    <header>
      <img src="./images/logo.png" alt="로고 이미지" width="150px" height="150px" />
      <input type="button" value="오늘의 뉴스" class="plainTextButton fontSize14" />
      <input type="button" value="공지사항" class="plainTextButton fontSize14" />
    </header>

    <br /><br />

    <div class="centerContainer">
      <div class="headerTitle">구해줘HOME!!</div>
      <div class="headerGradientLine"></div>
      <div class="headerCaption">우리를 위한 집</div>
    </div>

    <div class="selectPosition flexRowCenter">
      <input
        type="button"
        class="selectPositionButton"
        value="아파트 실거래가 조회하러 가기 >"
        onclick="location.href=`./apartTransaction.html`"
      />
    </div>

    <br /><br /><br /><br />

    <div class="flexRowAround">
      <div class="flexRowCenter">
        <img src="./images/2.jpg" width="150px" height="100px" />
        <div class="flexColumnCenter">
          <h3>지혜롭게 내 집 마련하기</h3>
          <input
            type="button"
            value="가용자금 확인 및 대출 계획"
            class="plainTextButton fontSize10"
          />
          <input type="button" value="집 종류 및 지역 선택" class="plainTextButton fontSize10" />
          <input type="button" value="정보 수집 & 시세 파악" class="plainTextButton fontSize10" />
          <input type="button" value="부동산 방문 & 집구경" class="plainTextButton fontSize10" />
          <input type="button" value="계약 및 잔금 치르기" class="plainTextButton fontSize10" />
          <input type="button" value="소유권 이전동기" class="plainTextButton fontSize10" />
          <input type="button" value="인테리어 공사" class="plainTextButton fontSize10" />
        </div>
      </div>
      <div class="flexColumnCenter">
        <h3>부동산 뉴스</h3>
        <h5>서울 아파트, 매매 전세 다른 양상..상승..아시아경제</h5>
        <a href="https://www.naver.com">어쩌구</a>
        <a href="https://www.daum.net">저쩌구</a>
        <a href="https://edu.ssafy.com/">어쩔티비</a>
        <a href="https://job.ssafy.com/">어쩔티비</a>
        <a href="https://edu.ssafy.com/">어쩔티비</a>
        <a href="https://job.ssafy.com/">어쩔티비</a>
      </div>
    </div>

    <br /><br /><br /><br />
    <!-- <footer>
      <div>
        <img src="./images/5.jpg" height="140px" />
      </div>
    </footer> -->
  </body>
</html>
