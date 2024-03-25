const cartBtn = document.querySelector('#cart');
const queryParams = new URLSearchParams(window.location.search);
const id = queryParams.get('id');
const size = "m"
const count = 1

cartBtn.addEventListener('click', () => {
    console.log("click")
    sendData('/api/POST/cart',data);
    console.log("click");
})

data={
    product_id : id,
    size : size,
    count : count,
}
