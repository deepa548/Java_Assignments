package exercise2;
import javax.swing.JOptionPane;

public class LottoDriver

{
    public static void main(String[] args) {
        Lotto lotto = new Lotto();

        int sum =0;
        int [] numArray;

        for(int i = 0; i<5; i++)
        {
            int userInput = Integer.parseInt(JOptionPane.showInputDialog(" Please enter" +
                    " three numbers between 3 and 27:"));

            numArray = lotto.getRandomArray();
                for (int element:numArray){
                    sum = numArray[0] + numArray[1] + numArray[2] ;
                }// end nested for loop

            if (sum == userInput)
            {
                JOptionPane.showMessageDialog(null, "You are a winner!");
                break;
            }
            else if (sum != userInput)
            {
                JOptionPane.showMessageDialog(null, "You Lost!, \n" +
                        "You used "+ (i+1) +" try out of 5");

            }//end else if
        }//end for loop

        JOptionPane.showMessageDialog(null, "You Lost The Game, \n" +
                    "Better Luck Next Time.....!");
    }//end main



}//end LottoDriver class
