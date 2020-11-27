public class Tiger extends Animal {

    @Override
    public String makeSound() {
        return "Tiger: roarrrrrr";
    }

    public static void main(String[] args) {
        Tiger tiger = new Tiger();
       tiger.makeSound();
        System.out.println(tiger.makeSound());
    }


}
