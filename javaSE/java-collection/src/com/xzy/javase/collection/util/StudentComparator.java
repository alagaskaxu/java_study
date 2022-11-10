package com.xzy.javase.collection.util;

import com.xzy.javase.collection.entity.Student;

import java.util.Comparator;

/**
 * Comparator泛型接口类
 * 自定义比较器
 * StudentComparator 自定义的学生类的比较器
 */
public class StudentComparator<T> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        if (null == o1 || null == o2)
        {
            throw new IllegalArgumentException("参数不能为空");
        }
        if (!(o1 instanceof Student)||!(o1 instanceof Student))
        {
            throw new IllegalArgumentException("参数必须是Student学生类");
        }
        Student stu1 = (Student) o1;
        Student stu2 = (Student) o2;
        int total1 = stu1.getTotal();   //得到总成绩
        int total2 = stu2.getTotal();
         if(total1>total2){
            return 1;   //返回正数时,排序先排后一个数即先排total2,结果排序从小到大,;
                        // 返回负数,则先排前一个数total1,结果排序从大到小
        }
         if (total1<total2)
        {
            return -1;  //与上面的return符号要相反,表示另一个数(此时为前一个数total1)
        }
        //if(total1 == total2)时要判断是不是同一个对象还是不同对象但总分相同
        if (stu1.hashCode() == stu2.hashCode() && stu1.equals(stu2)){
            //同一个对象
            return 0;  //返回0表示完全相同,不会添加到set里,达到去重效果
        }else{
            //对象不同,总分相同
            return 1;   //选择排总分相同的先排哪个数
        }
    }
}
