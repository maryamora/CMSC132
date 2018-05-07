import java.util.Scanner;

public class Simulation {

    public static void main(String[] args) {

        int choice = 0;

        System.out.println("SIMULATION\n\n1.) Write a word.\n2.) Read a word.\n3.) Do not simulate. Terminate program.\n\nSimulate? (Enter number) ");
        Scanner scanner = new Scanner(System.in);

        do{

            choice = scanner.nextInt();

        }while (choice < 1 || choice > 3);

        Memory memory = new Memory();

        do{
            switch (choice){

                case 1:
                    System.out.println("Write a word.");
                    WriteWord writeProcess = new WriteWord(memory);
                    memory = writeProcess.process();
                    //memory.print();

                    System.out.println("\n\nStatus:\nMemory Data Register = "+writeProcess.getMdr()+"\nMemory Address Register: "+writeProcess.getMar());

                    break;

                case 2:
                    System.out.println("Read a word");
                    ReadWord readWord = new ReadWord(memory);
                    readWord.process();
                    System.out.println("\n\nStatus:\nMemory Data Register = "+readWord.getMdr()+"\nMemory Address Register: "+readWord.getMar());


                    break;

            }

            System.out.println("\nTry again?\n1.) Write a word.\n2.) Read a word.\n3.) Do not simulate. Terminate program.\n\nSimulate? (Enter number) ");
            choice = scanner.nextInt();

        }while (choice != 3);

        System.out.println("\n\nGoodbye!");

    }

}
