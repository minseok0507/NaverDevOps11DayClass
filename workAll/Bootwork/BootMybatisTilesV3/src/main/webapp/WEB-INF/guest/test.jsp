<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: minseok
  Date: 24. 5. 30.
  Time: 오후 5:15
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
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/quill@2.0.2/dist/quill.bubble.css"/>

    <script src="https://cdn.jsdelivr.net/npm/quill@2.0.2/dist/quill.js"></script>
    <style>
        body * {
            font-family: 'Jua';
        }
    </style>
    <title>Title</title>
</head>
<body>
<!-- HTML -->
<div>
    <form id="contentForm" method="post" action="<c:url value="/save-content"/>">
        <div id="editor"></div>
        <textarea name="content" style="display: none;"></textarea>
        <button type="button">Save</button>
    </form>
</div>
<script>
    // JavaScript
    const quill = new Quill('#editor', {
        modules: {
            toolbar: [
                ['bold', 'italic'],
                ['link', 'blockquote', 'code-block', 'image'],
                [{list: 'ordered'}, {list: 'bullet'}],
            ],
        },
        theme: 'snow',
    });


    var form = document.getElementById('contentForm');
    form.addEventListener('click', function () {
        var contentInput = form.querySelector('textarea[name="content"]');
        contentInput.value = quill.root.innerHTML;
        console.log(contentInput.value);
    });
</script>

</body>
</html>
