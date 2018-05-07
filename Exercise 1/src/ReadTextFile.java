import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ReadTextFile {

    String fileName;
    BufferedReader reader;

    public ReadTextFile() {
        //nothing
        fileName = "";
    }

    public void process(){
        System.out.print("What is the name of your file? ");
        Scanner sc = new Scanner(System.in);
        fileName = sc.next();
        System.out.println();

        TimeCalculator tc = new TimeCalculator();
        Long startTime = System.nanoTime();
        Double cpuStartTime = tc.getCpuTime();
        System.out.println("READING TEXT FILE... ");

        try{
            reader = new BufferedReader(new FileReader(fileName));
            String line = reader.readLine();
            while (line != null){
                //read next line
                System.out.println(line);
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e){
            e.printStackTrace();
        }

        long endTime   = System.nanoTime();
        Double cpuEndTime = tc.getCpuTime();
        Double totalCPUTime = cpuEndTime - cpuStartTime;
        long totalTime = endTime - startTime;
        System.out.println("\nRunning Time: "+totalTime+"\nCPU Time: "+totalCPUTime);

    }

}
