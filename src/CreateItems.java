
public class CreateItems{
    Player myPlayer = Main.getMyPlayer();
    //Schwerter
    public void main(String args[]){
        Weapon myWeapon = new Weapon("Sword", 20, "Magical", 2, 6, "increasedHP", 3, "", 0);
        myPlayer.storeItem(myWeapon);
    }
    public void createAWeapon(String args[]){
        Weapon myWeapon = new Weapon("Stick", 3, "Common", 1, 3, "", 0, "", 0);
        myPlayer.storeItem(myWeapon);
    }
    public void createADifferentWeapon(String args[]){
        Weapon myWeapon = new Weapon("Longsword", 35, "Rare", 4, 7, "IncreasedDMG", 3, "IncreasedGold", 10);
        myPlayer.storeItem(myWeapon);
    }
    //Schilde
    public void createShield(String args[]){
        Shield myShield = new Shield("Plank", 5, "Common", 3, 0, "","", 0);
        myPlayer.storeItem(myShield);
    }
    public void createAShield(String args[]){
        Shield myShield = new Shield("Shield", 10, "Magical", 5, 3, "DamageReflect","", 0);
        myPlayer.storeItem(myShield);
    }
    public void createADifferentShield(String args[]){
        Shield myShield = new Shield("ObsidianShield", 30, "Rare", 5, 3, "DamageReflect","IncreasedHP", 10);
        myPlayer.storeItem(myShield);
    }
    //Helme
    public void createHelmet(String args[]){
        Helmet myHelmet = new Helmet("LeatherHelmet", 5, "Common", 1, 3, "","", 0);
        myPlayer.storeItem(myHelmet);
    }
    public void createAHelmet(String args[]){
        Helmet myHelmet = new Helmet("ObsidianShield", 30, "Rare", 3, 5, "IncreasedHP","", 0);
        myPlayer.storeItem(myHelmet);
    }
    public void createADifferentHelmet(String args[]){
        Helmet myHelmet = new Helmet("ObsidianShield", 30, "Rare", 5, 3, "IncreasedGold","IncreasedHP", 10);
        myPlayer.storeItem(myHelmet);
    }
    //Helme
    public void createArmor(String args[]){
        Armor myArmor = new Armor("ObsidianShield", 30, "Rare", 5, 3, "IncreasedGold","IncreasedHP", 10);
        myPlayer.storeItem(myArmor);
    }
    public void createAArmor(String args[]){
        Armor myArmor = new Armor("ObsidianShield", 30, "Rare", 5, 3, "IncreasedGold","IncreasedHP", 10);
        myPlayer.storeItem(myArmor);
    }
    public void createADifferentArmor(String args[]){
        Armor myArmor = new Armor("ObsidianShield", 30, "Rare", 5, 3, "IncreasedGold","IncreasedHP", 10);
        myPlayer.storeItem(myArmor);
    }
    //Helme
    public void createGloves(String args[]){
        Gloves myGloves = new Gloves("ObsidianShield", 30, "Rare", 5, 3, "IncreasedGold","IncreasedHP", 10);
        myPlayer.storeItem(myGloves);
    }
    public void createAGloves(String args[]){
        Gloves myGloves = new Gloves("ObsidianShield", 30, "Rare", 5, 3, "IncreasedGold","IncreasedHP", 10);
        myPlayer.storeItem(myGloves);
    }
    public void createADifferentGloves(String args[]){
        Gloves myGloves = new Gloves("ObsidianShield", 30, "Rare", 5, 3, "IncreasedGold","IncreasedHP", 10);
        myPlayer.storeItem(myGloves);
    }
    //Boots
    public void createBoots(String args[]){
        Boots myBoots = new Boots("LeatherHelmet", 5, "Common", 1, 3, "","", 0);
        myPlayer.storeItem(myBoots);
    }
    public void createABoots(String args[]){
        Boots myBoots = new Boots("LeatherHelmet", 5, "Common", 1, 3, "","", 0);
        myPlayer.storeItem(myBoots);
    }
    public void createADifferentBoots(String args[]){
        Boots myBoots = new Boots("LeatherHelmet", 5, "Common", 1, 3, "","", 0);
        myPlayer.storeItem(myBoots);
    }
}