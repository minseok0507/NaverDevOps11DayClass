var totalPageElement = document.getElementsByClassName("total_page")[0];
var pageList = document.getElementsByClassName("pagenum-list")[0];

if (totalPageElement) {
    var totalPage = parseInt(totalPageElement.innerText);

    if (totalPage <= 1) {
        if (pageList) {
            pageList.style.display = "none";
        }
    } else {
        totalPageElement.style.display = "none";
    }
}
