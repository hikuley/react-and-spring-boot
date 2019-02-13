package com.settle.go.service;

import com.settle.go.domain.TransactionEntity;
import com.settle.go.model.BaseResponse;
import com.settle.go.model.TransactionCreateRequest;
import com.settle.go.repository.TransactionRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService extends BaseService {


    private TransactionRepository transactionRepository;

    private ModelMapper modelMapper;

    @Autowired
    public TransactionService(TransactionRepository transactionRepository, ModelMapper modelMapper) {
        this.transactionRepository = transactionRepository;
        this.modelMapper = modelMapper;
    }

    public BaseResponse create(TransactionCreateRequest request) {

        TransactionEntity entity = modelMapper.map(request, TransactionEntity.class);

        entity.setBuyAmount(request.getRate() * request.getSellAmount());

        TransactionEntity save = transactionRepository.save(entity);

        return new BaseResponse.Builder()
                .withId(String.valueOf(save.getId()))
                .withSuccess(true)
                .withData(request)
                .withResponseMessage("Transaction created.")
                .withTimestamp(System.currentTimeMillis())
                .build();
    }


    public BaseResponse list(Pageable pageable) {

        Page page = transactionRepository.findAll(pageable);

        List content = page.getContent();

        long totalCount = page.getTotalElements();

        return new BaseResponse.Builder()
                .withSuccess(true)
                .withData(content)
                .withTotalCount(totalCount)
                .withTimestamp(System.currentTimeMillis())
                .build();
    }
}
