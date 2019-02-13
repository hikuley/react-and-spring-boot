import HttpRequest from "../util/HttpRequest";

class ExchangeApi {

    constructor() {
        this.httpRequest = new HttpRequest();
    }

    createTransaction = (data) => {
        return this.httpRequest.fetch({
            path: "/transaction/create",
            method: "POST",
            body: data
        });
    };

    getTransactionList = (params) => {
        return this.httpRequest.fetch({
            path: "/transaction/list",
            method: "GET",
            params: params
        });
    };

    rateRequest = (params) => {
        return this.httpRequest.fetch({
            path: "/exchange/rate",
            method: "GET",
            params: params
        });
    };

}

export default new ExchangeApi();