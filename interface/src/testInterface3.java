/**
 * JDK1.8后接口的新特性
 * JDK1.8(包含8)后,接口中可以定义具体的方法,让接口更加灵活,扩展性更强
 *
 * 接口的默认方法:
 * 1.默认方法用default关键字,一个接口中可以有多个默认方法.默认方法也叫扩展方法
 * 2.子类实现接口时,可以直接调用接口中的默认方法,也可以重写
 *
 * 接口的静态方法:
 * 1.接口中同时还可以定义静态方法,静态方法通过 接口名 调用.
 * 2.如果实现类中定义了相同名字的静态方法,
 * 那是完全不同的方法,直接从属于实现类,通过 类名 直接调用
 *
 */
public class testInterface3 {
    public static void main(String[] args) {
        testA1 ta = new testA1();
        ta.d1();    //调用默认方法1
        ta.d2();    //调用了重写的默认方法2
        System.out.println();
        //接口内的静态方法只能用接口名调用接口内的静态方法
        A1.staticMethod();
        //实现类testA1中的同名静态方法,与接口中完全不是同一个方法,
        //从属于实现类,通过 类名 调用
        testA1.staticMethod();

        //测试接口名冲突后重写
        testB tb = new testB();
        tb.d1();

    }

}

//测试接口的默认方法,静态方法
interface A1 {
    default void d1(){
        System.out.println("A1.default1方法");
    }
    default void d2(){
        System.out.println("A1.default2方法");
    }

    //静态方法
    static void staticMethod(){
        System.out.println("A1.staticMethod静态方法");
    }
}

class testA1 implements A1{
    //对于接口中的default修饰的方法不会强制重写

    //也可以对默认方法进行重写
    @Override
    public void d2() {
        System.out.println("重写默认方法2testA");
    }

    //如果实现类中定义了相同名字的静态方法(staticMethod),
    //那么实现类中是完全不同的方法,直接从属于实现类,通过 类名 直接调用
    static void staticMethod(){
        System.out.println("实现类中的同名静态方法,与接口中完全不是同一个");
    }
}

/**
 * 命名冲突问题
 * 如果方法名称和形参列表相同,会发生命名冲突:
 * 1.父类优先.如果父类的方法和接口默认方法名冲突,则父类优先
 * 2.接口冲突.如果多个接口中默认方法有相同名字,则子类无法区分,必须重写同名方法
 *
 */
interface B1{
    //接口名冲突,与A1的默认方法同名
    default void d1(){
        System.out.println("B1.默认1方法");
    }
}
//接口的d1方法重名,testB类无法区分,必须重写同名的方法
class testB implements A1,B1{
    //必须重写方法
    @Override
    public void d1() {
        System.out.println("接口名冲突后,重写了testB的默认方法1");
    }
}
