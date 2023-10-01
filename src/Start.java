public class Start
{
    public static void main()
    {
        String choice = "";
        Player myPlayer = new Player();
        Weapon myWeapon = new Weapon("Longsword", 35, "Rare", 4, 7, "IncreasedDMG", 3, "IncreasedGold", 10);

        System.out.println();
        System.out.println("Original Player Stats");
        System.out.println();
        System.out.println("Max HP:" + myPlayer.playerMaxHP);
        System.out.println("Final HP:" + myPlayer.playerFinalHP);
        System.out.println("Current HP:" + myPlayer.playerCurrentHP);
        System.out.println("Min DMG:" + myPlayer.minDMG);
        System.out.println("Max DMG:" + myPlayer.maxDMG);
        System.out.println("Armor:" + myPlayer.playerArmor);
        System.out.println();

        System.out.println("Store item");
        myPlayer.storeItem(myWeapon);
        myPlayer.showInventory();
        System.out.println();

        System.out.println("Take item and equip");
        myPlayer.equipItem(myPlayer.takeItem("Excalibur"));
        myPlayer.showInventory();
        System.out.println();

        System.out.println("Modified Player Stats");
        System.out.println();
        System.out.println("Max HP:" + myPlayer.playerMaxHP);
        System.out.println("Final HP:" + myPlayer.playerFinalHP);
        System.out.println("Current HP:" + myPlayer.playerCurrentHP);
        System.out.println("Min DMG:" + myPlayer.minDMG);
        System.out.println("Max DMG:" + myPlayer.maxDMG);
        System.out.println("Armor:" + myPlayer.playerArmor);
        System.out.println();

        System.out.println("Unequip and store item");
        myPlayer.unequipItem(choice);
        myPlayer.showInventory();
        System.out.println();

        System.out.println("Player Stats after unequiping");
        System.out.println("Max HP:" + myPlayer.playerMaxHP);
        System.out.println("Final HP:" + myPlayer.playerFinalHP);
        System.out.println("Current HP:" + myPlayer.playerCurrentHP);
        System.out.println("Min DMG:" + myPlayer.minDMG);
        System.out.println("Max DMG:" + myPlayer.maxDMG);
        System.out.println("Armor:" + myPlayer.playerArmor);
    }
}
