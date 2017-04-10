public class Test1 {
    public static boolean findRotate(String s1, String s2) {
        String target = s1 + s1;
        if (target.indexOf(s2) == -1)
            return false;
        return true;
    }
    
    public static void main(String[] args) {
        String s1 = "AABCD";
        String s2 = "CDAA";
        String s3 = "ABCD";
        String s4 = "ACBD";
        System.out.println(findRotate(s1, s2));
        System.out.println(findRotate(s3, s4));
    }
}