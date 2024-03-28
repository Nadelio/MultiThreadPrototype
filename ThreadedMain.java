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

    private static ThreadedMain main = new ThreadedMain();
    public static void main(String[] args)
    {
        main.start();
        runAnim();
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
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}