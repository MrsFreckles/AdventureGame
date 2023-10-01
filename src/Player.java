import system.AnsiColor;
public class Player{
    public String playerName;
    //Lebenspunkte
    public int playerMaxHP = 10;
    public int playerFinalHP;
    public int playerCurrentHP = 10;
    public int playerArmor = 3;
    private int level = 21;
    private int experience = 69;
    private int damage = 1;
    private int addDamage;
    private int lvlUpPoints;
    public int minDMG;
    public int maxDMG;
    //Gold
    private int playerGold;
    //Items
    Boots myBootsSlot;
    Gloves myGlovesSlot;
    Armor myArmorSlot;
    Helmet myHelmetSlot;
    Shield myShieldSlot;
    Weapon myWeaponSlot;
    Item myItemSlot;
    //Inventory
    private Item[][] inventory = new Item[3][9];
    private Item[] equippedItems = new Item[6];
    private Main myMenu = new Main();
    public Item tempItem = null;
    public Player(){
        this.myWeaponSlot = null;
        this.myBootsSlot = null;
        this.myItemSlot = null;
        this.myArmorSlot = null;
        this.myShieldSlot = null;
        this.myHelmetSlot = null;
        this.myGlovesSlot = null;
    }
    public void showHP(){
        int tempDifference = playerMaxHP;
        for(int current = 0; current < playerCurrentHP; current++){
            System.out.print(AnsiColor.ANSI_RED + "❤ " +AnsiColor.ANSI_RESET);
        }
        tempDifference = tempDifference - playerCurrentHP;
        for(int max = 0; max < tempDifference; max++){
            System.out.print(AnsiColor.ANSI_BLACK + "❤ " +AnsiColor.ANSI_RESET);
        }
        System.out.print("("+playerCurrentHP+"/"+playerMaxHP+")");
    }
    public void showArmor(){
        int temp = playerArmor;
        if(playerArmor >= 60){
            for(int i = 0; i < 10; i++){
                System.out.print(AnsiColor.ANSI_BLACK + "⛨ " + AnsiColor.ANSI_RESET);
            }
            System.out.println("");
        }
        if(playerArmor >= 50){
            for(int i = 0; i < 10; i++){
                System.out.print(AnsiColor.ANSI_PURPLE + "⛨ " + AnsiColor.ANSI_RESET);
            }
            System.out.println("");
        }
        if(playerArmor >= 40){
            for(int i = 0; i < 10; i++){
                System.out.print(AnsiColor.ANSI_BLUE + "⛨ " + AnsiColor.ANSI_RESET);
            }
            System.out.println("");
        }
        if(playerArmor >= 30){
            for(int i = 0; i < 10; i++){
                System.out.print(AnsiColor.ANSI_GREEN + "⛨ " + AnsiColor.ANSI_RESET);
            }
            System.out.println("");
        }
        if(playerArmor >= 20){
            for(int i = 0; i < 10; i++){
                System.out.print(AnsiColor.ANSI_YELLOW + "⛨ " + AnsiColor.ANSI_RESET);
            }
            System.out.println("");
        }
        if(playerArmor >= 10){
            for(int i = 0; i < 10; i++){
                System.out.print(AnsiColor.ANSI_ORANGE + "⛨ " + AnsiColor.ANSI_RESET);
            }
            System.out.println("");
        }
        if(playerArmor < 10){
            for(int i = 0; i < playerArmor; i++){
                System.out.print(AnsiColor.ANSI_RED + "⛨ " + AnsiColor.ANSI_RESET);
            }
            System.out.println("");
        } else{
            for(int i = 0; i < 10; i++){
                System.out.print(AnsiColor.ANSI_RED + "⛨ " + AnsiColor.ANSI_RESET);
            }
            System.out.println("");
        }
    }
    public void showItems(){
        System.out.println("Equipment:");
        System.out.println();
        if (myWeaponSlot == null) {
            System.out.println("Weapon: " + AnsiColor.ANSI_RED + "EMPTY" + AnsiColor.ANSI_RESET);
        } else {
            System.out.println("Weapon: " + myWeaponSlot.getName());
        }
        if (myShieldSlot == null) {
            System.out.println("Shield: " + AnsiColor.ANSI_RED + "EMPTY" + AnsiColor.ANSI_RESET);
        } else {
            System.out.println("Shield: " + myShieldSlot.getName());
        }
        if (myArmorSlot == null) {
            System.out.println("Armor: " + AnsiColor.ANSI_RED + "EMPTY" + AnsiColor.ANSI_RESET);
        } else {
            System.out.println("Armor: " + myArmorSlot.getName());
        }
        if (myHelmetSlot == null) {
            System.out.println("Helmet: " + AnsiColor.ANSI_RED + "EMPTY" + AnsiColor.ANSI_RESET);
        } else {
            System.out.println("Helmet: " + myHelmetSlot.getName());
        }
        if (myGlovesSlot == null) {
            System.out.println("Glove: " + AnsiColor.ANSI_RED + "EMPTY" + AnsiColor.ANSI_RESET);
        } else {
            System.out.println("Glove: " + myGlovesSlot.getName());
        }
        if (myBootsSlot == null) {
            System.out.println("Shoe: " + AnsiColor.ANSI_RED + "EMPTY" + AnsiColor.ANSI_RESET);
        } else {
            System.out.println("Shoe: " + myBootsSlot.getName());
        }
    }
    public void showExperience(){
        int temp = 0;
        for (int i = 0; i < 20; i++) {
            if(experience > temp){
                System.out.print(AnsiColor.ANSI_GREEN + "|" + AnsiColor.ANSI_RESET);
            } else if(experience > (temp - 2)){
                System.out.print(AnsiColor.ANSI_GREEN + "¦" + AnsiColor.ANSI_RESET);
            } else{
                System.out.print(AnsiColor.ANSI_BLACK + "|" + AnsiColor.ANSI_RESET);
            }
            temp = temp + 5;
            if(temp == 50){
                System.out.print(" " + level + " ");
            }
        }
        System.out.print(AnsiColor.ANSI_GREEN + " (" + experience + "%)" + AnsiColor.ANSI_RESET);
        System.out.println();
    }
    public void showGold(){
        System.out.println(AnsiColor.ANSI_YELLOW_BOLD +"◈" + AnsiColor.ANSI_RESET + ": " + playerGold);
    }
    public void showInventory(){
        for (int x = 0; x < inventory.length; x++) {
            for (int y = 0; y < inventory[0].length; y++) {
                if (inventory[x][y] != null) {
                    System.out.print("|" + inventory[x][y].getName() + "|");
                } else {
                    System.out.print("|     |");
                }
            }
            System.out.println();
        }
    }
    public void printStatus(){
        showHP();
        System.out.println();
        showExperience();
        showArmor();
        showGold();
        System.out.println("Min DMG:" + minDMG);
        System.out.println("Max DMG:" + maxDMG);
        System.out.println();
    }
    public void showEquippedItems(){
        if(equippedItems[0] != null){
            System.out.println("|" + myWeaponSlot + "|");
        }else{
            System.out.println("|     |");
        }
        if(equippedItems[1] != null){
            System.out.println("|" + myShieldSlot + "|");
        }else{
            System.out.println("|     |");
        }
        if(equippedItems[2] != null){
            System.out.println("|" + myHelmetSlot + "|");
        }else{
            System.out.println("|     |");
        }
        if(equippedItems[3] != null){
            System.out.println("|" + myArmorSlot + "|");
        }else{
            System.out.println("|     |");
        }
        if(equippedItems[4] != null){
            System.out.println("|" + myGlovesSlot + "|");
        }else{
            System.out.println("|     |");
        }
        if(equippedItems[5] != null){
            System.out.println("|" + myBootsSlot + "|");
        }else{
            System.out.println("|     |");
        }
    }
    public void sellItem(String pItemName){
        for(int x=0; x<inventory.length; x++){
            for(int y=0; y<inventory[0].length; y++){
                if(inventory[x][y] != null){
                    if(inventory[x][y].getName().equals(pItemName)){
                        playerGold = playerGold + myItemSlot.getValue();
                        inventory[x][y] = null;
                        System.out.println("Das Item " + pItemName + " wurde für " + myItemSlot.getValue() + " Gold verkauft.");
                    }
                }
            }
        }
    }
    public void showItemStats(String pItemName){
        for(int x=0; x<inventory.length; x++){
            for(int y=0; y<inventory[0].length; y++){
                if(inventory[x][y] != null){
                    if(inventory[x][y].getName().equals(pItemName)){
                        System.out.println("Item Type:" + myItemSlot.getItemType());
                        System.out.println("Item Name:" + myItemSlot.getName());
                        System.out.println("Rarity:" + myItemSlot.getRarity());
                        System.out.println("Value:" + myItemSlot.getValue());
                        System.out.println("Magic Type:" + myItemSlot.getMagicType());
                        System.out.println("Magic Effect:" + myItemSlot.getMagicEffect());
                        System.out.println("Min DMG:" + myItemSlot.getMaxDMG());
                        System.out.println("Max DMG:" + myItemSlot.getMinDMG());
                        System.out.println("Armor:" + myItemSlot.getArmor());
                    }
                }
            }
        }
    }

