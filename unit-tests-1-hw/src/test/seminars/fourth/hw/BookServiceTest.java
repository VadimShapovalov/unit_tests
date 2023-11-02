package seminars.fourth.hw;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seminars.fourth.book.*;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;

public class BookServiceTest {
    private BookRepository bookRepository;
    private BookService bookService;
@BeforeEach
public void setUp() {
    bookRepository = mock(BookRepository.class);
    bookService = new BookService(bookRepository);
}

    @Test
    public void findBookByIdExistingIdReturnsBook() {

        Book expectedBook = new Book("1", "Book1", "Author1");
        when(bookRepository.findById("1")).thenReturn(expectedBook);

        Book result = bookService.findBookById("1");

        assertEquals(expectedBook, result);
    }
    @Test
    public void findBookByIdNonExistingIdReturnsNull() {

        when(bookRepository.findById("3")).thenReturn(null);

        Book result = bookService.findBookById("3");

        assertNull(result);
    }
    @Test
    public void findAllBooksReturnsAllBooks() {

        InMemoryBookRepository im = new InMemoryBookRepository();
        List<Book> expectedBooks = Arrays.asList(
                new Book("1", "Book1", "Author1"),
                new Book("2", "Book2", "Author2")
        );
        when(bookRepository.findAll()).thenReturn(expectedBooks);

        List<Book> result = bookService.findAllBooks();

        assertEquals(expectedBooks, result);
    }

}
