
package resturant.managment.system;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileManager implements Serializable {
    public boolean write(String FilePath, Object data) {
        ObjectOutputStream writter;
        try {
            writter = new ObjectOutputStream(new FileOutputStream(FilePath));
            writter.writeObject(data);
            writter.flush();
            writter.close();
            return true;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public ArrayList<Object> read(String FilePath) {
        ArrayList Result = new ArrayList() ;
        ObjectInputStream Reader;
        try {
            Reader = new ObjectInputStream(new FileInputStream(FilePath));
            Result = (ArrayList) Reader.readObject();
            Reader.close();
        } catch(EOFException e) {
            System.out.print("");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (ArrayList<Object>) (Object) Result;
    }
    
    
}
