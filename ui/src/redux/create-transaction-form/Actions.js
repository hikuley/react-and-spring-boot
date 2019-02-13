export const TRANSACTION_REQUEST = "TRANSACTION_REQUEST";
export const TRANSACTION_SUCCESS = "TRANSACTION_SUCCESS";
export const TRANSACTION_FAILURE = "TRANSACTION_FAILURE";

export const RATE_REQUEST = "RATE_REQUEST";
export const RATE_SUCCESS = "RATE_SUCCESS";
export const RATE_FAILURE = "RATE_FAILURE";


export const transactionRequest = (data) => ({
    type: TRANSACTION_REQUEST,
    payload: data
});

export const transactionSuccess = (data) => ({
    type: TRANSACTION_SUCCESS,
    payload: data
});

export const transactionFailure = (data) => ({
    type: TRANSACTION_FAILURE,
    payload: data
});

export const rateRequest = (data) => ({
    type: RATE_REQUEST,
    payload: data
});

export const rateSuccess = (data) => ({
    type: RATE_SUCCESS,
    payload: data
});

export const rateFailure = (data) => ({
    type: RATE_FAILURE,
    payload: data
});

