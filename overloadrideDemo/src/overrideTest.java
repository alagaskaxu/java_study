/**
 * 测试方法重写(覆盖)
 */
public class overrideTest
{
    public static void main(String[] args)
    {
        Car car1 = new Bus();
        Car car2 = new Truck();
        car1.showName("Bus公交车car1");
        car2.showName("Truck卡车car2");
        //car1.run();

    }
}
