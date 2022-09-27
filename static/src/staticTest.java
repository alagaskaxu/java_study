/*
*static关键字核心用法
* static声明的变量为静态成员变量,也称为类变量.
* 特点
* 1.从属于类,只有一份,在类被载入时被显式初始化
* 2.一般使用"类名.类属性/方法"来调用
* 3.在static方法中不可直接访问非static的成员
*
* 构造器用于对象的初始化
* 类似地:static静态初始化块,用于类的初始化操作,可以初始化static属性
* 在静态初始化块中不能直接访问非static成员
 */
public class staticTest {
    int id;
    //静态成员变量(静态类变量)
    static String school = "南京林业大学";
    //static静态方法
    static void printfSchool(){
        System.out.println(school);
        //System.out.println(this.id);   //static里不能使用非static的成员
    }
    //普通方法
    void login(){
        System.out.print(id+"登录");
        System.out.println(this.id);
    }

    //static静态初始化块,一起被static修饰
    static {
        System.out.println("类被初始化的调用");
        int schoolId = 12559;
    }

    public static void main(String[] args) {
        //static定义的方法和属性不需要new对象,可以直接调用
        staticTest.printfSchool();
        //调用普通方法要先new对象
        staticTest t1 = new staticTest();
        t1.login(); //t1对象也不能调用static的内容

        staticTest.school = "苏州工业园区";
        staticTest.printfSchool();
        t1.id = 101;
        t1.login();
    }
}
