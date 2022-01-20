package EjecuteComand;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class run {

        public static void main(String[] args) throws Exception {
            ProcessBuilder python = new ProcessBuilder(
                    "cmd.exe", "/c", "python");
            ProcessBuilder flask = new ProcessBuilder(
                    "cmd.exe", "/c", "pip install Flask");
            ProcessBuilder pywhatkit = new ProcessBuilder(
                    "cmd.exe", "/c", "pip install pywhatkit");
            ProcessBuilder builder = new ProcessBuilder(
                    "cmd.exe", "/c", "Python src/main/java/service/util/main.py");
            python.redirectErrorStream(true) ;
            builder.redirectErrorStream(true);
            flask.redirectErrorStream(true);
            pywhatkit.redirectErrorStream(true);
            Process p = builder.start();

            BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            while (true) {
                line = r.readLine();
                if (line == null) { break; }
                System.out.println(line);
            }
        }
    }

