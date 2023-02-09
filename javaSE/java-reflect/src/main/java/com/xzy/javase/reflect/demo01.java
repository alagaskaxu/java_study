package com.xzy.javase.reflect;



import com.xzy.javase.entity.Emp;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class demo01 {
    public static void main(String[] args) {
        Class<Emp> empClass = Emp.class;
        Emp emp = new Emp();
        Class<? extends Emp> empClass1 = emp.getClass();
        System.out.println(empClass.getPackage().getName());
        System.out.println(empClass.getName());

        //属性
        Field []fields = empClass.getFields();  //获取所有public修饰的属性
        for (Field field:fields){
            //属性名称
            System.out.println(field.getName());
        }
        fields = empClass.getDeclaredFields();  //获取所有属性
        for (Field field:fields){
            //属性名称
            System.out.println(field.getName());
        }
        System.out.println("============");
        //获取public修饰的方法
        Method[] methods = empClass.getMethods();
        for (Method method:methods)
        {
            System.out.println(method.getName());
        }
        System.out.println("==========================");
        //获取父类名称
        System.out.println(empClass.getSuperclass().getName());
        System.out.println("-----");
        //获取所有实现接口class数组
        Class[] interClasses = empClass.getInterfaces();
        for (Class interClass:interClasses){
            System.out.println(interClass.getName());
        }
        //获取基本数据类型class对象
        System.out.println(int.class.getName());
        //获取数组class对象
        int[] i= {1,2,3};
        System.out.println(i.getClass().getName());
        System.out.println(i.getClass().isArray());
        System.out.println(new Object().getClass().isArray());
        Class<Emp> empClass2 = Emp.class;
        System.out.println(empClass==empClass2);
        System.out.println(empClass==empClass1);
        System.out.println(empClass1==empClass2);

        try {
            //动态创建对象
            Emp emp1 = empClass.newInstance();
            System.out.println(emp1);
            //动态调用方法
            Method m = empClass.getMethod("setDepId", Integer.class);
            m.invoke(emp1,10);
            //调用私有方法
            Method m1 = empClass.getDeclaredMethod("setDepId", Integer.class,Integer.class);
            m1.setAccessible(true); //允许调用私有方法
            m1.invoke(emp1,10,20);
            //获取字段值
            emp1.setEmpName("小明");
            Field f = empClass.getDeclaredField("empName");
            System.out.println(f.getName());
            //属性的类型
            System.out.println(f.getType().getName());
            //获取属性值
            f.setAccessible(true);  //允许查看私有属性
            System.out.println(f.get(emp1));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
