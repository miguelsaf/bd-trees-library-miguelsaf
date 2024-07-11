import model.Book;
import org.apache.commons.lang3.NotImplementedException;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.text.WordUtils;
import treestructure.BookNode;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * Application to test traversing Binary Trees and Binary Search Trees.
 *
 * Represents a Library with a collection of books.
 */
public class LibraryService {

    /**
     * The root node of our tree of Books.
     * Assume this tree is sorted by ISBN.
     * The tree and its nodes should not be modified by our application.
    */
    private final BookNode books;

    /**
     * Constructs our library with a default tree of books.
     * Assume this tree is sorted by ISBN.
     *
     * @param books The root node of a tree of Books
     */
    public LibraryService(final BookNode books) {
        this.books = books;
    }

    /**
     * Determines whether or not a book is in the library
     * by searching our tree for a book with the given ISBN.
     *
     * @param isbn A given ISBN to search our library for
     * @return True if a book with the given ISBN is in our library and
     *         false otherwise
     */
    public boolean isBookInLibraryByIsbn(String isbn) {
        // PARTICIPANTS: IMPLEMENT YOUR BINARY SEARCH HERE
        if(StringUtils.isBlank(isbn)) return false;

        BookNode p = books;

        while ( p != null && !p.getBook().getIsbn().equals(isbn)){
            if( isbn.compareTo(p.getBook().getIsbn()) < 0 ){
                p = p.getLeft();
            }else {
                p = p.getRight();
            }
        }
        if(p == null) return false;
        return true;
        //throw new NotImplementedException("isBookInLibraryByIsbn is not yet implemented!");
    }


    /**
     * Determines whether or not a book is in the library
     * by searching our tree for a book with the given Title and Author.
     *
     * @param title A given title to search our library for, alongside an author's name
     * @param author The name of a given author to search our library for, alongside a title
     * @return True if a book with the given title and author is in our library, and
     *         false otherwise
     */
    public boolean isBookInLibraryByTitleAndAuthor(String title, String author) {
        // PARTICIPANTS: IMPLEMENT YOUR DEPTH FIRST SEARCH HERE
        if(StringUtils.isBlank(title)) return false;
        if(StringUtils.isBlank(author)) return false;

        BookNode p;
        Stack<BookNode> bookNodeStack = new Stack<>();
        bookNodeStack.push(books);

        while ( !bookNodeStack.isEmpty() ){
            p = bookNodeStack.pop();
            if(p.getBook().getAuthor().equals(author) && p.getBook().getTitle().equals(title)){
                return true;
            }
            if(p.getLeft() != null ) bookNodeStack.push(p.getLeft());
            if(p.getRight() != null ) bookNodeStack.push(p.getRight());
            //bookNodeStack.pop();
        }
        return false;

        //throw new NotImplementedException("isBookInLibraryByTitleAndAuthor is not yet implemented!");
    }
}
