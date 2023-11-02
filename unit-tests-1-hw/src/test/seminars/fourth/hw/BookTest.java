package seminars.fourth.hw;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import seminars.fourth.book.*;

public class BookTest {
    @Test
    public void gettersAndSetters_WorkAsExpected() {

        Book book = new Book("1", "Test Book", "Test Author");

        assertEquals("1", book.getId());
        assertEquals("Test Book", book.getTitle());
        assertEquals("Test Author", book.getAuthor());

        book.setId("2");
        assertEquals("2", book.getId());

        book.setTitle("New Title");
        assertEquals("New Title", book.getTitle());

        book.setAuthor("New Author");
        assertEquals("New Author", book.getAuthor());
    }
}
