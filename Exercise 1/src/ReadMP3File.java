import javazoom.jl.player.Player;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;

public class ReadMP3File {

    String fileName;
    Player player;

    public ReadMP3File() {
        //process

    }

    public void process(){

        System.out.print("What is the name of your file? ");
        Scanner sc = new Scanner(System.in);
        fileName = sc.next();
        System.out.println();

        File file = new File(fileName);

        TimeCalculator tc = new TimeCalculator();
        long startTime = System.nanoTime();
        Double cpuStartTime = tc.getCpuTime();
        System.out.println("READING MP3 FILE...");

        try
        {
            //create FileInputStream object
            FileInputStream fin = new FileInputStream(file);
            byte fileContent[] = new byte[(int)file.length()];
            fin.read(fileContent);
        }
        catch(Exception e)
        {
            System.out.println("File not found" + e);
        }

        long endTime   = System.nanoTime();
        Double cpuEndTime = tc.getCpuTime();
        Double totalCPUTime = cpuEndTime - cpuStartTime;
        long totalTime = endTime - startTime;
        System.out.println("\nRunning Time: "+totalTime+"\nCPU Time: "+totalCPUTime);

        try {
            BufferedInputStream buffer = new BufferedInputStream(new FileInputStream(fileName));
            player = new Player(buffer);
            player.play();
        }
        catch (Exception e) {

            System.out.println(e);
        }



    }
}
