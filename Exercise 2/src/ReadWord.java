import java.util.Scanner;

public class ReadWord {

    int location; //location to be stored
    String mdr; //memory data register
    int mar; //memory address register
    Memory memory;

    public ReadWord(Memory memory) {
        location = 0;
        mdr = "";
        mar = 0;
        this.memory = memory;
    }

    public Memory process(){
        System.out.print("\nEnter location: ");
        Scanner scanner = new Scanner(System.in);
        location = scanner.nextInt();
        mar = location;
        mdr = memory.read(location);
        printMDR();
        return memory;
    }

    public void printMDR(){

        String character = "";
        String finalString = "";
        int counter = 1;

        for (int i = 0; i < mdr.length(); i++, counter++){

            character = character + mdr.charAt(i);

            if (counter == 3){
                finalString = finalString.concat(""+Character.toString((char)(int)Integer.valueOf(character)));
                //System.out.print(Character.toString((char)(int)Integer.valueOf(character)));
                counter = 0;
                character = "";
            }
        }
        System.out.println("data : "+finalString);
    }

    public int getLocation() {
        return location;
    }


    public String getMdr() {
        return mdr;
    }


    public int getMar() {
        return mar;
    }

}
