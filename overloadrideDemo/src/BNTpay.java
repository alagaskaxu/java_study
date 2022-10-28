import abstractClass.AbstractPay;

/**
 * 普通支付类继承了支付抽象类,要具体实现父类中所有的抽象方法
 */
public class BNTpay extends AbstractPay
{
    //实现父类中的抽象方法unionPay(银联支付)
    @Override
    public boolean unionPay(int money)
    {
        System.out.println("您正在使用银联支付,支付金额为:"+money);
        return true;
    }

    public static void main(String[] args)
    {
        //抽象类无法实例化,利用实例化子类对象来调用对应方法
        AbstractPay pay = new BNTpay();
        pay.aliPay(100);
        pay.wxPay(100);
        pay.unionPay(100);

    }
}
