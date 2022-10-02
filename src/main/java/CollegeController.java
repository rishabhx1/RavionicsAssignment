import database.CollegeDataSource;
import io.javalin.http.Context;
import io.javalin.http.HttpCode;
import models.CollegeDetails;

public class CollegeController {

    public static final String QUERY_PARAM_COURSE_NAME = "course_name";
    public static void getAll(Context context) {
        context.json(CollegeDataSource.getAll());
    }

    public static void getCollegeDetails(Context context) {
        String courseName = context.queryParam(QUERY_PARAM_COURSE_NAME);

        if (courseName == null || courseName.isBlank()) {
            context.status(HttpCode.BAD_REQUEST);
            return;
        }

       CollegeDetails collegeDetails = CollegeDataSource.getCollegeDetails(courseName);
        if (collegeDetails != null) {
            context.json(collegeDetails);
        } else {
            context.status(HttpCode.NOT_FOUND);
        }
    }

}
