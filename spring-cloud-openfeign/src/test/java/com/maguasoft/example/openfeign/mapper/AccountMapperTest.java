package com.maguasoft.example.openfeign.mapper;

import com.maguasoft.example.openfeign.domain.Account;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class AccountMapperTest {

    @Autowired
    private AccountMapper accountMapper;

    @Test
    public void testGet() {
        Account account = accountMapper.getAccount(1L);
        log.info("{}", account);
    }

    // save
    // saveOrUpdate
    // getBy(Long id)
    // removeBy(Long id)
    // T query(Query query);
    //
}
