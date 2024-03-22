document.addEventListener('DOMContentLoaded', (event) =>{
    const sortBtns = document.querySelectorAll('.sort-btn')

    sortBtns.forEach(function(sortBtn) {
        sortBtn.addEventListener('click', function(){
            console.log(typeof(this.value))
            var sortNum = parseInt(this.value)
            console.log(typeof(sortNum))
            console.log(this.value)
            console.log(sortNum)
            GetListRequest(`/product?id=${sortNum}`)
        });
    });
})

window.onload = () => {
    GetListRequest(`/product?id=1`);
}
const hideList = () => {
    console.log("onload")
}
function GetListRequest(url){
    const headers = {
        Authorization: 'Bearer ' + localStorage.getItem('access_token'),
        'Content-Type': 'application/json',
    };
    fetch(url, {
        method: 'POST',
        headers: headers
    })
        .then(response => response.json())
        .then(data => {
            // Thymeleaf로 직접 데이터 추가
            const productDataContainer = document.getElementById('field');
            // 데이터 배열을 순회하면서 각 항목을 HTML로 변환
            let productsHtml = data.map(item => {
                let rand = Math.floor(Math.random() *7)
                let urlImg
                switch(rand){
                    case 0 : urlImg = "/IMG/ang.gif"; break;
                    case 1 : urlImg = "/IMG/cat.gif"; break;
                    case 2 : urlImg = "/IMG/cool-fun.gif"; break;
                    case 3 : urlImg = "/IMG/crymococo.gif"; break;
                    case 4 : urlImg = "/IMG/sodosodo.gif"; break;
                    case 5 : urlImg = "/IMG/모코코.gif"; break;
                    case 6 : urlImg = "/IMG/thanks.gif"; break;
                }
                return `
                <article class="bg-white shadow-md rounded overflow-hidden">
<!--                "https://source.unsplash.com/random/300x300?clothes&sig=${item.id}"-->
                    <img src="${urlImg}"
                         alt="Fashion item" class="w-full h-64 object-cover"
                         onclick="location.href='/product/${item.id}'">
                    <div class="p-4">
                        <h3 class="font-semibold">상품명 : ${item.name}</h3>
                        <p class="text-gray-600">${item.price}원</p>
                        <p class="text-gray-600">인기순</p>
                        <p class="text-gray-600">${item.status}</p>
                        <p class="text-gray-600">${item.msg}</p>
                    </div>
                </article>
            `;
            }).join(''); // 배열의 모든 항목을 하나의 문자열로 결합
            productDataContainer.innerHTML = productsHtml;
        })
        .catch(error => {
            console.error('Error fetching user data:', error);
        });
}