package Interface;

/**
 * 支付接口
 */
public interface Ipay
{
    /**
     * 支付宝的接口
     * @param money
     * @return
     */
    boolean alipay(int money);

    /**
     * 支付接口方法,支持:微信
     * @param money
     * @return
     */
    boolean wxpay(int money);

    /**
     * 支付接口方法,支持:银联
     * @param money
     * @return
     */
    boolean unionpay(int money);

}
