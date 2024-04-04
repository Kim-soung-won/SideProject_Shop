document.addEventListener('DOMContentLoaded', (event) =>{
    const sortLabels = document.querySelectorAll('.sort-label')
    sortLabels.forEach(function(sortLabel) {
        sortLabel.getAttribute('order')
        sortLabel.addEventListener('click', function(){
            let val = this.getAttribute('value')
            let searchValue = document.getElementById('searchVal').value;
            val = parseInt(val)
            console.log(typeof val)
            console.log(val)
            GetListRequest(`/GET/manage/search?id=${val}&name=${searchValue}`);
        });
    });
})

window.onload = () => {
    GetListRequest(`/GET/manage`);
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
                    <td class="px-4 py-2">${item.brand}</td>
                    <td class="px-4 py-2">${item.name}</td>
                    <td class="px-4 py-2">${item.price}</td>
                    <td class="px-4 py-2">${item.mount}</td>
                    <td class="px-4 py-2">${item.sum}</td>
                    <td class="px-4 py-2">
                        <button class="bg-green-500 hover:bg-green-700 text-white font-bold py-1 px-2 rounded">View</button>
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