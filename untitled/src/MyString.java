public class MyString {
    private String s;
    private char c;
    public MyString(String _s, char _c) {
        s = _s;
        c = _c;
    }
    public int count() {
        int counter = 0;
        for (int i=0; i<s.length(); i++) {
            counter = s.charAt(i) == c ? counter + 1 : counter;
        }
        return counter;
    }

    public static void main(String[] args) {
        MyString myString = new MyString("Hello, World!", 'o');
        int result = myString.count();
        System.out.println(result);
    }
}