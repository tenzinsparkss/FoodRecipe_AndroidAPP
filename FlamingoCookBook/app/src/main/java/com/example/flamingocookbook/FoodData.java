package com.example.flamingocookbook;

public class FoodData {

    private String itemName;
    private String itemDescription;
    private String itemType;
    private String itemImage;

    public FoodData(String itemName, String itemDescription, String itemType, String itemImage) {
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.itemType = itemType;
        this.itemImage = itemImage;
    }

    public String getItemName() {
        return itemName;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public String getItemType() {
        return itemType;
    }

    public String getItemImage() {
        return itemImage;
    }
}
