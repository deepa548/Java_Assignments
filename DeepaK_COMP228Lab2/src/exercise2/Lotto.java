package exercise2;
import java.util.Random;
import javax.swing.JOptionPane;

public class Lotto {

    public int [] randomArray ;  //Declaring instance variable

    public Lotto()
    {
        randomArray = new int[3];
        Random randNum = new Random();

        for (int i =0; i<randomArray.length; i++)
        {
            int maximum =9;
            int minimum =1;
            randomArray[i]= randNum.nextInt(maximum) + minimum;
        }// end loop

    } //end constructor

    // method to return the array

    public int [] getRandomArray()
    {
        return randomArray;
    }


}// end Lotto class
