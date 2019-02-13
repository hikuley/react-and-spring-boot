import {TRANSACTION_REQUEST, TRANSACTION_SUCCESS, TRANSACTION_FAILURE, RATE_REQUEST, RATE_SUCCESS, RATE_FAILURE} from "./Actions";

const initialState = {
    response: null,
    requestCompleted: false,
    form: {
        sourceCurrency: null,
        sellAmount: null,
        buyCurrency: null
    },

    //Rate Request
    rateRequestComplete: false,
    rateRequestResponse: null,
    hasErrorForRateRequest: false,
    isLoading: false
};

export default function (state = initialState, action) {

    let {payload} = action;


    if (action.type === TRANSACTION_REQUEST) {
        return {
            ...state,
            requestCompleted: false,
            rateRequestComplete: false,
        }
    }

    if (action.type === TRANSACTION_SUCCESS) {
        return {
            ...state,
            response: payload,
            requestCompleted: true,
            rateRequestComplete: false,
        }
    }

    if (action.type === TRANSACTION_FAILURE) {
        return {
            ...state,
            rateRequestComplete: false,
        }
    }

    //Rate Request state

    if (action.type === RATE_REQUEST) {
        return {
            ...state,
            rateRequestComplete: false,
            hasErrorForRateRequest: false,
            rateRequestResponse: null,
            response: null,
            requestCompleted: false,
            isLoading: true
        }
    }

    if (action.type === RATE_SUCCESS) {
        return {
            ...state,
            hasErrorForRateRequest: false,
            rateRequestComplete: true,
            rateRequestResponse: payload,
            isLoading: false
        }
    }

    if (action.type === RATE_FAILURE) {
        return {
            ...state,
            hasErrorForRateRequest: true,
            rateRequestComplete: false,
            rateRequestResponse: payload,
            isLoading: false
        }
    }


    return state;

}