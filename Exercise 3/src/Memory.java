public class Memory {

    int memoryAddress;
    String data;

    public Memory() {
    }

    public Memory(int memoryAddress) {
        this.memoryAddress = memoryAddress;
    }

    public Memory(int memoryAddress, String data) {
        this.memoryAddress = memoryAddress;
        this.data = data;
    }

    public int getMemoryAddress() {
        return memoryAddress;
    }

    public void setMemoryAddress(int memoryAddress) {
        this.memoryAddress = memoryAddress;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

}
