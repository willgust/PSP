import java.io.IOException;

public class CreatorThread implements Runnable{
    @Override
    public void run() {
        try {
            MemberCreator.MemberCreator("correo.txt");
            Thread.sleep(3500);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
