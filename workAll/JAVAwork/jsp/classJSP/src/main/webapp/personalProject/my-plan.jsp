<%@ page import="java.util.Date" %>
<%@ page import="com.example.classjsp.data.dao.EventDao" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.classjsp.data.dto.EventDto" %><%--
  Created by IntelliJ IDEA.
  User: minseok
  Date: 24. 5. 2.
  Time: 오전 9:37
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
    <link rel="stylesheet"
          href="https://fonts.googleapis.com/css2?family=Material+Icons+Outlined:wght@400;500;600;700&display=swap">
    <script src="https://code.jquery.com/jquery-3.7.0.js"></script>
    <link rel="stylesheet" href="main.css?asd">
    <link rel="icon" href="icon/outline_calendar_month_black_24dp.png">
    <title>Calender</title>
    <%
        String getParamYear = request.getParameter("year");
        String getParamMonth = request.getParameter("month");
        String getParamDay = request.getParameter("day");

        Date toDate = new Date();
        int year = 0;
        int month = 0;
        int day = 0;

        if (getParamYear == null) {
            year = toDate.getYear() + 1900;
        } else {
            year = Integer.parseInt(getParamYear);
        }

        if (getParamMonth == null) {
            month = toDate.getMonth() + 1;
        } else {
            month = Integer.parseInt(getParamMonth);
        }

        if (getParamDay == null) {
            day = toDate.getDay();
        } else {
            day = Integer.parseInt(getParamDay);
        }

        if (year < 1900 || month < 1 || day < 1) {
            year = toDate.getYear() + 1900;
            month = toDate.getMonth() + 1;
            day = toDate.getDay();
        }

        String formetMonth = String.format("%02d", month);
        String yearMonth = year + "-" + formetMonth;
        EventDao eventDao = new EventDao();

        List<EventDto> events = eventDao.getEventsByYearMonth(yearMonth);

    %>
