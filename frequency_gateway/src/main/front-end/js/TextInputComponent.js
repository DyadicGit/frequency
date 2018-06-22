import React from 'react';
import PropTypes from 'prop-types';

export default class TextInputComponent extends React.Component {
    constructor(props) {
        super(props);
        this.handleSubmit = this.handleSubmit.bind(this);
    }
    handleSubmit(event) {
        event.preventDefault();
        this.props.submitAction(this.textInput)
    }

    render() {
        return (
            <form onSubmit={this.handleSubmit}>
                <label>
                    Input text:
                    <input
                        type="text"
                        ref={input => {
                            this.textInput = input;
                        }}
                    />
                </label>
                <button type="submit">Send</button>
            </form>
        );
    }
}

TextInputComponent.propTypes = {
    submitAction: PropTypes.func.isRequired,
};