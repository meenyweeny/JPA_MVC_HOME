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
      <div class="headerTitle">������HOME!!</div>
      <div class="headerGradientLine"></div>
      <div class="headerCaption">�츮�� ���� ��</div>
    </div>

    <div class="selectPosition flexRowCenter">
      <input
        type="button"
        class="selectPositionButton"
        value="����Ʈ �ǰŷ��� ��ȸ�Ϸ� ���� >"
        onclick="location.href=`apartTransaction.mvc`"
      />
                <input
        type="button"
        class="selectPositionButton"
        value="���� �ǰŷ��� ��ȸ�Ϸ� ���� >"
        onclick="location.href='dongTransaction.mvc'"
      />
    </div>
</body>
</html>