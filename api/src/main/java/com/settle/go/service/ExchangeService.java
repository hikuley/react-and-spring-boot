package com.settle.go.service;

import com.settle.go.exception.BaseException;
import com.settle.go.model.BaseResponse;
import com.settle.go.model.Rate;
import com.settle.go.model.RateQueryResponse;
import com.settle.go.model.RateRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

import static com.settle.go.Constants.API_URL;

@Service
public class ExchangeService extends BaseService {


    public BaseResponse rate(RateRequest rateRequest) throws BaseException {

        final String sourceCurrency = rateRequest.getSourceCurrency().toUpperCase();
        final String buyCurrency = rateRequest.getBuyCurrency().toUpperCase();

        Map<String, String> vars = new HashMap<>();
        vars.put("source", sourceCurrency);
        vars.put("currency", buyCurrency);


        RestTemplate restTemplate = new RestTemplate();
        RateQueryResponse response = restTemplate.getForObject(API_URL + "&currencies={currency}&source={source}&format=1", RateQueryResponse.class, vars);

        if (!response.isSuccess())
            throw new BaseException(response.getError().getInfo());

        Map.Entry<String, Double> responseRate = response.getQuotes().entrySet().iterator().next();
        Double rateValue = responseRate.getValue();

        return new BaseResponse.Builder()
                .withSuccess(true)
                .withData(new Rate(sourceCurrency, rateValue))
                .withTimestamp(System.currentTimeMillis())
                .build();
    }


}
