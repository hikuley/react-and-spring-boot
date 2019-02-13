import React, {Component} from 'react';
import {connect} from "react-redux";

import {Layout} from 'element-react';
import CreateTransactionForm from "../components/form/CreateTransactionForm";
import TransactionTable from "../components/table/TransactionTable";

class MainPage extends Component {

    render() {
        return (
            <div className="main-container">
                <Layout.Row>
                    <h4>Foreign Exchange</h4>
                    <CreateTransactionForm/>
                </Layout.Row>
                <Layout.Row>
                    <h4>Transactions</h4>
                    <TransactionTable/>
                </Layout.Row>
            </div>
        )
    }
}

const bindAction = (dispatch) => {
    return {}
};

const mapStateToProps = state => ({});

export default connect(mapStateToProps, bindAction)(MainPage);
