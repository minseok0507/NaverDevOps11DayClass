async function getURL(e) {
    let file = e.files[0];

    // 현재 시간을 가져옴
    let currentDate = new Date();

    //한국시간 세팅
    currentDate.setHours(currentDate.getHours() + 9)

    // 날짜를 원하는 형식으로 문자열로 변환 > "YYYYMMDDHHMMSS"
    let formattedDate = currentDate.toISOString().slice(0, 19).replace(/-/g, '').replace(/:/g, '').replace('T', '');

    // 현제 접속 유저 이름
    let writeUser = document.getElementsByName("writeUser")[0].value

    //파일이름에 추가할 문자열
    if (writeUser == "") { writeUser = "anonymous" }
    let customFileName = formattedDate + "_" + writeUser + "_";

    // 이미지 파일인지 확인
    let allowedExtensions = /(\.jpg|\.jpeg|\.png|\.gif)$/i;
    if (!allowedExtensions.exec(file.name)) {
        alert('올바른 이미지 파일을 선택해주세요.');
        return;
    }

    let maxSizeInBytes = 10 * 1024 * 1024; // 10MB 용량 제한
    if (file.size > maxSizeInBytes) {
        alert('이미지 크기가 너무 큽니다. 10MB 이하의 이미지를 선택해주세요.');
        return;
    }

    //uri가 인식할 수 있게 encode
    let name = encodeURIComponent(customFileName + file.name);
    let result = await fetch('/presigned-url?filename=' + name);
    result = await result.text();

    let uploadResult = await fetch(result, {
        method: 'PUT',
        body: file
    });

    if (uploadResult.ok) {
        document.querySelector('img').src = uploadResult.url.split("?")[0];
        document.getElementsByName("url")[0].value = uploadResult.url.split("?")[0];
    }

}