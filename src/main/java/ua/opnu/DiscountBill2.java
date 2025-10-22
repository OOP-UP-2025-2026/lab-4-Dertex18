package ua.opnu;


import ua.opnu.Employee;
import ua.opnu.GroceryBill;
import ua.opnu.Item;


public class DiscountBill2 { // Назва з трьома 'l' згідно з завданням


    private GroceryBill innerBill;


    private boolean regularCustomer;
    private int discountCount;
    private double discountAmount;


    public DiscountBill2(Employee clerk, boolean regularCustomer) {
        // Ми не кличемо super(), а створюємо внутрішній об'єкт
        this.innerBill = new GroceryBill(clerk);
        this.regularCustomer = regularCustomer;
        this.discountCount = 0;
        this.discountAmount = 0.0;
    }


    public void add(Item item) {

        innerBill.add(item);


        if (regularCustomer && item.getDiscount() > 0.0) {
            this.discountCount++;
            this.discountAmount += item.getDiscount();
        }
    }


    public double getTotal() {

        double originalTotal = innerBill.getTotal();


        return originalTotal - this.discountAmount;
    }


    public int getDiscountCount() {
        return this.discountCount;
    }

    public double getDiscountAmount() {
        return this.discountAmount;
    }

    public double getDiscountPercent() {
        double originalTotal = innerBill.getTotal();
        if (originalTotal == 0) {
            return 0.0;
        }
        return (this.discountAmount * 100) / originalTotal;
    }



    public Employee getClerk() {
        return innerBill.getClerk();
    }
}