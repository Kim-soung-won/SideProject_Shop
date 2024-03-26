const queryParam = new URLSearchParams(window.location.search);
const id = queryParam.get('id');

function sendData(url, data) {
    // Fetch API를 사용하여 서버에 POST 요청을 보냅니다.
    fetch(url, {
        method: 'POST', // 요청 방식 설정
        headers: {
            'Content-Type': 'application/json', // 내용 타입을 JSON으로 지정
        },
        body: JSON.stringify(data), // JavaScript 객체를 JSON 문자열로 변환하여 body에 담습니다.
    })
        .then(response => {
            if (!response.ok) { // 응답 상태가 OK가 아닐 경우 에러 처리
                throw new Error('Network response was not ok');
            }
            return response.json(); // 응답 본문을 JSON으로 변환
        })
        .then(data => {
            if(data.code===666){
                alert(data.msg);
            }
            console.log(data); // 서버로부터 받은 데이터 처리
        })
        .catch(error => {
            console.error('There was a problem with your fetch operation:', error);
        });
}