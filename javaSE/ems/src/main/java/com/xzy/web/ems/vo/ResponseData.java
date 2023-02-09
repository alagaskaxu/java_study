package com.xzy.web.ems.vo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * JSON数据结构
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseData implements Serializable {
    /**
     * 等于0:正常 大于0:业务性错误 小于0:程序运行异常
     */
    private int status = 0;
    /**
     * 错误信息:status小于0 或大于0时存在
     */
    private String message;
    /**
     * 请求成功时,返回请求相关的数据信息,仅当status=0时存在
     */
    private Object data;

    public ResponseData(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public ResponseData(Object data) {
        this.data = data;
    }

    /**
     * 成功
     *
     * @param data
     * @return
     */
    public final static ResponseData SUCCESS(Object data) {
        return new ResponseData(data);
    }

    /**
     * 失败
     *
     * @param status
     * @param message
     * @return
     */
    public final static ResponseData FAIL(int status, String message) {
        return new ResponseData(status, message);
    }

}
