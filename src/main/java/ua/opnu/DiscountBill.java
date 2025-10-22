package ua.opnu;

// Необхідні імпорти для точних розрахунків
import java.math.BigDecimal;
import java.math.RoundingMode;

public class DiscountBill extends GroceryBill {

    private boolean regularCustomer;
    private int discountCount;

    public DiscountBill(Employee clerk, boolean regularCustomer) {
        super(clerk);
        this.regularCustomer = regularCustomer;
        this.discountCount = 0;
    }


    @Override
    public void add(Item item) {
        super.add(item); // Додаємо товар до списку
        if (regularCustomer && item.getDiscount() > 0.0) {
            this.discountCount++;
        }
    }



    private BigDecimal getPreciseOriginalTotal() {
        BigDecimal originalTotal = BigDecimal.ZERO;

        for (Item item : this.items) {

            originalTotal = originalTotal.add(new BigDecimal(String.valueOf(item.getPrice())));
        }
        return originalTotal;
    }


    private BigDecimal getPreciseDiscountAmount() {

        if (!regularCustomer) {
            return BigDecimal.ZERO;
        }

        BigDecimal totalDiscount = BigDecimal.ZERO;
        for (Item item : this.items) {
            if (item.getDiscount() > 0.0) {
                totalDiscount = totalDiscount.add(new BigDecimal(String.valueOf(item.getDiscount())));
            }
        }
        return totalDiscount;
    }



    @Override
    public double getTotal() {

        BigDecimal originalTotal = getPreciseOriginalTotal();
        BigDecimal totalDiscount = getPreciseDiscountAmount();


        return originalTotal.subtract(totalDiscount).doubleValue();
    }

    public int getDiscountCount() {
        return this.discountCount;
    }

    public double getDiscountAmount() {

        return getPreciseDiscountAmount().doubleValue();
    }

    public double getDiscountPercent() {
        BigDecimal originalTotal = getPreciseOriginalTotal();


        if (originalTotal.compareTo(BigDecimal.ZERO) == 0) {
            return 0.0;
        }


        BigDecimal discountedTotal = originalTotal.subtract(getPreciseDiscountAmount());

        BigDecimal hundred = new BigDecimal("100");


        BigDecimal pct = hundred.subtract(
                discountedTotal.multiply(hundred).divide(originalTotal, 13, RoundingMode.HALF_UP)
        );

        return pct.doubleValue();
    }
}