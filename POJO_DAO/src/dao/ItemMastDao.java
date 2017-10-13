package dao;

import model.ItemMast;

public interface ItemMastDao {

    boolean insertIntoItemMast(ItemMast itemMast);

    boolean updateItemMast(ItemMast itemMast);

    boolean deleteItemMast(ItemMast itemMast);

    ItemMast[] listItemMast();

    ItemMast getItemMast(int proId);

    ItemMast[] findItemMast(String proName);
}
