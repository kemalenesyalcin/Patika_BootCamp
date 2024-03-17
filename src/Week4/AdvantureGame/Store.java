package Week4.AdvantureGame;

public class Store extends NormalLoc {
    public Store(Player player) {
        super(player, "The Store");
    }

    @Override
    public boolean onLocation() {
        System.out.println("Welcome to The Store !!");
        boolean showMenu = true;
        while (showMenu) {
            System.out.println("1-Weapons |||| 2-Armors |||| 3-Exit ");
            System.out.println("What is Your Choice ?");
            int selectCase = input.nextInt();
            while (selectCase < 1 || selectCase > 3) {
                System.out.println("Wrong Choice ! Try Again !");
            }
            switch (selectCase) {
                case 1:
                    printWeapon();
                    buyWeapon();
                    break;
                case 2:
                    printArmor();
                    buyArmor();
                    break;
                case 3:
                    System.out.println("Come back when you have money..");
                    showMenu = false;
                    break;

            }
        }
        return (true);
    }


    public void printWeapon() {
        System.out.println("Weapons..");
        for (Weapon w : Weapon.weapons()) {
            System.out.println(w.getId() + "-" + w.getName() + "Price:  " + w.getPrice() + "Damage:  " + w.getDamage());
        }
        System.out.println("Press '0' For Exit");
    }

    public void buyWeapon() {
        System.out.print("Select A Weapon!");
        int selectWeaponID = input.nextInt();
        while (selectWeaponID < 0 || selectWeaponID > Weapon.weapons().length) {
            System.out.println("Wrong Choice ! Try Again !");
            selectWeaponID = input.nextInt();
        }
        if (selectWeaponID != 0) {
            Weapon selectedWeapon = Weapon.getWeaponID(selectWeaponID);
            if (selectedWeapon != null) {
                if (selectedWeapon.getPrice() > this.getPlayer().getMoney()) {
                    System.out.println("You Dont Have Enough Money");
                } else {
                    System.out.println(selectedWeapon.getName() + "Purchased ! ");
                    int balance = this.getPlayer().getMoney() - selectedWeapon.getPrice();
                    this.getPlayer().setMoney(balance);
                    System.out.println("Your Money After Trade: " + this.getPlayer().getMoney());
                    this.getPlayer().getInventory().setWeapon(selectedWeapon);

                }
            }
        }

    }

    public void printArmor() {
        System.out.println("Armors..");
        for (Armor a : Armor.armors()) {
            System.out.println(a.getId() + "-" + a.getName() + "-" + "Price:" + a.getPrice() + "-" + "Block Rate:" + a.getBlock());
        }
        System.out.println("Press '0' For Exit");
    }

    public void buyArmor() {
        System.out.print("Select An Armor!");
        int selectArmorID = input.nextInt();
        while (selectArmorID < 0 || selectArmorID > Armor.armors().length) {
            System.out.println("Wrong Choice ! Try Again !");
            selectArmorID = input.nextInt();
        }
        if (selectArmorID != 0) {
            Armor selectedArmor = Armor.getArmorID(selectArmorID);
            if (selectedArmor != null) {
                if (selectedArmor.getPrice() > this.getPlayer().getMoney()) {
                    System.out.println("You Dont Have Enough Money");
                } else {
                    System.out.println(selectedArmor.getName() + "Purchased ! ");
                    this.getPlayer().setMoney(this.getPlayer().getMoney() - selectedArmor.getPrice());
                    this.getPlayer().getInventory().setArmor(selectedArmor);
                    System.out.println("Your Money After Trade: " + this.getPlayer().getMoney());
                }
            }

        }
    }
}