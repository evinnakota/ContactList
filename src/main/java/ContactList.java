import java.util.ArrayList;

public class ContactList {
    private ArrayList<Person> contacts;
    public ContactList() {
        contacts = new ArrayList<>();
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
        return; /*Menu:
        1. Add Contact
        2. List All Contacts By First Name
        3. List All Contacts By Last Name
        4. List All Contacts By Phone Number
        5. List All Students
        6. Search By First Name
        7. Search By Last Name
        8. Search by Phone Number
        0. Exit

        for (int action = 9; action != 0;) {
        print menu
        ask user what they want to do
        for 1-8, do the thing (call the func) use ifs
        specify details
        if they ever pick 0;
        }

         */
    }

}
