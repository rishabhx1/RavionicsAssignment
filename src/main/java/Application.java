import database.DataSource;
import io.javalin.Javalin;
import io.javalin.apibuilder.ApiBuilder;

public class Application {

    public static void main(String[] args) {

        Javalin app = Javalin.create(config -> {
            config.defaultContentType = "application/json";
            config.asyncRequestTimeout = 60_000L;
        });

        app.routes(() -> {
            ApiBuilder.get("colleges", CollegeController::getAll);
            ApiBuilder.get("findCollege", CollegeController::getCollegeDetails);
        });

        app.start(8000);

    }

}
