package com.xzy.orm.util;

import cn.hutool.core.util.StrUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 查询条件包装类,用来拼接SQL语句中where片段
 */
public class QueryWrapper {
    //where条件数量
    private int limits = 0;

    //拼接查询条件
    private StringBuffer sqlBuf = new StringBuffer();
    /**
     * 查询条件参数值
     */
    private List<Object> paramList = new ArrayList<>();

    /**
     * 添加or
     *
     * @return
     */
    public QueryWrapper or() {
        String whereSql = sqlBuf.toString();
        whereSql = StrUtil.cleanBlank(whereSql);
        if (whereSql.endsWith("where") || whereSql.endsWith("or") || whereSql.endsWith("and")) {
            return this;
        }
        sqlBuf.append(appendBlankAround("or"));
        return this;
    }

    /**
     * 添加左边圆括号
     *
     * @return
     */
    public QueryWrapper op() {
        setAndKeyword();
        sqlBuf.append('(');
        return this;
    }

    /**
     * 添加右边圆括号
     *
     * @return
     */
    public QueryWrapper cp() {
        sqlBuf.append(')');
        return this;
    }

    /**
     * 升序
     *
     * @param columnNames 排序字段名数组
     * @return
     */
    public QueryWrapper asc(String... columnNames) {
        sqlBuf.append(appendBlankAround("order by"));
        for (String columnName : columnNames) {
            sqlBuf.append(columnName);
            sqlBuf.append(',');
        }
        //删除最后一个逗号
        sqlBuf.deleteCharAt(sqlBuf.length() - 1);
        sqlBuf.append(appendBlankAround("desc"));
        return this;
    }

    /**
     * 降序
     *
     * @param columnNames 排序字段名数组
     * @return
     */
    public QueryWrapper desc(String... columnNames) {
        sqlBuf.append(appendBlankAround("order by"));
        for (String columnName : columnNames) {
            sqlBuf.append(columnName);
            sqlBuf.append(',');
        }
        //删除最后一个逗号
        sqlBuf.deleteCharAt(sqlBuf.length() - 1);
        sqlBuf.append(appendBlankAround("desc"));
        return this;
    }

    /**
     * 大于
     *
     * @param columnName
     * @param columnValue
     * @return
     */
    public QueryWrapper gt(String columnName, int columnValue) {
        setAndKeyword();
        sqlBuf.append(columnName);
        sqlBuf.append(appendBlankAround(">"));
        sqlBuf.append('?');
        paramList.add(columnValue);
        limits++;
        return this;
    }

    /**
     * 大于等于
     *
     * @param columnName
     * @param columnValue
     * @return
     */
    public QueryWrapper ge(String columnName, int columnValue) {
        setAndKeyword();
        sqlBuf.append(columnName);
        sqlBuf.append(appendBlankAround(">="));
        sqlBuf.append('?');
        paramList.add(columnValue);
        limits++;
        return this;
    }

    /**
     * 小于
     *
     * @param columnName
     * @param columnValue
     * @return
     */
    public QueryWrapper lt(String columnName, int columnValue) {
        setAndKeyword();
        sqlBuf.append(columnName);
        sqlBuf.append(appendBlankAround("<"));
        sqlBuf.append('?');
        paramList.add(columnValue);
        limits++;
        return this;
    }

    /**
     * 小于等于
     *
     * @param columnName
     * @param columnValue
     * @return
     */
    public QueryWrapper le(String columnName, int columnValue) {
        setAndKeyword();
        sqlBuf.append(columnName);
        sqlBuf.append(appendBlankAround("<="));
        sqlBuf.append('?');
        paramList.add(columnValue);
        limits++;
        return this;
    }

    /**
     * 不等于
     *
     * @param columnName
     * @param columnValue
     * @return
     */
    public QueryWrapper ne(String columnName, Object columnValue) {
        setAndKeyword();
        sqlBuf.append(columnName);
        sqlBuf.append(appendBlankAround("<>"));
        sqlBuf.append('?');
        paramList.add(columnValue);
        limits++;
        return this;
    }

