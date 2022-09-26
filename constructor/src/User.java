import javax.jws.soap.SOAPBinding;

/*
    模拟网站的账户(用于构造方法的重载)
 */
public class User {
    int id;
    String uname;   //用户名
    String pwd;     //密码

    //无参构造器,默认初值
    User(){ }
    //有参构造器,方法重载,只传id
    public User(int _id){
        id = _id;
    }
    //有参构造器,传用户名和密码
    public User(String _unmae, String _pwd){
        uname = _unmae;
        pwd = _pwd;
    }
    //有参构造器,传id和用户名和密码
    public User(int _id, String _unmae, String _pwd){
        id = _id;
        uname = _unmae;
        pwd = _pwd;
    }

    public static void main(String[] args) {
        User u1 = new User();   //调用无参构造器,属性值为默认初值0,0.0,null,flase
        User u2 = new User(1001);   //有参构造器,构造器的重载,只传id值
        User u3 = new User("xzy","123456");
        User u4 = new User(1001,"xzy","123456");
        System.out.println(u1.id+u1.uname+u1.pwd);
        System.out.println(u2.id+u2.uname+u2.pwd);
        System.out.println(u3.id+u3.uname+u3.pwd);
        System.out.println(u4.id+u4.uname+u4.pwd);
    }
}
