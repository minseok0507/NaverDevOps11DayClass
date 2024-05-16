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
    대통령실은 6일 일본 정부가 네이버에 '라인야후' 자본관계 재검토를 주문한 것에 대해 “한일관계는 고려사항이 아니다. 우리 기업인 네이버를 지원하는 데 최우선적으로 초점을 맞추고 있다”고 밝혔다. 대통령실은 그동안 관련 사안에 대해 직접적인 입장을 밝히지 않았었다.

대통령실 고위관계자는 이날 전자신문과의 통화에서 “정부는 네이버와 긴밀하게 협의하면서 (네이버가) 필요로 하는 조치를 지원하고 있다. 네이버가 원하는 방향으로 지원한다는 것이 정부의 일관된 입장”이라고 말했다.

일본 총무성은 개인정보 유출을 빌미로 사실상 라인야후 지분 구조 변경을 압박하고 있다. 라인야후는 네이버와 일본 소프트뱅크가 50%씩 지분을 갖고 있다. 두 회사 중 한 곳이라도 지분이 변경되면 경영권은 넘어간다.

총무성은 지난달 16일 라인야후 상대로 두 번째 행정지도를 하고 네이버클라우드와의 네트워크 분리를 빠르게 완료할 것을 주문했다. 라인야후는 네이버클라우드가 작년 11월 해킹당하면서 글로벌메신저이자 일본의 국민 메신저앱인 '라인' 앱 이용자와 거래처, 네이버 직원 등의 개인정보 51만건이 유출됐을 가능성이 있다고 밝힌 바 있다. 라인야후 서버는 일본에 있지만 네이버 클라우드를 통해 관리된다.

이 관계자는 “정부는 네이버가 지분을 매각하지 않고 일본 정부가 원하는 기술적인 조치를 하겠다고 결정하면 이를 지원할 것이며, 지분을 매각하는 것을 원한다면 정당한 값을 받고 더 나은 비즈니스를 할 수 있도록 할 것”이라고 말했다.

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
