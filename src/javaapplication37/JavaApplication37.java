
package javaapplication37;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author LAND
 */
public class JavaApplication37 {
    public static final int MAX_STUDENT = 1000;
    public static void main(String[] args) {                   
        int mathsum=0;   //數學成績總和
        int sciencesum=0; //自然成績總和
        int englishsum=0; //英文成績總和
        int mathcount=0;  //數學成績有幾筆
        int sciencecount=0; //自然成績有幾筆
        int englishcount=0;  //英文成績有幾筆
        try{ 
            FileInputStream fis=new FileInputStream("1.ser");
            ObjectInputStream ois=new ObjectInputStream(fis);   
            for(int i=0;i<MAX_STUDENT;i++){                
                Student student=(Student)ois.readObject();  
                for(Grade j:student.getgrade()){
                    if(j.getmathscore()!=0){
                       mathsum+=j.getmathscore();
                       mathcount++;
                    }
                    if(j.getsciencescore()!=0){
                        sciencesum+=j.getsciencescore();
                        sciencecount++;
                    }
                    if(j.getenglishscore()!=0){
                        englishsum+=j.getenglishscore();
                        englishcount++;
                    }
                }
                System.out.println(student);
            }
            ois.close();
        }catch(IOException ex){
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }            
        System.out.println("數學平均為:"+(mathsum/mathcount)+"自然平均為:"+(sciencesum/sciencecount)+"英文平均為:"+(englishsum/englishcount));
    }
}
