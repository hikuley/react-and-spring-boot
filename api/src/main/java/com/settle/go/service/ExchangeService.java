package com.settle.go.service;

import com.settle.go.exception.BaseException;
import com.settle.go.model.BaseResponse;
import com.settle.go.model.Rate;
import com.settle.go.model.RateQueryResponse;
import com.settle.go.model.RateRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import static com.settle.go.Constants.API_URL;

@Service
public class ExchangeService extends BaseService {

    private final Logger log = LoggerFactory.getLogger(ExchangeService.class);

    /*
     *  This method usages to get the currency rate from external REST api.
     *
     * */

    public BaseResponse rate(RateRequest rateRequest) throws BaseException {

        log.info("Began the exchange rate method with a request {}", rateRequest);

        final String sourceCurrency = rateRequest.getSourceCurrency().toUpperCase();
        final String buyCurrency = rateRequest.getBuyCurrency().toUpperCase();

        Map<String, String> vars = new HashMap<>();
        vars.put("source", sourceCurrency);
        vars.put("currency", buyCurrency);


        RestTemplate restTemplate = new RestTemplate();

        String url = API_URL + "&currencies={currency}&source={source}&format=1";

        log.info("Called external api with a url:", url);

        RateQueryResponse response = restTemplate.getForObject(url, RateQueryResponse.class, vars);

        log.info("External api response. {}", response);

        if (!response.isSuccess())
            throw new BaseException(response.getError().getInfo());

        Map.Entry<String, Double> responseRate = response.getQuotes().entrySet().iterator().next();

        BigDecimal rateValue = BigDecimal.valueOf(responseRate.getValue());

        Rate rate = new Rate(sourceCurrency, rateValue);

        log.info("Finished the exchange rate method and calculated a rate {}", rate);

        return new BaseResponse.Builder()
                .withSuccess(true)
                .withData(rate)
                .withTimestamp(System.currentTimeMillis())
                .build();
    }


}
