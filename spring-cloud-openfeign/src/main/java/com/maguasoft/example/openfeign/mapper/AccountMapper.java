package com.maguasoft.example.openfeign.mapper;

import com.maguasoft.example.openfeign.domain.Account;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountMapper {

    Account getAccount(Long id);
}
