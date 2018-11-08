public class Test {
    Integer a1 = new Integer(0);
    Integer a2 = new Integer(0);
    static final StringBuffer s = new StringBuffer("Hello");
    public static StringBuffer testStatic(final StringBuffer tmp){
        tmp.append(" world");
        System.out.println(tmp);
        return tmp;
    }

    public static int getLength(final StringBuffer sb){
        sb.append(" World");
        return sb.length();

    }

    public static void main(String[] args){
        Test test = new Test();
        String a = "abc";
        String b = "abc";
        String c = new String("abc");
        System.out.println(a == b);
        System.out.println(a == c);
        System.out.println(a.hashCode());
        System.out.println(c.hashCode());
        StringBuffer sb = new StringBuffer("Hello");
        System.out.println(getLength(sb));
    }
}
