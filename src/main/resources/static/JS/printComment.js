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
                <div class="border-t border-b py-4" id="commentContainer_${item.id}">
                    <div id="created_who">${item.name}</div>
                    <div class="comment_id" style="display: none">${item.id}</div>
                    <p>${item.content}</p>
                    <p>${item.created_at}</p>
                    <br>
                    <button style="background-color: deepskyblue"
                    class="deleteCommentBtn btn btn-primary"
                    data-comment-id="${item.id}">댓글 삭제하기</button>
                </div>
            `;
            }).join(''); // 배열의 모든 항목을 하나의 문자열로 결합
            commentListContainer.innerHTML = commentHtml;
            GetDeleteBtn();
        })
        .catch(error => {
            console.error('Error fetching user data:', error);
        });
}

function GetDeleteBtn(){
    console.log("GetBtn")
    const deleteCommentBtns = document.querySelectorAll('.deleteCommentBtn');
    console.log("deleteCommentBtns : ", deleteCommentBtns)
    deleteCommentBtns.forEach(btn => {
        btn.addEventListener('click', function (e) {
              console.log("click")
              const commentId = e.target.getAttribute('data-comment-id');
              console.log("commentId :", commentId)
              const commentContainer = document.getElementById(`commentContainer_${commentId}`);
              console.log("commentContainer : ", commentContainer)
              const id = parseInt(commentContainer.querySelector('.comment_id').innerHTML);
              console.log("id :", id)
              const name = commentContainer.querySelector('#created_who').innerHTML;
              console.log("name :", name)
              const data = {
                  comment_id: id,
                  created_who: name
              };
              console.log("data : ", data)
              sendData(`/api/DELETE/comment`, data);
        })
    })
}