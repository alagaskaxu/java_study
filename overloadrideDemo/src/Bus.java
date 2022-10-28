/**
 * 公家车类
 * 方法重写(覆盖)override
 */
public class Bus extends Car
{
    @Override
    public void showName(String name)
    {
        System.out.println("公交车型号:"+name);
    }
}
