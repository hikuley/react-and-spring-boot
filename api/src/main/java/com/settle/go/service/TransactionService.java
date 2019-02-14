package com.settle.go.service;

import com.settle.go.domain.TransactionEntity;
import com.settle.go.model.BaseResponse;
import com.settle.go.model.TransactionCreateRequest;
import com.settle.go.repository.TransactionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * This class allows to manage transactions by providing CRUD operations
 */
@Service
public class TransactionService extends BaseService {


    private final Logger log = LoggerFactory.getLogger(TransactionService.class);

    private TransactionRepository transactionRepository;

    @Autowired
    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }


    /**
     * This method usages to create one Transaction record.
     *
     * @param request Transaction request
     * @return BaseResponse
     */

    public BaseResponse create(TransactionCreateRequest request) {

        log.info("Began the transaction create method with a request {}", request);

        TransactionEntity entity = new TransactionEntity(request.getSellAmount(), request.getSellCurrency(), new BigDecimal(0), request.getBuyCurrency());

        BigDecimal sellAmount = request.getSellAmount();

        BigDecimal rate = request.getRate();

        entity.setBuyAmount(sellAmount.multiply(rate));

        log.info("Calculated buy currency:", entity.getBuyAmount());

        TransactionEntity savedTransaction = transactionRepository.save(entity);

        log.info("Finished transaction create method and calculated buy currency and crated a transaction {}", savedTransaction);

        return new BaseResponse.Builder()
                .withId(String.valueOf(savedTransaction.getId()))
                .withSuccess(true)
                .withData(savedTransaction)
                .withResponseMessage("Transaction created.")
                .withTimestamp(System.currentTimeMillis())
                .build();
    }

    /**
     * This method usages to get list of transaction with paging.
     *
     * @param pageable
     * @return BaseResponse
     */

    public BaseResponse list(Pageable pageable) {

        log.info("Began the transaction list method with a request {}", pageable);

        Page page = transactionRepository.findAll(pageable);

        List content = page.getContent();

        long totalCount = page.getTotalElements();

        log.info("Finished the transaction list method.");

        return new BaseResponse.Builder()
                .withSuccess(true)
                .withData(content)
                .withTotalCount(totalCount)
                .withTimestamp(System.currentTimeMillis())
                .build();
    }
}
