import {call, put, takeLatest} from 'redux-saga/effects';
import exchangeApi from "./ExchangeApi";
import {RATE_REQUEST, rateFailure, rateSuccess, TRANSACTION_REQUEST, transactionFailure, transactionSuccess} from "../redux/create-transaction-form/Actions";
import {LIST_TRANSACTION_REQUEST, listTransactionFailure, listTransactionRequest, listTransactionSuccess} from "../redux/table-transaction/Actions";
import {delay} from 'redux-saga';

const createTransactionRequest = function* (action) {
    const request = action.payload;

    const response = yield call(exchangeApi.createTransaction, request);
    const {success, responseMessage} = response;

    yield delay(1000);

    if (success) {
        yield put(transactionSuccess(response));
        yield put(listTransactionRequest({page: 0, sort: "id,desc"}));
    }
    else {
        yield put(transactionFailure(response));
    }
};

const getTransactionListRequest = function* (action) {
    const request = action.payload;

    const response = yield call(exchangeApi.getTransactionList, request);
    const {success} = response;

    yield delay(2000);

    if (success) {
        yield put(listTransactionSuccess(response));
    }
    else {
        yield put(listTransactionFailure(response));
    }
};

const getRateRequest = function* (action) {
    const request = action.payload;

    const response = yield call(exchangeApi.rateRequest, request);

    const {success} = response;

    yield delay(2000);

    if (success) {
        yield put(rateSuccess(response));
    }
    else {
        yield put(rateFailure(response));
    }

};

const ExchangeSaga = function* () {
    yield takeLatest(TRANSACTION_REQUEST, createTransactionRequest);
    yield takeLatest(LIST_TRANSACTION_REQUEST, getTransactionListRequest);
    yield takeLatest(RATE_REQUEST, getRateRequest);
};

export default ExchangeSaga;