(() => {

    const pictures = document.querySelectorAll('.picture-box');

    pictures.forEach(likedPicture => {

        likedPicture.addEventListener('dblclick', () => {

            const likeIcon = likedPicture.querySelector('.liked');
            likeIcon.style.display = 'block';

            setTimeout(function () {

                likeIcon.style.display = 'none';
            }, 250);




        })


    })

}) ();


(() => {

    const ratings = document.querySelectorAll('.ratings');

    ratings.forEach( currentRatting => {

        currentRatting.addEventListener('mouseover', () => {

            const stars = currentRatting.querySelectorAll('.far') ;
            //console.log(stars) ;

            stars.forEach( currentStar => {

                currentStar.addEventListener('mouseover', () =>{

                    const currentStarRating = currentStar.classList.add('fas') ;
                })


            })

        } )

        /*
                currentRatting.addEventListener('mouseout', () => {

                    const stars = currentRatting.querySelector('.far') ;
                    stars.classList.remove('fas');
                } )*/
    })



}) ();



    (() => {
        const pictures = document.querySelectorAll(".picture-box");

        pictures.forEach((likedPicture) => {
            let numbersOfLikes = 0;
            likedPicture.addEventListener("dblclick", () => {
                numbersOfLikes++;
                const likeIcon = likedPicture.querySelector(".liked");
                likeIcon.style.display = "block";

                setTimeout(function () {
                    likeIcon.style.display = "none";
                }, 250);

                const likeCounter = likedPicture.querySelector(".likecounter");
                likeCounter.innerHTML = numbersOfLikes;
            });
        });
    })();

(() => {
    const ratings = document.querySelectorAll(".rating");

    ratings.forEach(currentRating => {
        const stars = currentRating.querySelectorAll(".far");

        stars.forEach((currentStar, index) => {
            currentStar.addEventListener("mouseover", () => {
                for (let i = 0; i <= index; i++) {
                    stars[i].classList.add("fas");
                }
            });

            currentStar.addEventListener("mouseout", () => {
                const currentRate = currentRating.getAttribute("rated");

                if (!currentRate || currentRate <= index) {
                    const startIndex = !currentRate ? 0 : parseInt(currentRate) + 1;

                    for (let i = startIndex; i <= index; i++) {
                        stars[i].classList.remove("fas");
                    }
                }
            });

            currentStar.addEventListener("click", () => {
                currentRating.setAttribute("rated", index);
                for (let i = 0; i < 5; i++) {
                    stars[i].classList.remove("fas");
                }

                for (let i = 0; i <= index; i++) {
                    stars[i].classList.add("fas");
                }
            });
        });
    });
})();