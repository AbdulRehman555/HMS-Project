import java.io.Serializable;
//Java Interfaces
//Implementing Serializable for writing Objects of Doctor Class
public class Doctor extends Employee implements Serializable {
    private static final long serialVersionUID = 1L;
    private String specialization;
    private int experience;

    public  Doctor(){
        super();
        this.specialization = new String();
        this.experience = 0;
    }
    public Doctor(int employeeId, String employeeName, double basicPay,int experience) {
        super(employeeId, employeeName, basicPay);
        this.experience = experience;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
    public String getSpecialization() {
        return specialization;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }
    public int getExperience() {
        return experience;
    }

    //Overriding abstract method of Employee class
    @Override
    public double salary() {
        return super.basicPay+(experience*5000);
    }
    @Override
    public void getter() {
        super.getter();
        System.out.println("Specializtion: "+specialization);
        System.out.println("Experience: "+experience+" years");
    }
}
