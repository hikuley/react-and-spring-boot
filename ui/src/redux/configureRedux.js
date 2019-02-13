import {applyMiddleware, combineReducers, createStore} from 'redux';

import createSagaMiddleware from 'redux-saga'
import configSaga from "../saga/configSaga";
import createTransactionReducer from "../redux/create-transaction-form/Reducer";
import tableTransactionReducer from "../redux/table-transaction/Reducer";

const reducers = combineReducers({
    createTransactionReducer: createTransactionReducer,
    tableTransactionReducer: tableTransactionReducer
});


const sagaMiddleware = createSagaMiddleware();

const store = createStore(reducers, applyMiddleware(sagaMiddleware));

sagaMiddleware.run(configSaga);

export default store;