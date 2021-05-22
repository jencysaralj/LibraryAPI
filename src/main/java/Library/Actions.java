package Library;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class Actions extends Setup {
    public Response addBook(String payload) {
        Response response = given().
                contentType(ContentType.JSON).
                body(payload).
                post("http://216.10.245.166/Library/Addbook.php")
                .then()
                .log()
                .all()
                .statusCode(200)
                .extract()
                .response();
        return response;
    }

    public Response getBook(String URI, String Id) {
        Response response = given().
                get(URI + Id)
                .then()
                .log()
                .all()
                .statusCode(200)
                .extract()
                .response();
        return response;
    }

    public Response deleteRequest(String deleteUrl , String id) {
        String deleteId = "{\n" +
                "    \"ID\":" + id + "\n" +
                "}";
        Response response = given()
                .header("Content-type", "application/json")
                .body(deleteId)
                .and()
                .delete(deleteUrl)
                .then()
                .extract().response();
        return response;
    }
}