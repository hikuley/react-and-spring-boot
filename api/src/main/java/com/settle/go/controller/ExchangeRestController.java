package com.settle.go.controller;

import com.settle.go.model.BaseResponse;
import com.settle.go.model.RateRequest;
import com.settle.go.service.ExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/exchange")
public class ExchangeRestController extends BaseController {

    private ExchangeService exchangeService;

    @Autowired
    public ExchangeRestController(ExchangeService exchangeService) {
        this.exchangeService = exchangeService;
    }

    @GetMapping("/rate")
    public BaseResponse rate(RateRequest rateRequest) {
        return exchangeService.rate(rateRequest);
    }

}
