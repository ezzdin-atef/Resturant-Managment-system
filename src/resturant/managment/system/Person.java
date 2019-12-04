
package resturant.managment.system;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class Person implements Serializable {
    protected int id = 2;
    protected String username;
    protected String password;
    protected String fname;
    protected String lname;
    protected int flag = 0;
    protected final String PersonFileName = "person.bin";
    public static ArrayList<Person> Persons = new ArrayList<Person>();
    FileManager FManager = new FileManager();
    public Person() {}
    public Person(String fname, String lname, String username, String pass) {
        loadFromFile();
        if (Persons.size() == 0) 
            setId(1);
        else
            setId(Persons.get(Persons.size()-1).getId() + 1);
        setFname(fname);
        setLname(lname);
        setUsername(username);
        setPassword(pass);
        setFlag(0);
    }
    public void commitToFile() {
        FManager.write(PersonFileName, Persons);
    }
    
    public void loadFromFile() {
        Persons = (ArrayList<Person>) (Object) FManager.read(PersonFileName);
    }
    protected String getPersonData() {
        return this.id + "@" + this.username + "@" + this.password + "@" + this.fname + "@" + this.lname + "@" + this.flag;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setFname(String name) {
        this.fname = name;
    }
    public void setLname(String name) {
        this.lname = name;
    }
    public void setUsername(String usr) {
        this.username = usr;
    }
    public void setPassword(String pass) {
        this.password = pass;
    }
    public void setFlag(int flag) {
        this.flag = flag;
    }
    public int getFlag() {
        return this.flag;
    }
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public int getId() {
        return id;
    }
    public String getFname() {
        return fname;
    }
    public String getLname() {
        return lname;
    }
    public abstract boolean login(String user, String pass);
}
