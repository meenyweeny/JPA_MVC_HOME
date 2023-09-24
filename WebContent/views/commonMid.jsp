<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
    <link rel="stylesheet" href="css/common.css" />
    <link rel="stylesheet" href="css/index.css" />
</head>
<body>
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
        onclick="location.href=`apartTransaction.mvc`"
      />
                <input
        type="button"
        class="selectPositionButton"
        value="동별 실거래가 조회하러 가기 >"
        onclick="location.href='dongTransaction.mvc'"
      />
    </div>
</body>
</html>