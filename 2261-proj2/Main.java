
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main{
    public static void main(String [] args){
        Board b = new Board(6,7);
        Scanner input = new Scanner(System.in);
        boolean turn = false; //false for red, true for yellow
        int index = 0;
        while(true){
            if(b.winState(turn)) break;
            System.out.println(b.toString());
            try{
                System.out.print("Please choose a column (0-6) to drop the " +((turn)?"RED":"YELLOW") +" disk:");
                index = input.nextInt();
                if(index <= 6 && index >= 0){
                    b.dropAtIndex(index, turn);
                    turn = !turn;
                }else{
                    throw new NumberFormatException();
                }
            }catch(NumberFormatException e){
                System.out.println("Please enter a number 0-6");
            }catch(InputMismatchException e){
                System.out.println("Please enter a NUMBER 0-6");
            }catch(ArrayIndexOutOfBoundsException e){
                System.out.println("Column " +index+ " full try a diffent one");
            }
            

            
        }
        System.out.println((turn?"RED ":"YELLOW ") + "player has won!");

    }
}