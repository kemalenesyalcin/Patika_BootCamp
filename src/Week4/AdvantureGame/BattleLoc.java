package Week4.AdvantureGame;

import java.util.Random;

public abstract class BattleLoc extends Location {
    private Creature creature;
    private String award;
    private int maxCreature;

    public BattleLoc(Player player, String name, Creature creature, String award,int maxCreature) {
        super(player, name);
        this.creature = creature;
        this.award = award;
        this.maxCreature=maxCreature;
    }

    @Override
    public boolean onLocation(){
        int creNumber=this.randomCreatureNumber();
        System.out.println("You Are Here Right Now      "+this.getName());
        System.out.println("Be careful !! "+creNumber+"-"+this.getCreature().getName()+"  Living Here");
        System.out.println("Press 'F' For Fight or Press 'R' For Run");
        String selectCase=input.nextLine().toUpperCase();
        if (selectCase.equals("F") && (combat(creNumber))) {
                System.out.println(this.getName()+"You Killed them all ");
                return true;
        }
        if(this.getPlayer().getHealth()<=0){
            System.out.println("You Are Dead!");
            return false;
        }
        return true;
    }
    public boolean combat(int creNumber){
        for(int i=1; i<=creNumber; i++){
            this.getCreature().setHealth(this.getCreature().getOrjinalHealth());
            playerStats();
            creatureStats(i);
            while(this.getPlayer().getHealth()>0 && this.getCreature().getHealth()>0){
                System.out.println("Press 'A' For Attack or Press 'R' For Run");
                String selectCombat=input.nextLine().toUpperCase();
                if(selectCombat.equals("A")){
                    System.out.print("You Attacked   ");
                    this.getCreature().setHealth(this.getCreature().getHealth()-this.getPlayer().getTotalDamage());
                    afterHit();
                    if (this.getCreature().getHealth()>0){
                        System.out.println("You Took Hit !");
                        int creatureDamage=this.getCreature().getDamage()-this.getPlayer().getInventory().getArmor().getBlock();
                        if(creatureDamage<0){
                            creatureDamage=0;
                        }
                        this.getPlayer().setHealth(this.getPlayer().getHealth()-creatureDamage);
                        afterHit();
                    }
                }else {
                    return false;
                }
            }
            if(this.getCreature().getHealth()<this.getPlayer().getHealth()){
                System.out.println("You Won !!");
                System.out.println(this.getCreature().getAward()+"   Your Earned !");
                this.getPlayer().setMoney(this.getPlayer().getMoney()+this.getCreature().getAward());
                System.out.println("Your New Money "+ this.getPlayer().getMoney());
            }else {
                return false;
            }
        }
        return true;
    }
    public void afterHit(){
        System.out.println("Player Health: "+this.getPlayer().getHealth());
        System.out.println(this.getCreature().getName()+"-"+"Health: "+this.getCreature().getHealth());
        System.out.println();
    }
    public void playerStats(){
        System.out.println("Player Stats!");
        System.out.println("Health: "+this.getPlayer().getHealth());
        System.out.println("Weapon: "+this.getPlayer().getInventory().getWeapon().getName());
        System.out.println("Damage: "+this.getPlayer().getTotalDamage());
        System.out.println("Armor: "+this.getPlayer().getInventory().getArmor().getName());
        System.out.println("Block Rate: "+this.getPlayer().getInventory().getArmor().getBlock());
        System.out.println("Money: "+this.getPlayer().getMoney());
        System.out.println("--------------------------------------------------");

    }
    public void creatureStats(int i){
        System.out.println(i+"."+this.getCreature().getName()+"Stats");

        System.out.println("Health: "+this.creature.getHealth());
        System.out.println("Damage: "+this.creature.getDamage());
        System.out.println("Reward Money: "+this.creature.getAward());
    }
    public int randomCreatureNumber(){
        Random r=new Random();
        return r.nextInt(this.getMaxCreature())+1;
    }

    public Creature getCreature() {
        return creature;
    }

    public void setCreature(Creature creature) {
        this.creature = creature;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public int getMaxCreature() {
        return maxCreature;
    }

    public void setMaxCreature(int maxCreature) {
        this.maxCreature = maxCreature;
    }
}
