package Week4.AdvantureGame;

import java.util.Scanner;

public class Player {
    private int damage;
    private int health;
    private int orjinalHealth;
    private int money;
    private String name;
    private String charName;
    private Inventory inventory;
    private Scanner input=new Scanner(System.in);

    public Player(String name){
        this.name=name;
        this.inventory=new Inventory();
    }

    public void selectChar(){
        GameChar[] charList={new Samurai(),new Archer(),new Knight()};
        System.out.println("-------------------------------------------------");
        for (GameChar gameChar:charList) {
            System.out.println("ID: "+gameChar.getId()+
                    "\tCharacter: " + gameChar.getName()+
                    "\tDamage:"+gameChar.getDamage()+
                    "\tHealth:"+gameChar.getHealth()+
                    "\tMoney:"+gameChar.getMoney());
        }
        System.out.println("----------------------------------------------");
        System.out.print("Please Pick Your Character ID");
        int selectChar= input.nextInt();
        switch (selectChar){
            case 1:
                initPlayer(new Samurai());
                break;
            case 2:
                initPlayer(new Archer());
                break;
            case 3:
                initPlayer(new Knight());
                break;
            default:initPlayer(new Samurai());
        }
        System.out.println("Character :"+ this.getCharName()+
                "\tDamage: "+ this.getDamage()+
                "\tHealth: "+ this.getHealth()+
                "\tMoney: "+this.getMoney());
    }


    public void initPlayer(GameChar gameChar){
        this.setDamage(gameChar.getDamage());
        this.setHealth(gameChar.getHealth());
        this.setOrjinalHealth(gameChar.getHealth());
        this.setMoney(gameChar.getMoney());
        this.setCharName(gameChar.getName());
    }
    public void printInfo(){
        System.out.println(
                "Your Weapon: "+this.getInventory().getWeapon().getName()+
                "\tYour Armor: "+this.getInventory().getArmor().getName()+
                "\tYour Block Rate: "+this.getInventory().getArmor().getBlock()+
                "\tDamage: "+ this.getTotalDamage()+
                "\tHealth: "+ this.getHealth()+
                "\tMoney: "+this.getMoney());

    }
    public int getTotalDamage(){
        return damage+this.getInventory().getWeapon().getDamage();
    }
    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public int getOrjinalHealth() {
        return orjinalHealth;
    }

    public void setOrjinalHealth(int orjinalHealth) {
        this.orjinalHealth = orjinalHealth;
    }
}
