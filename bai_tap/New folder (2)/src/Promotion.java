public Promotion(double promotionRate, String startDay, String endDate) {
        this.promotionRate = promotionRate;
        this.startDay = startDay;
        this.endDate = endDate;
        }

public double getPromotionRate() {
        return promotionRate;
        }

public void setPromotionRate(double promotionRate) {
        this.promotionRate = promotionRate;
        }

public String getStartDay() {
        return startDay;
        }

public void setStartDay(String startDay) {
        this.startDay = startDay;
        }

public String getEndDate() {
        return endDate;
        }

public void setEndDate(String endDate) {
        this.endDate = endDate;
        }

@Override
public String toString() {
        return
        "promotionalPercent=" + promotionRate + "%" +
        ", startDay=" + startDay +
        ", endDate=" + endDate
        ;
        }

public static void main(String[] args) {
        Promotion promotion = new Promotion(10, "25/10/2020", "28/10/2020");
        System.out.println(promotion);
        promotion.setPromotionRate(25);
        promotion.setStartDay("11/11/2020");
        promotion.setEndDate("20/11/2020");
        System.out.println("sau khi cap nhat");
        System.out.println(promotion);

        }
        }

