public class Main {
    public static void main(String[] args) {
        double a1 = Math.random() * 255;
        double b1 = Math.random() * 255;
        int a2 = (int) a1;
        int b2 = (int) b1;
        String str1 = Character.toString((char) a2);
        String str2 = Character.toString((char) b2);
        System.out.println(str1);
        System.out.println(str2);
    }
}
