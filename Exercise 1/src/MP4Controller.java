import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;

public class MP4Controller implements Initializable{

    @FXML
    private MediaView mv;
    private MediaPlayer mp;
    private Media me;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String path = new File("E:/Documents/3rd Year Computer Science/2ND SEM/CMSC 132/LAB/Exercise 1/readthis.mp4").getAbsolutePath();

        TimeCalculator tc = new TimeCalculator();
        long startTime = System.nanoTime();
        Double cpuStartTime = tc.getCpuTime();
        System.out.println("start: "+cpuStartTime);
        System.out.println("READING MP4 FILE...");

        File file = new File(path);

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
        System.out.println("End: "+cpuEndTime);

        me = new Media(new File(path).toURI().toString());
        mp = new MediaPlayer(me);
        mv.setMediaPlayer(mp);
        mp.setAutoPlay(true);



    }
}
