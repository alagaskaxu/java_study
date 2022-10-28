package abstractClass;

/**
 * 支付抽象类
 */
public abstract class AbstractPay
{
    /**
     * 普通支付方法,支付宝支付
     * @param money
     * @return true
     */
    public boolean aliPay(int money)
    {
        System.out.println("您正在使用支付宝,当前金额为:"+money);
        return true;
    }

    public boolean wxPay(int money)
    {
        System.out.println("您正在使用微信支付,当前金额为:"+money);
        return true;
    }

    /**
     * 银联支付的抽象方法,没有具体实现方法
     * @param money
     * @return boolean
     */
    public abstract boolean unionPay(int money);

}
