import React from 'react';
import PropTypes from 'prop-types';
import TextInput from './TextInputComponent';
import {sendText} from './apiActions';

export default class TextInputContainer extends React.Component {
    render() {
        return (
            <TextInput submitAction = {sendText}/>
        );
    }
}
TextInputContainer.propTypes = {
    submitAction: PropTypes.func.isRequired,
};