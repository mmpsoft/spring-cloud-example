package com.maguasoft.example.openfeign.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@TableName("cars")
public class Cars {
    private Long id;
    private String status;
}
