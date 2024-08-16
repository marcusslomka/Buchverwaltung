package org.example;

import java.util.*;
import java.util.stream.*;
import java.util.AbstractMap;

public class Library {
    private List<Book> books = new ArrayList<>();
    private List<Loan> loans = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public void loanBook(Book book, Date startDate, Date endDate) {
        loans.add(new Loan(book, startDate, endDate));
    }

    // 1. Übung
    public List<Book> getBooksSortedByPublicationYear() {
        return books.stream()
                .sorted(Comparator.comparing(Book::getPublicationYear))
                .toList();
    }

    // 2. Übung
    public List<Author> getAuthorsSortedByBirthYear() {
        return books
                .stream()
                .flatMap(book -> book.getAuthors().stream())
                .distinct()
                .sorted(Comparator.comparing(Author::getBirthYear))
                .toList();
    }

    // 3. Übung
    public List<Book> filterBooksByPageCount(int minPages, int maxPages) {
        return books.stream()
                .filter(book -> book.getPages() <= maxPages && minPages <= book.getPages())
                .toList();
    }

    // 4. Übung
    public Map<Author, List<Book>> groupBooksByAuthor() {
        return books
                .stream()
                .flatMap(book -> book.getAuthors().stream().map(
                        author -> author. new AbstractMap.SimpleEntry<>(author,book))
                .collect(Collectors.groupingBy(Map.Entry::getKey,Collectors.mapping(book ->book, Collectors.toList())));
    }

    // 5. Übung
    //public Optional<Author> getOldestAuthor() {}

    // 6. Übung
    //public List<Book> getBooksByTitleKeyword(String keyword) {}

    // 7. Übung
    //public List<Book> getMostLoanedBooks() {}

    // 8. Übung
    //public Map<Book, Long> getLoanCountPerBook() {}

    // 9. Übung
    //public List<Book> getBooksLoanedByAuthor(Author author) {}

    // 10. Übung
    //public double getAverageLoanDuration() {}

    // Bonus: 11. Übung
    //public String getMostPopularAuthorByBorrowedBooksCount() {}

}
