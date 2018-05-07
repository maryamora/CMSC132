import java.util.ArrayList;

public class Memory {

    ArrayList<String> data;

    public Memory() {
        data = new ArrayList<>();
    }

    public void write(String mdr, int mar){
        data.add(mar, mdr);
    }

    public String read(int mar){
        return data.get(mar);
    }

    public int alu(){
        return data.size();
    }

    public void print(){
        int mar = 0;
        for (String a: data){
            System.out.println("memory location: "+mar+"; data: "+a);
            mar++;
        }
    }

}
