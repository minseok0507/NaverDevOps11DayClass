let getPageYear = document.getElementById('year').value;
let getPageMonth = document.getElementById('month').value;

let pageStartDate = new Date(getPageYear, getPageMonth - 1, 1);
let pageLastDate = new Date(getPageYear, getPageMonth, 0);
let pageBeforeDate = new Date(getPageYear, getPageMonth - 1, 0);

document.getElementsByClassName("top-year")[0].innerHTML = pageStartDate.getFullYear();
document.getElementsByClassName("top-month")[0].innerHTML = pageStartDate.getMonth() + 1;

let pageStartWeekDay = pageStartDate.getDay();
let pageLastDay = pageLastDate.getDate();
let pageBeforeDay = pageBeforeDate.getDate();

let getBigDayArr = document.getElementsByClassName("big-day");


let pageDateIncr = 1;
for (let i = pageStartWeekDay; i < pageStartWeekDay + pageLastDay; i++) {
    getBigDayArr[i].innerHTML = pageDateIncr;
    getBigDayArr[i].className += " enabled"
    pageDateIncr++;
}

let pageAfterDate = 1;
for (let i = pageStartWeekDay + pageLastDay; i < getBigDayArr.length; i++) {
    getBigDayArr[i].innerHTML = pageAfterDate;

    pageAfterDate++;
}

let pageBeforeDateIncr = pageBeforeDay - pageStartWeekDay + 1;
for (let i = 0; i < pageStartWeekDay; i++) {
    getBigDayArr[i].innerHTML = pageBeforeDateIncr;
    pageBeforeDateIncr++;
}


let today = new Date();
let todayYear = document.getElementById('year').value;
let todayMonth = document.getElementById('month').value;
let todayDay = document.getElementById('day').value;

drawCalendar(todayYear, todayMonth, todayDay);

let beforeBtn = document.getElementsByClassName("before")[0];
beforeBtn.addEventListener("click", function () {
    todayMonth--;
    drawCalendar(todayYear, todayMonth, todayDay);
})

let afterBtn = document.getElementsByClassName("after")[0];
afterBtn.addEventListener("click", function () {
    todayMonth++;
    drawCalendar(todayYear, todayMonth, todayDay);
})


let close = document.getElementById('close');
let popup = document.getElementsByClassName('popup-event')[0];

close.addEventListener('click', function () {
    // 클릭 시 실행되는 코드
    animateClose(popup);
});

let enabled = document.getElementsByClassName('enabled');

for (let i = 0; i < enabled.length; i++) {
    enabled[i].addEventListener('click', function () {
        animateOpen(popup);
        let startDateInput = document.getElementById("startDate")
        let endDateInput = document.getElementById("endDate");

        // 한 자리 숫자인 경우 두 자리 숫자로 변환
        let formattedMonth = ('0' + todayMonth).slice(-2);

        // this.innerHTML 값이 한 자리 숫자인 경우 두 자리 숫자로 변환
        let formattedDay = ('0' + this.innerHTML).slice(-2);

        // startDateInput에 할당할 값 설정
        startDateInput.value = todayYear + "-" + formattedMonth + "-" + formattedDay + "T00:00";
        endDateInput.value = todayYear + "-" + formattedMonth + "-" + formattedDay + "T23:59";

    })
}


function drawCalendar(year, month, day) {
    // 현재 날짜 및 시간 정보 가져오기
    let currentDate = new Date(year, month - 1, day);

    // 오늘 연도, 월, 일, 요일 정보 추출
    year = currentDate.getFullYear();
    month = currentDate.getMonth();
    day = currentDate.getDate();

    let todayStartDay = new Date(year, month, 1);
    let todayStartDayOfWeek = todayStartDay.getDay(); // 0(일요일) ~ 6(토요일)
    let lastDay = new Date(year, month + 1, 0).getDate(); //마지막날

    let beforeLastDay = new Date(year, month, 0).getDate(); //전달 마지막날

    let topSpanYear = document.getElementsByClassName("year")[0];
    topSpanYear.innerHTML = year;
    let topSpanMonth = document.getElementsByClassName("month")[0];
    topSpanMonth.innerHTML = month + 1; // 월은 0부터 시작하므로 +1

    let dayArr = document.getElementsByClassName("small-day");
    let num = 1;
    for (let i = todayStartDayOfWeek; i < todayStartDayOfWeek + lastDay; i++) {
        dayArr[i].innerHTML = num;
        dayArr[i].style.color = "black";
        dayArr[i].style.fontWeight = "border";
        num++;
    }
    let newNum = 1;
    for (let i = todayStartDayOfWeek + lastDay; i < dayArr.length; i++) {
        dayArr[i].innerHTML = newNum;
        dayArr[i].style.color = "lightgray";
        newNum++;
    }

    let backDay = beforeLastDay - todayStartDayOfWeek + 1
    for (let i = 0; i < todayStartDayOfWeek; i++) {
        dayArr[i].innerHTML = backDay;
        dayArr[i].style.color = "lightgray";
        backDay++;
    }

    for (let i = 0; i < dayArr.length; i++) {
        dayArr[i].addEventListener('click', function () {
            location.href = 'main.jsp?year=' + year + '&month=' + Number(month + 1);
        });

    }


}


function animateClose(element) {
    // 애니메이션 효과 적용
    element.style.transform = 'translate(0, 50%)';
    element.style.opacity = '0';
    element.style.transition = 'all 0.2s ease-in-out';

    setTimeout(function () {
        element.style.display = 'none';
    }, 300);
}

function animateOpen(element) {
    // 애니메이션 효과 적용
    element.style.display = 'block';

    setTimeout(function () {
        element.style.transform = 'translate(0, 0%)';
        element.style.opacity = '1';
        element.style.transition = 'all 0.2s ease-in-out';
    }, 300);
}

