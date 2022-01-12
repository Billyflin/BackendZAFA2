package EjecuteComand;

import java.io.IOException;

public class execute {
//The best possible I found is to construct a command which you want to execute
//as a string and use that in exec. If the batch file takes command line arguments
//the command can be constructed a array of strings and pass the array as input to
//the exec method. The command can also be passed externally as input to the method.


    public void run() {
    Runtime run = Runtime.getRuntime();
    Process p = null;
    String cmd = "Python main.py";

    try {
        p = run.exec(cmd);
        p.getErrorStream();
        p.waitFor();

    }
    catch (IOException | InterruptedException e) {
        e.printStackTrace();
        System.out.println("ERROR.RUNNING.CMD");

    }finally{
        p.destroy();
    }
    }
}
