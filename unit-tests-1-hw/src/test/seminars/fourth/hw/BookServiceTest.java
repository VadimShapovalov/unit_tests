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



/*
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BookServiceTest {

    private BookRepository bookRepository;
    private BookService bookService;

    @Before
    public void setUp() {
        // Инициализация мока и BookService перед каждым тестом
        bookRepository = mock(BookRepository.class);
        bookService = new BookService(bookRepository);
    }

    @Test
    public void findBookById_ExistingId_ReturnsBook() {
        // Arrange
        Book expectedBook = new Book("1", "Book1", "Author1");
        when(bookRepository.findById("1")).thenReturn(expectedBook);

        // Act
        Book result = bookService.findBookById("1");

        // Assert
        assertEquals(expectedBook, result);
    }

    @Test
    public void findBookById_NonExistingId_ReturnsNull() {
        // Arrange
        when(bookRepository.findById("3")).thenReturn(null);

        // Act
        Book result = bookService.findBookById("3");

        // Assert
        assertNull(result);
    }

    @Test
    public void findAllBooks_ReturnsAllBooks() {
        // Arrange
        List<Book> expectedBooks = Arrays.asList(
            new Book("1", "Book1", "Author1"),
            new Book("2", "Book2", "Author2")
        );
        when(bookRepository.findAll()).thenReturn(expectedBooks);

        // Act
        List<Book> result = bookService.findAllBooks();

        // Assert
        assertEquals(expectedBooks, result);
    }

    @Test(expected = RuntimeException.class)
    public void findBookById_RepositoryThrowsException_ThrowsException() {
        // Arrange
        when(bookRepository.findById(anyString())).thenThrow(new RuntimeException());

        // Act
        bookService.findBookById("1");
    }

    @Test
    public void findAllBooks_EmptyRepository_ReturnsEmptyList() {
        // Arrange
        when(bookRepository.findAll()).thenReturn(Collections.emptyList());

        // Act
        List<Book> result = bookService.findAllBooks();

        // Assert
        assertTrue(result.isEmpty());
    }

    @Test
    public void findBookById_Always_InvokesBookRepositoryFindById() {
        // Arrange
        String id = "anyId";
        bookService.findBookById(id);

        // Act - вызов уже выполнен в Arrange шаге

        // Assert
        verify(bookRepository).findById(id);
    }

    // ... Дополнительные тесты по необходимости
}
 */



//    Iterator iteratorMock = mock(Iterator.class);
//    // Act
//    when(iteratorMock.next()).thenReturn("Hello", "World");
//    String result = iteratorMock.next() + " " + iteratorMock.next();
//    // assert
//    assertEquals("Hello World", result);


}
