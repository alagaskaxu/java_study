package com.xzy.javase.collection.entity;

/**
 * 学生实体类
 */
public class Student {
    /**
     * 姓名
     */
    private String name;
    /**
     * 学号
     */
    private String stuCode;
    /**
     * java成绩
     */
    private Integer javaScore;
    /**
     * c成绩
     */
    private Integer cScore;
    /**
     * python成绩
     */
    private Integer pythonScore;

    public Student() {
    }

    public Student(String name, String stuCode, Integer javaScore, Integer cScore, Integer pythonScore) {
        this.name = name;
        this.stuCode = stuCode;
        this.javaScore = javaScore;
        this.cScore = cScore;
        this.pythonScore = pythonScore;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStuCode() {
        return stuCode;
    }

    public void setStuCode(String stuCode) {
        this.stuCode = stuCode;
    }

    public Integer getJavaScore() {
        return javaScore;
    }

    public void setJavaScore(Integer javaScore) {
        this.javaScore = javaScore;
    }

    public Integer getcScore() {
        return cScore;
    }

    public void setcScore(Integer cScore) {
        this.cScore = cScore;
    }

    public Integer getPythonScore() {
        return pythonScore;
    }

    public void setPythonScore(Integer pythonScore) {
        this.pythonScore = pythonScore;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", stuCode='" + stuCode + '\'' +
                ", javaScore=" + javaScore +
                ", cScore=" + cScore +
                ", pythonScore=" + pythonScore +
                ", totalScore="+this.getTotal()+
                '}';
    }

    //重写hashcode和equals方法,来研究set如何判断元素重复
    @Override
    public int hashCode() {
        return this.toString().hashCode();  //返回学生对象的字符串的hashCode,字符串相同则hashCode值是一样的
    }

    @Override
    public boolean equals(Object obj) {
        if (null == obj)
        {
            return false;
        }
        if (!(obj instanceof Student)) //instanceof 判断将比较的obj是否是学生类
        {
            return false;
        }
        //转成Student类
        Student stu = (Student) obj;
        //将当前学生对象与传入的学生对象进行比较,比较其属性的值是否相同,可以只比几个特别的值
        return this.toString().equals(stu.toString());
    }

    public int getTotal()
    {
        int total = 0;
        total+= null==javaScore?0:javaScore;
        total+= null==cScore?0:cScore;
        total+= null==pythonScore?0:pythonScore;
        return total;
    }
}
