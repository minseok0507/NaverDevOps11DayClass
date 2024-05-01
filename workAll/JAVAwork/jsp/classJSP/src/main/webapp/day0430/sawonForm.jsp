<%--
  Created by IntelliJ IDEA.
  User: minseok
  Date: 24. 4. 30.
  Time: 오전 11:35
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
<%--    <script src="https://code.jquery.com/jquery-3.7.0.js"></script>--%>
    <style>
        body * {
            font-family: 'Jua';
        }
    </style>
    <title>Title</title>
</head>
<body>

<div style="margin: 20px; width: 400px;">
    <form action="sawonActionInsert.jsp" method="post">
        <table class="table table-bordered">
            <caption align="top"><h5 class="alert alert-warning">사원정보입력</h5></caption>

            <tr>
                <th width="100" class="table-danger">사원명</th>
                <td>
                    <input type="text" name="name" class="form-control" required autofocus>
                </td>
            </tr>

            <tr>
                <th width="100" class="table-danger">부서명</th>
                <td>
                    <select name="buseo" id="buseo">
                        <option value="교육부">교육부</option>
                        <option value="인사부">인사부</option>
                        <option value="홍보부">홍보부</option>
                        <option value="해외파견부">해외파견부</option>
                    </select>
                </td>
            </tr>

            <tr>
                <th width="100" class="table-danger">나이</th>
                <td>
                    <input type="number" name="age" class="form-control" required>
                </td>
            </tr>

            <tr>
                <th width="100" class="table-danger">주소</th>
                <td>
                    <input type="text" name="addr" class="form-control" required>
                </td>
            </tr>

            <tr>
                <th width="100" class="table-danger">성별</th>
                <td>
                    <label><input type="radio" name="gender" value="남자" checked> 남자</label>
                    <label><input type="radio" name="gender" value="여자"> 여자</label>
                </td>
            </tr>

            <tr>
                <th width="100" class="table-danger">생년월일</th>
                <td>
                    <input type="date" name="birthday" class="form-control" required>
                </td>
            </tr>

            <tr>
                <th width="100" class="table-danger">프로필 사진</th>
                <td>
                    <select name="photo" id="photo" class="form-select">
                        <option value="">프로필사진없음</option>
                        <option value="../img/star/17.jpg">사진 1</option>
                        <option value="../img/star/18.jpg">사진 2</option>
                        <option value="../img/star/19.jpg">사진 3</option>
                        <option value="../img/star/20.jpg">사진 4</option>
                    </select>
                    <img src="https://cdn-icons-png.flaticon.com/512/6522/6522516.png" alt="" width="150px" class="photo">
                </td>
            </tr>



            <tr>
                <td colspan="2" align="center">
                    <button class="btn btn-outline-secondary btn-sm" style="width: 80px">
                        전송
                    </button>

                    <button class="btn btn-outline-secondary btn-sm" style="width: 80px"
                            onclick="location.href='sawonList.jsp'">
                        사원목록
                    </button>
                </td>
            </tr>
        </table>
    </form>
</div>

<script>
    var selPhoto = document.getElementById("photo");
    var img = document.getElementsByClassName("photo")[0];
    selPhoto.addEventListener("change",function (){
        img.setAttribute("src", this.selectedOptions[0].value);
    })
</script>

</body>
</html>
