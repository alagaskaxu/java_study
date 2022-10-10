/**
 * 自定义包装类Integer
 */
public class myInteger {
    private int value;
    private static  myInteger[] cache = new myInteger[256];

    public static final int Low = -128;
    public static final int High = 127;

    //静态初始化块:是在类被加载的时候,初始化的静态属性
    static {
        for (int i = myInteger.Low;i<=High;i++){
            //初始化数组-128 -> 下标 0 ; -127 ->下标 1  ;-126 -> 下标2
            cache[i + (-Low)] = new myInteger(i);   //cache[i + 128]
            //数组中缓存的对象存放在cache数组
        }

    }

    //返回myInteger类型的valueOf方法;int数据类型转化为包装类对象
    public static myInteger valueOf(int i){
        //如果在-128到127之间,则返回数组中缓存的对象,否则创建新的对象
        if (i >= Low && i <= High){
            return cache[i + (-Low)];   //i+128
        }else {
            return new myInteger(i);
        }
    }

    //int包装类对象转成基本数据类型方法
    public int intValue(){
        return value;
    }

    //转变为字符串输出toString方法
    @Override
    public String toString() {
        return value+"";
    }

    //构造器
    private myInteger(int i){
        this.value = i;
    }

    //测试自己写的int包装类
    public static void main(String[] args) {
        myInteger a = myInteger.valueOf(100);
        myInteger b = myInteger.valueOf(100);   //100在缓存区间-128到127里,不需要创建新对象
        System.out.println(a == b); //true.同一个对象

        myInteger c = myInteger.valueOf(300);
        myInteger d = myInteger.valueOf(300);   //300超过了缓存区间-128到127,需要创建一个新的对象来存放
        System.out.println(c == d); //false.不同对象
    }
}
