import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Main
{
    private static volatile boolean turnUpdate = false;

    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(2, () -> {
            System.out.println("Turn End!");
            turnUpdate = false;
        });
        
        Action action1 = new Action(true, 0, "NONE", "TestAction1", false) {
            @Override
            public void effectProcess() {
                int burnDuration = 3;
                while (burnDuration > 0) {
                    if (turnUpdate) {
                        burnDuration--;
                        System.out.println(this.getName() + " Duration: " + burnDuration);
                        try{ barrier.await(); }catch(InterruptedException|BrokenBarrierException e){ Thread.currentThread().interrupt(); }
                    }
                }
            }
        };
        
        Action action2 = new Action(true, 0, "NONE", "TestAction2", false) {
            @Override
            public void effectProcess() {
                int burnDuration = 2;
                while (burnDuration > 0) {
                    if (turnUpdate) {
                        burnDuration--;
                        System.out.println(this.getName() + " Duration: " + burnDuration);
                        try{ barrier.await(); }catch(InterruptedException|BrokenBarrierException e){ Thread.currentThread().interrupt(); }
                    }
                }
            }
        };
        
        Thread action1Thread = new Thread(action1, action1.getName());
        Thread action2Thread = new Thread(action2, action2.getName());
        
        action1Thread.start();
        action2Thread.start();
        
        for(int i = 3; i > 0; i--) 
        {
            System.out.println("Turn Start!");
            turnUpdate = true;
            // try{ barrier.await(); }catch(InterruptedException|BrokenBarrierException e){ Thread.currentThread().interrupt(); }
            try { Thread.sleep(1000); }catch(InterruptedException e){ Thread.currentThread().interrupt(); }
        }
    }
}

        