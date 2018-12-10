package librarymanagement;

import java.util.*;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;

public class LibraryManagement {

    public Scanner io = new Scanner(System.in);
    static BookManager bookManager = new BookManager();
    static StudentManager studentManager = new StudentManager();

    public static void main(String[] args) {
        LibraryManagement lm = new LibraryManagement();
        lm.showMenu();


    }

    public void showMenu() {


        while (true) {
            try {
                int choice = 0;
                System.out.println("1.Add Book");
                System.out.println("2.Remove Book");
                System.out.println("3.Add Student");
                System.out.println("4.Remove Student");
                System.out.println("5.Edit Book");
                System.out.println("6.Edit Student");
                System.out.println("7.sort books");
                System.out.println("8.sort students");
                System.out.println("9.exit");
                choice = io.nextInt();
                if (choice == 9) {
                    System.exit(0);
                }
                System.out.println("taking action for entered choice " + choice);
                takeAction(choice);


            } catch (InputMismatchException e) {
                System.out.println("enter valid number");
            }
            io.nextLine();
        }

    }

    public void takeAction(int choice) {

        switch (choice) {
            case 1: {
                try {
                    int id = 0;
                    System.out.println("Enter book id");
                    id = io.nextInt();
                    io.nextLine();
                    System.out.println("Enter book title");
                    String title = io.nextLine();
                    System.out.println("Enter book author");
                    String author = io.nextLine();
                    Book b = new Book(id, title, author);
                    if (bookManager.addBook(b)) {
                        System.out.println("book added successfully");
                    } else {
                        System.out.println("book cannot be added");
                    }

                } catch (InputMismatchException e) {
                    System.out.println("enter valid input!");
                }
                break;
            }
            case 2: {
                try {
                    System.out.println("Enter book id");
                    int id = io.nextInt();
                    io.nextLine();
                    Book b = bookManager.find(id);
                    if (b == null) {
                        System.out.println("book cannot be removed");
                    } else {
                        bookManager.remove(b);
                        System.out.println("book removed successfully");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("enter valid input!");
                }
                break;
            }


            case 3: {
                try {

                    System.out.println("Enter Student id");
                    int id = io.nextInt();
                    io.nextLine();
                    System.out.println("Enter Student name");
                    String name = io.nextLine();
                    System.out.println("Enter Student dept");
                    String dept = io.nextLine();
                    Student s = new Student(id, name, dept);
                    if (studentManager.addStudent(s)) {
                        System.out.println("student added successfully");
                    } else {
                        System.out.println("student cannot be added");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("enter valid input!");
                }
                break;
            }


            case 4: {
                try {
                    System.out.println("Enter student id");
                    int id = io.nextInt();
                    io.nextLine();
                    Student s = studentManager.find(id);
                    if (s == null) {
                        System.out.println("student cannot be removed");
                    } else {
                        studentManager.remove(s);
                        System.out.println("student removed successfully");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("enter valid input!");
                }
                break;

            }


            case 5: {
                try {
                    System.out.println("Enter book id");
                    int id = io.nextInt();
                    io.nextLine();
                    Book b = bookManager.find(id);
                    if (b == null) {
                        System.out.println("book not found!");
                    } else {
                        System.out.println("Enter book title to update");
                        String title = io.nextLine();
                        b.setTitle(title);
                        System.out.println("Enter book author to update");
                        String author = io.nextLine();
                        b.setAuthor(author);
                        System.out.println("book edited successfully");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("enter valid input!");
                }
                break;
            }


            case 6: {
                try {
                    System.out.println("Enter student id");
                    int id = io.nextInt();
                    io.nextLine();
                    Student s = studentManager.find(id);
                    if (s == null) {
                        System.out.println("student not found!");
                    } else {
                        System.out.println("Enter student name to update");
                        String name = io.nextLine();
                        s.setName(name);
                        System.out.println("Enter student dept to update");
                        String dept = io.nextLine();
                        s.setDept(dept);
                        System.out.println("student edited successfully");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("enter valid input!");
                }
                break;
            }
            case 7: {
                try {
                    ArrayList<Book> booklist = new ArrayList<Book>();
                    booklist = bookManager.getBookList();
                    System.out.println("1.sort by id");
                    System.out.println("2.sort by name");
                    System.out.println("3.sort by author name");
                    int temp = io.nextInt();
                    io.nextLine();
                    switch (temp) {
                        case 1: {
                            IdCompare idcompare = new IdCompare();
                            Collections.sort(booklist, idcompare);
                            printBooks(booklist);

                            break;
                        }
                        case 2: {
                            NameCompare namecompare = new NameCompare();
                            Collections.sort(booklist, namecompare);
                            printBooks(booklist);
                            break;
                        }
                        case 3: {
                            AuthorCompare authorcompare = new AuthorCompare();
                            Collections.sort(booklist, authorcompare);
                            printBooks(booklist);
                            break;
                        }
                        default: {
                            System.out.println("enter valid option!");
                            break;
                        }
                    }
                } catch (InputMismatchException e) {
                    System.out.println("enter valid input!");
                }
                break;
            }
            case 8: {
                try {
                    ArrayList<Student> studentlist = new ArrayList<Student>();
                    studentlist = studentManager.getStudentList();
                    System.out.println("1.sort by id");
                    System.out.println("2.sort by name");
                    System.out.println("3.sort by department");
                    int temp = io.nextInt();
                    io.nextLine();
                    switch (temp) {
                        case 1: {
                            StuIdCompare idcompare = new StuIdCompare();
                            Collections.sort(studentlist, idcompare);
                            printStudents(studentlist);

                            break;
                        }
                        case 2: {
                            StuNameCompare namecompare = new StuNameCompare();
                            Collections.sort(studentlist, namecompare);
                            printStudents(studentlist);
                            break;
                        }
                        case 3: {
                            StuDeptCompare authorcompare = new StuDeptCompare();
                            Collections.sort(studentlist, authorcompare);
                            printStudents(studentlist);
                            break;
                        }
                        default: {
                            System.out.println("enter valid option!");
                            break;
                        }
                    }
                } catch (InputMismatchException e) {
                    System.out.println("enter valid input!");
                }
                break;
            }
            default: {
                System.out.println("enter valid choice!");
                break;
            }
        }
    }

    public void printBooks(ArrayList<Book> booklist) {
        for (Book book : booklist) {
            System.out.println(book.getId() + "\t"
                    + book.getTitle() + "\t"
                    + book.getAuthor());
        }
    }

    public void printStudents(ArrayList<Student> studentlist) {
        for (Student student : studentlist) {
            System.out.println(student.getId() + "\t"
                    + student.getName() + "\t"
                    + student.getDept());
        }
    }
}
