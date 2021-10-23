package de.coolepizza.bingo.utils;



import de.coolepizza.bingo.manager.BingoSettings;
import org.bukkit.Material;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class ItemSelector {
    private static ArrayList<Material> base = new ArrayList<>();
    private static ArrayList<Material> normal = new ArrayList<>();
    private static ArrayList<Material> hard = new ArrayList<>();
    static {
        // Insg. 234 Items

        // Basic Items

        addBaseItem(Material.NOTE_BLOCK);
        addBaseItem(Material.FLOWER_POT);
        addBaseItem(Material.SMITHING_TABLE);
        addBaseItem(Material.FLETCHING_TABLE);
        addBaseItem(Material.STONECUTTER);
        addBaseItem(Material.IRON_BLOCK);
        addBaseItem(Material.GRINDSTONE);
        addBaseItem(Material.COMPOSTER);
        addBaseItem(Material.BARREL);
        addBaseItem(Material.PISTON);
        addBaseItem(Material.SMOKER);
        addBaseItem(Material.BLAST_FURNACE);
        addBaseItem(Material.DISPENSER);
        addBaseItem(Material.HOPPER);
        addBaseItem(Material.POWERED_RAIL);
        addBaseItem(Material.DETECTOR_RAIL);
        addBaseItem(Material.RAIL);
        addBaseItem(Material.ACTIVATOR_RAIL);
        addBaseItem(Material.ANVIL);
        addBaseItem(Material.PUMPKIN);
        addBaseItem(Material.CARVED_PUMPKIN);
        addBaseItem(Material.JACK_O_LANTERN);
        addBaseItem(Material.DRIED_KELP_BLOCK);
        addBaseItem(Material.IRON_BARS);
        addBaseItem(Material.HAY_BLOCK);
        addBaseItem(Material.LANTERN);
        addBaseItem(Material.BIRCH_LEAVES);
        addBaseItem(Material.OAK_LEAVES);
        addBaseItem(Material.SPRUCE_LEAVES);
        addBaseItem(Material.REPEATER);
        addBaseItem(Material.MINECART);
        addBaseItem(Material.CHEST_MINECART);
        addBaseItem(Material.HOPPER_MINECART);
        addBaseItem(Material.FURNACE_MINECART);
        addBaseItem(Material.TARGET);
        addBaseItem(Material.IRON_DOOR);
        addBaseItem(Material.IRON_TRAPDOOR);
        addBaseItem(Material.SEAGRASS);
        addBaseItem(Material.CHAIN);
        addBaseItem(Material.WHITE_CONCRETE);
        addBaseItem(Material.WHITE_CONCRETE_POWDER);
        addBaseItem(Material.GLASS);
        addBaseItem(Material.REDSTONE_TORCH);
        addBaseItem(Material.CUT_SANDSTONE);
        addBaseItem(Material.SANDSTONE);
        addBaseItem(Material.CHISELED_SANDSTONE);
        addBaseItem(Material.CAULDRON);
        addBaseItem(Material.APPLE);
        addBaseItem(Material.KELP);
        addBaseItem(Material.SHIELD);
        addBaseItem(Material.IRON_INGOT);
        addBaseItem(Material.GOLD_INGOT);
        addBaseItem(Material.WRITABLE_BOOK);
        addBaseItem(Material.CLOCK);
        addBaseItem(Material.SHEARS);
        addBaseItem(Material.COMPASS);
        addBaseItem(Material.IRON_SHOVEL);
        addBaseItem(Material.IRON_PICKAXE);
        addBaseItem(Material.IRON_HOE);
        addBaseItem(Material.IRON_AXE);
        addBaseItem(Material.IRON_SWORD);
        addBaseItem(Material.IRON_HELMET);
        addBaseItem(Material.IRON_CHESTPLATE);
        addBaseItem(Material.IRON_LEGGINGS);
        addBaseItem(Material.IRON_BOOTS);
        addBaseItem(Material.GOLDEN_SHOVEL);
        addBaseItem(Material.GOLDEN_PICKAXE);
        addBaseItem(Material.GOLDEN_HOE);
        addBaseItem(Material.GOLDEN_AXE);
        addBaseItem(Material.GOLDEN_SWORD);
        addBaseItem(Material.GOLDEN_HELMET);
        addBaseItem(Material.GOLDEN_CHESTPLATE);
        addBaseItem(Material.GOLDEN_LEGGINGS);
        addBaseItem(Material.GOLDEN_BOOTS);
        addBaseItem(Material.BOOK);
        addBaseItem(Material.LEATHER_HELMET);
        addBaseItem(Material.LEATHER_CHESTPLATE);
        addBaseItem(Material.LEATHER_LEGGINGS);
        addBaseItem(Material.LEATHER_BOOTS);
        addBaseItem(Material.ARROW);
        addBaseItem(Material.FLINT_AND_STEEL);
        addBaseItem(Material.LAVA_BUCKET);
        addBaseItem(Material.WATER_BUCKET);
        addBaseItem(Material.MILK_BUCKET);
        addBaseItem(Material.BUCKET);
        addBaseItem(Material.PAINTING);
        addBaseItem(Material.ITEM_FRAME);
        addBaseItem(Material.EGG);
        addBaseItem(Material.BONE);
        addBaseItem(Material.GOLD_NUGGET);
        addBaseItem(Material.SUGAR);
        addBaseItem(Material.FEATHER);
        addBaseItem(Material.WHEAT_SEEDS);
        addBaseItem(Material.ORANGE_DYE);
        addBaseItem(Material.WHITE_DYE);
        addBaseItem(Material.MAGENTA_DYE);
        addBaseItem(Material.LIGHT_BLUE_DYE);
        addBaseItem(Material.YELLOW_DYE);
        addBaseItem(Material.LIGHT_GRAY_DYE);
        addBaseItem(Material.PINK_DYE);
        addBaseItem(Material.GRAY_DYE);
        addBaseItem(Material.CYAN_DYE);
        addBaseItem(Material.PURPLE_DYE);
        addBaseItem(Material.BLUE_DYE);
        addBaseItem(Material.CHARCOAL);
        addBaseItem(Material.GOLD_BLOCK);
        addBaseItem(Material.WRITTEN_BOOK);

        // Medium Items

        addNormalItem(Material.BELL);
        addNormalItem(Material.SOUL_CAMPFIRE);
        addNormalItem(Material.SOUL_TORCH);
        addNormalItem(Material.SOUL_LANTERN);
        addNormalItem(Material.JUKEBOX);
        addNormalItem(Material.CACTUS);
        addNormalItem(Material.DIAMOND_BLOCK);
        addNormalItem(Material.WARPED_STEM);
        addNormalItem(Material.CRIMSON_STEM);
        addNormalItem(Material.SOUL_SAND);
        addNormalItem(Material.SOUL_SOIL);
        addNormalItem(Material.TNT);
        addNormalItem(Material.OBSERVER);
        addNormalItem(Material.GILDED_BLACKSTONE);
        addNormalItem(Material.QUARTZ_BLOCK);
        addNormalItem(Material.BOOKSHELF);
        addNormalItem(Material.QUARTZ_PILLAR);
        addNormalItem(Material.CHISELED_QUARTZ_BLOCK);
        addNormalItem(Material.SHROOMLIGHT);
        addNormalItem(Material.GLOWSTONE);
        addNormalItem(Material.CRYING_OBSIDIAN);
        addNormalItem(Material.OBSIDIAN);
        addNormalItem(Material.REDSTONE_BLOCK);
        addNormalItem(Material.DAYLIGHT_DETECTOR);
        addNormalItem(Material.LAPIS_BLOCK);
        addNormalItem(Material.COMPARATOR);
        addNormalItem(Material.WARPED_WART_BLOCK);
        addNormalItem(Material.NETHER_WART_BLOCK);
        addNormalItem(Material.MAGMA_BLOCK);
        addNormalItem(Material.NETHERRACK);
        addNormalItem(Material.SNOW);
        addNormalItem(Material.VINE);
        addNormalItem(Material.NETHER_BRICKS);
        addNormalItem(Material.TRIPWIRE_HOOK);
        addNormalItem(Material.BONE_BLOCK);
        addNormalItem(Material.LOOM);
        addNormalItem(Material.DEAD_BUSH);
        addNormalItem(Material.GOLDEN_CARROT);
        addNormalItem(Material.GOLDEN_APPLE);
        addNormalItem(Material.CAKE);
        addNormalItem(Material.DIAMOND_SHOVEL);
        addNormalItem(Material.DIAMOND_PICKAXE);
        addNormalItem(Material.DIAMOND_HOE);
        addNormalItem(Material.DIAMOND_AXE);
        addNormalItem(Material.DIAMOND_SWORD);
        addNormalItem(Material.DIAMOND_HELMET);
        addNormalItem(Material.DIAMOND_CHESTPLATE);
        addNormalItem(Material.DIAMOND_LEGGINGS);
        addNormalItem(Material.DIAMOND_BOOTS);
        addNormalItem(Material.IRON_HORSE_ARMOR);
        addNormalItem(Material.GOLDEN_HORSE_ARMOR);
        addNormalItem(Material.DIAMOND);
        addNormalItem(Material.RED_MUSHROOM);
        addNormalItem(Material.BROWN_MUSHROOM);
        addNormalItem(Material.HONEY_BOTTLE);
        addNormalItem(Material.CROSSBOW);
        addNormalItem(Material.FISHING_ROD);
        addNormalItem(Material.SWEET_BERRIES);
        addNormalItem(Material.GLOWSTONE_DUST);
        addNormalItem(Material.LIME_DYE);
        addNormalItem(Material.GREEN_DYE);
        addNormalItem(Material.MAP);
        addNormalItem(Material.FIREWORK_ROCKET);
        addNormalItem(Material.WARPED_FUNGUS);
        addNormalItem(Material.CRIMSON_FUNGUS);

        // Hard Items

        hard.add(Material.ENCHANTING_TABLE);
        hard.add(Material.COBWEB);
        hard.add(Material.EMERALD_BLOCK);
        hard.add(Material.PRISMARINE);
        hard.add(Material.PRISMARINE_BRICKS);
        hard.add(Material.DARK_PRISMARINE);
        hard.add(Material.BREWING_STAND);
        hard.add(Material.ANCIENT_DEBRIS);
        hard.add(Material.SEA_LANTERN);
        hard.add(Material.SPONGE);
        hard.add(Material.MELON);
        hard.add(Material.SEA_PICKLE);
        hard.add(Material.GHAST_TEAR);
        hard.add(Material.MAGMA_CREAM);
        hard.add(Material.ENCHANTED_BOOK);
        hard.add(Material.SPECTRAL_ARROW);
        hard.add(Material.NETHERITE_SCRAP);
        hard.add(Material.DIAMOND_HORSE_ARMOR);
        hard.add(Material.HEART_OF_THE_SEA);
        hard.add(Material.NAME_TAG);
        hard.add(Material.SADDLE);
        hard.add(Material.FERMENTED_SPIDER_EYE);
        hard.add(Material.EXPERIENCE_BOTTLE);
        hard.add(Material.BAMBOO);
        hard.add(Material.COOKIE);
        hard.add(Material.BROWN_DYE);
        hard.add(Material.GLISTERING_MELON_SLICE);
        hard.add(Material.FIRE_CHARGE);
        hard.add(Material.ENDER_EYE);
        hard.add(Material.END_CRYSTAL);
        hard.add(Material.SCAFFOLDING);
        hard.add(Material.RABBIT_FOOT);
        hard.add(Material.RABBIT_HIDE);
        hard.add(Material.PUFFERFISH);
        hard.add(Material.SCUTE);

    }
    public static void addBaseItem(Material material){
        base.add(material);
    }
    public static void removeBaseItem(Material material){
        if (base.contains(material)){
            base.remove(material);
        }
    }
    public static void addBaseItem(String material){
        for (Material value : Material.values()) {
            if (value.name().contains(material)){
                base.add(value);
            }
        }
    }
    public static void addNormalItem(Material material){
        normal.add(material);
    }
    public static void removeNormalItem(Material material){
        if (normal.contains(material)){
            normal.remove(material);
        }
    }
    public static void addNormalItem(String material){
        for (Material value : Material.values()) {
            if (value.name().contains(material)){
                normal.add(value);
            }
        }
    }

    public static ArrayList<Material> getBase() {
        return base;
    }

    public static void addHardItem(Material material){
        hard.add(material);
    }
    public static void removeHardItem(Material material){
        if (hard.contains(material)){
            hard.remove(material);
        }
    }
    public static void addHardItem(String material){
        for (Material value : Material.values()) {
            if (value.name().contains(material)){
                hard.add(value);
            }
        }
    }

    public static ArrayList<Material> getHard() {
        return hard;
    }

    public static ArrayList<Material> getNormal() {
        return normal;
    }

    public static ArrayList<Material> getItems(BingoSettings.BingoDifficulty bingoDifficulty , int itemsize) {
        ArrayList<Material> items = new ArrayList<>();
        if (bingoDifficulty == BingoSettings.BingoDifficulty.EASY){
            for (int i = 0; i < itemsize  ; i++) {
                Material material = base.get(new Random().nextInt(base.size()));

                while (items.contains(material)){
                    material = base.get(new Random().nextInt(base.size()));
                }
                items.add(material);
            }
        }else if (bingoDifficulty == BingoSettings.BingoDifficulty.NORMAl){
            int baseitems = (itemsize/3)*2;
            int normalitems = itemsize - baseitems;
            for (int i = 0; i < baseitems  ; i++) {
                Material material = base.get(new Random().nextInt(base.size()));
                while (items.contains(material)){
                      material = base.get(new Random().nextInt(base.size()));
                }
                items.add(material);
            }

            for (int i = 0; i < normalitems  ; i++) {
                Material material = normal.get(new Random().nextInt(normal.size()));
                while (items.contains(material)){
                    material = normal.get(new Random().nextInt(normal.size()));
                }
                items.add(material);
            }

        }else if (bingoDifficulty == BingoSettings.BingoDifficulty.HARD){
            int itemsizes = itemsize/3;

            for (int i = 0; i < itemsizes  ; i++) {
                Material material = base.get(new Random().nextInt(base.size()));
                while (items.contains(material)){
                    material = base.get(new Random().nextInt(base.size()));
                }
                items.add(material);
            }

            for (int i = 0; i < itemsizes  ; i++) {
                Material material = normal.get(new Random().nextInt(normal.size()));
                while (items.contains(material)){
                    material = normal.get(new Random().nextInt(normal.size()));
                }
                items.add(material);
            }
            for (int i = 0; i < itemsizes  ; i++) {
                Material material = hard.get(new Random().nextInt(hard.size()));
                while (items.contains(material)){
                    material = hard.get(new Random().nextInt(hard.size()));
                }
                items.add(material);
            }
        }
        for (Material item : items) {
            if (!item.isItem()){
                return getItems(bingoDifficulty, itemsize);
            }
        }
        return items;
    }

}
