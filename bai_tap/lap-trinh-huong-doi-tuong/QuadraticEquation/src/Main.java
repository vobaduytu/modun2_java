public class Main {
    public static void main(String[] args) {
        Quadratic quadratic = new Quadratic(2, 5, 4);
        System.out.println(quadratic.getDiscriminant());
        if (quadratic.getDiscriminant() >= 0) {
            System.out.println(quadratic.getRoot1());
            System.out.println(quadratic.getRoot2());
        } else {
            System.out.println("vo nghiem");

        }

    }
}
