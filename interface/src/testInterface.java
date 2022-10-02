
/**
 * 接口:interface
 * 接口全面实现了:规范和具体实现的分离
 * 接口的声明格式:
 * [访问修饰符] interface 接口名 [extends 父接口1,父接口2...]{
 *     常量定义;    //接口里不能定义变量,都是静态常量
 *     方法定义;
 * }
 * 接口可以继承(extends)多个父接口
 * 类可以使用(implements)多个接口
 *
 * 使用说明:
 * 1.子类通过implements来实现接口中的规范
 * 2.接口不能创建实例,但是可用于声明引用变量的类型
 * 3.一个类实现了接口,必须实现接口中所有的方法,并且这些方法只能是public的
 * 4.JDK1.8(不含8)之前,接口中只能包含静态常量,抽象方法,不能有普通属性,普通方法,构造方法
 * 5.JDK1.8后,接口中包含普通的静态方法,默认方法
 */
public class testInterface {
    public static void main(String[] args) {
        Angel a = new Angel();
        a.fly();
        a.helpOthers();

        Bird b = new Bird();
        b.fly();
        System.out.println("======");

        //Volant v = new Volant();    //口不能创建实例,即不能new 接口类型
        Volant v = new Angel();     //但是可用于声明引用变量的类型,Volant类型
        v.fly();      //Volant类型就只能调用v的fly方法了,
                    // v是Angel创建的实例对象,有天使的fly方法和help方法,
                    //但v的类型是Volant,只能使用fly方法
    }
}

//飞行接口
interface Volant{
    int FLY_HEIGHT = 100;//静态常量,public static int FLY_HEIGHT,默认会自动加上public static 修饰
    void fly(); // public abstract void fly(); 编译器自动加上 public abstract 修饰

}
//善良接口
interface Honest {
    void helpOthers();
}

//天使类,使用接口用implements,可以使用多个接口
class Angel implements Volant,Honest{
    //引用接口就需要具体实现接口里的方法
    @Override
    public void fly() {
        System.out.println("天使飞行");
    }
    //类可以使用多个接口,但是每个接口的方法都需要具体实现
    @Override
    public void helpOthers() {
        System.out.println("善良天使");
    }
}

//使用一个接口的鸟类,实现一个接口里的方法就行了
class Bird implements Volant{
    @Override
    public void fly() {
        System.out.println("飞鸟");
    }
}

