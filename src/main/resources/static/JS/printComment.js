window.onload = () => {
    GetListRequest(`/api/GET/commentList?id=3322`);
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
            const commentListContainer = document.getElementById('field');
            // 데이터 배열을 순회하면서 각 항목을 HTML로 변환
            let commentHtml = data.map(item => {
                return `
                <div class="border-t border-b py-4">
                    <P>${item.created_at}</P>
                    <p>${item.name}</p>
                    <p>${item.content}</p>
                </div>
            `;
            }).join(''); // 배열의 모든 항목을 하나의 문자열로 결합
            commentListContainer.innerHTML = commentHtml;
        })
        .catch(error => {
            console.error('Error fetching user data:', error);
        });
}