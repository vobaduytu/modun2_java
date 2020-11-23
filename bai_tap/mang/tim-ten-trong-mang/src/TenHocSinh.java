import java.util.Scanner;

public class TenHocSinh {
    public static void main(String[] args) {
        String[] name={"tu","anh","hai","thinh"};
        Scanner sc = new Scanner(System.in);
        System.out.println("nhap ten hoc sinh :");
        String newname = sc.nextLine();
        for (int i = 0; i < name.length;i++){
            if(name[i].equals(newname)){
                System.out.println("vi tri ten hoc sinh trong mang :" + (i + 1));

            }

        }
    }
}
