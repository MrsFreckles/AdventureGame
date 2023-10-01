public class Weapon extends Item{
    private String itemType = "Weapon";
    private String name;
    private int value;
    private String rarity;
    private int minDMG;
    private int maxDMG;
    private int magicEffect[] = new int[2];
    private String magicType[] = new String[2];
    Player myPlayer = new Player();
    public Weapon(String pName, int pValue, String pRarity, int pMinDMG, int pMaxDMG, String pMagicalType, int pMagicalEffect, String pRareType, int pRareEffect){
        itemType = "Weapon";
        this.name = pName;
        this.value = pValue;
        this.rarity = pRarity;
        this.minDMG = pMinDMG;
        this.maxDMG = pMaxDMG;
        this.magicType[0] = pMagicalType;
        this.magicEffect[0] = pMagicalEffect;
        this.magicType[1] = pRareType;
        this.magicEffect[1] = pRareEffect;
    }


    public int getArmor(){
        return 0;
    }
    public String getItemType(){
        return itemType;
    }
    public String getName(){
        return name;
    }
    public int getValue(){
        return value;
    }
    public String getRarity(){
        return rarity;
    }
    public int getMinDMG(){
        return minDMG;
    }
    public int getMaxDMG(){
        return maxDMG;
    }
    public String[] getMagicType(){
        return magicType;
    }
    public int[] getMagicEffect(){
        return magicEffect;
    }
}