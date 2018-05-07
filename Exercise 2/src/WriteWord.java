import java.util.Scanner;

public class WriteWord {

    String word; //word to be stored
    String mdr; //memory data register
    int mar; //memory address register

    Memory memory;

    public WriteWord(Memory memory) {
        word = "";
        this.memory = memory;
    }

    public Memory process(){
        System.out.print("Enter word: ");
        Scanner scanner = new Scanner(System.in);
        word = scanner.nextLine();
        mdr = processWord();
        mar = memory.alu();
        writeSignal();

        return memory;
    }

    public String processWord(){
        int temp = 0;
        String tempString = "";

        for (int i = 0; i < word.length(); i++){
            temp = word.charAt(i);

            if (temp < 100){
                tempString = tempString.concat("0"+String.valueOf(temp));
            }else{
                tempString = tempString.concat(String.valueOf(temp));
            }
        }
        System.out.println(tempString);
        return tempString;
    }

    public void writeSignal(){
        memory.write(mdr,mar);
    }

    public String getWord() {
        return word;
    }


    public String getMdr() {
        return mdr;
    }


    public int getMar() {
        return mar;
    }

}
