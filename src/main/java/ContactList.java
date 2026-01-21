import java.util.ArrayList;
import java.util.Scanner;

public class ContactList {
    private ArrayList<Person> contacts;
    public ContactList() {
        this.contacts = new ArrayList<>();
    }

    public ArrayList<Person> getContacts() {
        return contacts;
    }

    public void addContact(Person p) {
        contacts.add(p);
    }

    public void printContacts() {
        for (Person p : contacts) {
            System.out.println(p);
        }
    }

    public void sort(int sortBy) {
        int n = contacts.size();
        boolean done = false;
        for (int i = 0; i < n-1 && !done; i++) {
            done = true;
            for (int j = 0; j < n-1-i;j++) {
                if (compare(contacts.get(j+1),contacts.get(j),sortBy)) {
                    Person a = contacts.get(j);
                    contacts.set(j,contacts.get(j+1));
                    contacts.set(j+1,a);
                    done = false;
                }
            }
        }
    }

    public static boolean compare(Person p1, Person p2, int s) {
        if (0 == s) return p1.getFirstName().compareTo(p2.getFirstName()) < 0;
        if (1 == s) return p1.getLastName().compareTo(p2.getLastName()) < 0;
        return p1.getPhoneNumber().compareTo(p2.getPhoneNumber()) < 0;
    }

    public static boolean isMatch(Person p, String f, int s) {
        if (0 == s) return p.getFirstName().compareTo(f) == 0;
        if (1 == s) return p.getLastName().compareTo(f) == 0;
        return p.getPhoneNumber().compareTo(f) == 0;
    }

    public Person search(String s, int key) {
        for (Person p : contacts) {
            if (isMatch(p,s,key)) return p;
        }
        return null;

    }
    public Person searchByFirstName(String f) {
        return search(f,0);
    }
    public Person searchByLastName(String l) {
        return search(l,1);
    }
    public Person searchByPhoneNumber(String p) {
        return search(p,2);
    }


    public void listStudents() {
        for (Person p : contacts) {
            if (p instanceof Student) System.out.println(p);
        }
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        int action = -1;
        while (action != 0) {
            System.out.println("Menu: ");
            System.out.println("1. Add Contact");
            System.out.println("2. List All Contacts By First Name");
            System.out.println("4. List All Contacts By Phone Number");
            System.out.println("5. List All Students");
            System.out.println("6. Search By First Name");
            System.out.println("7. Search By Last Name");
            System.out.println("8. Search by Phone Number");
            System.out.println("0. Exit");

            if (!scanner.hasNextInt()) {
                System.out.println("Please enter a number (0-8).");
                scanner.nextLine();
                continue;
            }

            action = scanner.nextInt();
            scanner.nextLine();

            if (action == 1) {
                System.out.println("Select contact type:");
                System.out.println("1. Student");
                System.out.println("2. Singer");
                System.out.print("Choice: ");

                if (!scanner.hasNextInt()) {
                    System.out.println("Invalid choice.");
                    scanner.nextLine();
                    continue;
                }

                int type = scanner.nextInt();
                scanner.nextLine();

                System.out.print("First Name: ");
                String first = scanner.nextLine();

                System.out.print("Last Name: ");
                String last = scanner.nextLine();

                System.out.print("Phone Number: ");
                String phone = scanner.nextLine();

                if (type == 1) {
                    System.out.print("Grade: ");
                    if (!scanner.hasNextInt()) {
                        System.out.println("Grade must be a number.");
                        scanner.nextLine();
                        continue;
                    }

                    int grade = scanner.nextInt();
                    scanner.nextLine();

                    addContact(new Student(first, last, phone, grade));
                    System.out.println("Added contact.");

                } else if (type == 2) {
                    System.out.print("Singer Part: ");
                    String part = scanner.nextLine();

                    addContact(new Singer(first, last, phone, part));
                    System.out.println("Added contact.");

                } else {
                    System.out.println("Invalid contact type.");
                }

            } else if (action == 2) {
                sort(0);
                printContacts();

            } else if (action == 3) {
                sort(1);
                printContacts();

            } else if (action == 4) {
                sort(2);
                printContacts();

            } else if (action == 5) {
                listStudents();

            } else if (action == 6) {
                System.out.print("Enter first name: ");
                String name = scanner.nextLine();
                Person p = searchByFirstName(name);
                if (p == null) System.out.println(name + " is not in the list");
                else System.out.println(p);


            } else if (action == 7) {
                System.out.print("Enter last name: ");
                String name = scanner.nextLine();
                Person p = searchByLastName(name);
                if (p == null) System.out.println(name + " is not in the list");
                else System.out.println(p);

            } else if (action == 8) {
                System.out.print("Enter phone number: ");
                String phone = scanner.nextLine();
                Person p = searchByPhoneNumber(phone);
                if (p == null) System.out.println(phone + " is not in the list");
                else System.out.println(p);

            } else if (action == 0) {
                System.out.println("Goodbye!");

            } else {
                System.out.println("Invalid option.");
            }


        }


    }
    public static void main(String[] args) {
        ContactList cl = new ContactList();
        cl.run();
    }


}
