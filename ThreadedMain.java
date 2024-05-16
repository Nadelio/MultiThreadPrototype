public class ThreadedMain extends Thread
{
    public static String[] animFrames = {
        "_( - .-)_",
        "\\( - o-)/",
        "\\( > o<)/",
        "\\( > O<)/",
        "\\( > ~<)/",
        "_( - ~-)_",
        "_( - .-)_"        
    };

    public static boolean turnUpdate;

    private static ThreadedMain main = new ThreadedMain();
    public static void main(String[] args)
    {
        

        main.start();
        for(int i = 3; i > -1; i--)
        {
            System.out.println("Turn Start!");
            turnUpdate = true;
            try {Thread.sleep(25);}catch(Exception e){}
            System.out.println("Turn End!");
            turnUpdate = false;

            try {Thread.sleep(1000);}catch(Exception e){}
        }
        //runAnim();
    }

    public static void runAnim()
    {
        for(String s : animFrames)
        {
            System.out.println(s);
            try {Thread.sleep(250);}catch(Exception e){}
            main.run();
        }
    }
    @Override
    public void run()
    {
        //System.out.print("\033[H\033[2J");
        //System.out.flush();
        Action action1 = new Action(true, 0, "NONE", "TestAction1", false){
            @Override
            public void effectProcess(){
                int burnDuration = 3;
                while(burnDuration > 0){
                    if(turnUpdate){
                        burnDuration--;
                        System.out.println(this.getName() + " Duration: " + burnDuration);
                        try {Thread.sleep(50);} catch(InterruptedException e){}
                    }
                }
            }
        };

        Action action2 = new Action(true, 0, "NONE", "TestAction2", false){
            @Override
            public void effectProcess(){
                int burnDuration = 2;
                while(burnDuration > 0){
                    if(turnUpdate){
                        burnDuration--;
                        System.out.println(this.getName() + " Duration: " + burnDuration);
                        try {Thread.sleep(50);} catch(InterruptedException e){}
                    }
                }
            }
        };
        action1.run();
        action2.run();
    } //! need to develop some way to procedurally generate Threads or flip between action1.effectProcess() and action2.effectProcess()
}