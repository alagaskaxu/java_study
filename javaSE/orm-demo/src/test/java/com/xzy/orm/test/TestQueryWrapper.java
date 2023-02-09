package com.xzy.orm.test;

import com.xzy.orm.util.QueryWrapper;
import org.junit.Test;

import java.util.Arrays;

/**
 * 测试打包查询条件
 */
public class TestQueryWrapper {

    /**
     * 查询条件模拟
     * 测试等于、不等于、大于、小于、大于小于、小于等于
     */
    @Test
    public void test01() {
        QueryWrapper qw = new QueryWrapper();
        //部门ID为10
        qw.eq("dep_id", 10);
        //年龄大于等于24
        qw.ge("age", 24);
        //月薪大于5000
        qw.gt("salary", 5000);
        //月薪小于10000
        qw.lt("salary", 10000);
        //性别为男
        qw.eq("sex", "男");
        //身高小于等于180
        qw.le("height",180);
        //sql语句片段
        System.out.println(qw.getWherePart());
        //占位符参数值数组
        System.out.println(Arrays.toString(qw.getParams()));
    }

    /**
     * 测试or,圆括号
     */
    @Test
    public void test03() {
        QueryWrapper qw = new QueryWrapper();
        qw.op();
        //订单状态等于1
        qw.eq("state", 1);
        qw.or();
        //订单状态等于2
        qw.eq("state", 2);
        qw.or();
        //订单状态等于3
        qw.eq("state", 3);
        qw.cp();
        //sql语句片段
        System.out.println(qw.getWherePart());
        //占位符参数值数组
        System.out.println(Arrays.toString(qw.getParams()));
    }

    /**
     *  测试like、排序
     */
    @Test
    public void test02(){
        QueryWrapper qw = new QueryWrapper();
        qw.like("name","明");

        //查询条件模拟:根据姓名、项目组ID、部门ID降序
        qw.asc("name","group_id","dep_id");
        //sql语句片段
        System.out.println(qw.getWherePart());
        //占位符参数值数组
        System.out.println(Arrays.toString(qw.getParams()));
    }

    /**
     * 测试字段值为null
     */
    @Test
    public  void test04(){
        QueryWrapper qw = new QueryWrapper();
        qw.isNUll("dep_name");
        //sql语句片段
        System.out.println(qw.getWherePart());
        //占位符参数值数组
        System.out.println(Arrays.toString(qw.getParams()));
    }

    /**
     * 设置手动添加条件
     */
    @Test
    public  void test05(){
        QueryWrapper qw = new QueryWrapper();
        qw.appendWherePart("(state=? or state=?)",1,2);
        qw.appendWherePart("user_id=?",1);
        //sql语句片段
        System.out.println(qw.getWherePart());
        //占位符参数值数组
        System.out.println(Arrays.toString(qw.getParams()));
    }
}