    public void showStats(){
        System.out.println("Max HP:" + playerMaxHP);
        System.out.println("Final HP:" + playerFinalHP);
        System.out.println("Current HP:" + playerCurrentHP);
        System.out.println("Min DMG:" + minDMG);
        System.out.println("Max DMG:" + maxDMG);
        System.out.println("Armor:" + playerArmor);
    }

    public void equipWeapon(Weapon pWeapon){
        if(myWeaponSlot != null){
            unequipItem("Weapon");
        }
        takeItem(pWeapon.getName());
        myWeaponSlot = pWeapon;
        minDMG = minDMG + myWeaponSlot.getMinDMG();
        maxDMG = maxDMG + myWeaponSlot.getMaxDMG();
        applyBonus(myWeaponSlot);
    }

    public void equipShield(Shield pShield){
        if(myShieldSlot != null) {
            unequipItem(myShieldSlot.getName());
        }
        takeItem(pShield.getName());
        myShieldSlot  = pShield;
        playerArmor = playerArmor + myShieldSlot.getArmor();
        applyBonus(myShieldSlot);
    }

    public void equipArmor(Armor pArmor) {
        if(myArmorSlot != null)
        {
            unequipItem(myArmorSlot.getName());
        }

        takeItem(pArmor.getName());
        myArmorSlot = pArmor;
        playerArmor = playerArmor + myArmorSlot.getArmor();
        applyBonus(myArmorSlot);
    }
    public void equipHelmet(Helmet pHelmet) {
        if(myHelmetSlot != null)
        {
            unequipItem(myHelmetSlot.getName());
        }

        takeItem(pHelmet.getName());
        myHelmetSlot = pHelmet;
        playerArmor = playerArmor + myHelmetSlot.getArmor();
        applyBonus(myHelmetSlot);
    }
    public void equipGloves(Gloves pGloves) {
        if(myGlovesSlot != null)
        {
            unequipItem(myGlovesSlot.getName());
        }

        takeItem(pGloves.getName());
        myGlovesSlot = pGloves;
        playerArmor = playerArmor + myGlovesSlot.getArmor();
        applyBonus(myGlovesSlot);
    }
    public void equipBoots(Boots pBoots) {
        if(myBootsSlot != null)
        {
            unequipItem(myBootsSlot.getName());
        }

        takeItem(pBoots.getName());
        myBootsSlot = pBoots;
        playerArmor = playerArmor + myBootsSlot.getArmor();
        applyBonus(myBootsSlot);
    }
    public void equipItem(Item pItem) {
        if (pItem instanceof Weapon) {
            equipWeapon((Weapon) pItem);
        } else if (pItem instanceof Shield) {
            equipShield((Shield) pItem);
        } else if (pItem instanceof Armor) {
            equipArmor((Armor) pItem);
        } else if (pItem instanceof Helmet) {
            equipHelmet((Helmet) pItem);
        } else if (pItem instanceof Gloves) {
            equipGloves((Gloves) pItem);
        } else if (pItem instanceof Boots) {
            equipBoots((Boots) pItem);
        }  else {
            // Handle unsupported item type or provide an error message.
        }
    }



