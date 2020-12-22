public class Promotion {
    public double promotionRate;
    public String startDay;
    public String endDate;

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
//
//    public static void main(String[] args) {
//        Promotion promotion = new Promotion(10, "25/10/2020", "28/10/2020");
//        System.out.println(promotion);
//        promotion.setStartDay("100/100/11");
//        System.out.println("sau khi thay doi");
//        System.out.println(promotion);
//
//    }
}
