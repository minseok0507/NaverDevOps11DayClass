let lastSubmittedTime = 0;



function handleSubmit(event) {

    // 현재 시간을 가져옵니다.
    const currentTime = new Date().getTime();

    // 마지막으로 제출된 시간과 현재 시간의 차이를 계산합니다.
    const elapsedTime = currentTime - lastSubmittedTime;

    // 만약 마지막으로 제출된 시간으로부터 5초 이상이 지났다면 form을 제출합니다.
    if (elapsedTime >= 5000) {
        lastSubmittedTime = currentTime;
        return true; // form 제출을 허용합니다.
    } else {
    // 5초 안에 연속으로 제출되었을 때 경고 메시지를 표시하고 form 제출을 막습니다.
        alert("한 번의 제출에 5초가 지나야 합니다.");
        event.preventDefault(); // 기본 동작인 form 제출을 막습니다.
        return false;
    }
}


