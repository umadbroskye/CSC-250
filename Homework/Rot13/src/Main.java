public class Main {
    public static void main(String[] args) {
        String s = "abcdefghijklmnopqrstuvwxyz";
        String to_encode = "hello";
        int index = (s.indexOf("b") + 13) % 26;
        System.out.println(s.charAt(index));
    }
}
