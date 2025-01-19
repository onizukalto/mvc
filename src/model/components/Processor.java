// model/components/Processor.java
package model.components;

public class Processor extends Component {
    private String socketType;
    private int tdp;
    private double frequency;

    public Processor(String id, String name, double price, String type,
                    String socketType, int tdp, double frequency) {
        super(id, name, price, type);
        this.socketType = socketType;
        this.tdp = tdp;
        this.frequency = frequency;
    }

    public String getSocketType() { return socketType; }
    public int getTdp() { return tdp; }
    public double getFrequency() { return frequency; }
}