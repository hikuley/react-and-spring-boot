package com.settle.go.service;

import com.settle.go.model.BaseResponse;
import com.settle.go.model.RateRequest;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;


@RunWith(SpringRunner.class)
public class ExchangeServiceTest {


    @InjectMocks
    private ExchangeService exchangeService;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void rate() {
        String sourceCurrency = "USD";

        String buyCurrency = "TRY";

        RateRequest rateRequest = new RateRequest(sourceCurrency, buyCurrency);

        BaseResponse baseResponse = exchangeService.rate(rateRequest);

        assertThat(baseResponse, is(notNullValue()));
    }
}