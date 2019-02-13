import ExchangeSaga from "./ExchangeSaga";

const configSaga = function* configurationSaga() {
    yield [ExchangeSaga()];
};
export default configSaga;