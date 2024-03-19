const popularBtn = document.getElementById("popular")
const latestBtn = document.getElementById("latest")
const highPriceBtn = document.getElementById("high-price")
const lowPriceBtn = document.getElementById("low-price")

popularBtn.addEventListener("click", ()=>{
    console.log("click pop")
    httpGetRequest('/product/popular')
})
latestBtn.addEventListener("click", ()=> {
    console.log("click latest")
    httpGetRequest('/product/latest')
})
lowPriceBtn.addEventListener("click" ,()=> {
    console.log("click low")
    httpGetRequest('/product/lowPrice')
})
highPriceBtn.addEventListener("click",()=> {
    console.log("click high")
    httpGetRequest('/product/highPrice')
})


window.onload = () => {
    httpGetRequest('/product/popular');
}
const hideList = () => {
    console.log("onload")
}
function httpGetRequest(url){
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
                return `
                <article class="bg-white shadow-md rounded overflow-hidden">
                    <img src="https://source.unsplash.com/random/300x300?clothes&sig=${item.id}"
                         alt="Fashion item" class="w-full h-64 object-cover"
                         onclick="location.href='/product/${item.id}'">
                    <div class="p-4">
                        <h3 class="font-semibold">상품명 : ${item.name}</h3>
                        <p class="text-gray-600">${item.price}원</p>
                        <p class="text-gray-600">인기순</p>
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