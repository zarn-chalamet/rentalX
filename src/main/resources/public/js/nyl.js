let infos = [
        {       id:1,
                img: "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcShOiYElieWi3Z9s0BBnHMlPIbLM2Yfs3iLnw&usqp=CAU",
                name : "Regent Mansion",
                price : 4000,
                type : "1 bedroom",
                type2 : "1 bathroom"
        },
        {
                id:2,
                img: "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcShOiYElieWi3Z9s0BBnHMlPIbLM2Yfs3iLnw&usqp=CAU",
                name : "STK Resort",
                price : 3500,
                type : "1 bedroom",
                type2 : "1 bathroom"
        },
        {
                id:3,
                img: "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcShOiYElieWi3Z9s0BBnHMlPIbLM2Yfs3iLnw&usqp=CAU",
                name : "Beyond",
                price : 4500,
                type : "1 bedroom",
                type2 : "1 bathroom"
        },
        {
                id:4,
                img: "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcShOiYElieWi3Z9s0BBnHMlPIbLM2Yfs3iLnw&usqp=CAU",
                name : "Tangmo dormitory",
                price : 3500,
                type : "1 bedroom",
                type2 : "1 bathroom"
        },
        {
                id:5,
                img: "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcShOiYElieWi3Z9s0BBnHMlPIbLM2Yfs3iLnw&usqp=CAU",
                name : "Rattana",
                price : 3500,
                type : "1 bedroom",
                type2 : "1 bathroom"
        },
        {
                id:6,
                img: "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcShOiYElieWi3Z9s0BBnHMlPIbLM2Yfs3iLnw&usqp=CAU",
                name : "Panida 2 Dormitory",
                price : 4000,
                type : "1 bedroom",
                type2 : "1 bathroom"
        },
]



let productContainer = document.querySelector(".session");

infos.forEach((info) => {

        productContainer.innerHTML += `


    `;
    changeheart();
});

function changeheart() {
        let hearts = document.querySelectorAll(".heart");

        hearts.forEach((heart) => {
            let isLiked = false;

            heart.addEventListener("click", () => {
                if (isLiked) {
                    heart.innerHTML = `<button class="heart"><i class="fa-regular fa-heart"></i></button>`;
                    isLiked = false;
                } else {
                    heart.innerHTML = `<button class="hh"><i class="fa-solid fa-heart" id="H_icon"></i></button>`;
                    isLiked = true;
                }
            });
        });
    }








