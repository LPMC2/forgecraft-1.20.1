package com.forgecraft_fabric.items;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.text.Text;

import java.util.ArrayList;
import java.util.List;

public class ForgeData {
    private int id = 0;
    private String name = "DEFAULT";
    private int cost = 0;
    private List<EntityAttributeModifier> attributeModifiers = new ArrayList<EntityAttributeModifier>();
    private Text description = Text.empty();
    private List<String> apply_type = new ArrayList<String>();
    public ForgeData (int id, String name, int cost, Text description, List<String> apply_type) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.description = description;
        this.apply_type.addAll(apply_type);
    }
    public List<String> getApplyType() {return apply_type;}
    public int getID() {
        return id;
    }
    public String getName() {
        return name;
    }
    public int getCost() {
        return cost;
    }
    public Text getDescription(){return description;}
    public List<EntityAttributeModifier> getAttributeList() {
        return attributeModifiers;
    }
    public EntityAttributeModifier getAttributeIndex(int index) {
        if(attributeModifiers.isEmpty()) return null;
        return attributeModifiers.get(index);
    }
}
