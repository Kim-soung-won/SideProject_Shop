const loveBtn = document.querySelector('#love');

data={
    product_id:id
}
loveBtn.addEventListener('click', () => {
    console.log("click")
    sendData('/api/PUT/love',data);
    console.log("click");
})
