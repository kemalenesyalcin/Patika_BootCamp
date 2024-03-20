package Week5.BookSorter;
import java.util.*;


public class Main{
    public static void main(String[] args) {
        Set<Book> booksByTitle = new TreeSet<>();
        booksByTitle.add(new Book("Harry potter1", 200, "jk", "2022-01-01"));
        booksByTitle.add(new Book("Harry potter2", 150, "rowling", "2022-02-15"));
        booksByTitle.add(new Book("Harry potter3", 180, "jk roww", "2022-03-10"));
        booksByTitle.add(new Book("Harry potter4", 250, "j.k roww", "2022-04-20"));
        booksByTitle.add(new Book("Harry potter5", 220, "JK rowling", "2022-05-30"));

        System.out.println("Books sorted by title:");
        for (Book book : booksByTitle) {
            System.out.println(book);
        }

        Set<Book> booksByPageCount = new TreeSet<>(Comparator.comparingInt(Book::getPageCount));
        booksByPageCount.addAll(booksByTitle);

        System.out.println("\nBooks sorted by page count:");
        for (Book book : booksByPageCount) {
            System.out.println(book);
        }
    }
}