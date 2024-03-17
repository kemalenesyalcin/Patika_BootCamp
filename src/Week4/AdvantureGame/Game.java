package Week4.AdvantureGame;
import java.util.Scanner;

public class Game {
    private Scanner input=new Scanner(System.in);
    public void start(){
        System.out.println("Welcome to Adventure Game");
        System.out.print("Please Enter Your Character Name");
        String playerName=input.nextLine();
        Player player=new Player(playerName);
        System.out.println(player.getName()+" Welcome to This Scary İsland");
        System.out.println("Please Select A Character !");
        player.selectChar();


        Location location=null;
        while (true){
            player.printInfo();
            System.out.println("Fields !");
            System.out.println("1 - Safe House");
            System.out.println("2 - The Store");
            System.out.println("3 - Enter The Cave");
            System.out.println("4 - Enter The Forest");
            System.out.println("5 - Enter The River");
            System.out.println("0 - Exit");
            System.out.println("Please Select A Field");
            int selectLoc= input.nextInt();
            switch (selectLoc){
                case 0:
                    location=null;
                    break;
                case 1:
                    location=new SafeHouse(player);
                    break;
                case 2:
                    location=new Store(player);
                    break;
                case 3:
                    location=new Cave(player);
                    break;
                case 4:
                    location=new Forest(player);
                    break;
                case 5:
                    location=new River(player);
                    break;
                default:
                    System.out.println("Please enter a valid number");
            }
            if(location==null){
                System.out.println("Why Are You Running :)");
                break;
            }
            if (!location.onLocation()){
                System.out.println("You Are Dead !!");
                break;
            }
        }

    }
}
