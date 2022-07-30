const BUCKET_ENDPOINT = 'bucket';
// const defaultImg = 'http://localhost:8080/Homework_Adv_5_war_exploded/images/product-default.png';

const createListItem = (item) => `
    <div class="bucket-item">
        <div class="image">
           <img width="150" height="150" 
           src="http://localhost:8080/Homework_Adv_5_war_exploded/images/product-default.png" 
           alt="image">
        </div>

        <div class="content">
            <h3>${item.name}</h3>
            <p>
                ${item.description}
            </p>
        </div>

        <div class="btns">
            <button onclick="removeItem(${item.id})" class="btn btn-danger">Remove</button>
        </div>
    </div>
`

function removeItem(id) {
    fetch(`${BUCKET_ENDPOINT}?productId=${id}`, {
        method: 'DELETE',
    }).then(() => {
        window.location.reload();
    });
}

function getItems() {
    const bucketContainer = document.getElementById('bucket');
    fetch(BUCKET_ENDPOINT, {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json'
        }
    }).then((result) => {
        console.log('result', result);
        return result.json();
    }).then((json) => {
        console.log('json',json);
        json.forEach((item) => {
            bucketContainer.innerHTML = bucketContainer.innerHTML + createListItem(item);
        });
    });
}

getItems();