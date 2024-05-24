<%--
  Created by IntelliJ IDEA.
  User: minseok
  Date: 24. 5. 22.
  Time: 오후 1:49
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

        .id_ok {
            color: #008000;
            display: none;
        }

        .id_already {
            color: #ff2929;
            display: none;
        }
    </style>
    <title>Title</title>
    <script>
        let duplication = false;
    </script>
</head>
<body>
<form action="/member/insert" method="post" onsubmit="form()" enctype="multipart/form-data">
    <table class="table table-bordered" style="width: 400px;">
        <caption align="top">
            <h3><b>회원 가입</b></h3>
        </caption>
        <tr>
            <th width="100" class="table-info">이름</th>
            <td colspan="2">
                <input type="text" name="name" id="name" class="form-control"
                       required="required">
            </td>
        </tr>
        <tr>
            <th width="100" class="table-info">아이디</th>
            <td colspan="2">
                <div class="input-group">
                    <input type="text" name="myid" id="myid" class="form-control"
                           required="required">
                    &nbsp;
                    <button type="button" class="btn btn-sm btn-danger"
                            id="id-check">중복확인
                    </button>
                </div>
                <span class="id_ok">사용 가능한 아이디입니다.</span>
                <span class="id_already">누군가 이 아이디를 사용하고 있어요.</span>

            </td>
        </tr>
        <tr>
            <th width="100" class="table-info">사진</th>
            <td width="200">
                <input type="file" name="photofile" id="photofile" class="form-control"
                       required="required" onchange="preview(this)">
            </td>
            <td rowspan="2">
                <img src="" id="showimg1" style="width: 100%;">
            </td>
        </tr>
        <tr>
            <th width="100" class="table-info">비밀번호</th>
            <td width="200">
                <input type="password" name="passwd" id="passwd" class="form-control"
                       required="required" maxlength="8">
            </td>
        </tr>
        <tr>
            <th width="100" class="table-info">핸드폰</th>
            <td width="200" colspan="2">
                <input type="tel" name="hp" id="hp" class="form-control"
                       required="required" pattern="[0-9]{3}-[0-9]{4}-[0-9]{4}"
                       placeholder="xxx-xxxx-xxxx">
            </td>
        </tr>
        <tr>
            <th width="100" class="table-info">이메일</th>
            <td width="200" colspan="2">
                <input type="email" name="email" id="email" class="form-control"
                       required="required">
            </td>
        </tr>
        <tr>
            <th width="100" class="table-info">주소</th>
            <td width="200" colspan="2">
                <input type="text" name="addr" id="addr" class="form-control"
                       required="required">
            </td>
        </tr>
        <tr>
            <th width="100" class="table-info">생년월일</th>
            <td width="200" colspan="2">
                <input type="date" name="birthday" id="birthday" class="form-control"
                       value="2024-01-01">
            </td>
        </tr>
        <tr>
            <td colspan="3" align="center">
                <button type="submit" class="btn btn-outline-danger"
                        style="width: 100px;">회원가입
                </button>

                <button type="reset" class="btn btn-outline-danger"
                        style="width: 100px;">초기화
                </button>

            </td>
        </tr>
    </table>
</form>
<script>
    function preview(tag) {
        if (tag.files[0]) {
            let f = tag.files[0];

            if (!f.type.match("image.*")) {
                alert("이미지 파일만 가능합니다");
                tag.value = "";
                return;
            }
            if (f) {
                let reader = new FileReader();
                reader.onload = function (e) {
                    $("#showimg1").attr("src", e.target.result);
                }
                reader.readAsDataURL(tag.files[0]);
            }
        }
    }

    function checkId() {
        var myid = $('#myid').val(); //id값이 "id"인 입력란의 값을 저장
        $.ajax({
            url: './idCheck', //Controller에서 요청 받을 주소
            type: 'post', //POST 방식으로 전달
            data: {myid: myid},
            success: function (cnt) { //컨트롤러에서 넘어온 cnt값을 받는다
                if (cnt == 0) { //cnt가 1이 아니면(=0일 경우) -> 사용 가능한 아이디
                    $('.id_ok').css("display", "inline-block");
                    $('.id_already').css("display", "none");
                    document.getElementById("myid").readOnly = true;
                    duplication = true;
                } else { // cnt가 1일 경우 -> 이미 존재하는 아이디
                    $('.id_already').css("display", "inline-block");
                    $('.id_ok').css("display", "none");
                    alert("아이디 중복!");
                    $('#myid').val('').focus();
                }
            },
            error: function () {
                alert("에러입니다");
            }
        });
    };
    $("#id-check").on("click", function () {
        var myid = $('#myid').val(); //id값이 "id"인 입력란의 값을 저장
        if (myid.length < 8) {
            alert("8자 이상 작성하십시오.")
            $('#myid').focus();
        } else {
            checkId();
        }
    })

    function form() {
        if (duplication) {
        } else {
            alert("중복 체크!")
            event.preventDefault();
        }
    }
</script>
</body>
</html>
