const REGISTRATION_ENDPOINT = 'register';
const LOGIN_ENDPOINT = 'login';
const PRODUCT_ENDPOINT = 'product';

function handleRegistration(event) {
    handleFormSubmit(event, REGISTRATION_ENDPOINT, (result) => {
        switch (result.status) {
            case 200 :
                window.location.href = result.url;
                break;
            case '409':
                document.querySelector('#errorMessage').innerText = `User with email ${data.email} already exists`;
                break;
            default:
                document.querySelector('#errorMessage').innerText = `Opps something went wrong. Please try again`;
        }
    }, handleError);
}

function handleLogin(event) {
    handleFormSubmit(event, LOGIN_ENDPOINT,
        (result) => {
            switch (result.status) {
                case 200 :
                    window.location.href = result.url;
                    break;
                case '403':
                    document.querySelector('#errorMessage').innerText = `Incorrect credentials`;
                    break;
                default:
                    document.querySelector('#errorMessage').innerText = `Opps something went wrong. Please try again`;
            }
        }, handleError);
}

function handleCreateProduct(event) {
    handleFormSubmit(event, PRODUCT_ENDPOINT,
        (result) => {
            switch (result.status) {
                case 200 :
                    alert("Success");
                    window.location.reload();
                    break;
                default:
                    document.querySelector('#errorMessage').innerText = `Opps something went wrong. Please try again`;
            }
        }, handleError);
}

function handleFormSubmit(event, endpoint, onSuccess, onError) {
    event.preventDefault();
    const formData = new FormData(event.target);
    const userObj = {};
    formData.forEach((value, key) => (userObj[key] = value));
    console.log(userObj);


    let values = Object.values(userObj);

    for (const value of values) {
        if (!value) {
            onError(userObj);
            return;
        }
    }

    const sendData = async (data) => {
        if(data.image){
            data.image = await toBase64(data.image);
        }
        const result = await fetch(endpoint, {
            method: 'POST',
            body: JSON.stringify(data),
            headers: {
                'Content-Type': 'application/json'
            }
        });
        onSuccess(result);
    }

    sendData(userObj);
}
const handleError = (object) => {
    document.querySelector('#errorMessage').innerText = `Please fill all fields`;
    Object.keys(object).forEach((key) => {
        if (!object[key]) {
            let element = document.querySelector(`input[name="${key}"]`);
            element.style.outline = '1px solid red'
        }
    });
}

const toBase64 = file => new Promise((resolve, reject) => {
    const reader = new FileReader();
    reader.readAsDataURL(file);
    reader.onload = () => resolve(reader.result);
    reader.onerror = error => reject(error);
});