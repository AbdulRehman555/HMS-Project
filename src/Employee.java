import java.io.Serializable;

public abstract class Employee implements Serializable {
    private static final long serialVersionUID = 1L;
    private int employeeId;
    private String employeeName;
    protected double basicPay;

    public Employee(int employeeId, String employeeName,double basicPay){
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.basicPay = basicPay;
    }

    public Employee() {
        this.employeeId = 0;
        this.employeeName = new String();
        this.basicPay = 0;
    }

    public int getEmployeeId() {
        return employeeId;
    }
    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }
    public void setBasicPay(double basicPay) {
        this.basicPay = basicPay;
    }
    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    //Making salary() abstract
    public abstract double salary();

    public void getter(){
        System.out.println("Name: "+employeeName);
        System.out.println("ID: "+employeeId);
        System.out.println("Basic Pay: Rs. "+basicPay);
    }
}
