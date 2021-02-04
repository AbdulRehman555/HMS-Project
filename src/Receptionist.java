import java.io.Serializable;

public class Receptionist extends Employee implements Serializable {
    private static final long serialVersionUID = 1L;

    private int overtime;
    public Receptionist(){
        super();
    }
    public Receptionist(int employeeId, String employeeName, double basicPay, int overtime) {
        super(employeeId, employeeName, basicPay);
        this.overtime = overtime;
    }

    public void setOvertime(int overtime) {
        this.overtime = overtime;
    }
    public int getOvertime() {
        return overtime;
    }

    @Override
    public double salary() {
        return super.basicPay+(overtime*500);
    }

    @Override
    public void getter() {
        super.getter();
        System.out.print("OverTime: "+overtime+" hrs");;
    }
}
