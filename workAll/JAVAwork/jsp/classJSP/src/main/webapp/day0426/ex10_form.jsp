<%--
  Created by IntelliJ IDEA.
  User: minseok
  Date: 24. 4. 26.
  Time: 오후 3:50
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
<body>
<h5>폼태그 읽기</h5>
<form action="ex10_action.jsp" method="post">
    <table class="table table-bordered" style="width: 400px">
        <tr>
            <th class="table-info" width="100">메뉴명</th>
            <td>
                <input type="text" name="menu" class="form-control" required autofocus="autofocus">
            </td>
        </tr>
        <tr>
            <th class="table-info" width="100">음식사진</th>
            <td>
                <select class="food" name="food" id="food" style="height: 50px;">
                    <option value="../img/food/1.jpg,3000">샌드위치</option>
                    <option value="../img/food/2.jpg,6000">닭꼬치</option>
                    <option value="../img/food/3.jpg,3500">라면</option>
                    <option value="../img/food/4.jpg,13000">고기</option>
                    <option value="../img/food/5.jpg,5000">콘치즈</option>
                </select>
                <img src="../img/food/1.jpg" id="foodImg" name="foodImg" width="50">
                <span id="price" name="price">3000</span>원
            </td>
        </tr>
        <tr>
            <th class="table-info" width="100">만족도</th>
            <td>
                <label>
                    <input type="radio" name="grade" value="매우만족" checked>매우만족
                </label>
                <label>
                    <input type="radio" name="grade" value="만족">만족
                </label>
                <label>
                    <input type="radio" name="grade" value="보통">보통
                </label>
                <label>
                    <input type="radio" name="grade" value="불만">블만
                </label>
            </td>
        </tr>
        <tr>
            <th class="table-info" width="100">우수회원</th>
            <td>
                <label>
                    <input type="checkbox" name="member">우수회원
                </label>
            </td>
        </tr>

        <tr>
            <td colspan="2" align="center">
                <button class="btn btn-outline-success">전송</button>
            </td>
        </tr>
    </table>
</form>

<script>
    document.getElementById("food").addEventListener("change", (event) => {
        let arr = [];
        const result = event.target.value;
        arr = result.split(",");
        document.getElementById("foodImg").setAttribute("src",arr[0]);
        document.getElementById("price").innerText = arr[1];
    })

</script>
</body>
</html>
