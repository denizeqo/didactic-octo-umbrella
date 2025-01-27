package services.DAO;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookDAOTest {

    @Test
    void checkAvailability() {
        BookDAO book = new BookDAO();

        boolean isav = book.checkAvailability(222414);

        assertEquals(true, isav);
    }
}