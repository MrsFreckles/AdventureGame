public abstract class Item implements Cloneable{
    public abstract String getItemType();
    public abstract String getName();
    public abstract int getValue();
    public abstract String getRarity();
    public abstract String[] getMagicType();
    public abstract int[] getMagicEffect();
    public abstract int getArmor();
    public abstract int getMinDMG();
    public abstract int getMaxDMG();

    @Override
    protected Item clone() throws CloneNotSupportedException {
        return (Item) super.clone();
    }

}
