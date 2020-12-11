import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean cont = true;
        do {
            System.out.println("Ngan hang ABC kinh chao Quy khach Nguyen Van A" +
                    " Menu:\n");
            System.out.println("1.  nhấn phím A để kiểm tra tài khoản");
            System.out.println("2.  nhấn phím D để nạp tiền");
            System.out.println("3.  nhấn phím W để rút tiền");
            System.out.println("4.  nhấn phím H để xem lịch sử 3 lần");
            System.out.println("5.  nhấn phím X để thoát");
            System.out.println("------------------------------");
            System.out.println("------------------------------");

            System.out.println(" nhập lựa chọn của bạn:");

            String chon = input.nextLine();
            switch (chon) {
                case "A":
                    AtmMethod.add("Nguyen Van A", 1200000);
                    AtmMethod.seach();
                     break;
//              
                case "D":

                    System.out.println("so tien ban nap");

                    AtmMethod.napMany();
                    break;
                case "W":
                    System.out.println("so tien ban muon rut");
                    AtmMethod.rutMany();
                    break;
                case "H":
                    AtmMethod.history();
                    break;
                case "X":
                    AtmMethod.exit();
                    cont = false;
                    break;
                default:
                    System.out.println("bạn nhập sai chức năng");
                    System.out.println("cảm ơn quý khách đã sử dụng dịch vụ ATM");
                    cont = false;
                    break;
            }
        } while (cont);
    }
}
