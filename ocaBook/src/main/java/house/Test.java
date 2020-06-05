package house;
import buliding.Book;
public class Test {

    public static void main(String[] args) {

        Book book = new Book ("dcd");
        System.out.println ( book.name );

        int a = 10;

        a = ++a + a  + --a - --a + a++; // (11) + (10) + 10 + 10
        System.out.println (a );


    }
}
