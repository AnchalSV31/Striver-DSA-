package Strings;

public class Stringbuffer {
    public static void main(String[] args) {
        // StringBuffer sb = new StringBuffer("DSA");
        // System.out.println(sb);
        // System.out.println(sb.length());
        // System.out.println(sb.capacity());    //buffer size+length == 16+3=19
        // // sb.ensureCapacity(50);

        // sb.append(" Placement");
        // System.out.println(sb);
        // System.out.println(sb.length());   //13
        // System.out.println(sb.capacity());   //19
        // // sb.ensureCapacity(70);
    
        // sb.append(" Series");
        // System.out.println(sb);
        // System.out.println(sb.length());   //length>curr  capacity ie.19
        // System.out.println(sb.capacity());   //new capacity = curr capacity*2+2 =19*2+2 = 40

        // StringBuffer sb = new StringBuffer("Hi");
        // System.out.println(sb);
        // System.out.println(sb.charAt(0));

        // StringBuffer sb= new StringBuffer("Dove");
        // System.out.println(sb);
        // sb.delete(0,2);
        // // sb.setCharAt(0, 'L');
        // System.out.println(sb);

        StringBuffer sb = new StringBuffer("Hello World");
        System.out.println(sb);
        sb.replace(6,11,"India");
        System.out.println(sb);

    }
}
