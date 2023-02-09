package com.xzy.web.ajax.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 省份类
 *
 * @author bnt
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Province {
    /**
     * 省份ID
     */
    private Integer proId;
    /**
     * 省份名称
     */
    private String name;
    /**
     * 省份代码
     */
    private String code;
    /**
     * 省份简拼
     */
    private String pinYin;
}
