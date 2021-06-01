import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MemberThread implements Runnable {


    @Override
    public void run() {
        try {

            MemberMonitor.memberMonitor();
            Thread.sleep(3000);


        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

    }


}
