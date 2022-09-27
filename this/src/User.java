/*
*   this指针
*   this的本质是"当前对象的地址"
*   在普通方法中,this总是指向调用该方法的对象
*   在构造方法中,this总是指向正要初始化的对象
 */
public class User {
    int id;
    String name;
    String pwd;
    //无参构造器
    public User(){
    }
    //在构造方法中this指向要初始化的对象(new出的对象)
    public User(int id,String _name){
        System.out.println("正要初始化的对象: "+this);  //this指向要初始的对象.this指针用来存放对象的地址
        this.id = id;   //一个id是形参,this指针用来帮助找到User类里对应的属性
        name = _name;   //属性和形参不同名也能实现效果类似,但this指针比较规范,方便
    }
    //this调用重载的构造器
    public User(int id, String name, String pwd){
        //在构造器中使用this调用其它构造器,必须放在构造器第一行
        this(id,name);  //this()调用当前类的构造器,这里的this相当于new User(id,name),调用了上面的构造器
        //this(id,name);与this.id = id; this.name = name等价,只是this()是调用其它构造器,将本构造器的形参值作为实参传入其它构造器
        this.pwd = pwd;
    }

    //普通方法
    public void login(){
        System.out.println("登录名: "+this.name+",密码:"+pwd);
    }

    //main方法
    public static void main(String[] args) {
        User u1 = new User(101,"徐");    //构造方法中this指向u1这个要初始化的对象
        u1.pwd = "123456";  //有参构造器中的this.id与这个u1.pwd本质上差不多
        u1.login(); //普通方法login中的this就指向u1这个对象

        User u2 = new User(1002, "xu", "123");
        System.out.println("u2:"+u2.name);
    }

}
