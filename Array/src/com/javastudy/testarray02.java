package com.javastudy;

/**
 * 测试引用类数组的使用
 */
public class testarray02 {
    public static void main(String[] args) {
        User[] users = new User[3];     //默认数据是null
        //动态初始化
        users[0] = new User(1001,"xu");
        User u = new User(1002,"徐");
        users[1] = u;
        users[2] = new User(1003,"张三");

        for(int i = 0;i<users.length;i++){
            System.out.println("用户名"+i+": "+users[i].getName());
            System.out.println(users[i].toString());    //sout方法默认输出toString方法;users[i] == users[i].tostring
            System.out.println(users[i]);
            System.out.println("-------");
        }

        //引用类数组静态初始化
        User[] user2 = {new User(2001,"李四"),new User(2002,"王五"),new User(2002,"David")};
        System.out.println("--输出user2数组元素--");
        //for-each,强化for循环遍历数组元素
        for (User user:user2){
            System.out.println(user);
        }

    }

}

class User {
    private int id;
    private String name;

    //构造器
    public User (){}

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{"+"id=" + id +
                ",name='" + name + '\''+'}';
    }
}
