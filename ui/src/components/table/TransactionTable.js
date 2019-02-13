import React, {Component} from 'react';
import {Loading, Pagination, Table} from "element-react";
import {connect} from "react-redux";
import {listTransactionRequest} from "../../redux/table-transaction/Actions";

class TransactionTable extends Component {

    constructor(props) {
        super(props);
        this.state = {}
    }

    componentWillMount() {
        this.paging(1);
    }

    paging(index) {
        this.props.getList({
            page: index - 1,
            sort: "id,desc"
        });
    }

    render() {
        let {columns, data, totalCount, isLoading} = this.props.stateTransactionTable;

        return (
            <Loading loading={isLoading}>
                <Table
                    style={{width: '100%'}}
                    columns={columns}
                    data={data}
                />
                <Pagination onCurrentChange={this.paging.bind(this)} layout="prev, pager, next" total={totalCount} small={false} className="custom-pagination"/>
            </Loading>
        )
    }
}

const bindAction = (dispatch) => {
    return {
        getList: (request) => dispatch(listTransactionRequest(request))
    }
};

const mapStateToProps = state => ({
    stateTransactionTable: state.tableTransactionReducer
});


export default connect(mapStateToProps, bindAction)(TransactionTable);