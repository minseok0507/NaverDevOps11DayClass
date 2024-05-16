<%--
  Created by IntelliJ IDEA.
  User: minseok
  Date: 24. 5. 7.
  Time: 오전 9:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
    <link href="https://fonts.googleapis.com/css2?family=Caveat:wght@400..700&family=Dancing+Script:wght@400..700&family=East+Sea+Dokdo&family=Jua&family=Gaegu&family=Gamja+Flower&family=Pacifico&family=Single+Day&display=swap"
          rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.7.0.js"></script>
    <style>
        body * {
            font-family: 'Jua';
        }
    </style>
    <title>Title</title>
</head>
<%
    boolean findPass = false;
    Cookie[] cookies = request.getCookies();
    if (cookies != null && cookies.length > 0) {
        for (Cookie cookie : cookies) {
            String name = cookie.getName();
            if (name.equals("pass")) {
                findPass = true;
                break;
            }
        }
    }
%>
<body>
<%
    if (findPass) {%>
<pre>
    바이에른 뮌헨은 새 감독을 알아봐야 한다.

영국 '디 애슬래틱'의 데이비드 온스테인 기자는 6일(한국시간) "데이비드 모예스 감독 후임은 로페테기 감독이다. 계약 조건에 합의가 됐다. 선임을 눈앞에 두고 있다. 웨스트햄 기술 디렉터 팀 스타이덴은 모예스 감독 후임으로 여러 타깃을 정했고 로페테기 감독이 낙점됐다. 로페테기 감독은 울버햄튼을 떠난 뒤 프리미어리그, 라리가, 사우디아라비아, 뮌헨 등에서 제안을 받았지만 거절했다. 로페테기 감독 시선은 웨스트햄으로 향해 있다"고 전했다.

로페테기 감독은 선수 시절 레알 마드리드, 바르셀로나를 오간 골키퍼였다. 라요 바예카노에서 맹활약을 하다 은퇴했고 라요에서 감독을 맡으면서 감독 생활을 시작했다. 레알 카스티야를 지도하다가 스페인 연령별 대표팀을 연이어 맡으면서 입지를 쌓아갔다.

포르투에서 인상을 남긴 뒤 스페인 A대표팀 감독이 됐다. 스페인 감독을 맡다가 레알과 사전계약을 했는데 이로 인해 계약이 조기 종료됐고 2018 국제축구연맹(FIFA) 러시아 월드컵을 치르지 못했다. 레알에서 1시즌도 버티지 못하고 경질됐다. 이후 세비야로 갔는데 유럽축구연맹(UEFA) 유로파리그(UEL)에서 우승을 하면서 부활에 성공했다.
</pre>
<%
} else {
%>
<script>
    alert("암호를 입력하시오")
    history.back();
</script>
<%
    }
%>
</body>
</html>
