public class Boots extends Item{
    private String itemType= "Boots";
    private String name;
    private int value;
    private String rarity;
    private int armor;
    private int magicEffect[];
    private String magicType[];

    public Boots(String pName, int pValue, String pRarity, int pArmor, int pMagicalEffect, String pMagicalType, String pRareType, int pRareEffect){
        itemType = "Boots";
        this.name = pName;
        this.value = pValue;
        this.rarity = pRarity;
        this.armor = pArmor;
        magicType = new String[2];
        magicEffect = new int[2];
        this.magicType[0] = pMagicalType;
        this.magicEffect[0] = pMagicalEffect;
        this.magicType[1] = pRareType;
        this.magicEffect[1] = pRareEffect;
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
    public int getArmor(){
        return armor;
    }
    public String[] getMagicType(){
        return magicType;
    }
    public int[] getMagicEffect(){
        return magicEffect;
    }
    public int getMinDMG(){
        return 0;
    }
    public int getMaxDMG(){
        return 0;
    }
}