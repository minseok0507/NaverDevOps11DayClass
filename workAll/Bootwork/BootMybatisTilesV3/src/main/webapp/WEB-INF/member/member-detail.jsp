<%--
  Created by IntelliJ IDEA.
  User: minseok
  Date: 24. 5. 24.
  Time: 오후 3:15
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

        .detail-table {
            display: flex;
            justify-content: center;
        }
    </style>
    <title>Title</title>
</head>
<body>
<div class="detail-table">
    <table class="table" style="width: 500px;margin: 20px;">
        <caption align="top">
            <h2><b>${member.name} 회원님의 정보확인</b></h2>
        </caption>
        <tr>
            <td width="200">
                <img src="/upload-img/${member.photo}" alt="" id="photo" name="photo" class="rounded-circle"
                     style="width: 150px; border: 1px solid black;">
                <br><br>
                <label for="photofile" class="btn btn-success btn-sm" id="photo-modify">사진수정</label>
                <input type="file" id="photofile" style="display: none">
            </td>
            <td>
                아이디 : ${member.myid}<br>
                핸드폰 : ${member.hp}<br>
                email : ${member.email}<br>
                생 일 : ${member.birthday}<br>
                가입일 : ${member.registday}<br>
            </td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <button type="button" class="btn btn-sm btn-outline-secondary" style="width: 80px;"
                        onclick="location.href='./list'">목록
                </button>
                <button type="button" class="btn btn-sm btn-outline-info" style="width: 80px;"
                        onclick="location.href='./update?num=${member.num}'">수정
                </button>
                <button type="button" class="btn btn-sm btn-outline-danger" style="width: 80px;"
                        onclick="deleteButton()">삭제
                </button>
            </td>
        </tr>
<%--        <tr>--%>
<%--            <td colspan="2" align="center">--%>
<%--                <textarea name="commentText" id="commentText" cols="30" rows="3" required></textarea>--%>
<%--                <input type="text" name="commentUser" id="commentUser" required>--%>
<%--                <button type="button" id="comment-button">댓글</button>--%>
<%--            </td>--%>
<%--        </tr>--%>
    </table>
</div>


<script>
    document.getElementById("photofile").addEventListener("change", function () {
        // 파일 입력 필드 값 가져오기
        const fileInput = document.getElementById("photofile");
        const file = fileInput.files[0];
        let num = ${member.num};
        // FormData 객체 생성
        const formData = new FormData();
        formData.append("photofile", file);
        formData.append("num", num); // 필요한 num 값 추가

        // fetch를 이용한 POST 요청 보내기
        fetch("/member/photoupdate", {
            method: "POST",
            body: formData
        })
            .then(response => response.text())
            .then(result => {
                $("#photo").attr("src", "/upload-img/" + result);
            })
            .catch(error => {
                console.error("사진 업데이트 중 오류 발생:", error);
            });
    });


    function deleteButton() {
        if (confirm(`${member.name}의 정보를 삭제하시겠습니까?`)) {
            location.href=`/member/delete?num=${member.num}`;
        }
    }


</script>
</body>
</html>
