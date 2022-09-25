/*
* 类class的定义:
* 三个常见成员:
* 属性field, 负责静态特征(数据)
* 方法method, 负责动态行为(对数据的操作)
* 构造器constru, 负责初始化对象
 */

//学生类
public class student
{
    //学生类的属性,静态特征(数据),也叫成员变量,java会使用默认的值对属性进行初始化
    int id; //学号
    String name;    //学号
    int age;    //年龄
    int score;  //成绩
    /*
    成员变量java会设初值
    整形初值为 0
    浮点型初值为 0.0
    字符型初值为 '\u0000'
    布尔型初值为 false
    所有引用类型为 null
     */
    //方法(动态行为) 对数据的操作
    public void study()
    {
        System.out.println(name+",正在学习");
    }

    //main方法是程序的入口,程序运行从main方法开始
    public static void main(String[] args)
    {
        //用类(class)来创建对象(object)
        student stu01 = new student();  //stu01 的类型叫student,student就叫引用类型
        student stu02 = new student();  //student类就类似一个模板,利用这个模板可以创造很多一样属性的对象,而各自属性的值可以不一样
        stu01.id = 100001;      //各自属性的值可以单独设置
        stu02.id = 100002;
        stu01.name = "徐xx";
        stu01.age = 22;
        stu01.score = 100;
        stu02.name = "java";
        stu02.age = 18;
        stu02.score = 99;

        //调用student类里的方法,会使用对象自己的属性
        stu01.study();
        stu02.study();

    }

}
