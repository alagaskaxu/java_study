/*
*   if-else 选择控制语句
 */
public class ifTest {
    public static void main(String[] args) {
        //Math.random();  调用随机数,[0,1)范围内的随机数
//        System.out.println(Math.random());
        int r = (int)(Math.random()*10);    //(int)强制类型转换,将double型的随机数转为int型,会损失精度,只保留整数
        System.out.println(r);

        //如果r小于5,则打印"数比较小"
        if (r < 5){     //if语句不加{}只能判断运行下一句语句,{}可以用来判断运行语句块
            System.out.println("数比较小");
        }else {
            System.out.println("数比较大");
        }
        //if-else,if判断语句为真则执行if语句,判断为假则执行else语句

        //多分支结构if-elseif-...-else
        //生成[0-100]表示年龄的随机数,15以下为儿童,15-24为青年,25-44为中年,45-64为中老年,65以上为老年
        int age = (int)(Math.random()*100);
        System.out.println(age);
        if (age < 15)
        {
            System.out.println("儿童");
        }else if (age < 25)
        {
            System.out.println("青年");
        }else if (age < 45)
        {
            System.out.println("中年");
        }else if (age < 65)
        {
            System.out.println("中老年");
        }else
        {
            System.out.println("老年");
        }

        //随机生成a-z的字母,如果是a,e,i,o,u,则输出"元音",否则为"辅音"
        int num = (int)(Math.random()*27);  //[0-26],random()范围为[0,1)
        char word = (char)('a' + num);  //默认加上int类型会变成int类型,要用(char)强制转换
        int lnum = 'a' + num;
        System.out.println("lum = " + lnum);
        System.out.println("word = " + word);

        if (word == 'a' || word == 'e' || 'i' == word || 'o' == word || 'u' == word)
        {
            System.out.println("元音"+word);
        }else
        {
            System.out.println("辅音"+word);
        }
    }

}
