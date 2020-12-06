package org.bigjava.bean;

/**
 * @ProjectName: JavaEESenior
 * @ClassName: Book
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-10-29 11:00
 * @Version v1.0
 */
public class Book {
    private String bookName;
    private String author;

    public Book() {
    }

    public Book(String bookName, String author) {
        this.bookName = bookName;
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookName='" + bookName + '\'' +
                ", author='" + author + '\'' +
                '}';
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
