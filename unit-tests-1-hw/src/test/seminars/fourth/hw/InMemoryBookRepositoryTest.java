package seminars.fourth.hw;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seminars.fourth.book.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class InMemoryBookRepositoryTest {
    private InMemoryBookRepository bookRepository;

    @BeforeEach
    public void setUp() {
        bookRepository = new InMemoryBookRepository();
    }
    @Test
    public void findByIdExistingIdReturnsBook() {

        Book result = bookRepository.findById("1");

        assertNotNull(result);
        assertEquals("1", result.getId());
        assertEquals("Book1", result.getTitle());
        assertEquals("Author1", result.getAuthor());
    }
    @Test
    public void findByIdNonExistingIdReturnsNull() {

        Book result = bookRepository.findById("3");

        assertNull(result);
    }
    @Test
    public void findAllReturnsAllBooks() {

        List<Book> result = bookRepository.findAll();

        assertNotNull(result);
        assertEquals(2, result.size());
    }
}
