package com.abstractClass;

/**
 * Animal类只是抽象类方法的语法
 * DB将模拟抽象类方法的实际应用场景
 * 模板方法模式(抽象类应用)
 */
//操作数据库
public abstract class DBOperator {
    //1.建立数据库连接 2.打开数据库 3.使用数据库 4.关闭数据库连接
    //建立连接的方法(由于各个数据库连接方法不同,具体实现按场景来,所以需要定义成抽象方法,抽象类)
    public abstract void connection();

    //打开数据库方法(建设所有打开的方法都一样,则使用普通方法即可,无需按具体场景来,减少代码重复)
    public void open(){
        System.out.println("打开数据库");
    }

    //使用数据库方法
    public void use(){
        System.out.println("使用数据库");
    }

    //关闭连接抽象方法
    public abstract void close();

    //将方法全整合到 数据库进程方法 里,方便测试使用
    //数据库进程的操作模板
    public void BDprocess(){
    connection();
    open();
    use();
    close();
    }

}

//利用数据库模板创建能匹配 MySql数据库的具体方法
class MySqlOperator extends DBOperator{
    //将抽象方法具体实现,即重写具体的连接和关闭方法,以致完全匹配Mysql的连接关闭方法
    @Override
    public void connection() {
        System.out.println("建立和MySql数据库的连接");
    }

    @Override
    public void close() {
        System.out.println("关闭与Mysql的连接");
    }
}

//利用模板创建能匹配 Oracle数据库的方法
class OracleOperator extends DBOperator{
    @Override
    public void connection() {
        System.out.println("建立和Oracle数据库的连接");
    }

    @Override
    public void close() {
        System.out.println("关闭与Oracle的连接");
    }
}

class main{
    //main方法
    public static void main(String[] args) {
        //使用Mysql数据库
        MySqlOperator mysql = new MySqlOperator();
        mysql.BDprocess();

        //使用Oracle数据库
        new OracleOperator().BDprocess();   //直接调用进程方法也可以,但没有实例化对象
        //可见抽象类和方法可以利用相同的模板对 不同需求作个性化定制,以求完美符合需求
    }
}