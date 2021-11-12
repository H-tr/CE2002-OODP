import javax.swing.JFrame;

public class BackgroundMethod extends Thread {

    @Override
    public void run() {
        while (true) {
            System.out.println("Poop");
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
