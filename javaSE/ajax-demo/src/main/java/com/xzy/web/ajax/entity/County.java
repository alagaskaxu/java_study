package com.xzy.web.ajax.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


/**
 * 县级市、区
 *
 * @author luliujun
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class County {
    /**
     * 县/区ID
     */
    private Integer countyId;
    /**
     * 县ID
     */
    private Integer cityId;
    /**
     * 县名称
     */
    private String name;
    /**
     * 县代码
     */
    private String code;
    /**
     * 县简拼
     */
    private String pinYin;


}
