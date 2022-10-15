/**
 * 异常 Exception
 * 异常处理,指程序在出现问题时依然可以正确的执行完
 * java面向对象处理异常过程
 * 抛出异常: 在执行一个方法时,如果发送异常,则这个方法生成代表该异常的一个对象,
 * 停止当前执行路径,并把异常对象提交给JRE.
 * 捕获异常: JRE得到该异常后,寻找相应的代码来处理该异常JRE在方法调用栈中查找,
 * 从生成异常的方法开始回溯,直到找到相应的异常处理代码为止
 */
public class test01 {
    public static void main(String[] args) {
        test02();
    }

    public static void test01(){
        System.out.println("1111");
        int a = 1/0;    //报错,算术错误
        System.out.println("2222");
    }

    public static void test02(){
        System.out.println("1111");
        try {
            int a = 1/0;    //ctrl + alt + T 快捷键 try-catch
        } catch (Exception e) {
            e.printStackTrace();
        }
        //仍然报错,但是程序可以继续运行完再退出
        System.out.println("2222");
    }
}
