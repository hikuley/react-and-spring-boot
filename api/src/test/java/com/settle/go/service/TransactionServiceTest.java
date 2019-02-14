package com.settle.go.service;

import com.settle.go.domain.TransactionEntity;
import com.settle.go.model.BaseResponse;
import com.settle.go.model.TransactionCreateRequest;
import com.settle.go.repository.TransactionRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.stubbing.Answer;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
public class TransactionServiceTest {


    @Mock
    private TransactionRepository repository;

    @InjectMocks
    private TransactionService transactionService;


    @Before
    public void setUp() throws Exception {

    }


    @Test
    public void create() {

        Double rate = 5.25;
        Double sellAmount = 100.00;
        String sellCurrency = "USD";
        String buyCurrency = "TRY";

        BigDecimal sellAmountBigDecimal = new BigDecimal(sellAmount);
        BigDecimal rateBigDecimal = new BigDecimal(rate);

        TransactionCreateRequest request = new TransactionCreateRequest(sellAmountBigDecimal, sellCurrency, buyCurrency, rateBigDecimal);

        when(repository.save(any(TransactionEntity.class)))
                .thenAnswer((Answer<TransactionEntity>) invocation -> {
                    TransactionEntity transaction = (TransactionEntity) invocation.getArguments()[0];
                    transaction.setId(1L);
                    return transaction;
                });

        BaseResponse baseResponse = transactionService.create(request);

        assertThat(baseResponse, is(notNullValue()));
        assertThat(baseResponse.getData(), is(notNullValue()));
        assertEquals(((TransactionEntity) baseResponse.getData()).getBuyAmount(), sellAmountBigDecimal.multiply(rateBigDecimal));
    }

    @Test
    public void list() {

        Double sellAmount = 100.00;
        Double buyAmount = 100.00;
        BigDecimal sellAmountBigDecimal = new BigDecimal(sellAmount);
        BigDecimal buyAmountBigDecimal = new BigDecimal(buyAmount);
        String sellCurrency = "USD";
        String buyCurrency = "TRY";

        List all = new LinkedList();
        all.add(new TransactionEntity(sellAmountBigDecimal, sellCurrency, buyAmountBigDecimal, buyCurrency));
        all.add(new TransactionEntity(sellAmountBigDecimal, sellCurrency, buyAmountBigDecimal, buyCurrency));
        all.add(new TransactionEntity(sellAmountBigDecimal, sellCurrency, buyAmountBigDecimal, buyCurrency));
        all.add(new TransactionEntity(sellAmountBigDecimal, sellCurrency, buyAmountBigDecimal, buyCurrency));
        all.add(new TransactionEntity(sellAmountBigDecimal, sellCurrency, buyAmountBigDecimal, buyCurrency));
        all.add(new TransactionEntity(sellAmountBigDecimal, sellCurrency, buyAmountBigDecimal, buyCurrency));
        all.add(new TransactionEntity(sellAmountBigDecimal, sellCurrency, buyAmountBigDecimal, buyCurrency));
        all.add(new TransactionEntity(sellAmountBigDecimal, sellCurrency, buyAmountBigDecimal, buyCurrency));
        all.add(new TransactionEntity(sellAmountBigDecimal, sellCurrency, buyAmountBigDecimal, buyCurrency));
        all.add(new TransactionEntity(sellAmountBigDecimal, sellCurrency, buyAmountBigDecimal, buyCurrency));

        when(repository.findAll()).thenReturn(all);

        List result = (List) transactionService.list(PageRequest.of(0, 3));
        //MOCK ALERT: verify the method was called
        verify(repository).findAll();

    }

}