    /**
     * 相等
     *
     * @param columnName
     * @param columnValue
     * @return
     */
    public QueryWrapper eq(String columnName, Object columnValue) {
        setAndKeyword();
        sqlBuf.append(columnName);
        sqlBuf.append(appendBlankAround("="));
        sqlBuf.append('?');
        paramList.add(columnValue);
        limits++;
        return this;
    }

    /**
     * 判断字段值为null
     *
     * @param columnName
     * @return
     */
    public QueryWrapper isNUll(String columnName) {
        setAndKeyword();
        sqlBuf.append(appendBlankAround(columnName));
        sqlBuf.append("is null");
        return this;
    }

    /**
     * 不等于
     *
     * @param columnName
     * @param columnValue
     * @return
     */
    public QueryWrapper like(String columnName, String columnValue) {
        setAndKeyword();
        sqlBuf.append(columnName);
        sqlBuf.append(appendBlankAround("like"));
        sqlBuf.append("'%");
        sqlBuf.append(columnValue);
        sqlBuf.append("%'");
        limits++;
        return this;
    }

    /**
     * 添加where语句SQL片段,支持占位符
     *
     * @param wherePart
     * @param params
     * @return
     */
    public QueryWrapper appendWherePart(String wherePart, Object... params) {
        setAndKeyword();
        sqlBuf.append(' ');
        sqlBuf.append(wherePart);
        for (Object param : params) {
            paramList.add(param);
        }
        limits++;
        return this;
    }

    /**
     * between:在两个数值之间
     *
     * @param columnName 字段名称
     * @param min        最大值
     * @param max        最小值
     * @return
     */
    public QueryWrapper between(String columnName, Number min, Number max) {
        setAndKeyword();
        sqlBuf.append(columnName);
        sqlBuf.append(appendBlankAround("between"));
        sqlBuf.append('?');
        sqlBuf.append(appendBlankAround("and"));
        sqlBuf.append("?");
        paramList.add(min);
        paramList.add(max);
        limits++;
        return this;
    }

    /**
     * 设置and关键字
     */
    private void setAndKeyword() {
        //第1个条件前面无需加and
        if (0 == limits) {
            return;
        }
        String whereSql = sqlBuf.toString().trim();
        whereSql = StrUtil.cleanBlank(whereSql);
        //and前面不可以出现 and、or、左边圆括号(
        if (whereSql.endsWith("or") || whereSql.endsWith("and") || whereSql.endsWith("(")) {
            return;
        }
        sqlBuf.append(appendBlankAround("and"));
    }


    /**
     * 在字符串左右两边添加空格
     *
     * @param str
     * @return
     */
    private final static String appendBlankAround(String str) {
        if (StrUtil.isEmpty(str)) {
            return str;
        }
        if (StrUtil.isBlank(str)) {
            return str;
        }
        //清除右边所有空格
        str = StrUtil.trimEnd(str);
        return ' ' + str + ' ';
    }

    /**
     * 在字符串左边添加空格
     *
     * @param str
     * @return
     */
    private final static String appendBlankLeft(String str) {
        if (StrUtil.isEmpty(str)) {
            return str;
        }
        if (StrUtil.isBlank(str)) {
            return str;
        }
        //清除原有空格
        str = StrUtil.cleanBlank(str);
        return ' ' + str;
    }

    /**
     * 在字符串右边添加空格
     *
     * @param str
     * @return
     */
    private final static String appendBlankRight(String str) {
        if (StrUtil.isEmpty(str)) {
            return str;
        }
        if (StrUtil.isBlank(str)) {
            return str;
        }
        //清除原有空格
        str = StrUtil.cleanBlank(str);
        return str + ' ';
    }

    /**
     * 获取where语句占位符参数值数组
     *
     * @return
     */
    public Object[] getParams() {
        return paramList.toArray();
    }

    /**
     * 获取SQL语句中where语句片段
     *
     * @return
     */
    public String getWherePart() {
        String wherePart = sqlBuf.toString();
        if (limits > 0) {
            //当存在条件时,添加where关键字
            wherePart = appendBlankAround("where") + wherePart;
        }
        return wherePart;
    }

}
