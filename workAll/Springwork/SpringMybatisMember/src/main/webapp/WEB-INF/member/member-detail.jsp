<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: minseok
  Date: 24. 5. 21.
  Time: 오후 5:32
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
<h1>member detail</h1>
<div>
    <table class="table" style="width: 500px;margin: 20px;">
        <caption align="top">
            <h2><b>${member.name} 회원님의 정보확인</b></h2>
        </caption>
        <tr>
            <td width="200">
                <img src="/img/${member.photo}" alt="" id="photo" name="photo" class="rounded-circle"
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
        <tr>
            <td colspan="2" align="center">
                <textarea name="commentText" id="commentText" cols="30" rows="3" required></textarea>
                <input type="text" name="commentUser" id="commentUser" required>
                <button type="button" id="comment-button">댓글</button>
            </td>
        </tr>
    </table>
</div>
<div id="reload">
    <table>
        <c:forEach items="${comments}" var="comment" varStatus="i">
            <tr>
                <td>${i.count}</td>
                <td>${comment.commentText}</td>
                <td>${comment.commentUser}</td>
                <td>${comment.commentDate}</td>
            </tr>
        </c:forEach>
    </table>
</div>

<script>
    fetchComments()

    function fetchComments() {
        return fetch(`/comment/post?num=${member.num}`)
            .then(response => {
                if (!response.ok) {
                    throw new Error(`HTTP error ${response.status}`);
                }
                return response.json();
            })
            .then(comments => {
                let s = '<table>';
                comments.forEach((comment, i) => {
                    s += `
                        <tr>
                          <td>\${i+1}</td>
                          <td>\${comment.commentText}</td>
                          <td>\${comment.commentUser}</td>
                          <td>\${Unix_timestamp(comment.commentDate)}</td>
                        </tr>
                      `;
                });
                s += '</table>';
                document.getElementById("reload").innerHTML = s;
                return comments;
            })
            .catch(error => {
                console.error('Error fetching comments:', error);
                throw error;
            });
    }


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
        fetch("./photoupdate", {
            method: "POST",
            body: formData
        })
            .then(response => response.text())
            .then(result => {
                $("#photo").attr("src", "/img/" + result);
            })
            .catch(error => {
                console.error("사진 업데이트 중 오류 발생:", error);
            });
    });

    document.getElementById("comment-button").addEventListener("click", function () {
        let commentText = document.getElementById("commentText").value;
        let commentUser = document.getElementById("commentUser").value;

        if (commentText.length < 5) {
            alert("댓글을 5글자 이상 쓰시오")
            return
        } else if (commentUser.length < 3) {
            alert("이름 3글자 이상 쓰시오")
            return;
        }

        const commentData = {
            memberNum: ${member.num},
            commentText: commentText,
            commentUser: commentUser
        };
        fetch('/comment/insert', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(commentData)
        })
            .then(response => response.json())
            .then(result => {
                if (result.status === 'success') {
                    // 댓글 등록 성공 처리
                    console.log('댓글이 등록되었습니다.');
                    document.getElementById("commentText").value = "";
                    document.getElementById("commentUser").value = "";
                    fetchComments()
                } else {
                    // 댓글 등록 실패 처리
                    console.error('댓글 등록 중 오류가 발생했습니다:', result.message);
                }
            })
            .catch(error => {
                console.error('댓글 등록 중 오류가 발생했습니다:', error);
            });


    })

    function Unix_timestamp(t){
        var date = new Date(t);
        var year = date.getFullYear();
        var month = "0" + (date.getMonth()+1);
        var day = "0" + date.getDate();
        var hour = "0" + date.getHours();
        var minute = "0" + date.getMinutes();
        var second = "0" + date.getSeconds();
        return year + "-" + month.substr(-2) + "-" + day.substr(-2) + " " + hour.substr(-2) + ":" + minute.substr(-2) + ":" + second.substr(-2);
    }

</script>
</body>
</html>
