public class triangle {

    public static void main(String[] args) {
        int rows = 5;
        for (int r=1;r<=rows;r++){
            for (int n=1;n<=3;n++){
                int b =r-1;
                for (int c=1;c<=b;c++){
                    System.out.print(' ');
                }
                int s=2*(rows-r)+1;
                for (int c=1;c<=s;c++){
                    System.out.print('*');
                }
                for (int c=1;c<=b;c++){
                    System.out.print(' ');
                }
            }
            System.out.println();
        }
    }
}
