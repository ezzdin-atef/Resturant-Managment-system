
package resturant.managment.system;

public abstract class Person {
    protected int id = 2;
    protected String fname;
    protected String lname;
    FileManager FManager = new FileManager();
    public Person() {}
    public Person(String fname, String lname) {
        this.id++;
        setFname(fname);
        setLname(lname);
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
    
    public int getId() {
        return id;
    }
    public String getFname() {
        return fname;
    }
    public String getLname() {
        return lname;
    }
    
}
