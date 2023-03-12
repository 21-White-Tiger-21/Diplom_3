package steps;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import model.UserCredentialsModel;
import model.UserModel;
import static org.apache.http.HttpStatus.SC_ACCEPTED;

public class UserClient extends RestClient {
    @Step("Регистрация нового пользователя")
    public Response registerNewUser(UserModel user) {
        String REGISTER = "/auth/register";
        return reqSpec
                .body(user)
                .when()
                .post(REGISTER);
    }
    @Step("Авторизация пользователя")
    public Response login(UserCredentialsModel creds) {
        String LOGIN = "/auth/login";
        return reqSpec
                .body(creds)
                .when()
                .post(LOGIN);
    }
    @Step("Удаление пользователя")
    public void delete(String user, String bearerToken) {
        String DELETE = "/auth/user?={user}";
        reqSpec
                .header("authorization", bearerToken)
                .pathParams("user", user)
                .when()
                .delete(DELETE)
                .then().log().all()
                .assertThat()
                .statusCode(SC_ACCEPTED);
    }
}