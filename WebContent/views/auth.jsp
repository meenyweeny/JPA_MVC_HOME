<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.*, java.io.*" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" />
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"></script>
    <style>
      .red{
        color: red;
      }

      .m10{
        margin-top: 10px;
      }
      .m5{
        margin-top: 5px;
      }
      .m16{
        margin-top: 16px;
      }

      .txtr{
        width: 100px;
        text-align: right;
      }

      .bgc{
        background-color: rgb(95, 92, 92);
      }
      .cw{
        color: white;
      }

    </style>
</head>

<body>
    <div class="container">
      <div class="row">
        <div class="col-3"></div>
        <div class="col-6 card">
            <div class="row">
            <h5 class="card-title m10">회원가입</h5>
              <div class="card-body col-3 txtr">
                <div>아이디<span class="red">*</span></div>
                <div class="m16">비밀번호<span class="red">*</span></div>
                <div class="m16">이름<span class="red">*</span></div>
                <div class="m16">주소<span class="red">*</span></div>
                <div class="m16">전화번호<span class="red">*</span></div>
              </div>
              <div class="card-body col-7">
                <div> <input type="text" class="col-10" name="id" id="id"></span></div>
                <div class="m10"> <input type="text" class="col-10" name="id" id="id"></span></div>
                <div class="m10"> <input type="text" class="col-10" name="id" id="id"></span></div>
                <div class="m10"> <input type="text" class="col-10" name="id" id="id"></span></div>
                <div class="m10"> <input type="text" class="col-10" name="id" id="id"></span></div>
                <a href="#" class="btn btn-warning m10">등록</a>
              </div>
            </div>
        </div>
        <div class="col-1"></div>
        <div class="col-2">
          <div class="card bgc">
            <div class="row">
              <div class="card-body">
                <br>
                <div class="cw">아이디</div>
                <div> <input type="text" class="col-12 m10" name="id" id="id"></span></div>
                <div class="cw">비밀번호</div>
                <div> <input type="text" class="col-12 m10" name="id" id="id"></span></div>
                <span><a href="#" class="btn btn-light m10"> 로그인 </a> </span>
                <span><a href="#" class="btn btn-dark m10">비밀번호 찾기</a> </span>
              </div>  
            </div>
          </div>
        </div>
      </div>
    </div>

  </div>
</body>

</html>