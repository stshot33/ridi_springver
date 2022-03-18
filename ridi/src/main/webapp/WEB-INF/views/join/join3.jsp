<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
  <head>
    <meta charset="UTF-8" />
    <title>insert page title</title>
    <link rel="stylesheet" href="/ridi/resources/css/join/join3.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css" integrity="sha384-DyZ88mC6Up2uqS4h/KRgHuoeGwBcD4Ng9SiP4dIRy0EXTlnuz47vAwmeGwVChigm" crossorigin="anonymous"/>
  </head>
  <body>
    <div class="container">
      <header>
        <h3><a href="index.html">RIDIBOOKS</a></h3>
      </header>
      <section>
        <h4>만 14세 미만 회원가입</h4>
        <img src="../images/14세 미만.webp"/>
        <div>
          <input type="checkbox" name="" id="" />
          <span>법정 대리인(보호자)로서 피보호자의 리디북스 회원가입에<br>동의합니다.</span>
        </div>
      </section>
      <div class="center">
        <button class="phoneConfirm btn" type="button" onclick="location.href='join2'">휴대폰 인증</button>
        <button class="cancel btn" type="button" onclick="location.href='join1'">취소</button>
      </div>
      <div class="center">
        <p>개인정보보호법 제39조의3</p>
        <p>(개인정보의 수집 · 이용 동의 등에 대한 특례)</p>
        <p>만 14세 미만 어린이는</p>
        <p>법정대리인의 동의와 법정대리인(보호자)의 본인인증 후</p>
        <p>회원가입이 가능합니다.</p>
      </div>
    </div>
  </body>
</html>
