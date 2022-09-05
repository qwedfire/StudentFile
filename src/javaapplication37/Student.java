/**
請寫一個Student的物件
屬性：
學生編號：自動產生的流水號
學生姓名：長度介於4~8個英文字
email：長度介於4~12個英文字 + [@gmail.com,@yahoo.com.tw,@hotmail.com]隨機取一個
手機號碼：09開頭+8個隨機數字
成績單：ArrayList<Grade>
 */
package javaapplication37;

import java.io.Serializable;
import java.util.ArrayList;
/**
 * 
 * @author LAND
 */
public class Student implements Serializable {   
    public enum Emailtype{
        gmail("@gmail.com"),
        yahoo("@yahoo.com.tw"),
        hotmail("@hotmail.com");
        private String value;
        Emailtype(String value){
            this.value=value;
        }        
        public String getvalue(){
            return value;
        }
        public static Emailtype getemailtype(int index){
            Emailtype temp[]=Emailtype.values();
            return temp[index-1];
        }
    }    
    private static  int SERIAL_NUMBER=1;
    private static final int MAXNAME_NUMBER=8; //名子最多8個字
    private static final int MINNAME_NUMBER=4; //名子最少4個字
    private static final int MINMAIL_NUMBER=4;  //信箱最少4個字
    private static final int MAXMAIL_NUMBER=12;//信箱最多12個字
    private static final int MAXCHAR_NUMBER=57;//char數字最大號碼(9)
    private static final int MINCHAR_NUMBER=48;//char數字最小號碼(0)
    private static final int MAXENGLISH_NUMBER=122;//char英文最大號碼(z)
    private static final int MINENGLISH_NUMBER=97;//char英文最小號碼(a)
    private int id;
    private String name;
    private String email;
    private String cellphone;
    private ArrayList<Grade> studentgrade;
    public Student(){
        this.id=SERIAL_NUMBER;
        SERIAL_NUMBER++;
        setname();
        setemail();
        setcellphone();   
        setgrade();        
    }    
    public void setname(){        
        String randomname="";
        for(int i=0;i<(int)(Math.random()*(MAXNAME_NUMBER-MINNAME_NUMBER+1)+MINNAME_NUMBER);i++){
            randomname+=(char)(Math.random()*(MAXENGLISH_NUMBER-MINENGLISH_NUMBER+1)+MINENGLISH_NUMBER);
        }
        this.name=randomname;
    }
    public void setemail(){
        String randomemail="";
        Emailtype mail=Emailtype.getemailtype((int)(Math.random()*3+1));
        for(int i=0;i<(int)(Math.random()*(MAXMAIL_NUMBER-MINMAIL_NUMBER+1)+MINMAIL_NUMBER);i++){
            randomemail+=(char)(Math.random()*(MAXENGLISH_NUMBER-MINENGLISH_NUMBER+1)+MINENGLISH_NUMBER);
        }        
        switch(mail){
            case gmail:
                randomemail+=mail.getvalue();
                break;
            case yahoo:
                randomemail+=mail.getvalue();
                break;
            case hotmail:   
                defalut:
                randomemail+=mail.getvalue();
                break;
        }
        this.email=randomemail;
    }
    public void setcellphone(){
        String randomcellphone="09";       
        for(int i=0;i<8;i++){
            randomcellphone+=(char)(Math.random()*(MAXCHAR_NUMBER-MINCHAR_NUMBER+1)+MINCHAR_NUMBER);
        }
        this.cellphone=randomcellphone;
    }
    public void setgrade(){
        studentgrade=new ArrayList();
        Grade grade=new Grade();
        studentgrade.add(grade);
    }
    public int getid(){
        return id;
    }
    public String getname(){
        return name;
    }
    public String getmail(){
        return email;
    }
    public String getcellphone(){
        return cellphone;
    }
    public ArrayList<Grade> getgrade(){
        return studentgrade;
    }    
    @Override
    public String toString(){
        String studentallgrade="";
        for(Grade i:studentgrade){
            studentallgrade+=i.toString();
        }
        return "學生編號:"+this.id+"  學生姓名:"+this.name+"  信箱:"+this.email
                +"  手機號碼:"+this.cellphone+"  成績單:"+studentallgrade;
    }
}
