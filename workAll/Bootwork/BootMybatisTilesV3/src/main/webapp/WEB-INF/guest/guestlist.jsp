<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
<link href="https://fonts.googleapis.com/css2?family=Caveat:wght@400..700&family=Dancing+Script:wght@400..700&family=East+Sea+Dokdo&family=Jua&family=Gaegu&family=Gamja+Flower&family=Pacifico&family=Single+Day&display=swap" rel="stylesheet">
   <script src="https://code.jquery.com/jquery-3.7.0.js"></script>
   <style>
       body *{
           font-family: 'Jua';
       }
   </style>
</head>
<body>
<c:if test="${sessionScope.myid != null}">
   <div class="guest-form-area" style="width: 400px;">
      <textarea name="gcontent" id="gcontent" cols="30" rows="10" style="width: 100%; height: 120px;" class="form-control"></textarea>
      <br>
      <input type="file" id="uploadFiles" name="uploadFiles" multiple required>
      <button class="btn btn-sm btn-info" id="btn-add-guest">등록</button>
   </div>
</c:if>
<div class="guest-list-area">
   방명록
</div>

<script>
   $(function (){
      $("#btn-add-guest").click(function (){
         let gcontent = $("#gcontent").val();
         if (gcontent === ''){
            alert("방명록 글을 작성 후 등록하시오")
            return;
         }
         let formData = new FormData();
         for (let i = 0; i < $("#uploadFiles")[0].files.length; i++) {
            formData.append("uploadFiles",$("#uploadFiles")[0].files[i]);

         }
         formData.append("gcontent", gcontent);
         console.log(formData)
         $.ajax({
            type:"post",
            dataType:"text",
            url:"/guest/addguest",
            data:formData,
            processData: false,
            contentType: false,
            success:function (){
               guest_list();
               $("#gcontent").val("");
               $("#uploadFiles").val("");
            }
         })
      })
   })


   function guest_list(){

   }
</script>
</body>
</html>
