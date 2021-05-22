package LibraryTest;
import Library.Actions;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TestMethods extends Actions {

    @Test
    public void testAddBook() {
        Response output = addBook(payload);
        Assert.assertEquals("successfully added", output.jsonPath().getString("Msg"));
    }

    @Test
    public void getBookByIdTest() {
        Response bookAdded = addBook(payload);
        Response bookId = getBook(IdURL, bookAdded.jsonPath().getString("ID"));
        Assert.assertEquals("physics", bookId.jsonPath().getString("isbn[0]"));
    }

    @Test
    public void getBookByNameTest() {
        Response bookAdded = addBook(payload);
        Response bookId = getBook(IdURL, bookAdded.jsonPath().getString("ID"));
        String author = bookId.jsonPath().getString("author[0]");
        Response bookName = getBook(NameURL, author);
        Assert.assertEquals("physics", bookName.jsonPath().getString("isbn[0]"));
    }

    @Test
    public void removeBookTest() {
        Response addingBook = addBook(payload);
        Response output = deleteRequest("http://216.10.245.166/Library/DeleteBook.php", addingBook.jsonPath().getString("ID"));
        Assert.assertEquals("book is successfully deleted",output.jsonPath().getString("msg"));
    }
}

