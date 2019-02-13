import {LIST_TRANSACTION_REQUEST, LIST_TRANSACTION_SUCCESS, LIST_TRANSACTION_FAILURE} from "./Actions";

const initialState = {
    form: {
        user: '',
        region: ''
    },
    columns: [
        {
            label: "Transaction ID",
            prop: "id",
            width: 180
        },
        {
            label: "Sell Amount",
            prop: "sellAmount",
            width: 180
        },
        {
            label: "Sell Currency",
            prop: "sellCurrency"
        },
        {
            label: "Buy Amount",
            prop: "buyAmount"
        },
        {
            label: "Buy Currency",
            prop: "buyCurrency"
        },
        {
            label: "Transaction Date",
            prop: "createDateTime"
        }
    ],
    data: [],
    isLoading: true,
};

export default function (state = initialState, action) {

    let {payload} = action;


    if (action.type === LIST_TRANSACTION_REQUEST) {
        return {
            ...state,
            isLoading: true,
        }
    }

    if (action.type === LIST_TRANSACTION_SUCCESS) {
        return {
            ...state,
            data: payload.data,
            totalCount: payload.totalCount,
            isLoading: false,
        }
    }

    if (action.type === LIST_TRANSACTION_FAILURE) {
        return {
            ...state,

        }
    }

    return state;

}