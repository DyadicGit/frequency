import FileInput from './FileInputComponent';

import React, { Component } from "react";
import TextInput from "./TextInputContainer";

export default class App extends Component {
    render () {
        return (
            <div>
                <FileInput/>
                <TextInput/>
            </div>
        );
    }
}