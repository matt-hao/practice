package primary.design;

import java.util.List;

/**
 * clarify:
 * 1. item categories?
 * 2. if inventory of item was not enough, how? through exp
 * 3. coupon?
 * 4. payment method?
 * <p>
 * ShoppingCart
 * List<ItemOrder> items;
 * add(ItemOrder)
 * remove(ItemOrder)
 * applyCoupan(Coupan)
 * getTotal()
 * <p>
 * ItemOrder
 * Item item;
 * int quantity
 * double price;
 * getPrice()
 * getQuantity()
 * changeQuantity();
 * <p>
 * Enum ItemTypes\ or Category
 * <p>
 * Item
 * String name;
 * ItemTypes type;
 * double price;
 * String itemID;
 * getName()
 * getItemID();
 * getItemPrice();
 * <p>
 * <p>
 * user case:
 * 1. select Items-> add to card
 * 2. change count of item
 * 3. check inventory
 * 4. excute trans
 * 5. cancel trans
 * 6. calculate price
 * 7, clear cart;
 * 8. add to card
 * 9. remove from card;
 * 10. add coupon to itemorder
 */
public class ShoppingCart {
    private List<ItemOrder> items;

    public void excuteTransaction() {
    }

    public void cancelTransaction() {
    }

    private void checkInventory() {
        //for items
        for (ItemOrder i : items) {
            i.checkInventory(); // if not meet, throw exp
        }
    }

    public boolean changeQuantityByItem(ItemOrder io, int quantity) {
        //1.calculate quantity
        if (io.getInventory() - quantity < 0)
            return false;
        io.setQuantity(quantity);
        return true;
    }

    public boolean addToCart(ItemOrder io) {
        //for loop check whether io existed
        return true;
    }

    public boolean removeFromCart(ItemOrder io) {
        return true;
    }

    public double calculatePrice() {
        return 0;
    }

    public void addCoupon(ItemOrder io, Coupon coupon) {
        io.setCoupon(coupon);
    }

    public void clearCart() {
        items.clear();
    }
}

class ItemOrder {
    private Item item;
    private int quantity;
    private double prices;
    private Coupon coupon;


    public boolean checkInventory() {
        return item.getInventory() - this.quantity >= 0;
    }

    public int getInventory() {
        return item.getInventory();
    }

    public void setQuantity(int q) {
        this.quantity = q;
    }

    public double getPrices() {
        return coupon == null ? prices : coupon.getRate() * prices;
    }

    public void setCoupon(Coupon c) {
        this.checkCoupon();
        this.coupon = c;
    }

    public boolean checkCoupon() {
        return true;
    }
}

class Item {
    //basic info
    private int id;
    private String name;
    private int inventory;
    private Category category;

    public int getInventory() {
        return 0;
    }
}

class Category {
    List<Item> items;
}

class Coupon {
    private String type;
    private double rate;
    private String rule;

    public double getRate() {
        return this.rate;
    }
}