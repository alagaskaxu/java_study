/*
  *switch 多值判断控制语句
 */
public class switchSentence
{
    public static void main(String[] args) {
        int grade = 1;
        switch (grade)
        {
            case 1:
                System.out.println("大学一年级");
                break;      //用break跳出case 1,不跳出则一直执行语句直到break跳出
            case 2:
                System.out.println("大学二年级");
                break;
            case 3:
                System.out.println("大学三年级");
                break;
        }

        int mouth = 2;
        switch (mouth)
        {
            case 1:
            case 2:
            case 3:
                System.out.println("春季");   //1,2,3语句一样,直接省略相同语句,最后一起执行
                break;
            case 4:
            case 5:
            case 6:
                System.out.println("夏季");
                break;
        }

        //switch与case,可以接收数字,枚举类,字符串(jdk1.7后才支持字符串)
        String car = "法拉利";
        switch (car)
        {
            case "奥迪":
                System.out.println("买了奥迪");
                break;
            case "奔驰":
                System.out.println("买了奔驰");
                break;
            case "法拉利":
                System.out.println("买了法拉利");
                break;
            default:
                System.out.println("买了五菱宏光");   //default表示默认执行的语句,当没有case与switch语句没有匹配时,执行默认语句
                break;
        }

        //阿拉伯数字(0-5)转大写汉字 1->壹
        int num = (int)(Math.random()*6);
        char s;
        switch (num)
        {
            case 0:
                s = '零';
                break;
            case 1:
                s = '壹';
                break;
            case 2:
                s = '贰';
                break;
            case 3:
                s = '叁';
                break;
            case 4:
                s = '肆';
                break;
            case 5:
                s = '伍';
                break;
            default:
                s = 'a';
                break;
        }
        System.out.println("数字:"+num+" 对应汉字:"+s);

    }
}
