public class javaStudent
{
    int id;
    String sname;
    int age;
    computer computer;
    void study()
    {
        System.out.println("我正在学习,使用的电脑是: " + computer.brand);

    }

    public static void main(String[] args) {
        computer c1 = new computer();
        c1.brand = "联想";
        c1.price = 6000;
        computer c2 = new computer();
        c2.brand = "戴尔";
        c2.price = 5000;

        javaStudent stu1 = new javaStudent();
        stu1.id = 1001;
        stu1.sname = "徐";
        stu1.age = 18;
        stu1.computer = c1;
        stu1.study();
    }

}
