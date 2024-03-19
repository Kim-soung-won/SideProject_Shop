document.addEventListener('DOMContentLoaded', (event) =>{
    const figures = document.querySelectorAll('figure')

    figures.forEach(function(figure) {
        figure.addEventListener('click', function(){
            const captionText = this.querySelector('figcaption').innerText;
            console.log(captionText);
        });
    });
})