import {handleResponse} from 'handleResponse';

export function sendText(text) {
    return function () {
        return fetch('/echo/', {
            headers: {
                'Content-Type': 'application/json'
            },
            method: 'GET',
            body: text
        }).then(handleResponse);
    };
}