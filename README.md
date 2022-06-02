# Loan Management System.
This project is developed as part of learning **Angular and Spring Boot, _a full stack development_**.

## Database Setup
#### 1.  Run Docker Process:
`docker run --name lmspsql -p 5455:5432 -e POSTGRES_USER=lmsUser -e POSTGRES_PASSWORD=one@word1 -e POSTGRES_DB=lmsDB -d  postgres`

Run the following command as needed to manage the postgres database process:
```
docker stop lmspsql 
docker start lmspsql
```

#### 2. Database connection details:
```
Host: localhost
Port: 5455
Database: lmsDB
User: lmsUser
Password: one@word1
```

#### 3. Generating DDL:
   ---------------
Update the below properties in application.yml and run the application as to create DDL:
hibernate.ddl-auto: "create-drop"

Once the DDL are created in postgres database, change the property to the value as 'update' or 'none'.

#### 4. Run the following DML:
```
INSERT INTO public.lms_user(lms_username, lms_userpass, lms_userrole) VALUES('balaadmin', '{noop}pass', 'ROLE_ADMIN');
INSERT INTO public.lms_user(lms_username, lms_userpass, lms_userrole) VALUES('bala', '{noop}pass', 'ROLE_USER');
```

Run the application:
```
cd /dist
java -jar ./loan-management-system-0.0.1-SNAPSHOT.jar
```

**URL:** http://localhost:8080/lmsui/index.html

**For testing application API:** [try postman collection](./artifacts/bootcamp.postman_collection.json)


