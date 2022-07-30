const PRODUCT_ENDPOINT = 'product'
const BUCKET_ENDPOINT = 'bucket'
let userId;
const defaultImg = 'http://localhost:8080/Homework_Adv_5_war_exploded/images/product-default.png';

const  createCard = (product) =>
    `
                <div class="col">
                    <div class="card shadow-sm">
                        <img height="250px" src="${product.image ? product.image : defaultImg}" alt="product">

                        <div class="card-body">
                            <h3>${product.name}</h3>
                            <p class="card-text" style="text-after-overflow: ellipsis">${product.description}</p>
                            
                            <div class="d-flex justify-content-between align-items-center">
                                <div class="btn-group">
                                    <a href="product?id=${product.id}">
                                        <button type="button" class="btn btn-sm btn-outline-secondary">View</button>
                                    </a>
                                    <button onclick="addProductToBucket(${product.id})" type="button" class="btn btn-sm btn-outline-success">
                                        <i class="fa-solid fa-basket-shopping"></i>
                                    </button>
                                </div>
                                <span class="text-muted">${product.price} $</span>
                            </div>
                        </div>
                    </div>
                </div>`;


function addProductToBucket(productId) {
    if (!userId) {
        window.location.href = 'login.jsp';
        return;
    }

    fetch(BUCKET_ENDPOINT, {
        headers: {
            'Content-Type': 'application/json'
        },
        method: 'POST',
        body: JSON.stringify({productId})
    }).then((result) => {
        console.log(result);
        alert('Added to bucket');
    });
}

function getProducts() {
    const sendRequest = async () => {
        const result = await fetch(PRODUCT_ENDPOINT, {
            method: 'GET',
            'Content-Type': 'application/json'
        });
        let products = await result.json();
        let element = document.querySelector('#content');

        products.forEach((item) => {
            element.innerHTML = element.innerHTML + createCard(item);
        });

        console.log(products);
    }
    sendRequest()
}

userId = localStorage.getItem("userId");
getProducts();




