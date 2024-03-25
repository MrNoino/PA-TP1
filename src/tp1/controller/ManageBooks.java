package tp1.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import tp1.model.Book;
import tp1.model.DbWrapper;
import tp1.model.Log;
import tp1.model.User;
import tp1.view.Main;

/**
 * A class to manage books on the database
 */
public class ManageBooks {

    private ArrayList<Book> books;

    public ManageBooks() {
        books = new ArrayList<Book>();
    }

    public Book getBookById(long authorId, long bookId) {

        DbWrapper dbWrapper = new DbWrapper();
        dbWrapper.connect();
        ResultSet resultSet = dbWrapper.query("CALL get_book_by_id(?, ?);", new Object[]{authorId, bookId});
        try {
            if (resultSet == null || !resultSet.next()) {
                return null;
            }

            return new Book(resultSet.getLong("id"),
                    resultSet.getString("title"),
                    resultSet.getString("subtitle"),
                    resultSet.getInt("pages"),
                    resultSet.getInt("words"),
                    resultSet.getString("isbn"),
                    resultSet.getString("edition"),
                    resultSet.getString("submission_date"),
                    resultSet.getString("approval_date"),
                    resultSet.getInt("literary_style_id"),
                    resultSet.getString("publication_type"),
                    resultSet.getInt("author_id"));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     *
     * @return Returns a list of books
     */
    public ArrayList<Book> getBooks(long authorId, String orderField, String sortOrder, int page) {

        String sql = "CALL ";
        if (orderField.equals("title")) {
            sql += "get_books_ordered_title_paginated";
        } else if (orderField.equals("submission_date")) {
            sql += "get_books_ordered_submission_date_paginated";
        } else {
            return null;
        }
        sql += "(?, ?, ?);";

        DbWrapper dbWrapper = new DbWrapper();
        dbWrapper.connect();
        ResultSet resultSet = dbWrapper.query(sql, new Object[]{authorId, sortOrder, page});
        try {
            if (resultSet == null) {
                return null;
            }

            while (resultSet.next()) {
                this.books.add(new Book(resultSet.getLong("id"),
                        resultSet.getString("title"),
                        resultSet.getString("subtitle"),
                        resultSet.getInt("pages"),
                        resultSet.getInt("words"),
                        resultSet.getString("isbn"),
                        resultSet.getString("edition"),
                        resultSet.getString("submission_date"),
                        resultSet.getString("approval_date"),
                        resultSet.getInt("literary_style_id"),
                        resultSet.getString("publication_type"),
                        resultSet.getInt("author_id")));
            }
            return this.books;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Book> getBooksBySubmissionDate(long authorId, String submissionDate) {
        DbWrapper dbWrapper = new DbWrapper();
        dbWrapper.connect();
        ResultSet resultSet = dbWrapper.query("CALL get_books_by_submission_date(?, STR_TO_DATE(?, \"%d-%m-%Y\"));", new Object[]{authorId, submissionDate});
        try {
            if (resultSet == null) {
                return null;
            }

            while (resultSet.next()) {
                this.books.add(new Book(resultSet.getLong("id"),
                        resultSet.getString("title"),
                        resultSet.getString("subtitle"),
                        resultSet.getInt("pages"),
                        resultSet.getInt("words"),
                        resultSet.getString("isbn"),
                        resultSet.getString("edition"),
                        resultSet.getString("submission_date"),
                        resultSet.getString("approval_date"),
                        resultSet.getInt("literary_style_id"),
                        resultSet.getString("publication_type"),
                        resultSet.getInt("author_id")));
            }
            return this.books;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Book> getBooksByIsbn(long authorId, String isbn) {
        DbWrapper dbWrapper = new DbWrapper();
        dbWrapper.connect();
        ResultSet resultSet = dbWrapper.query("CALL get_books_by_isbn(?, ?);", new Object[]{authorId, isbn});
        try {
            if (resultSet == null) {
                return null;
            }

            while (resultSet.next()) {
                this.books.add(new Book(resultSet.getLong("id"),
                        resultSet.getString("title"),
                        resultSet.getString("subtitle"),
                        resultSet.getInt("pages"),
                        resultSet.getInt("words"),
                        resultSet.getString("isbn"),
                        resultSet.getString("edition"),
                        resultSet.getString("submission_date"),
                        resultSet.getString("approval_date"),
                        resultSet.getInt("literary_style_id"),
                        resultSet.getString("publication_type"),
                        resultSet.getInt("author_id")));
            }
            return this.books;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean existsTitle(String title) {
        DbWrapper dbWrapper = new DbWrapper();
        dbWrapper.connect();
        ResultSet resultSet = dbWrapper.query("CALL exists_title(?);", new Object[]{title});
        try {
            if (resultSet == null || !resultSet.next()) {
                return false;
            }

            if (resultSet.getBoolean("exists")) {
                System.out.println("\nTítulo já em uso\n");
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbWrapper.disconnect();
        }
        return false;
    }

    public boolean existsIsbn(String isbn) {
        DbWrapper dbWrapper = new DbWrapper();
        dbWrapper.connect();
        ResultSet resultSet = dbWrapper.query("CALL exists_isbn(?);", new Object[]{isbn});
        try {
            if (resultSet == null || !resultSet.next()) {
                return false;
            }

            if (resultSet.getBoolean("exists")) {
                System.out.println("\nISBN já em uso\n");
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbWrapper.disconnect();
        }
        return false;
    }

    /**
     * Insert a book in the database
     *
     * @param book The book to insert in the database
     * @return Confirms if a book was inserted successfully
     */
    public boolean insertBook(Book book) {
        DbWrapper dbWrapper = new DbWrapper();
        boolean inserted = dbWrapper.manipulate("CALL insert_book(?, ?, ?, ?, ?, ?, ?, ?, ?);", new Object[]{book.getTitle(),
            book.getSubtitle(),
            book.getPages(),
            book.getWords(),
            book.getIsbn(),
            book.getEdition(),
            book.getLiteracyStyleId(),
            book.getPublicationType(),
            book.getAuthorId()}) > 0;

        if (inserted && Main.getLoggedUser() != null) {
            new ManageLogs().insertLog(new Log(Main.getLoggedUser().getId(), new SimpleDateFormat("yyyy-mm-dd").format(new Date()), "Inseriu Obra"));
        }
        return inserted;
    }

    /**
     * Updates a book in the database
     *
     * @param book The book to be updated
     * @return Confirms if a book was updated successfully
     */
    public boolean updateBook(Book book) {
        DbWrapper dbWrapper = new DbWrapper();
        return dbWrapper.manipulate("CALL update_book(?, ?, ?, ?, ?, ?, ?, ?, ?, ?);", new Object[]{book.getId(),
            book.getTitle(),
            book.getSubtitle(),
            book.getPages(),
            book.getWords(),
            book.getIsbn(),
            book.getEdition(),
            book.getLiteracyStyleId(),
            book.getPublicationType(),
            book.getAuthorId()}) > 0;
    }

    /**
     * Deletes a book
     *
     * @param book The book to be deleted
     * @return Confirms if a book was deleted successfully
     */
    public boolean deleteBook(Book book) {
        return true;
    }
}
