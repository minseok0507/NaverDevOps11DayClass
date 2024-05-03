<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
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

        #showimg {
            position: absolute;
            top: 100px;
            left: 450px;
            width: 200px;
        }
    </style>

</head>
<body>
<div style="margin: 20px;width: 400px;">
    <form action="memoAction.jsp" method="post" enctype="multipart/form-data">
        <table class="table table-bordered">
            <caption align="top"><b>간단한 메모추가</b></caption>
            <tr>
                <th width="100" class="table-danger">제목</th>
                <td>
                    <label for="title"></label><input type="text" name="title" class="form-control" id="title"
                                                      required="required">
                </td>
            </tr>
            <tr>
                <th width="100" class="table-danger">사진업로드</th>
                <td>
                    <input type="file" name="upload"
                           onchange="preview(this)" style="width: 200px;">
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <label for="content"></label><textarea name="content" id="content" cols="30" rows="10" style="width: 100%; height: 100px;"
                                                           class="form-control" required></textarea>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <button class="btn btn-secondary">저장</button>
                </td>
            </tr>
        </table>
    </form>
    <img id="showimg" src=""><!-- 미리보기용 -->
</div>

<script type="text/javascript">
    function preview(tag) {
        //파일 업로드 미리보기 함수
        if (tag.files[0]) {
            let f = tag.files[0];

            if (!f.type.match("image.*")) {
                alert("이미지 파일만 가능합니다");
                return;
            }
            if (f) {
                let reader = new FileReader();
                reader.onload = function (e) {
                    $("#showimg").attr("src", e.target.result);
                }
                reader.readAsDataURL(tag.files[0]);
            }
        }
    }
</script>
</body>
</html>