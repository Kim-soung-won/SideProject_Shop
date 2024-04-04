const searchBtn = document.getElementById('searchBtn');

searchBtn.addEventListener('click', ()=>{
    const searchValue = document.getElementById('searchVal');
    console.log(typeof(searchValue.value))
    console.log(searchValue.value)
    GetListRequest(`/GET/manage/search?name=${searchValue.value}`);
})