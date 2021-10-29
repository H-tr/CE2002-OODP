import java.util.Scanner;

public class OrderManager {

    private Order order;

    public OrderManager(Order order) {
        this.order = order;
    };
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println();
        System.out.println("Please Enter your choice:");
        int choice = sc.nextInt();
    }
}
