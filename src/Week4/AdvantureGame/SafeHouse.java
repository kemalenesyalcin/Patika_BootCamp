package Week4.AdvantureGame;

public class SafeHouse extends NormalLoc{
    public SafeHouse(Player player) {
        super(player,"Safe House");
    }

    @Override
    public boolean onLocation() {
        System.out.println("You came to the safe house !! ");
        this.getPlayer().setHealth(this.getPlayer().getOrjinalHealth());
        System.out.println("Your Hp Recovered !");

        return true;
    }
}
