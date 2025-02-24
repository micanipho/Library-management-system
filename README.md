# Library Management System (LMS) Specification

## 1. Introduction
The Library Management System (LMS) is a software application designed to manage the operations of a library. It allows librarians to manage books, users, and borrowing/returning processes efficiently. The system will be developed in Java and will include a console-based interface for interaction.

---

## 2. Objectives
- Simplify book and user management.
- Track book borrowing and returning processes.
- Provide a user-friendly interface for librarians and users.
- Ensure data persistence by saving book and user information to files.

---

## 3. Functional Requirements

### 3.1 Book Management
- **Add a Book**:
  - Librarians can add new books to the library.
  - Each book will have the following attributes:
    - Title
    - Author
    - ISBN (unique identifier)
    - Availability status (available/borrowed)
- **Update a Book**:
  - Librarians can update book details (e.g., title, author).
- **Delete a Book**:
  - Librarians can remove a book from the library using its ISBN.
- **Search for a Book**:
  - Users can search for a book by its ISBN, title, or author.
- **List All Books**:
  - Display a list of all books in the library.

### 3.2 User Management
- **Add a User**:
  - Librarians can add new users (students or librarians).
  - Each user will have the following attributes:
    - Name
    - User ID (unique identifier)
    - Contact Information
- **Update a User**:
  - Librarians can update user details (e.g., name, contact information).
- **Delete a User**:
  - Librarians can remove a user from the system using their User ID.
- **List All Users**:
  - Display a list of all users.

### 3.3 Borrowing and Returning Books
- **Borrow a Book**:
  - Users can borrow a book if it is available.
  - The system will update the book's availability status to "borrowed."
- **Return a Book**:
  - Users can return a borrowed book.
  - The system will update the book's availability status to "available."
- **Track Due Dates**:
  - The system will track the due date for borrowed books.
- **Calculate Fines**:
  - If a book is returned after the due date, the system will calculate a fine.

### 3.4 Data Persistence
- **Save Data**:
  - Book and user data will be saved to files (e.g., `books.dat`, `users.dat`).
- **Load Data**:
  - The system will load book and user data from files when the program starts.

### 3.5 User Interface
- **Console-Based Interface**:
  - A menu-driven interface will allow users to interact with the system.
  - Options will include:
    - Add/Update/Delete/Search Books
    - Add/Update/Delete Users
    - Borrow/Return Books
    - Exit the System

---

## 4. Non-Functional Requirements
- **Performance**:
  - The system should handle up to 10,000 books and 1,000 users efficiently.
- **Usability**:
  - The console interface should be intuitive and easy to use.
- **Reliability**:
  - Data should not be lost in case of unexpected program termination.
- **Scalability**:
  - The system should be designed to allow future enhancements (e.g., GUI, database integration).

---

## 5. System Design

### 5.1 Class Diagram

+-----------------+       +-----------------+       +-----------------+
|      Book       |       |      User       |       |     Library     |
+-----------------+       +-----------------+       +-----------------+
| - title: String |       | - name: String  |       | - books: List   |
| - author: String|       | - userId: String|       | - users: List   |
| - isbn: String  |       | - contactInfo:  |       +-----------------+
| - isAvailable:  |       |   String        |       | + addBook()     |
|   boolean       |       +-----------------+       | + removeBook()  |
+-----------------+       | + getName()     |       | + searchBook()  |
| + getTitle()    |       | + getUserId()   |       | + addUser()     |
| + getAuthor()   |       | + getContactInfo|       | + removeUser()  |
| + getIsbn()     |       +-----------------+       | + borrowBook()  |
| + isAvailable() |                                 | + returnBook()  |
+-----------------+                                 +-----------------+


### 5.2 Data Storage
- **Books**:
  - Stored in a file named `books.dat`.
  - Serialized using Java's `ObjectOutputStream`.
- **Users**:
  - Stored in a file named `users.dat`.
  - Serialized using Java's `ObjectOutputStream`.

---

## 6. Technology Stack
- **Programming Language**: Java
- **File Handling**: Java I/O (ObjectInputStream, ObjectOutputStream)
- **User Interface**: Console-based (Scanner for input)
- **Testing**: JUnit (for unit testing)

---

## 7. Future Enhancements
1. **Graphical User Interface (GUI)**:
   - Use JavaFX or Swing to create a more user-friendly interface.
2. **Database Integration**:
   - Replace file storage with a database like MySQL or SQLite.
3. **User Authentication**:
   - Add a login system for librarians and users.
4. **Advanced Search**:
   - Allow searching by multiple criteria (e.g., genre, publication year).
5. **Email Notifications**:
   - Send email reminders for due dates.

---

## 8. Testing Plan
- **Unit Testing**:
  - Test individual methods (e.g., `addBook`, `borrowBook`).
- **Integration Testing**:
  - Test the interaction between classes (e.g., `Library` and `Book`).
- **User Acceptance Testing (UAT)**:
  - Ensure the system meets the requirements of librarians and users.

---

## 9. Deliverables
1. **Source Code**:
   - Java classes for `Book`, `User`, `Library`, and `Main`.
2. **Data Files**:
   - `books.dat` and `users.dat` for storing data.
3. **Documentation**:
   - User manual for operating the system.
   - Developer documentation for future enhancements.

