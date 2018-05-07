public class Registers {

    int index;
    String registerName;
    int value;

    public Registers() {
    }

    public Registers(int index, String registerName, int value) {
        this.index = index;
        this.registerName = registerName;
        this.value = value;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getRegisterName() {
        return registerName;
    }

    public void setRegisterName(String registerName) {
        this.registerName = registerName;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
