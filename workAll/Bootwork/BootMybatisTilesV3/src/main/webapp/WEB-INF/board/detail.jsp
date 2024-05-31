<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: minseok
  Date: 24. 5. 28.
  Time: 오전 11:50
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

        .profile {
            width: 30px;
            border-radius: 50%;
            float: left;
        }

        .detail-comment-container {
            margin: 20px 0;
        }

        .comment {
            border-bottom: 1px solid gray;
            padding: 10px;
            position: relative;
            /*background-color: lightblue;*/
        }

        .comment_inbox_text {
            border: none;
            width: 100%;
            height: 30px;
            margin-top: 5px;
        }

        .comment-img {
            width: 40px;
            float: left;
            margin-right: 10px;
        }

        .comment-img img {
            width: 40px;
            border-radius: 50%;
        }
    </style>
    <title>Title</title>
</head>
<body>
<div>
    <h1>${board.boardTitle}</h1>
    <div><img src="/upload-img/${profile_photo}" class="profile"></div>
    ${board.writeUser} <br>
    ${board.boardDate} 조회 ${board.viewCount}
    <div style="float: right">
        댓글 <span id="comment-count"></span>
    </div>
    <div style="margin: 30px;">
        ${board.boardContent}
    </div>
</div>
<div class="detail-comment-container">
    <h5>댓글</h5>
    <c:if test="${sessionScope.myid != null}">
        <div style="padding: 15px; border: 3px solid #d8d8d8; border-radius: 4px;margin-bottom: 20px">
            <em data-v-afadf0bc="" class="comment_inbox_name">${sessionScope.myid}</em><br>
            <textarea placeholder="댓글을 남겨보세요" id="comment_textarea" class="comment_inbox_text"
                      style="overflow: hidden; overflow-wrap: break-word;"></textarea>
            <button style="border: none; padding: 5px 10px; background-color: white;"
                    onclick="checkComment()"
            >전송
            </button>
        </div>
    </c:if>

    <div id="comments">


    </div>

</div>
<div>
    <c:if test="${sessionScope.myid != null}">
        <button class="btn btn-sm btn-secondary"
                onclick="location.href='/board/write'"
        >글쓰기
        </button>
        <button class="btn btn-sm btn-secondary"
                onclick="location.href='/board/reply?id=${board.id}'"
        >답글
        </button>
    </c:if>
    <c:if test="${sessionScope.myid == board.writeUser}">
        <button class="btn btn-sm btn-info"
                onclick="location.href='/board/update?id=${board.id}'" style="color: white"
        >수정
        </button>
        <button class="btn btn-sm btn-danger"
                onclick="deleteBoard()"
        >삭제
        </button>
    </c:if>
    <button class="btn btn-sm btn-secondary"
            onclick="location.href='/board/list'"
    >목록
    </button>
</div>

<script>
    requestComment();

    function deleteBoard() {
        if (confirm("이 글을 삭제하시겠습니끼?")) {

        }
    }

    function checkComment() {
        const commentTextarea = document.getElementById('comment_textarea');
        const commentText = commentTextarea.value.trim();
        if (commentText.length === 0) {
            alert('댓글 내용을 입력해주세요.');
            return;
        }
        postComment(commentText);
    }

    function postComment(commentText) {

        const commentData = {
            boardId: ${board.id},
            commentText: commentText,
            commentUser: "${sessionScope.myid}"
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
                    console.log('댓글 작성 성공');
                    let commentTextarea = document.getElementById('comment_textarea');
                    commentTextarea.value = '';
                    requestComment();
                } else {
                    // 댓글 등록 실패 처리
                    console.error('댓글 등록 중 오류가 발생했습니다:', result.message);
                }
            })
            .catch(error => {
                console.error('댓글 등록 중 오류가 발생했습니다:', error);
            });
    }

    function requestComment() {
        return fetch(`/comment/get?boardId=${board.id}`)
            .then(response => {
                if (!response.ok) {
                    throw new Error(`HTTP error ${response.status}`);
                }
                return response.json();
            })
            .then(comments => {
                // 받은 댓글 데이터를 화면에 표시하는 등의 로직 추가
                displayComments(comments);
            })

    }

    function displayComments(comments) {
        let count = 0;
        // 받은 댓글 데이터를 화면에 표시하는 로직 작성
        let s = "";
        comments.forEach(comment => {
            count++;
            // 댓글 정보를 사용하여 HTML 요소 구성
            s +=
                `
                <div class="comment">
                    <%-- <div class="comment-img"> --%>
                    <%-- <img src="/upload-img/" alt="">--%>
                    <%--</div>--%>
                    <b style="display: block; font-weight: bolder; font-size: 1.2em">\${comment.commentUser}</b>
                    <div class="comment-content" style="clear: both;">
                    \${comment.commentText}
                    </div>
                    <span style="font-size: 0.8em; margin-top: 10px; display: block">\${comment.commentDate}</span>
                `;
            let CommentUser = `\${comment.commentUser}`;
            let ClientUser = "${sessionScope.myid}";
            console.log(CommentUser);
            if(CommentUser === ClientUser){
                s += `<div style="position: absolute; top: 10px; right: 0"><button class="btn btn-sm btn-outline-danger onclick="deleteComment()" >삭제</button></div>`;
            }
            s+= "</div>";
        });
        let commentContainer = document.getElementById("comments");
        commentContainer.innerHTML = s;
        let commentCount = document.getElementById("comment-count");
        commentCount.innerText = count;
    }

    function deleteComment(){
        alert();
    }
</script>
</body>
</html>
