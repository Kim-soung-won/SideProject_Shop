const topProductBtn = document.getElementById('ProductTop');
const topOrderBtn = document.getElementById('OrderTop');
const topBrandBtn = document.getElementById('BrandTop');

function setTopBtn(i, value){
    const sortLabels = document.querySelectorAll('.sort-label')
    sortLabels.forEach(function(sortLabel) {
        sortLabel.addEventListener('click', function(){
            console.log("value : ",value)
            console.log("click");
            let toggle = parseInt(this.getAttribute('order'))
            this.setAttribute('order', i * -1)
            toggle = parseInt(this.getAttribute('order'))

            let val = this.getAttribute('value')
            let searchValue = document.getElementById('searchVal').value;
            val = parseInt(val) * toggle

            console.log(val)
            if(value === 1) {
                GetProductListRequest(`/GET/manage/product/search?id=${val}&name=${searchValue}&paging=1`);
            }
            else if(value === 2){
                GetOrderListRequest(`/GET/manage/order/search?id=${val}&name=${searchValue}`);
            }
            else if(value === 3){
                GetBrandListRequest(`/GET/manage/brand/search?id=${val}&name=${searchValue}`);
            }
        });
    });
};

function colorChange(clickElement){
    const topLabels = document.querySelectorAll('.tab')
    topLabels.forEach(topLabel =>
        topLabel.classList.remove('tab-active')
    );
    clickElement.classList.add('tab-active');
}


topProductBtn.addEventListener('click', function(){
    GetProductListRequest(`/GET/manage/product`);
    colorChange(this);
});

topOrderBtn.addEventListener('click', function(){
    GetOrderListRequest(`/GET/manage/order/search?page=0`);
    colorChange(this);
});

topBrandBtn.addEventListener('click', function(){
    GetBrandListRequest(`/GET/manage/brand/search?page=0`);
    colorChange(this);
});



