/**
 * 卡车类
 */
public class Truck extends Car
{
    @Override
    public void showName(String name)
    {
        System.out.println("卡车型号:"+name);   //重写
        super.showName(name);   //调用父类方法
    }
}
