package com.fc.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultVo<T> {
    //请求id
    private String requestId;

    //操作人
    private String operator;

    //时间戳
    private Long timestamp;

    //状态码
    private String code;

    //返回的信息
    private String info;

    //对象
    private T data;
}

