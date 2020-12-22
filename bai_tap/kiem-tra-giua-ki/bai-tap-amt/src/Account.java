public class Account {
    private int balance;

    private String name;

    public Account(String name, int balance) {
        this.name = name;
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    // nap tien
    public boolean deposit(int amount) {
        if (amount > 0) {
            this.balance += amount;
            return true;
        }
        return false;
    }

    // rut tien
    public boolean withdrawal(int amount) {
        if (amount > 0 && balance - amount >= 0) {
            this.balance -= amount;
            return true;
        }
        return false;
    }

    public String getName() {
        return name;
    }
}
