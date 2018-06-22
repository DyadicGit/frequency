import React from 'react';
import TextInput from './TextInputComponent';
import {sendText} from './apiActions';

export default class TextInputContainer extends React.Component {
    render() {
        return (
            <TextInput submitAction = {sendText}/>
        );
    }
}