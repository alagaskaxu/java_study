package com.xzy.web.ajax.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 城市类
 *
 * @author bnt
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class City {
    /**
     * 城市ID
     */
    private Integer cityId;
    /**
     * 省份ID
     */
    private Integer proId;
    /**
     * 城市名称
     */
    private String name;
    /**
     * 城市代码
     */
    private String code;
    /**
     * 城市简拼
     */
    private String pinYin;
}