    public void unequipItem(String pType)
    {
        if(pType.equals("Weapon")) {
            if(myWeaponSlot == null) {
                System.out.println("No item in slot");
            }else{
                takeBonus(myWeaponSlot);
                minDMG = minDMG - myWeaponSlot.getMinDMG();
                maxDMG = maxDMG - myWeaponSlot.getMaxDMG();
                storeItem(myWeaponSlot);
                myWeaponSlot = null;
            }
        }
        if(pType.equals("Shield")) {
            if(myShieldSlot == null) {
                System.out.println("No item in slot");
            }else{
                playerArmor = playerArmor - myShieldSlot.getArmor();
                takeBonus(myShieldSlot);
                storeItem(myShieldSlot);
                myShieldSlot = null;
            }
        }
        if(pType.equals("Armor")) {
            if(myArmorSlot == null) {
                System.out.println("No item in slot");
            }else{
                playerArmor = playerArmor - myArmorSlot.getArmor();
                takeBonus(myArmorSlot);
                storeItem(myArmorSlot);
                myArmorSlot = null;
            }
        }
        if(pType.equals("Helmet")) {
            if(myHelmetSlot == null) {
                System.out.println("No item in Slot");
            }else{
                playerArmor = playerArmor - myHelmetSlot.getArmor();
                takeBonus(myHelmetSlot);
                storeItem(myHelmetSlot);
                myHelmetSlot = null;
            }
        }
        if(pType.equals("Gloves")) {
            if(myGlovesSlot == null) {
                System.out.println("No item in slot");
            }else{
                playerArmor = playerArmor - myGlovesSlot.getArmor();
                takeBonus(myGlovesSlot);
                storeItem(myGlovesSlot);
                myGlovesSlot = null;
            }
        }
        if(pType.equals("Boots")) {
            if(myBootsSlot == null) {
                System.out.println("No item in slot");
            }else{
                playerArmor = playerArmor - myBootsSlot.getArmor();
                takeBonus(myBootsSlot);
                storeItem(myBootsSlot);
                myBootsSlot = null;
            }
        }
    }
    public void applyBonus(Item pItem)
    {
        if(pItem.getRarity() == "Magical")
        {
            if(pItem.getMagicType()[0] == "increasedHP")
            {
                playerFinalHP = playerMaxHP + pItem.getMagicEffect()[0];
                playerCurrentHP = playerFinalHP;
            }
            if(pItem.getMagicType()[0] == "increasedDMG")
            {
                minDMG = minDMG + pItem.getMagicEffect()[0];
                maxDMG = maxDMG + pItem.getMagicEffect()[0];
            }
            if(pItem.getMagicType()[0] == "increasedArmor")
            {
                playerArmor = playerArmor + pItem.getMagicEffect()[0];
            }
            if(pItem.getMagicType()[0] == "increasedGold")
            {
                playerGold = playerGold + pItem.getMagicEffect()[0];
            }
            if(pItem.getMagicType()[0] == "damageReflect")
            {

            }
            if(pItem.getMagicType()[0] == "GOD")
            {
                playerArmor = playerArmor + 1000;
                minDMG = minDMG + 1000;
                maxDMG = maxDMG + 1000;
                playerFinalHP = playerMaxHP + 1000;
                playerCurrentHP = playerFinalHP;
            }
        }
        if(pItem.getRarity() == "Rare")
        {
            for(int x=0; x<=1; x++)
            {
                if(pItem.getMagicType()[x] == "increasedHP")
                {
                    playerFinalHP = playerMaxHP + pItem.getMagicEffect()[x];
                    playerCurrentHP = playerFinalHP;
                }
                if(pItem.getMagicType()[x] == "increasedDMG")
                {
                    minDMG = minDMG + pItem.getMagicEffect()[x];
                    maxDMG = maxDMG + pItem.getMagicEffect()[x];
                }
                if(pItem.getMagicType()[x] == "increasedArmor")
                {
                    playerArmor = playerArmor + pItem.getMagicEffect()[x];
                }
                if(pItem.getMagicType()[x] == "increasedGold")
                {
                    playerGold = playerGold + pItem.getMagicEffect()[x];
                }
                if(pItem.getMagicType()[x] == "damageReflect")
                {

                }
                if(pItem.getMagicType()[x] == "GOD")
                {
                    playerArmor = playerArmor + 1000;
                    minDMG = minDMG + 1000;
                    maxDMG = maxDMG + 1000;
                    playerFinalHP = playerMaxHP + 1000;
                    playerCurrentHP = playerFinalHP;
                }
            }
        }
    }
    public void takeBonus(Item pItem)
    {
        if(pItem.getRarity() == "Magical")
        {
            if(pItem.getMagicType()[0] == "increasedHP")
            {
                playerFinalHP = playerMaxHP - pItem.getMagicEffect()[0];
                playerCurrentHP = playerFinalHP;
            }
            if(pItem.getMagicType()[0] == "increasedDMG")
            {
                minDMG = minDMG - pItem.getMagicEffect()[0];
                maxDMG = maxDMG - pItem.getMagicEffect()[0];
            }
            if(pItem.getMagicType()[0] == "increasedArmor")
            {
                playerArmor = playerArmor - pItem.getMagicEffect()[0];
            }
            if(pItem.getMagicType()[0] == "increasedGold")
            {
                playerGold = playerGold - pItem.getMagicEffect()[0];
            }
            if(pItem.getMagicType()[0] == "damageReflect")
            {

            }
            if(pItem.getMagicType()[0] == "GOD")
            {
                playerArmor = playerArmor - 1000;
                minDMG = minDMG - 1000;
                maxDMG = maxDMG - 1000;
                playerFinalHP = playerMaxHP - 1000;
                playerCurrentHP = playerFinalHP;
            }
        }
        if(pItem.getRarity() == "Rare")
        {
            for(int x=0; x<=1; x++)
            {
                if(pItem.getMagicType()[x] == "increasedHP")
                {
                    playerFinalHP = playerMaxHP - pItem.getMagicEffect()[x];
                    playerCurrentHP = playerFinalHP;
                }
                if(pItem.getMagicType()[x] == "increasedDMG")
                {
                    minDMG = minDMG - pItem.getMagicEffect()[x];
                    maxDMG = maxDMG - pItem.getMagicEffect()[x];
                }
                if(pItem.getMagicType()[x] == "increasedArmor")
                {
                    playerArmor = playerArmor - pItem.getMagicEffect()[x];
                }
                if(pItem.getMagicType()[x] == "increasedGold")
                {
                    playerGold = playerGold - pItem.getMagicEffect()[x];
                }
                if(pItem.getMagicType()[x] == "damageReflect")
                {

                }
                if(pItem.getMagicType()[x] == "GOD")
                {
                    playerArmor = playerArmor - 1000;
                    minDMG = minDMG - 1000;
                    maxDMG = maxDMG - 1000;
                    playerFinalHP = playerMaxHP - 1000;
                    playerCurrentHP = playerFinalHP;
                }
            }
        }
    }
    public boolean storeItem(Item pItem){
        boolean wasSuccessful = false;
        for(int x=0; x<inventory.length; x++){
            for(int y=0; y<inventory[0].length; y++){
                if(inventory[x][y] == null){
                    inventory[x][y] = pItem;
                    wasSuccessful = true;
                    x = inventory.length;
                    y = inventory[0].length;
                }else{
                    wasSuccessful = false;
                }
            }
        }
        return wasSuccessful;
    }
    public Item takeItem(String pItemName) {
        //geht durch das Inventar und sucht nach dem Item
        for (int x = 0; x < inventory.length; x++) {
            for (int y = 0; y < inventory[0].length; y++) {
                //wenn das Item gefunden wurde
                if (inventory[x][y] != null) {

                    if (inventory[x][y].getName().equals(pItemName)) {
                        Item temp = inventory[x][y];
                        inventory[x][y] = null;
                        return temp;
                    }
                }
            }
        }
        return null;
    }

    public void saveToConfig(){
        Main.getFileUtils().writeToJsonFile("player.json", this);
    }

}