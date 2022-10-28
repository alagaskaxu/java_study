import Interface.Ipay;

/**
 * 普通类实现接口中所有方法
 */
public class Mypay implements Ipay
{
    @Override
    public boolean alipay(int money) {
        System.out.println("支付宝接口支付金额:" + money);
        return true;
    }
    @Override
    public boolean wxpay(int money) {
        System.out.println("微信接口支付金额:"+money);
            return true;
    }

    @Override
    public boolean unionpay(int money) {
        System.out.println("银联接口支付金额:"+money);
        return true;
    }

    public static void main(String[] args) {
        Ipay ipay = new Mypay();
        ipay.alipay(111);
        ipay.wxpay(222);
        ipay.unionpay(333);
    }
}
