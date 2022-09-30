/**
 * super :当前对象的父类型特征(可以看作是直接父类对象的引用)
 * 可以通过super来访问父类中被子类覆盖的方法或属性
 */
public class testSuper {
    public static void main(String[] args) {
        Child c = new Child();
        c.num = 5000;
        c.show();
    }

}

class Parent {
    int num = 300;
    public void show(){
        System.out.println("父类中,show()");

    }

    //父类构造器

    public Parent() {
        System.out.println("创建对象时默认先调用的父类构造器,num = "+num);
    }
}

class Child extends Parent {
    int num = 1000;

    /**
     * 注:
     * 1.在一个类中,若是构造方法的第一行代码没有显式的用super()或this();
     * 那么java默认调用super(),含义是调用父类的无参数构造方法,super()省略
     * 2.子类创建的整个过程只创建了一个对象,虽然会调用父类构造器,但没创建父类
     * 3.super的本质是:当前对象的父类型特征
     */
    //构造器
    public Child() {
        super(); //java默认自动添加该语句,调用父类的无参构造器,说明
        //可以自己改为 this();
        System.out.println("创建对象时子类的默认num= "+num);
        System.out.println("创建对象时对象实例的默认num= "+this.num);
    }

    @Override   //重写不是替换,只是覆盖,父类方法还是存在的(类似两层方法不冲突),通过supper可以调用父方法和属性
    public void show(){
        System.out.println("子类,show()");
        super.show();   //super指向Parent,调用了父类的show方法
        System.out.println("c重新赋值后子类num = "+num);    //Child子类的num,
        System.out.println("实例对象c的num = "+this.num);    //对象c的num
        System.out.println("用super找到父类num = "+super.num);

    }

}
