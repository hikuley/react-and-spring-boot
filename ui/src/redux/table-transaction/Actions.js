export const LIST_TRANSACTION_REQUEST = "LIST_TRANSACTION_REQUEST";
export const LIST_TRANSACTION_SUCCESS = "LIST_TRANSACTION_SUCCESS";
export const LIST_TRANSACTION_FAILURE = "LIST_TRANSACTION_FAILURE";


export const listTransactionRequest = (data) => ({
    type: LIST_TRANSACTION_REQUEST,
    payload: data
});

export const listTransactionSuccess = (data) => ({
    type: LIST_TRANSACTION_SUCCESS,
    payload: data
});

export const listTransactionFailure = (data) => ({
    type: LIST_TRANSACTION_FAILURE,
    payload: data
});