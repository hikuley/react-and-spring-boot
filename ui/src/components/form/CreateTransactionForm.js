import React, {Component} from 'react';

import {Button, Form, Input, Loading, Message, MessageBox} from 'element-react';
import {connect} from "react-redux";

import {rateRequest, transactionRequest} from "../../redux/create-transaction-form/Actions"

class CreateTransactionForm extends Component {

    constructor(props) {
        super(props);

        this.state = {
            form: {
                sourceCurrency: null,
                sellAmount: null,
                buyCurrency: null
            },
            rules: {
                sourceCurrency: [
                    {required: true, message: 'Please input the required', trigger: 'blur'}
                ],
                sellAmount: [
                    {required: true, message: 'Please input the required', trigger: 'blur'},
                    {
                        validator: (rule, value, callback) => {
                            setTimeout(() => {
                                var valid = (value.match(/^-?\d*(\.\d+)?$/));
                                if (!valid) {
                                    callback(new Error('Please input the number'));
                                } else {
                                    callback();
                                }
                            }, 1000);
                        }, trigger: 'change'
                    }

                ],
                buyCurrency: [
                    {required: true, message: 'Please input the required', trigger: 'blur'}
                ]
            }
        };


    }

    componentWillReceiveProps(newProps) {

        let {requestCompleted, response, rateRequestComplete, rateRequestResponse, hasErrorForRateRequest} = newProps.stateTransactionForm;

        if (requestCompleted) {
            Message({
                type: 'success',
                message: response.responseMessage
            });
            this.formReset();
        }

        if (rateRequestComplete) {
            let {data} = rateRequestResponse;
            this.getQuote(data);
        }

        if (hasErrorForRateRequest) {
            Message({
                type: 'info',
                message: rateRequestResponse.responseMessage
            });
        }

    }


    handleSubmit(e) {
        e.preventDefault();
        this.refs.form.validate((valid) => {
            if (valid) {

                this.props.rateRequest({
                    sourceCurrency: this.state.form.sourceCurrency,
                    buyCurrency: this.state.form.buyCurrency,
                });

            } else {
                console.log('error submit!!');
                return false;
            }
        });
    }

    handleReset(e) {
        e.preventDefault();
        this.formReset();
        this.refs.form.resetFields();

    }


    formReset() {
        this.setState(
            {
                form: {
                    sourceCurrency: null,
                    sellAmount: null,
                    buyCurrency: null
                }
            }
        );

    }

    onChange(key, value) {
        this.setState({
            form: Object.assign({}, this.state.form, {[key]: value})
        });
    }

    getQuote(data) {
        let {rate} = data;
        MessageBox.confirm(this.state.form.sourceCurrency.toUpperCase() + ' is ' + rate + ' ' + this.state.form.buyCurrency.toUpperCase() + ' Would you like to create a transaction?', 'Warning', {
            confirmButtonText: 'Yes',
            cancelButtonText: 'No',
            type: 'warning'
        }).then(() => {
            this.props.createTransaction({
                sellAmount: this.state.form.sellAmount,
                sellCurrency: this.state.form.sourceCurrency,
                buyCurrency: this.state.form.buyCurrency,
                rate: rate
            });

        }).catch(() => {
        });
    }

    render() {

        let {isLoading} = this.props.stateTransactionForm;

        return (

            <Loading loading={isLoading}>

                <Form inline={true} ref="form" model={this.state.form} rules={this.state.rules} labelWidth="150" className="custom-form">
                    <Form.Item label="Sell Amount" prop="sellAmount">
                        <Input type="text" value={this.state.form.sellAmount} onChange={this.onChange.bind(this, 'sellAmount')} autoComplete="off"/>
                    </Form.Item>
                    <Form.Item label="Source Currency" prop="sourceCurrency">
                        <Input type="text" value={this.state.form.sourceCurrency} onChange={this.onChange.bind(this, 'sourceCurrency')} autoComplete="off"/>
                    </Form.Item>
                    <Form.Item label="Buy Currency" prop="buyCurrency">
                        <Input type="text" value={this.state.form.buyCurrency} onChange={this.onChange.bind(this, 'buyCurrency')} autoComplete="off"/>
                    </Form.Item>
                    <Form.Item>
                        <Button type="primary" onClick={this.handleSubmit.bind(this)}>Get Quote</Button>
                        <Button onClick={this.handleReset.bind(this)}>Reset</Button>
                    </Form.Item>
                </Form>

            </Loading>
        )
    }

}

const bindAction = (dispatch) => {
    return {
        createTransaction: (request) => dispatch(transactionRequest(request)),
        rateRequest: (request) => dispatch(rateRequest(request))
    }
};

const mapStateToProps = state => ({
    stateTransactionForm: state.createTransactionReducer
});


export default connect(mapStateToProps, bindAction)(CreateTransactionForm);