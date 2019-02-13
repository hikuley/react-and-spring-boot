package com.settle.go.controller;

import com.settle.go.model.BaseResponse;
import com.settle.go.model.TransactionCreateRequest;
import com.settle.go.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/transaction")
public class TransactionRestController extends BaseController {

    private TransactionService transactionService;

    @Autowired
    public TransactionRestController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping("/create")
    public BaseResponse create(@RequestBody TransactionCreateRequest transactionCreateRequest) {
        return transactionService.create(transactionCreateRequest);
    }

    @GetMapping("/list")
    public BaseResponse list(@PageableDefault(value = 10, page = 0) Pageable pageable) {
        return transactionService.list(pageable);
    }

}
