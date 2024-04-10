document.addEventListener('DOMContentLoaded', (event) =>{
    const sortLabels = document.querySelectorAll('.sort-label')
    sortLabels.forEach(function(sortLabel) {
        sortLabel.addEventListener('click', function(){
            let toggle = parseInt(this.getAttribute('order'))
            this.setAttribute('order', toggle * -1)
            toggle = parseInt(this.getAttribute('order'))

            let val = this.getAttribute('value')
            let searchValue = document.getElementById('searchVal').value;
            val = parseInt(val) * toggle

            console.log(val)

            GetListRequest(`/GET/manage/search?id=${val}&name=${searchValue}`);
        });
    });
})

window.onload = () => {
    GetListRequest(`/GET/manage`);
}

function redirectTo(id) {
    location.replace(`/manage/product/?id=${id}`);
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
            const dataContainer = document.getElementById('field');
            // 데이터 배열을 순회하면서 각 항목을 HTML로 변환
            let manageHtml = data.map(item => {
                return `
                <tr class="table-row" >
                    <td class="px-4 py-2">${item.id}</td>
                    <td class="px-4 py-2">${item.brandName}</td>
                    <td class="px-4 py-2">${item.name}</td>
                    <td class="px-4 py-2">${item.price}</td>
                    <td class="px-4 py-2">${item.amount}</td>
                    <td class="px-4 py-2">${item.sales}</td>
                    <td class="px-4 py-2">
                        <button class="bg-green-500 hover:bg-green-700 text-white font-bold py-1 px-2 rounded" 
                        onclick=redirectTo(${item.id})>View</button>
                    </td>
                </tr>
            `;
            }).join(''); // 배열의 모든 항목을 하나의 문자열로 결합
            dataContainer.innerHTML = manageHtml;
        })
        .catch(error => {
            console.error('Error fetching user data:', error);
        });
}