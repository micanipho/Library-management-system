# Library Management System (LMS) - Spring Boot API

Welcome to the Library Management System (LMS) project! This is a Spring Boot-based RESTful API designed to manage books, users, and borrowing/returning processes in a library. The system provides endpoints for adding, updating, deleting, and searching books and users, as well as handling book borrowing and returning operations.

## Table of Contents

- [Features](#features)
- [Technologies Used]()
- [Project Structure]()
- [API Endpoints]()
- [Setup and Installation]()
- [Database Configuration]()
- [Running the Application]()
- [Testing the API]()
- [Future Enhancements]()

## Features

### Book Management:

- Add, update, delete, and search books.
- Track book availability (available/borrowed).

### User Management:

- Add, update, and delete users.
- Borrow and return books.
- Track due dates and calculate fines for late returns.
### Data Persistence:

- Uses PostgreSQL for storing book and user data.
- RESTful API:
  - Provides endpoints for all operations.

## Technologies Used

- Spring Boot: Backend framework for building the REST API.
- Spring Data JPA: For database operations and persistence.
- PostgreSQL: Relational database for storing data.
- Maven: Dependency management and build tool.
- Postman: For testing API endpoints.

## Project Structure

src/main/java  
└── com.Library_management_system  
├── controller  
│   ├── BookController.java  
│   └── UserController.java  
├── model  
│   ├── Book.java  
│   └── User.java  
├── repository  
│   ├── BookRepository.interface  
│   └── UserRepository.interface  
│   └── UserConfig.java  
│   └── BookConfig.java    
├── service  
│   ├── BookService.java  
│   └── UserService.java  
└── LibraryManagementSystemApplication.java  

## API Endpoints
### Book Management

- GET   /lms/api/v1/books (Get all books.)  
- GET	/lms/api/v1/books/{bookId} (Get a book by Id.) 
- GET	/lms/api/v1/books/search (Search books by title or author.)  
- POST	/lms/api/v1/books	(Add a new book.)    
- PUT	/lms/api/v1/books/{bookId} (Update a book by Id)  
- DELETE /lms/api/v1/books/{bookId} (Delete a book by Id.)  

### User Management
- GET	/lms/api/v1/users	(Get all users.)
- GET	/lms/api/v1/users/{userId}	(Get a user by ID.)
- POST	/lms/api/v1/users	(Add a new user.)
- PUT	/lms/api/v1/users/{userId}	(Update a user by ID.)
- DELETE /lms/api/v1/users/{userId}	(Delete a user by ID.)

### Borrowing and Returning

- POST	/lms/api/v1/books/borrow	(Borrow a book.)
- POST	/lms/api/v1/books/return	(Return a book.)

## Setup and Installation

### Prerequisites

    Java 21 or higher.

    Maven 3.x.

    PostgreSQL installed and running.

    An IDE (e.g., IntelliJ IDEA, Eclipse).

### Steps

Clone the Repository:
```angular2html
    git clone https://github.com/your-username/library-management-system.git
    cd library-management-system
```
Build the Project:
```bash
    mvn clean install
```
Run the Application:
```bash
    mvn spring-boot:run

```
Access the API:

     The API will be available at http://localhost:8080.

## Database Configuration

Add the following configuration to the application.properties file to connect to your PostgreSQL database:
properties

### PostgreSQL Configuration
```angular2html
spring.datasource.url=jdbc:postgresql://localhost:5432/lmsdb
spring.datasource.username=your-username
spring.datasource.password=your-password
spring.datasource.driver-class-name=org.postgresql.Driver
```

### Hibernate Configuration

```angular2html
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
```
Replace your-username and your-password with your PostgreSQL credentials.

## Running the Application

Start the application using the command:
```bash
    mvn spring-boot:run
```
Use Postman or any API testing tool to interact with the endpoints.

## Testing the API

Use Postman or cURL to test the API endpoints.

### Example requests:

Add a Book:
```bash
        curl -X POST http://localhost:8080/api/books \
        -H "Content-Type: application/json" \
        -d '{"title": "The Great Gatsby", "author": "F. Scott Fitzgerald", "isbn": "9780743273565"}'
```
Borrow a Book:
```bash
        curl -X POST http://localhost:8080/api/books/borrow \
        -H "Content-Type: application/json" \
        -d '{"userId": "1", "isbn": "9780743273565"}'
```
## Future Enhancements

### User Authentication:

- Add JWT-based authentication for secure access.

###    Frontend Integration:

- Develop a React or Angular frontend for a complete web application.

###  Email Notifications:
- Send email reminders for due dates and fines.
### Advanced Search:
Add filters for searching books by genre, publication year, etc.