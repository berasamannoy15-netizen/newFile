class books {
    String name ;
    double price ;
    boolean available ;
}
 class books1 {
     public static void main(String[] args) {
         books bk1 = new books() ;
         bk1.name = "Java Basics";
         bk1.price = 299.5 ;
         bk1.available = true ;
         System.out.println("Book 1");
         System.out.println("Title:" + bk1.name);
         System.out.println("Price:"+ bk1.price);
         System.out.println("Available:" + bk1.available);

         System.out.println();

         books bk2 = new books() ;
         bk2.name = "Python Basics";
         bk2.price = 399.0 ;
         bk2.available = false ;
         System.out.println("Book 2");
         System.out.println("Title:" + bk2.name);
         System.out.println("Price:"+ bk2.price);
         System.out.println("Available:" + bk2.available);
     }
 }