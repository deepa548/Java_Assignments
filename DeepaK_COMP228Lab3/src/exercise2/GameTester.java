package exercise2;
import java.util.Scanner;

public abstract class GameTester {

    private  String EmployeName;
    private boolean gameStatus;
    public abstract int determineSalary();

    public GameTester(String name, boolean gameStatus) {
        this.EmployeName = name;
        this.gameStatus = gameStatus;
    }
    public String getName() {
        return EmployeName;
    }

    public boolean gameStatus() {
        return gameStatus;
    }





}//end class
