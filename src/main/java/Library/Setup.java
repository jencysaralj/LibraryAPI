package Library;

import com.github.javafaker.Faker;

public class Setup {
    public String IdURL = "http://216.10.245.166/Library/GetBook.php?ID=";
    public String NameURL = "http://216.10.245.166/Library/GetBook.php?AuthorName=";
    public String DeleteBookURL = "http://216.10.245.166/Library/DeleteBook.php";
    public String payload;

    public void SetPayload() {
        Faker faker = new Faker();
        String aisle = faker.number().digits(6);
        String isbn = faker.number().digits(6);
        payload = "{\n" +
                "\"name\":\"Chemistry\",\n" +
                "\"isbn\":" + isbn + ",\n" +
                "\"aisle\":" + aisle + ",\n" +
                "\"author\":\"Sonu\"\n" +
                "}";
    }
}
