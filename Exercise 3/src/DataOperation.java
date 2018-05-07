import java.lang.reflect.Array;
import java.util.ArrayList;

public class DataOperation {

    int programCounter;
    String instructionRegister;
    ArrayList<Memory> mainMemory;
    ArrayList<Registers> mainRegisters;

    public DataOperation() {
        programCounter = 0;
        instructionRegister = "null";
        mainMemory = new ArrayList<>();
        mainRegisters = new ArrayList<>();
    }

    public void control(){

        /*
            Main Memory looks like...

            address     Data
            0           Add R0, R1, R2
            4           -
            8           -
            12          -
            16          -
            20          -
            24          -
            28          -
            32          -

            Main Registers look like...

            index       Register name       Value
            0           R0                  0
            1           R1                  5
            2           R2                  10
            3           R3                  15
            4           R4                  20
            5           R5                  25
            6           R6                  30
            7           R7                  35
            8           R8                  40

            Initial --> Program Counter = 0
            Initial --> IR = "";

        */

        setMainMemory();
        setMainRegisters();

        //print before process
        printEverything();

        //get instruction address from program counter
        retrieveAddress();
        //send to ALU
        ALU();
        //print after process
        printEverything();

    }

    public void ALU(){
        //tokenize
        ArrayList<String> tokenized = new ArrayList<>();
        tokenized = tokenize();
        //compute
        compute(tokenized);
        programCounter++;
    }

    public void compute(ArrayList<String> processThis){
        if (processThis.get(0).equalsIgnoreCase("Add")){
            //proceed
        }
            String a = ""+processThis.get(1).charAt(1);
            String b = ""+processThis.get(2).charAt(1);
            String c = ""+processThis.get(3).charAt(1);
            mainRegisters.get(Integer.parseInt(a)).setValue(mainRegisters.get(Integer.parseInt(b)).value+ mainRegisters.get(Integer.parseInt(c)).value);

    }

    public ArrayList<String> tokenize(){
        ArrayList<String> instruction = new ArrayList<>();
        String temp = "";
        for (int i = 0; i < instructionRegister.length(); i++){
            if (instructionRegister.charAt(i) == ' ' || instructionRegister.charAt(i) == ','){
                if (temp != ""){
                    instruction.add(temp);
                }
                temp = "";
            }else{
                temp = temp+instructionRegister.charAt(i);
            }
        }
        if (temp != "") {
            instruction.add(temp);
        }
        return instruction;
    }

    public void retrieveAddress(){
        instructionRegister = mainMemory.get(programCounter/4).getData();
    }

    public void setMainRegisters(){

        Registers tempRegister;
        String tempStr = "";

        for (int i = 0, tempVal = 0; i <= 8; i++, tempVal = tempVal+5){
            tempStr = "R"+i;
            tempRegister = new Registers(i,tempStr,tempVal);
            mainRegisters.add(tempRegister);
        }
    }

    public void setMainMemory(){
        Memory tempMemory;
        int tempAddress;

        for (tempAddress = 0; tempAddress <= 32; tempAddress = tempAddress+4){
            tempMemory = new Memory(tempAddress);
            mainMemory.add(tempMemory);
        }

        mainMemory.get(0).setData("Add R0, R1, R2");

    }

    public void printEverything(){
        System.out.println("Computer's innerworkings...\n");
        System.out.println("Program Counter = "+programCounter);
        System.out.println("Instruction Register = "+instructionRegister);
        System.out.println("\nMemory");
        System.out.println();

        for (Memory memory: mainMemory){
            System.out.println("Address: "+memory.getMemoryAddress()+"\t\tData: "+memory.getData());
        }

        System.out.println("\nRegisters");
        System.out.println();

        for (Registers registers: mainRegisters){
            System.out.println("Index: "+registers.getIndex()+"\t\tRegister: "+registers.getRegisterName()+"\t\tValue: "+registers.getValue());
        }

        System.out.println();

    }

}
