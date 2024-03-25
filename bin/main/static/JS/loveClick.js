const loveBtn = document.querySelector('#love');
const queryParam = new URLSearchParams(window.location.search);
const love_id = queryParam.get('id');

data={
    product_id:love_id
}
loveBtn.addEventListener('click', () => {
    console.log("click")
    sendData('/api/PUT/love',data);
    console.log("click");
})