</head>
<body>
<input type="hidden" name="year" id="year" style="display: none;" value="<%=year%>">
<input type="hidden" name="month" id="month" style="display: none;" value="<%=month%>">
<input type="hidden" name="day" id="day" style="display: none;" value="<%=day%>">
<div class="main-container">
    <div class="top">
        <div class="logo">
            <a href="main.jsp">
                <span><i class="material-icons-outlined" style="margin-right: 5px">calendar_month</i> 캘린더</span>
            </a>
        </div>
        <div class="top-control">
            <button class="d-flex align-items-center justify-content-center"
                    onclick="location.href='my-plan.jsp?year=<%=year%>&month=<%=month-1%>'">
                <i class="material-icons-outlined">chevron_left</i>
            </button>
            <button class="d-flex align-items-center justify-content-center"
                    onclick="location.href='my-plan.jsp?year=<%=year%>&month=<%=month+1%>'">
                <i class="material-icons-outlined">chevron_right</i>
            </button>
        </div>
        <div class="top-date"><span class="top-year"><%=year%></span>년 <span class="top-month"><%=month%></span>월
        </div>
    </div>


    <div class="small-container">
        <table>
            <tr class="top-nav">
                <th colspan="5">
                    <span class="year"></span>년 <span class="month"></span>월
                </th>
                <td class="before"><i class="material-icons-outlined">chevron_left</i></td>
                <td class="after"><i class="material-icons-outlined">chevron_right</i></td>
            </tr>
            <tr class="day-title">
                <td>일</td>
                <td>월</td>
                <td>화</td>
                <td>수</td>
                <td>목</td>
                <td>금</td>
                <td>토</td>
            </tr>
            <tr class="first-week week-day">
                <td>
                    <div class="small-day"></div>
                </td>
                <td>
                    <div class="small-day"></div>
                </td>
                <td>
                    <div class="small-day"></div>
                </td>
                <td>
                    <div class="small-day"></div>
                </td>
                <td>
                    <div class="small-day"></div>
                </td>
                <td>
                    <div class="small-day"></div>
                </td>
                <td>
                    <div class="small-day"></div>
                </td>
            </tr>
            <tr class="second-week week-day">
                <td>
                    <div class="small-day"></div>
                </td>
                <td>
                    <div class="small-day"></div>
                </td>
                <td>
                    <div class="small-day"></div>
                </td>
                <td>
                    <div class="small-day"></div>
                </td>
                <td>
                    <div class="small-day"></div>
                </td>
                <td>
                    <div class="small-day"></div>
                </td>
                <td>
                    <div class="small-day"></div>
                </td>
            </tr>
            <tr class="third-week week-day">
                <td>
                    <div class="small-day"></div>
                </td>
                <td>
                    <div class="small-day"></div>
                </td>
                <td>
                    <div class="small-day"></div>
                </td>
                <td>
                    <div class="small-day"></div>
                </td>
                <td>
                    <div class="small-day"></div>
                </td>
                <td>
                    <div class="small-day"></div>
                </td>
                <td>
                    <div class="small-day"></div>
                </td>
            </tr>
            <tr class="forth-week week-day">
                <td>
                    <div class="small-day"></div>
                </td>
                <td>
                    <div class="small-day"></div>
                </td>
                <td>
                    <div class="small-day"></div>
                </td>
                <td>
                    <div class="small-day"></div>
                </td>
                <td>
                    <div class="small-day"></div>
                </td>
                <td>
                    <div class="small-day"></div>
                </td>
                <td>
                    <div class="small-day"></div>
                </td>
            </tr>
            <tr class="fifth-week week-day">
                <td>
                    <div class="small-day"></div>
                </td>
                <td>
                    <div class="small-day"></div>
                </td>
                <td>
                    <div class="small-day"></div>
                </td>
                <td>
                    <div class="small-day"></div>
                </td>
                <td>
                    <div class="small-day"></div>
                </td>
                <td>
                    <div class="small-day"></div>
                </td>
                <td>
                    <div class="small-day"></div>
                </td>
            </tr>
            <tr class="sixth-week week-day">
                <td>
                    <div class="small-day"></div>
                </td>
                <td>
                    <div class="small-day"></div>
                </td>
                <td>
                    <div class="small-day"></div>
                </td>
                <td>
                    <div class="small-day"></div>
                </td>
                <td>
                    <div class="small-day"></div>
                </td>
                <td>
                    <div class="small-day"></div>
                </td>
                <td>
                    <div class="small-day"></div>
                </td>
            </tr>
        </table>


        <div class="top-button">
            <button onclick="location.href='main.jsp?year=<%=year%>&month=<%=month%>'">달력</button>
            <button onclick="location.href='my-plan.jsp?year=<%=year%>&month=<%=month%>'">일정</button>
        </div>
    </div>

    <table class="table">
        <tr class="big-top">
            <td width="70">
                삭제
            </td>
            <td>
                제목
            </td>
            <td>
                시작 날짜
            </td>
            <td>
                끝 날짜
            </td>
            <td>
                설명
            </td>
            <td>
                아이디
            </td>
            <td width="70">
                수정
            </td>
        </tr>
        <%
            for (int i = 0; i < events.size(); i++) {%>
        <tr>
            <td></td>
            <td><%=events.get(i).getTitle()%></td>
            <td><%=events.get(i).getStartDate()%></td>
            <td><%=events.get(i).getEndDate()%></td>
            <td><%=events.get(i).getInformation()%></td>
            <td><%=events.get(i).getUserId()%></td>
            <td></td>
        </tr>
        <%}%>
    </table>

</div>


<script src="jsFuntion.js"></script>


<script>
    let todayYear = document.getElementById('year').value;
    let todayMonth = document.getElementById('month').value;
    let todayDay = document.getElementById('day').value;

    let dayArr = document.getElementsByClassName("small-day");

    drawCalendar(todayYear, todayMonth, todayDay);

    let beforeBtn = document.getElementsByClassName("before")[0];
    beforeBtn.addEventListener("click", function () {
        todayMonth--;
        drawCalendar(todayYear, todayMonth, todayDay);

        for (let i = 0; i < dayArr.length; i++) {
            dayArr[i].addEventListener('click', function () {
                location.href = 'my-plan.jsp?year=' + todayYear + '&month=' + Number(todayMonth);
            });
        }
    })

    let afterBtn = document.getElementsByClassName("after")[0];
    afterBtn.addEventListener("click", function () {
        todayMonth++;
        drawCalendar(todayYear, todayMonth, todayDay);

        for (let i = 0; i < dayArr.length; i++) {
            dayArr[i].addEventListener('click', function () {
                location.href = 'my-plan.jsp?year=' + todayYear + '&month=' + Number(todayMonth);
            });
        }
    })
</script>


</body>
</html>
