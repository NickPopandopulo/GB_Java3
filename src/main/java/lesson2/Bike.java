package lesson2;

public class Bike {
    private final int id;
    private final String model;
    private final String serialNo;

    public Bike(int id, String model, String serialNo) {
        this.id = id;
        this.model = model;
        this.serialNo = serialNo;
    }

    @Override
    public String toString() {
        return "Bike{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", serialNo='" + serialNo + '\'' +
                '}';
    }
}
