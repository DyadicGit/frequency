import 'whatwg-fetch';
import {handleResponse} from './handleResponse';

export function sendFile(text) {
    return function () {
        return fetch('/echo/', {
            method: 'POST',
            body: text
        }).then(handleResponse);
    };
}

export function sendText(text) {
    return function () {
        return fetch(`/echo/${text}`)
            .then(handleResponse)
    };
}