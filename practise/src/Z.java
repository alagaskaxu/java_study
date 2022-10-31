class X {
    Y b = new Y();
    public X()
    {
        System.out.print("X");
    }
    public X(int i)
    {
        System.out.print("x");
    }
}
class Y {
    Y() {
        System.out.print("Y");
    }
}
public class Z extends X {
    Y y = new Y();
    public Z() {
        super();
        System.out.print("Z");
    }
    public Z(int i)

    {
        super(1);
        System.out.print("z");
    }

    public static void main(String[] args) {
        new Z(1);
    }
}