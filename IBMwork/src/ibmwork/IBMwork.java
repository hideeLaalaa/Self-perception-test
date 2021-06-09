/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ibmwork;

import java.awt.Dimension;
import java.awt.Rectangle;

/**
 *
 * @author Hidee
 */
public class IBMwork {
static String userName;
static String sex;
static aptitude section[] = new aptitude[7];
static int sectNo=0;
static int char1=-1,char2=-1;
static String[] character = {"SHAPER","CO-ORDINATOR","PLANTER","RESOURCE INVESTIGATOR","MONITOR EVALUATOR","IMPLEMENTER","TEAMWORKER","FINISHER"};
static int[] charTotal = new int[8];

    static void resetUser() {
        userName=null;
        sex=null;
        sectNo=0;
        char1=-1;
        char2=-1;
        charTotal = new int[8];
        resetSection();
    }
    /**
     * @param args the command line arguments
     */

     public IBMwork(){

     }
     
     public static void resetSection(){
         section = new aptitude[7];
         setQuestion();
     }
         
     
     public static void setQuestion(){
         section[0] = new aptitude("I can be relied upon to see that work that needs to be done is organised",
                "I pick up slips and omissions that others fail to notice",
                "I react strongly when meetings look like losing track of the main objective",
                "I produce original suggestions",
                "I analyse other people's ideas objectively, for both merits and failings",							
                "I am keen to find out the latest ideas and developments",							
                "I have an aptitude for organising people",							
                "I am always ready to support good suggestions that help to resove a problem"							
                );
        section[1]= new aptitude("I like to have a strong influence on decisions",
                "I feel in my elements where work requires a high degree of attention and concentration",
                "I am concerned to help colleagues with their problems",
                "I like to make critical discrimination between alternatives",
                "I tend to have a creative approach to problem solving",							
                "I enjoy reconciliation of different points of view",							
                "I am more interested in practicalities than in new ideas",							
                "I particularly enjoy exploring different views and techniques"							
                );
        section[2]= new aptitude("I keep a watching eye on areas where difficulty may arise",							
                "I explore ideas that may have a wider application than in the immediate task",							
                "I like to weigh up and evaluate a range of suggestions thoroughly before choosing",							
                "I can co-ordinate and use productively other people's abilities and talents",							
                "I maintain a steady systematic approach, whatever the pressure",							
                "I often produce a new approach to a long continuing problem",							
                "I am ready to make my personal views known in a forceful way if necessary",							
                "I am ready to help whenever I can"							
                );
        section[3]= new aptitude("I am keen to see there is nothing vague about my task and objectives",							
                "I am not reluctant to emphasize my own point of view on meetings",							
                "I can work with all sorts of people provided that they have got something worthwhile to contribute",							
                "I like following up interesting ideas and/or people",							
                "I can usually find the argument to refute unsound proposition",							
                "I tend to see patterns where others see unconnected items",							
                "Being busy gives me real satisfaction",							
                "I have a quiet interest in getting to know people better"														
                );
        section[4]= new aptitude("I often find my imagination frustrated by working in a group",							
                "I find my personal skill particularly appropriate in  achieving agreement",							
                "My feelings seldom interfere with my judgments",							
                "I strive to build up an effective structure",							
                "I can work with people who vary widely in their personal qualities and outlooks",							
                "I feel it is sometimes worth incurring some temporary unpopularity if one is to succeed in  getting one's views across in a group",							
                "I usually know someone whose specialist knowledge is particularly apt",							
                "I seem to develop a natural sense of urgency"																			
                );
        section[5]= new aptitude("I start to look around for possible ideas and openings",							
                "I am concerned to finish and perfect current work before I start a new one",							
                "I approach the problem in a carefully analytical way",							
                "I am able to assert myself to get other people involved if necessary",							
                "I am able to take an independent and innovative look at most situations",							
                "I am happy to take the lead when action is required",							
                "I can respond positively to my colleagues and their initiatives",							
                "I find it hard to give in to a job where goals are not clearly defined"																										
                );
        section[6]= new aptitude("I think I have a talent for sorting out the concrete steps that need to be taken, given a broad brief",							
                "My considered judgments may take time but is usually near the mark",							
                "A broad range of personal contacts is important to my style of working",							
                "I have an eye for getting the details right",							
                "I try to make my mark in group meetings",							
                "I can see how ideas and techniques can be used in relationships",							
                "I see both sides of a problem and take a decision acceptable to all",							
                "I get on well with others and work hard for the team"																										
                );

     }

    public static void main(String[] args) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                System.out.print("woohan");
//                resultPage test = new resultPage();
//                test.setSize(1110, 500);
     
                NewFrame test = new NewFrame();
                test.setSize(1050, 710);
//                test.setMaximizedBounds(new Rectangle(800,710));
                test.setVisible(true);
          
            }
        });
        setQuestion();
        
    }
    
    public void setUserName(String name){
        userName = name;
    }
    
    static String getUserName(){
        return userName;
    }
    
    public void setSex(String Sex){
        sex = Sex;
    }
    
    static String getSex(){
        return sex;
    }
    
    static String getTitle(){
        if(sex.equals("Male"))
            return "Mr ";
        if(sex.equals("Female"))
            return "Miss ";
        else
            return "";
    }
    
    public static void setMax(){
        int max1=0,max2=0;
        for(int i = 0;i<8;i++){
            int sum=0;
            for(int j=0;j<7;j++){
                sum+=section[j].marks[i];
            }
            charTotal[i]=sum;
            if(sum>max1){
                max1=sum;
                char1=i;
            }
            else if(sum>max2){
                max2=sum;
                char2=i;
            }
        }
    }
    
    public static String resultString(){
        
        String result = String.format("\n\t\t%-6s:%44s%-2s\n\t\t%-8s:%44s%-2s\n\t\t%-38s*%-9s\n\t\t%-56s*%-39s", "NAME","",userName,"SEX  ","",sex,
                "Preferred self team role : ",(char1==-1?"":character[char1])," ",(char2==-1?"":character[char2]));
        return result;
    }
        
    
}

class aptitude{
 
    String[] questions = new String[8];
    int[] marks = new int[8];
    
    public aptitude(String... quest){
        setQuestions(quest);
    }
    public aptitude(){
        
    }
    
    public void setQuestions(String... quest){
        questions = quest;
    }
    
    public String[] getQuestions(){
        return questions;
    }
    
    public int[] getMarks(){
        return marks;
    }
    
    public void resetMarks(){
        marks = new int[8];
    }
    
    public int getTotalMarks(){
        int total=0;
        for(int x:marks)
            total+=x;
        return total;
    }
    
}