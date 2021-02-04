import java.io.Serializable;

public class Patient implements Serializable {
    private static final long serialVersionUID = 1L;

    private int patientId;
    private String patientName;
    private int patientAge;
    private String disease;
    private int doctorId;
    private String severity;
    private int nurseId;
    private int bedNumber;
    private String patientStatus;


    public Patient(){
        this.patientId = 0;
        this.patientName = new String();
        this.patientAge = 0;
        this.patientStatus = new String();
    }
    public Patient(int patientId, String patientName, int patientAge){
        this.patientId = patientId;
        this.patientName = patientName;
        this.patientAge = patientAge;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }
    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }
    public void setPatientAge(int patientAge) {
        this.patientAge = patientAge;
    }

    public void setPatientStatus(String patientStatus) {
        this.patientStatus = patientStatus;
    }
    public String getPatientStatus() {
        return patientStatus;
    }

    public void getPatientInfo(){
        System.out.println("~~~~~~~~ PATIENT INFO ~~~~~~~~");
        System.out.println("Name: "+patientName);
        System.out.println("ID: "+patientId);
        System.out.println("Age: "+patientAge);
        System.out.println("Disease: "+disease);
        System.out.println("Severity: "+severity);
        if(severity.equals("dangerous")){
            System.out.println("Nurse: "+nurseId);
            System.out.println("Bed Number: "+bedNumber);
        }
    }
    public void setNurseId(int nurseId) {
        this.nurseId = nurseId;
    }
    public int getNurseId() {
        return nurseId;
    }

    public void setBedNumber(int bedNumber) {
        this.bedNumber = bedNumber;
    }
    public int getBedNumber() {
        return bedNumber;
    }
    public void setSeverity(String severity) {
        this.severity = severity;
    }
    public String getSeverity() {
        return severity;
    }
    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }
    public int getDoctorId() {
        return doctorId;
    }
    public int getPatientId() {
        return patientId;
    }
    public String getPatientName() {
        return patientName;
    }
    public int getPatientAge() {
        return patientAge;
    }
    public void setDisease(String disease) {
        this.disease = disease;
    }
    public String getDisease() {
        return disease;
    }

    public void getter(){
        System.out.println("Patient ID: "+patientId);
        System.out.println("Name: "+patientName);
        System.out.println("Age: "+patientAge);
        System.out.println("Disease: "+disease);
        System.out.println("Doctor treating (ID): "+doctorId);
        System.out.println("Severity: "+severity);
        System.out.println("Nurse overlooking (ID): "+nurseId);
        System.out.println("Bed Number: "+bedNumber);

    }
}
