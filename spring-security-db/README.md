## Spring Security Using Mysql Basic Authentication in  Spring Boot App

This project covers the following:
- Basic Authentication using credentials "mmsr/mmsr".
- MySQL DB connection with "Record" table. See DB_Dump.sql file
- Secured URLs are configured in RecordController class to perform CRUD operations.
- Application will startup on the default port 8080.
- URLs having "secured" are not accessible without logging
- The project contains Dockerfile which can be used to build the docker images.


Instructions for testing
-------------------------

- When the application is up, following URLs are exposed

http://localhost:8080/all - GET
http://localhost:8080/getSimpleRecord
http://localhost:8080/secured/getRecords
http://localhost:8080/secured/getRecord/2
http://localhost:8080/secured/createRecord - POST
http://localhost:8080/secured/updateRecord - PUT
http://localhost:8080/secured/deleteRecord - DELETE

- When testing with Postman, it is required to create header by selecting "BasicAuth" in Authorization option and giving username/password as "mmsr/mmsr"
- Sample JSON for testing

{
    "id": "2",
    "name": "name2",
    "description": "record2"
}

screenshot of postman will be sent.


