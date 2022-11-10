package com.xzy.javase.collection.test;

import com.xzy.javase.collection.entity.Student;
import com.xzy.javase.collection.util.StudentComparator;

import java.util.TreeSet;

public class TestComparator {
    public static void main(String[] args) {
        TreeSet<Student> stuSet = new TreeSet<>(new StudentComparator<Student>());
        //TreeSet<>( Comparator) 可以让set按自定义的比较器排序,而非默认比较
        stuSet.add(new Student("tom","s01",90,80,75));
        stuSet.add(new Student("jack","s02",null,78,75));
        stuSet.add(new Student("cat","s03",92,90,87));
        stuSet.add(new Student("dog","s04",60,86,70));
        stuSet.add(new Student("marry","s05",90,80,75));    //总成绩相同
        stuSet.add(new Student("tom","s01",90,80,75));
        //按照StudentComparator比较器,可能不会去重或去除了多个成绩相同的对象,需要在设置比较器时,完善代码里return 0 的条件
        System.out.println(stuSet); //total从小到大
        System.out.println(stuSet.size());
    }
}
