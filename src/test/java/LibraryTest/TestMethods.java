package LibraryTest;

import Library.Actions;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


public class TestMethods extends Actions {

    @BeforeMethod
    public void init() {
        SetPayload();
    }

    @Test
    public void testAddBook() {
        Response output = addBook(payload);
        Assert.assertEquals("successfully added", output.jsonPath().getString("Msg"));
    }

    @Test
    public void getBookByIdTest() {
        Response bookAdded = addBook(payload);
        Response bookId = getBook(IdURL, bookAdded.jsonPath().getString("ID"));
        assertEquals(bookId.jsonPath().getString("author[0]"), "Sonu");
    }

    @Test
    public void getBookByNameTest() {
        Response bookAdded = addBook(payload);
        Response bookId = getBook(IdURL, bookAdded.jsonPath().getString("ID"));
        String author = bookId.jsonPath().getString("author[0]");
        Response bookName = getBook(NameURL, author);
        assertEquals(bookName.jsonPath().getString("book_name[0]"), "Chemistry");
    }

    @Test
    public void testDeleteBook() {
        Response requestOutput = addBook(payload);
        Response output = deleteRequest(DeleteBookURL, requestOutput.jsonPath().getString("ID"));
        assertEquals(output.jsonPath().getString("msg"), "book is successfully deleted");
    }
}

