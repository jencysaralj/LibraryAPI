package Library;

import com.github.javafaker.Faker;

public class Setup {
    public String id;
    public String authorName;
    public String IdURL="http://216.10.245.166/Library/GetBook.php?ID=";
    public String NameURL="http://216.10.245.166/Library/GetBook.php?AuthorName=";
    public String DeleteBookURL="http://216.10.245.166//Library/DeleteBook.php";
    Faker faker = new Faker();
    String aisle = faker.number().digits(8);

    public String payload = "{\n" +
            "\"name\":\"Chemistry\",\n" +
            "\"isbn\":\"physics\",\n" +
            "\"aisle\":" + aisle + ",\n" +
            "\"author\":\"Sonu\"\n" +
            "}";
}
