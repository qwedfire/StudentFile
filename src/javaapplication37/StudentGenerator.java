/**
 * StudentGenrator
隨機產生1000個student(裡面的屬性會依照格式隨機產生)，並在成績單屬性裡面隨機產生不同科目0~3個Grade的物件(屬性值依照格式隨機產生)，將其使用Serializable寫進檔案。
 */
package javaapplication37;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *學生產生器
 * @author LAND
 */
public class StudentGenerator implements Serializable{                
    public static final int MAX_STUDENT = 1000;                  
    public StudentGenerator(){        
        try {			
            FileOutputStream fos = new FileOutputStream("1.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            for(int i = 0 ; i < MAX_STUDENT ; i++) {                         
                oos.writeObject(new Student());
            }   
            oos.close();
        }
        catch(IOException ex) {
            ex.printStackTrace();     
        }
    }   
}
