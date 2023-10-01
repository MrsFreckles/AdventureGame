public enum Items {
    //Weapons
    WOODEN_SWORD(new Weapon("Wooden Sword", 5, "Common", 2, 4, "", 0, "", 0)),
    WOODEN_AXE(new Weapon("Wooden Axe", 5, "Common", 2, 4, "", 0, "", 0));
    //Shields
    //Helmets
    //Armor
    //Gloves
    //Boots

    private final Item item;
    Items(Item pItem){
        this.item = pItem;
    }

    public Item getItem() {
        try {
            return item.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    public static Items getEnum(String value) {
        for (Items v : values())
            if (v.getItem().getName().equalsIgnoreCase(value)) return v;
        throw new IllegalArgumentException();
    }

}
