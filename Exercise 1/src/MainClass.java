import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Scanner;

public class MainClass extends Application {

    public static void main(String[] args) {


        int choice = 0;


        System.out.println("What file would you like to read?\n\n1. Text File               2. MP3 File              3. Video File\n\n");

        do{

            System.out.print("Enter number: ");
            Scanner sc = new Scanner(System.in);
            choice = sc.nextInt();

        }while(choice < 1 || choice > 3);

        switch (choice){

            case 1:
                ReadTextFile rtf = new ReadTextFile();
                rtf.process();
                System.exit(0);
                break;

            case 2:
                ReadMP3File rmf = new ReadMP3File();
                rmf.process();
                System.exit(0);
                break;

            case 3:


                launch(args);


                System.exit(0);
                break;

        }
    }

    @Override
    public void start(Stage primaryStage) {

        try{

            Parent root = FXMLLoader.load(getClass().getResource("MP4Controller.fxml"));
            primaryStage.setTitle("Hello World");
            primaryStage.setScene(new Scene(root, 300, 275));
            primaryStage.show();

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
