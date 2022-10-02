# RavionicsAssignment
Assignment was to create a college database with college table and course table and fetch that data using API.

## Libraries used
1. Javalin - to create APIs.
2. MySQL JDBC - to connect database.
3. Java

## Scripts 
I have created a script using MySQL workbench to database, tables and add mock data.
That script can be ran using MySQL workbench.

## Time to run project
1. Start MySQL server.
2. Update MySQL username, password in class DataSource if needed.
3. Run the script to add mock data.
4. Run the project IDE.

## How to test project 
1. Use postman/insomnia/cmd line to test API calls.
2. Project is started on `localhost:8000`.

Added screenshots for requests and responses.
## Curl commands to test

1. Request: 
`curl --request GET \
  --url http://localhost:8000/colleges`
  
  
  Response:
  `[
 {
  "id": "1",
  "name": "Maharaja Agrasen University",
  "course_details": {
   "id": "1-1",
   "name": "Computer Science",
   "fees": 100.0,
   "duration": "1 month"
  },
  "accommodation_details": {
   "is_ac": true,
   "fees": 1000.0
  }
 },
 {
  "id": "2",
  "name": "Bhartiye Vidyapeeth Deemed University",
  "course_details": {
   "id": "2-1",
   "name": "English",
   "fees": 150.0,
   "duration": "3 months"
  },
  "accommodation_details": {
   "is_ac": false,
   "fees": 1500.0
  }
 }
]`
  
2. Request:
`curl --request GET \
  --url 'http://localhost:8000/findCollege?course_name=English'`
  
  
  Response:
  ``{
 "id": "2",
 "name": "Bhartiye Vidyapeeth Deemed University",
 "course_details": {
  "id": "2-1",
  "name": "English",
  "fees": 150.0,
  "duration": "3 months"
 },
 "accommodation_details": {
  "is_ac": false,
  "fees": 1500.0
 }
}``

## References
1. https://www.jsonschema2pojo.org/
2. https://javalin.io/documentation

