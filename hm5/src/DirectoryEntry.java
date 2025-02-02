
import java.util.ArrayList;
import java.util.Objects;

public class DirectoryEntry {
    private String name; // person’s name
    private String number; // person’s phone number
    public void setNumber(String phoneNum) { number = phoneNum; }
    public String getNumber() { return number; }
    public void setName(String phoneName) {name = phoneName;}
    public String getName() {return name;}



}

class Test {
    ArrayList<DirectoryEntry> theDirectory = new ArrayList<>();

// aName: The name of the person being added or changed
// newNumber: The new number to be assigned
public String addOrChangeEntry(String name, String newNumber) {
        boolean nameFound = false;
        String oldNumber = null;
        for (DirectoryEntry i: theDirectory) {
        if (Objects.equals(i.getName(), name)) {
        oldNumber = i.getNumber();
        i.setNumber(newNumber);
        nameFound = true;
        }
        }
        if (!nameFound) {
        DirectoryEntry newDirectory = new DirectoryEntry();
        newDirectory.setName(name);
        newDirectory.setNumber(newNumber);
        theDirectory.add(newDirectory);
        }
        return oldNumber;
        }

// aName: The name of the person to be removed
public DirectoryEntry remove (String aName) {
        DirectoryEntry oldDirectory = null;
        for (DirectoryEntry i: theDirectory) {
        if (Objects.equals(i.getName(), aName)){
        oldDirectory = i;
        theDirectory.remove(i);
        }
        }
        return oldDirectory;
        }

    public static void main(String[] args) {
        Test t = new Test();
        DirectoryEntry d1 = new DirectoryEntry(); d1.setName("Jack"); d1.setNumber("111");
        DirectoryEntry d2 = new DirectoryEntry(); d2.setName("Mohamed"); d2.setNumber("222");
        t.theDirectory.add(d1); t.theDirectory.add(d2);
        System.out.println(t.addOrChangeEntry("Juntang", "333"));
        System.out.println(t.remove("Mohamed"));
        for (DirectoryEntry d : t.theDirectory) {
            System.out.println(d.getName() + "\t" +d.getNumber());
        }
    }
}


