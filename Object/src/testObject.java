/**
 * 测试Object类的用法
 */
public class testObject {
    public static void main(String[] args) {
        Employee e1 = new Employee(1001, "徐");
        System.out.println(e1);  //打印对象默认是调用的toString方法,只输入el与el.toString等价,java默认会加上tostring
        //父类Object默认 toString方法 : return类名@hash值
        System.out.println(e1.toString());
        Employee e2 = new Employee(1001, "徐");
        //用equals比较两个对象是否相等
        System.out.println(e1 == e2);   //false,equals默认就是return (e1 == e2)比较两个对象的地址是否相同
        //equals来自Object父类的方法: return (this == obj);
        System.out.println(e1.equals(e2));  //true,默认比较两个对象的地址是否相同
        //必要时,需要改写equals方法达到不同目的,重写后id相同则返回true
    }
}

class Employee extends Object {
    int id;
    String name;
    //重写toString方法
    @Override
    public String toString() {
        return "雇员编号: "+id+",姓名: "+name;
    }
    //重写equals方法,id相同则相同返回true
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    //构造器
    public Employee(){}
    public Employee(int id, String name){
        this.id = id;
        this.name = name;
    }
}
