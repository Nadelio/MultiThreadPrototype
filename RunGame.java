import java.io.Console;
import java.io.IOException;
import java.awt.GraphicsEnvironment;
// credit to https://stackoverflow.com/a/29138847/21975226 for this code! :)
public class RunGame
{
    public static void main(String[] args)
    {
        // this is what will be compiled into a .jar file that calls the .class files that then run the animation.
        Console console = System.console();
        if(console == null && !GraphicsEnvironment.isHeadless())
        {
            String filename = Main.class.getProtectionDomain().getCodeSource().getLocation().toString().substring(6);
            try {Runtime.getRuntime().exec(new String[]{"cmd","/c","start","cmd","/k","java -jar \"" + filename + "\""});}catch(IOException e){}
        }
        else
        {
            Main.main(new String[0]);
            System.out.println("Program has ended, please type 'exit' to close the console");
        }
    }    
}
