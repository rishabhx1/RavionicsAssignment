package database;

import models.AccommodationDetails;
import models.CollegeDetails;
import models.CourseDetails;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CollegeDataSource {

    private static final Map<String, CollegeDetails> collegeIdDetailsMap = new HashMap<>();
    private static final Map<String, CourseDetails> courseIdDetailsMap = new HashMap<>();

    public static void init() {
        // Mock data
        CourseDetails courseDetails1 = new CourseDetails(
                "1-1",
                "Computer Science",
                100.0,
                "1 month"
        );
        CourseDetails courseDetails2 = new CourseDetails(
                "2-1",
                "English",
                1000.0,
                "3 month"
        );

        AccommodationDetails accommodationDetails = new AccommodationDetails(
                true,
                150.0
        );

        CollegeDetails collegeDetails1 = new CollegeDetails(
                "1",
                "Maharaja Agrasen University",
                courseDetails1,
                accommodationDetails
        );

        CollegeDetails collegeDetails2 = new CollegeDetails(
                "2",
                "Bhartiye Vidyapeeth Deemed University",
                courseDetails2,
                accommodationDetails
        );

        courseIdDetailsMap.put(courseDetails1.getId(), courseDetails1);
        courseIdDetailsMap.put(courseDetails2.getId(), courseDetails2);

        collegeIdDetailsMap.put(collegeDetails1.getId(), collegeDetails1);
        collegeIdDetailsMap.put(collegeDetails2.getId(), collegeDetails2);

    }

    public static List<CollegeDetails> getAll() {
        List<CollegeDetails> list = new ArrayList<>();

        try (Connection connection = DataSource.getConnection();
             ResultSet resultSet = connection.prepareStatement(
                     "SELECT \n" +
                             "college_table.id,\n" +
                             "college_table.name,\n" +
                             "college_table.accommodation_is_ac,\n" +
                             "college_table.accommodation_fees,\n" +
                             "college_table.course_id,\n" +
                             "course_table.name as course_name,\n" +
                             "course_table.fees as course_fees,\n" +
                             "course_table.duration as course_duration\n" +
                             "FROM college_table   \n" +
                             "INNER JOIN course_table\n" +
                             "ON college_table.course_id = course_table.id;"
             ).executeQuery()
        ) {

            while (resultSet.next()) {
                CollegeDetails collegeDetails = getCollegeDetails(resultSet);

                list.add(collegeDetails);
            }
            connection.close();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            return list;
        }
    }

    @NotNull
    private static CollegeDetails getCollegeDetails(ResultSet resultSet) throws SQLException {
        String id = resultSet.getString("id");
        String name = resultSet.getString("name");
        boolean accommodationIsAc = resultSet.getBoolean("accommodation_is_ac");
        double accommodationFees = resultSet.getDouble("accommodation_fees");
        String courseId = resultSet.getString("course_id");
        String courseName = resultSet.getString("course_name");
        double courseFees = resultSet.getDouble("course_fees");
        String courseDuration = resultSet.getString("course_duration");

        return new CollegeDetails(
                id,
                name,
                new CourseDetails(
                        courseId,
                        courseName,
                        courseFees,
                        courseDuration
                ),
                new AccommodationDetails(
                        accommodationIsAc,
                        accommodationFees
                )
        );
    }

    @Nullable
    public static CollegeDetails getCollegeDetails(String courseName) {
        try (Connection connection = DataSource.getConnection()) {
            ResultSet idSet = connection.prepareStatement("SELECT id FROM course_table WHERE name=\"" + courseName + "\";")
                    .executeQuery();

            String id = null;

            while (idSet.next()) {
                id = idSet.getString("id");
            }

            ResultSet resultSet = connection.prepareStatement(
                    "SELECT \n" +
                            "college_table.id,\n" +
                            "college_table.name,\n" +
                            "college_table.accommodation_is_ac,\n" +
                            "college_table.accommodation_fees,\n" +
                            "college_table.course_id,\n" +
                            "course_table.name as course_name,\n" +
                            "course_table.fees as course_fees,\n" +
                            "course_table.duration as course_duration\n" +
                            "FROM college_table   \n" +
                            "INNER JOIN course_table\n" +
                            "ON college_table.course_id = course_table.id\n" +
                            "WHERE course_id=\"" + id + "\";"
            ).executeQuery();

            CollegeDetails details;

            resultSet.next();
            details = getCollegeDetails(resultSet);
            connection.close();

            return details;

        } catch (SQLException e) {
            return null;
        }
    }



}
