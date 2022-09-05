/**
 * 請寫一個Grade的物件
屬性：
科目：Math,Science,English
成績：0~100
 */
package javaapplication37;

import java.io.Serializable;

/**
 * 
 * @author LAND
 */
public class Grade implements Serializable{
    private static final int MAX_SCORE=100;
    private static final int MAX_SUBJECT=3;
    private int mathscore;
    private int sciencescore;
    private int englishscore;     
    private int randomgrade;
    public Grade(){
        setscore();
    }
    public void setscore(){
        int randomgrade=(int)(Math.random()*(MAX_SUBJECT+1));
        this.randomgrade=randomgrade;
        int score;
        for(int i=0;i<randomgrade;i++){
            score=(int)(Math.random()*(MAX_SCORE+1));
            if(i==0){
                this.mathscore=score;
            }
            else if(i==1){
                this.sciencescore=score;
            }
            else {
                this.englishscore=score;
            }
        }        
    }
    public int getmathscore(){
        return mathscore;
    }
    public int getsciencescore(){
        return sciencescore;
    }
    public int getenglishscore(){
        return englishscore;
    }
    @Override
    public String toString(){
        if(randomgrade==3){
        return "數學成績:"+this.mathscore+
                "自然成績:"+this.sciencescore+
                "英文成績:"+this.englishscore;
        }
        else if(randomgrade==2){
            return "數學成績:"+this.mathscore+
                "自然成績:"+this.sciencescore;
        }
        else if(randomgrade==1){
            return "數學成績:"+this.mathscore;              
        }
        else {
            return "";
        }
    }
}
