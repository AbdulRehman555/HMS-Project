/*
============================================================
    Program: Hospital Management System
    Coded By: Abdul Rehman 4040-FBAS/BSCS/F18(A)
              M Talha Khalid 4013-FBAS/BSCS/F18(A)
              Ahmad Anis 4044-FBAS/BSCS/F18(A)

============================================================
*/
import java.io.*;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Scanner;


public class HMS {
    //Global variables/objects
    private static Scanner scanner = new Scanner(System.in);
    public static SecureRandom random = new SecureRandom();

    //ArrayLists
    public static ArrayList<Patient> patients = new ArrayList<Patient>();
    public static ArrayList<Doctor> doctors = new ArrayList<Doctor>();
    public static ArrayList<Nurse> nurses = new ArrayList<Nurse>();
    public static ArrayList<Receptionist> receptionists = new ArrayList<Receptionist>();


    public static void main(String args[]){
        readFiles();
        MyFrame myFrame = new MyFrame();
    }

    public static void readFiles(){
        //Reading Doctors Data
        try{
            FileInputStream fis = new FileInputStream(new File("doctorsFile.txt"));
            ObjectInputStream ois = new ObjectInputStream(fis);
            while(true){
                doctors.add((Doctor) ois.readObject());
                if(ois.readObject()==null){
                    break;
                }
            }

            ois.close();
            fis.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        //Reading Nurses Data
        try{
            FileInputStream fis = new FileInputStream(new File("nursesFile.txt"));
            ObjectInputStream ois = new ObjectInputStream(fis);
            while(true){
                nurses.add((Nurse) ois.readObject());
                if(ois.readObject()==null){
                    break;
                }
            }

            ois.close();
            fis.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        //Reading Patients Data
        try{
            FileInputStream fis = new FileInputStream(new File("patientsFile.txt"));
            ObjectInputStream ois = new ObjectInputStream(fis);
            while(true){
                patients.add((Patient) ois.readObject());
                if(ois.readObject()==null){
                    break;
                }
            }

            ois.close();
            fis.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }//Reading Receptionist Data
        try{
            FileInputStream fis = new FileInputStream(new File("receptionistsFile.txt"));
            ObjectInputStream ois = new ObjectInputStream(fis);
            while(true){
                receptionists.add((Receptionist) ois.readObject());
                if(ois.readObject()==null){
                    break;
                }
            }

            ois.close();
            fis.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static void saveToFiles(){
        //Saving Doctors data
        try{
            FileOutputStream fos = new FileOutputStream(new File("doctorsFile.txt"));
            ObjectOutputStream ous = new ObjectOutputStream(fos);
            for(int i = 0 ;i< doctors.size();i++){
                ous.writeObject(doctors.get(i));
            }
            ous.writeObject(null);
            ous.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Saving Patients data
        try{
            FileOutputStream fos = new FileOutputStream(new File("patientsFile.txt"));
            ObjectOutputStream ous = new ObjectOutputStream(fos);
            for(int i = 0 ;i< patients.size();i++){
                ous.writeObject(patients.get(i));
            }
            ous.writeObject(null);

            ous.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Saving Nurses data
        try{
            FileOutputStream fos = new FileOutputStream(new File("nursesFile.txt"));
            ObjectOutputStream ous = new ObjectOutputStream(fos);
            for(int i = 0 ;i< nurses.size();i++){
                ous.writeObject(nurses.get(i));
            }
            ous.writeObject(null);

            ous.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Saving Receptionist data
        try{
            FileOutputStream fos = new FileOutputStream(new File("receptionistsFile.txt"));
            ObjectOutputStream ous = new ObjectOutputStream(fos);
            for(int i = 0 ;i< receptionists.size();i++){
                ous.writeObject(receptionists.get(i));
            }
            ous.writeObject(null);

            ous.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void newDoctor(){
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("  -:Enter Doctor's data:-  ");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~");
        do{
            Doctor doctor = new Doctor();
            System.out.print("Enter Doctor's ID: ");
            doctor.setEmployeeId(scanner.nextInt());
            scanner.nextLine();
            System.out.print("Name: ");
            doctor.setEmployeeName(scanner.nextLine());
            System.out.print("Basic Pay: ");
            doctor.setBasicPay(scanner.nextDouble());
            scanner.nextLine();
            System.out.print("Specialization: ");
            doctor.setSpecialization(scanner.nextLine());
            System.out.print("Experience: ");
            doctor.setExperience(scanner.nextInt());

            doctors.add(doctor);

            System.out.print("Is Any Other Doctor? (y/n)");
            if(scanner.next().equals("n"))
                break;
        }while(true);
    }
    public static void newNurse(){
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("  -:Enter Nurses's data:-  ");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~");
        do{
            Nurse nurse = new Nurse();
            System.out.print("Enter Nurse ID: ");
            nurse.setEmployeeId(scanner.nextInt());
            scanner.nextLine();
            System.out.print("Name: ");
            nurse.setEmployeeName(scanner.nextLine());
            System.out.print("Basic Pay: ");
            nurse.setBasicPay(scanner.nextDouble());
            scanner.nextLine();
            System.out.print("Position: ");
            nurse.setPosition(scanner.nextLine());
            System.out.print("Hours Worked: ");
            nurse.setHoursWorked(scanner.nextInt());

            nurses.add(nurse);

            System.out.print("Is Any Other Nurse? (y/n)");
            if(scanner.next().equals("n"))
                break;
        }while(true);

    }
    public static void newPatient(){
        Ward ward = new Ward();
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("  -:Enter Patients data:-  ");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~");

        do {
            Patient patient = new Patient();
            System.out.print("Enter patient Id: ");
            patient.setPatientId(scanner.nextInt());
            scanner.nextLine();
            System.out.print("Enter patient name: ");
            patient.setPatientName(scanner.nextLine());
            System.out.print("Enter patient age: ");
            patient.setPatientAge(scanner.nextInt());
            scanner.nextLine();
            System.out.print("Enter patient disease: ");
            String disease = scanner.nextLine();
            patient.setDisease(disease);
            System.out.print("Severity (normal/dangerous): ");
            patient.setSeverity(scanner.nextLine());

            //Referring to Specified doctor
            Doctor dct = new Doctor();
            switch(disease){
                case "Fever":
                    dct = getSpecifiedDoctor(doctors,"Fever");
                    patient.setDoctorId(dct.getEmployeeId());
                    //Solution to Problem 2
                    //REGEX (fetching severity level dang from dangerous )
                    //Only Dangerous condition patients can be admitted
                    if(patient.getSeverity().equals(".*dang$")){
                        int randomNurse = random.nextInt(nurses.size());
                        patient.setNurseId(nurses.get(randomNurse).getEmployeeId());
                        int bedNumber = ward.setBed(patient.getPatientId());
                        if(bedNumber!=-1){
                            patient.setBedNumber(bedNumber);
                        }
                        else{
                            System.out.println("No Vacancy! Ward is Full.");
                        }
                    }
                    break;
                case "Bone Breakage":
                    dct = getSpecifiedDoctor(doctors,"Sergen");
                    patient.setDoctorId(dct.getEmployeeId());
                    if(patient.getSeverity().equals("dangerous")){
                        int randomNurse = random.nextInt(nurses.size());
                        patient.setNurseId(nurses.get(randomNurse).getEmployeeId());
                        int bedNumber = ward.setBed(patient.getPatientId());
                        if(bedNumber!=-1){
                            patient.setBedNumber(bedNumber);
                        }
                        else{
                            System.out.println("No Vacancy! Ward is Full.");
                        }
                    }
                    break;
                case "Teeth Problem":
                    dct = getSpecifiedDoctor(doctors,"Dentist");
                    patient.setDoctorId(dct.getEmployeeId());
                    if(patient.getSeverity().equals("dangerous")){
                        int randomNurse = random.nextInt(nurses.size());
                        patient.setNurseId(nurses.get(randomNurse).getEmployeeId());
                        int bedNumber = ward.setBed(patient.getPatientId());
                        if(bedNumber!=-1){
                            patient.setBedNumber(bedNumber);
                        }
                        else{
                            System.out.println("No Vacancy! Ward is Full.");
                        }
                    }
                    break;
                default:
                    System.out.println("Specified Doctor not Found!");

            }

            patients.add(patient);

            System.out.print("Is Any Other Patient? (y/n)");
            if(scanner.next().equals("n"))
                break;
        }while(true);
    }
    public static void getPatientRecord(){
        System.out.print("Enter Patient ID whose info is required: ");
        int requiredPatient = scanner.nextInt();
        patientRecord(patients,requiredPatient);
    }
    public static void salaryCheck(){
        //Solution to Problem 1
        //POLYMORPHISM
        Receptionist receptionist = new Receptionist(1,"M Talha",20_000,3);
        Doctor doctor = new Doctor(2,"Ahmad Anis",50_000,3);
        Nurse nurse = new Nurse(3,"Sara",20_000,12);

        Employee[] employees = new Employee[3];
        employees[0] = receptionist;
        employees[1] = doctor;
        employees[2] = nurse;

        for(Employee currentEmployee : employees){
            System.out.println(currentEmployee.getClass().getName());
            System.out.println(currentEmployee.getEmployeeName() + " earned Rs." +currentEmployee.salary());
        }
    }
    public static void displayInfo(){
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("\t\t\tWelcome to Hospital Management System");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Problems treated in our Hospital are following:");
        System.out.println("1. Fever\n2. Bone Breakage\n3. Teeth Problems");
        System.out.println("Only severe condition patients are admitted to wards.");
        System.out.println("Bed is alloted to addmitted patients.");
        System.out.println("Nurse is also overlooking a severe condition(addmitted) patients.");
        System.out.println("Ward consists of 10 beds, each bed will be freed when patient residing on bed will be discharged by the doctor.");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

    }
    public static void patientRecord(ArrayList<Patient> patients , int id){
        boolean isFound = false;
        for(int i = 0 ; i < patients.size();i++){
            Patient p = patients.get(i);
            if(p.getPatientId() == id){
                isFound = true;
                p.getter();
            }
        }
        if(!isFound)
            System.out.println("= Patient does not exists =");

    }
    public static Doctor getSpecifiedDoctor(ArrayList<Doctor> doctors, String specialization){
        boolean isFound = false;
        for(int i = 0 ;i < doctors.size(); i++){
            if(doctors.get(i).getSpecialization().equals(specialization)){
                isFound = true;
                return doctors.get(i);
            }
        }
        return null;
    }
}
