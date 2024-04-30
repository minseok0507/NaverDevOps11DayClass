function addToCart() {
    var btn = document.getElementById('addToCartBtn');
    btn.disabled = true; // 버튼을 비활성화

    fetch('/item?id=[[${i.id}]]', {method: 'POST'})
        .then(() => {
            location.reload();
        })
        .finally(() => {
            setTimeout(() => {
                btn.disabled = false; // 5초 후 버튼을 다시 활성화
            }, 5000); // 5000ms = 5초
        });
}

function deleteList(){
    fetch('/item?id=[[${i.id}]]', {method : 'DELETE'})
            .then(() => {
                location.reload();
            });
}