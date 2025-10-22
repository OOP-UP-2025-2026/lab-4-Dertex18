package ua.opnu;
import java.util.ArrayList;
import java.util.List;

public class GroceryBill {
    private Employee clerk;

    // protected, щоб дочірній клас DiscountBill мав доступ до списку
    protected List<Item> items;

    public GroceryBill(Employee clerk) {
        this.clerk = clerk;
        this.items = new ArrayList<>();
    }


    public void add(Item item) {
        items.add(item);
    }


    public double getTotal() {
        double total = 0.0;
        for (Item item : items) {
            total += item.getPrice();
        }
        return total;
    }
    public Employee getClerk() {
        // "clerk" - це ім'я вашої змінної Employee у класі GroceryBill
        return this.clerk;
    }
}