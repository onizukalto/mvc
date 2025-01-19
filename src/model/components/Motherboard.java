// model/components/Motherboard.java
package model.components;

public class Motherboard extends Component {
    private String socketType;
    private String formFactor;

    public Motherboard(String id, String name, double price, String type,
                      String socketType, String formFactor) {
        super(id, name, price, type);
        this.socketType = socketType;
        this.formFactor = formFactor;
    }

    public String getSocketType() { return socketType; }
    public String getFormFactor() { return formFactor; }
}