const commentBtn = document.querySelector('.commentBtn');
const content = document.querySelector('.input-comment');



commentBtn.addEventListener('click', () => {
    const data={
        product_id : id,
        content : content.value
    }
    console.log("click")
    sendData('/api/POST/comment',data);
    console.log("click");
});
