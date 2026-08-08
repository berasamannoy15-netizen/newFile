public class DataTypesExample {
    public static void main(String[] args) {


        // ===== Primitive Data Types =====
        byte b = 100;                 // 1 byte
        short s = 32000;              // 2 bytes
        int i = 100000;               // 4 bytes
        long l = 10000000000L;        // 8 bytes


        float f = 10.5f;              // 4 bytes
        double d = 99.99;             // 8 bytes


        char c = 'A';                 // 2 bytes
        boolean bool = true;          // 1 bit (true/false)


        // ===== Non-Primitive (Reference) Data Types =====
        String str = "Hello Java";    // String
        int[] arr = {1, 2, 3, 4};     // Array


        DataTypesExample obj = new DataTypesExample(); // Object


        // ===== Output =====
        System.out.println("byte: " + b);
        System.out.println("short: " + s);
        System.out.println("int: " + i);
        System.out.println("long: " + l);
        System.out.println("float: " + f);
        System.out.println("double: " + d);
        System.out.println("char: " + c);
        System.out.println("boolean: " + bool);
        System.out.println("String: " + str);
        System.out.println("Array element: " + arr[0]);
        System.out.println("Object: " + obj);
    }
}


