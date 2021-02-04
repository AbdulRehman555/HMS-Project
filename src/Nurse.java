import java.io.Serializable;

public class Nurse extends Employee implements Serializable {
    private static final long serialVersionUID = 1L;
    private String position;
    private int hoursWorked;

    public Nurse(){
        super();
    }
    public Nurse(int employeeId, String employeeName, double basicPay, int hoursWorked) {
        super(employeeId, employeeName, basicPay);
        this.hoursWorked = hoursWorked;
    }

    public void setPosition(String position) {
        this.position = position;
    }
    public String getPosition() {
        return position;
    }
    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }
    public int getHoursWorked() {
        return hoursWorked;
    }

    @Override
    public double salary() {
        return super.basicPay+(hoursWorked*200);
    }

    @Override
    public void getter() {
        super.getter();
        System.out.print("Position: "+position);
        System.out.println("Hours worked(per day): "+hoursWorked+" hrs");
    }
}
