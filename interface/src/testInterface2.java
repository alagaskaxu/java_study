/**
 * 测试接口的多继承
 */
public class testInterface2 implements C{
    //C接口多继承了A,B接口,使用C接口时就要具体实现所有的方法
    @Override
    public void testA() {
    }
    @Override
    public void testB() {
    }
    @Override
    public void testC() {
    }
}

interface A{
    void testA();
}

interface B{
    void testB();
}

interface C extends A,B{
    void testC();
}
