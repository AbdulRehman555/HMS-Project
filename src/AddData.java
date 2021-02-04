

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddData extends JFrame implements ActionListener {
    JPanel upperPanel;
    JPanel lowerPanel;
    JPanel logoPanel;
    JLabel logoLabel;

    JTextField pIdText;
    JTextField pNameText;
    JTextField pAgeText;
    JTextField pDiseaseText;
    JTextField pSeverityText;

    JTextField dIdText;
    JTextField dNameText;
    JTextField dPayText;
    JTextField dSpecailizationText;
    JTextField dExperienceText;

    JTextField nIdText;
    JTextField nNameText;
    JTextField nPayText;
    JTextField nPositionText;
    JTextField nHrsWorkedText;

    JTextField rIdText;
    JTextField rNameText;
    JTextField rPayText;
    JTextField rOvertimeText;

    JButton addNewPatient;
    JButton addNewDoctor;
    JButton addNewNurse;
    JButton addNewReceptionist;

    JButton backButton;
    AddData(){
        this.setTitle("HMS");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(550,600);
        this.setResizable(false);
        this.setLayout(null);

        upperPanel = new JPanel();
        upperPanel.setLayout(null);
        lowerPanel = new JPanel();
        logoPanel = new JPanel();
        upperPanel.setBounds(110,0,550,100);
        upperPanel.setBackground(new Color(79,79,79));
        lowerPanel.setBounds(0,420,550,200);
        lowerPanel.setBackground(new Color(79,79,79));

        logoPanel.setBounds(0,0,110,100);
        logoPanel.setLayout(null);
        logoPanel.setBackground(new Color(46,61,73));

        logoLabel = new JLabel("HMS");
        logoLabel.setFont(new Font("MV Boli",Font.PLAIN,30));
        logoLabel.setForeground(new Color(2,179,228));
        logoLabel.setBounds(20,25,100,50);

        backButton = new JButton("<");
        backButton.setFont(new Font(null,Font.BOLD,20));
        backButton.setBackground(Color.white);
        backButton.setForeground(new Color(35,82,124));
        backButton.setFocusable(false);
        backButton.setBounds(0,100,50,30);
        backButton.setBorderPainted(false);
        backButton.addActionListener(this);

        this.add(backButton);
        this.add(logoLabel);
        this.add(logoPanel);
        this.add(upperPanel);
        this.add(lowerPanel);
        this.setVisible(true);
    }

    public void addPatient(){
        JLabel patientLabel = new JLabel("PATIENT");
        patientLabel.setFont(new Font(null,Font.PLAIN,20));
        patientLabel.setForeground(Color.white);
        patientLabel.setBounds(120,35,100,30);

        JLabel idLabel = new JLabel("ID");
        idLabel.setFont(new Font(null,Font.PLAIN,15));
        idLabel.setForeground(new Color(51,122,183));
        idLabel.setBounds(150,150,100,30);
        pIdText = new JTextField();
        pIdText.setBounds(230,150,150,25);
        pIdText.setText("1");
        pIdText.setForeground(Color.GRAY);

        JLabel nameLabel = new JLabel("Name");
        nameLabel.setFont(new Font(null,Font.PLAIN,15));
        nameLabel.setForeground(new Color(51,122,183));
        nameLabel.setBounds(150,180,100,30);
        pNameText = new JTextField();
        pNameText.setBounds(230,180,150,25);
        pNameText.setText("Abdul Rehman");
        pNameText.setForeground(Color.GRAY);

        JLabel ageLabel = new JLabel("Age");
        ageLabel.setFont(new Font(null,Font.PLAIN,15));
        ageLabel.setForeground(new Color(51,122,183));
        ageLabel.setBounds(150,210,100,30);
        pAgeText = new JTextField();
        pAgeText.setBounds(230,210,150,25);
        pAgeText.setText("22");
        pAgeText.setForeground(Color.GRAY);

        JLabel diseaseLabel = new JLabel("Disease");
        diseaseLabel.setFont(new Font(null,Font.PLAIN,15));
        diseaseLabel.setForeground(new Color(51,122,183));
        diseaseLabel.setBounds(150,240,100,30);
        pDiseaseText = new JTextField();
        pDiseaseText.setBounds(230,240,150,25);
        pDiseaseText.setText("Fever");
        pDiseaseText.setForeground(Color.GRAY);

        JLabel severityLabel = new JLabel("Severity");
        severityLabel.setFont(new Font(null,Font.PLAIN,15));
        severityLabel.setForeground(new Color(51,122,183));
        severityLabel.setBounds(150,270,100,30);
        pSeverityText = new JTextField();
        pSeverityText.setBounds(230,270,150,25);
        pSeverityText.setText("normal");
        pSeverityText.setForeground(Color.GRAY);

        addNewPatient = new JButton("Add New");
        addNewPatient.setForeground(Color.white);
        addNewPatient.setBackground(new Color(35,82,124));
        addNewPatient.setBounds(270,330,110,30);
        addNewPatient.setBorderPainted(false);
        addNewPatient.addActionListener(this);
        addNewPatient.setFocusable(false);

        this.add(addNewPatient);
        upperPanel.add(patientLabel);
        this.add(idLabel);
        this.add(nameLabel);
        this.add(ageLabel);
        this.add(diseaseLabel);
        this.add(severityLabel);
        this.add(pIdText);
        this.add(pNameText);
        this.add(pAgeText);
        this.add(pDiseaseText);
        this.add(pSeverityText);

    }

    public void dealPatient(){
        Ward ward = new Ward();
        Patient patient = new Patient();
        patient.setPatientId(Integer.parseInt(pIdText.getText()));
        patient.setPatientName(pNameText.getText());
        patient.setPatientAge(Integer.parseInt(pAgeText.getText()));
        patient.setDisease(pDiseaseText.getText());
        patient.setSeverity(pSeverityText.getText());

        //Referring to Specified doctor
        Doctor dct = new Doctor();
        switch(pDiseaseText.getText()){
            case "Fever":
                for(int i = 0; i<HMS.doctors.size();i++){
                    if(HMS.doctors.get(i).getSpecialization().equals("Fever")){
                        patient.setDoctorId(HMS.doctors.get(i).getEmployeeId());
                    }
                }
                //Solution to Problem 2
                //REGEX (fetching severity level dang from dangerous )
                //Only Dangerous condition patients can be admitted
                if(patient.getSeverity().equals("dangerous")){
                    String[] responses = {"Allow" , "Not Allow","Cancel"};
                    int option = JOptionPane.showOptionDialog(null,
                            "Patient Condition is serious\n" +
                                    "Allow us to Admit him.",
                            "Permission",
                            JOptionPane.YES_NO_CANCEL_OPTION,
                            JOptionPane.INFORMATION_MESSAGE,
                            null,
                            responses,
                            0);
                    if(option==0){
                        int randomNurse = HMS.random.nextInt(HMS.nurses.size());
                        patient.setNurseId(HMS.nurses.get(randomNurse).getEmployeeId());
                        int bedNumber = ward.setBed(patient.getPatientId());
                        if(bedNumber!=-1){
                            patient.setBedNumber(bedNumber);

                        }
                        else{
                            System.out.println("No Vacancy! Ward is Full.");
                        }
                    }

                }
                break;
            case "Bone Breakage":
                for(int i = 0; i<HMS.doctors.size();i++){
                    if(HMS.doctors.get(i).getSpecialization().equals("Bone Breakage")){
                        patient.setDoctorId(HMS.doctors.get(i).getEmployeeId());
                    }
                }
                if(patient.getSeverity().equals("dangerous")){
                    String[] responses = {"Allow" , "Not Allow","Cancel"};
                    int option = JOptionPane.showOptionDialog(null,
                            "Patient Condition is serious\n" +
                                    "Allow us to Admit him.",
                            "Permission",
                            JOptionPane.YES_NO_CANCEL_OPTION,
                            JOptionPane.INFORMATION_MESSAGE,
                            null,
                            responses,
                            0);
                    if(option==0){
                        int randomNurse = HMS.random.nextInt(HMS.nurses.size());
                        patient.setNurseId(HMS.nurses.get(randomNurse).getEmployeeId());
                        int bedNumber = ward.setBed(patient.getPatientId());
                        if(bedNumber!=-1){
                            patient.setBedNumber(bedNumber);

                        }
                        else{
                            System.out.println("No Vacancy! Ward is Full.");
                        }
                    }

                }
                break;
            case "Teeth Problem":
                for(int i = 0; i<HMS.doctors.size();i++){
                    if(HMS.doctors.get(i).getSpecialization().equals("Teeth Problem")){
                        patient.setDoctorId(HMS.doctors.get(i).getEmployeeId());
                    }
                }
                if(patient.getSeverity().equals("dangerous")){
                    String[] responses = {"Allow" , "Not Allow","Cancel"};
                    int option = JOptionPane.showOptionDialog(null,
                            "Patient Condition is serious\n" +
                                    "Allow us to Admit him.",
                            "Permission",
                            JOptionPane.YES_NO_CANCEL_OPTION,
                            JOptionPane.INFORMATION_MESSAGE,
                            null,
                            responses,
                            0);
                    if(option==0){
                        int randomNurse = HMS.random.nextInt(HMS.nurses.size());
                        patient.setNurseId(HMS.nurses.get(randomNurse).getEmployeeId());
                        int bedNumber = ward.setBed(patient.getPatientId());
                        if(bedNumber!=-1){
                            patient.setBedNumber(bedNumber);

                        }
                        else{
                            System.out.println("No Vacancy! Ward is Full.");
                        }
                    }

                }
                break;
            default:
                System.out.println("Specified Doctor not Found!");

        }

        HMS.patients.add(patient);
    }

    public void addDoctor(){
        JLabel doctorLabel = new JLabel("DOCTOR");
        doctorLabel.setFont(new Font(null,Font.PLAIN,20));
        doctorLabel.setForeground(Color.white);
        doctorLabel.setBounds(120,35,100,30);

        JLabel idLabel = new JLabel("ID");
        idLabel.setFont(new Font(null,Font.PLAIN,15));
        idLabel.setForeground(new Color(51,122,183));
        idLabel.setBounds(140,150,100,30);
        dIdText = new JTextField();
        dIdText.setBounds(240,150,150,25);
        dIdText.setText("1");
        dIdText.setForeground(Color.GRAY);

        JLabel nameLabel = new JLabel("Name");
        nameLabel.setFont(new Font(null,Font.PLAIN,15));
        nameLabel.setForeground(new Color(51,122,183));
        nameLabel.setBounds(140,180,100,30);
        dNameText = new JTextField();
        dNameText.setBounds(240,180,150,25);
        dNameText.setText("Abdul Rehman");
        dNameText.setForeground(Color.GRAY);

        JLabel payLabel = new JLabel("Basic Pay");
        payLabel.setFont(new Font(null,Font.PLAIN,15));
        payLabel.setForeground(new Color(51,122,183));
        payLabel.setBounds(140,210,100,30);
        dPayText = new JTextField();
        dPayText.setBounds(240,210,150,25);
        dPayText.setText("45000");
        dPayText.setForeground(Color.GRAY);

        JLabel specializationLabel = new JLabel("Specialization");
        specializationLabel.setFont(new Font(null,Font.PLAIN,15));
        specializationLabel.setForeground(new Color(51,122,183));
        specializationLabel.setBounds(140,240,100,30);
        dSpecailizationText = new JTextField();
        dSpecailizationText.setBounds(240,240,150,25);
        dSpecailizationText.setText("Fever");
        dSpecailizationText.setForeground(Color.GRAY);

        JLabel experienceLabel = new JLabel("Experience");
        experienceLabel.setFont(new Font(null,Font.PLAIN,15));
        experienceLabel.setForeground(new Color(51,122,183));
        experienceLabel.setBounds(140,270,100,30);
        dExperienceText = new JTextField();
        dExperienceText.setBounds(240,270,150,25);
        dExperienceText.setText("3 yrs");
        dExperienceText.setForeground(Color.GRAY);

        addNewDoctor = new JButton("Add New");
        addNewDoctor.setForeground(Color.white);
        addNewDoctor.setBackground(new Color(35,82,124));
        addNewDoctor.setBounds(280,330,110,30);
        addNewDoctor.setBorderPainted(false);
        addNewDoctor.addActionListener(this);
        addNewDoctor.setFocusable(false);

        this.add(addNewDoctor);
        upperPanel.add(doctorLabel);
        this.add(idLabel);
        this.add(nameLabel);
        this.add(payLabel);
        this.add(specializationLabel);
        this.add(experienceLabel);
        this.add(dIdText);
        this.add(dNameText);
        this.add(dPayText);
        this.add(dSpecailizationText);
        this.add(dExperienceText);
    }

    public void addNurse(){
        JLabel nurseLabel = new JLabel("NURSE");
        nurseLabel.setFont(new Font(null,Font.PLAIN,20));
        nurseLabel.setForeground(Color.white);
        nurseLabel.setBounds(120,35,100,30);

        JLabel nurseIdLabel = new JLabel("ID");
        nurseIdLabel.setFont(new Font(null,Font.PLAIN,15));
        nurseIdLabel.setForeground(new Color(51,122,183));
        nurseIdLabel.setBounds(140,150,100,30);
        nIdText = new JTextField();
        nIdText.setBounds(240,150,150,25);
        nIdText.setText("1");
        nIdText.setForeground(Color.GRAY);

        JLabel nNameLabel = new JLabel("Name");
        nNameLabel.setFont(new Font(null,Font.PLAIN,15));
        nNameLabel.setForeground(new Color(51,122,183));
        nNameLabel.setBounds(140,180,100,30);
        nNameText = new JTextField();
        nNameText.setBounds(240,180,150,25);
        nNameText.setText("Sara");
        nNameText.setForeground(Color.GRAY);

        JLabel nPayLabel = new JLabel("Basic Pay");
        nPayLabel.setFont(new Font(null,Font.PLAIN,15));
        nPayLabel.setForeground(new Color(51,122,183));
        nPayLabel.setBounds(140,210,100,30);
        nPayText = new JTextField();
        nPayText.setBounds(240,210,150,25);
        nPayText.setText("2000");
        nPayText.setForeground(Color.GRAY);

        JLabel nPositionLabel = new JLabel("Position");
        nPositionLabel.setFont(new Font(null,Font.PLAIN,15));
        nPositionLabel.setForeground(new Color(51,122,183));
        nPositionLabel.setBounds(140,240,100,30);
        nPositionText = new JTextField();
        nPositionText.setBounds(240,240,150,25);
        nPositionText.setText("Senior");
        nPositionText.setForeground(Color.GRAY);

        JLabel nHrsWorkedLabel = new JLabel("Hrs Worked");
        nHrsWorkedLabel.setFont(new Font(null,Font.PLAIN,15));
        nHrsWorkedLabel.setForeground(new Color(51,122,183));
        nHrsWorkedLabel.setBounds(140,270,100,30);
        nHrsWorkedText = new JTextField();
        nHrsWorkedText.setBounds(240,270,150,25);
        nHrsWorkedText.setText("8");
        nHrsWorkedText.setForeground(Color.GRAY);

        addNewNurse = new JButton("Add New");
        addNewNurse.setForeground(Color.white);
        addNewNurse.setBackground(new Color(35,82,124));
        addNewNurse.setBounds(280,330,110,30);
        addNewNurse.setBorderPainted(false);
        addNewNurse.addActionListener(this);
        addNewNurse.setFocusable(false);

        this.add(addNewNurse);
        upperPanel.add(nurseLabel);
        this.add(nurseIdLabel);
        this.add(nNameLabel);
        this.add(nPayLabel);
        this.add(nPositionLabel);
        this.add(nHrsWorkedLabel);
        this.add(nIdText);
        this.add(nNameText);
        this.add(nPayText);
        this.add(nPositionText);
        this.add(nHrsWorkedText);
    }

    public void addReceptionist(){
        JLabel receptionistLabel = new JLabel("RECEPTIONIST");
        receptionistLabel.setFont(new Font(null,Font.PLAIN,20));
        receptionistLabel.setForeground(Color.white);
        receptionistLabel.setBounds(120,35,150,30);

        JLabel rIdLabel = new JLabel("ID");
        rIdLabel.setFont(new Font(null,Font.PLAIN,15));
        rIdLabel.setForeground(new Color(51,122,183));
        rIdLabel.setBounds(140,150,100,30);
        rIdText = new JTextField();
        rIdText.setBounds(240,150,150,25);
        rIdText.setText("1");
        rIdText.setForeground(Color.GRAY);

        JLabel rNameLabel = new JLabel("Name");
        rNameLabel.setFont(new Font(null,Font.PLAIN,15));
        rNameLabel.setForeground(new Color(51,122,183));
        rNameLabel.setBounds(140,180,100,30);
        rNameText = new JTextField();
        rNameText.setBounds(240,180,150,25);
        rNameText.setText("M Asad");
        rNameText.setForeground(Color.GRAY);

        JLabel rPayLabel = new JLabel("Basic Pay");
        rPayLabel.setFont(new Font(null,Font.PLAIN,15));
        rPayLabel.setForeground(new Color(51,122,183));
        rPayLabel.setBounds(140,210,100,30);
        rPayText = new JTextField();
        rPayText.setBounds(240,210,150,25);
        rPayText.setText("25000");
        rPayText.setForeground(Color.GRAY);

        JLabel rOvertimeLabel = new JLabel("OverTime");
        rOvertimeLabel.setFont(new Font(null,Font.PLAIN,15));
        rOvertimeLabel.setForeground(new Color(51,122,183));
        rOvertimeLabel.setBounds(140,240,100,30);
        rOvertimeText = new JTextField();
        rOvertimeText.setBounds(240,240,150,25);
        rOvertimeText.setText("3 hrs");
        rOvertimeText.setForeground(Color.GRAY);

        addNewReceptionist = new JButton("Add New");
        addNewReceptionist.setForeground(Color.white);
        addNewReceptionist.setBackground(new Color(35,82,124));
        addNewReceptionist.setBounds(280,330,110,30);
        addNewReceptionist.setBorderPainted(false);
        addNewReceptionist.addActionListener(this);
        addNewReceptionist.setFocusable(false);

        this.add(addNewReceptionist);
        upperPanel.add(receptionistLabel);
        this.add(rIdLabel);
        this.add(rNameLabel);
        this.add(rPayLabel);
        this.add(rOvertimeLabel);
        this.add(rIdText);
        this.add(rNameText);
        this.add(rPayText);
        this.add(rOvertimeText);
    }

    // Function to return the modified string
    public String extractInt(String str)
    {
        // Replacing every non-digit number
        // with a space(" ")
        str = str.replaceAll("[^\\d]", " ");

        // Remove extra spaces from the beginning
        // and the ending of the string
        str = str.trim();

        // Replace all the consecutive white
        // spaces with a single space
        str = str.replaceAll(" +", " ");

        if (str.equals(""))
            return "-1";

        return str;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== addNewPatient){
            dealPatient();
            pIdText.setText("");
            pNameText.setText("");
            pAgeText.setText("");
            pDiseaseText.setText("");
            pSeverityText.setText("");
        }
        if(e.getSource()== addNewDoctor){
            Doctor doctor = new Doctor();
            doctor.setEmployeeId(Integer.parseInt(dIdText.getText()));
            doctor.setEmployeeName(dNameText.getText());
            doctor.setBasicPay(Integer.parseInt(dPayText.getText()));
            doctor.setSpecialization(dSpecailizationText.getText());
            doctor.setExperience(Integer.parseInt(extractInt(dExperienceText.getText())));

            HMS.doctors.add(doctor);

            dIdText.setText("");
            dNameText.setText("");
            dPayText.setText("");
            dSpecailizationText.setText("");
            dExperienceText.setText("");
        }
        if(e.getSource()== addNewNurse){
            Nurse nurse = new Nurse();
            nurse.setEmployeeId(Integer.parseInt(nIdText.getText()));
            nurse.setEmployeeName(nNameText.getText());
            nurse.setBasicPay(Integer.parseInt(nPayText.getText()));
            nurse.setPosition(nPositionText.getText());
            nurse.setHoursWorked(Integer.parseInt(nHrsWorkedText.getText()));

            HMS.nurses.add(nurse);

            nIdText.setText("");
            nNameText.setText("");
            nPayText.setText("");
            nPositionText.setText("");
            nHrsWorkedText.setText("");
        }
        if(e.getSource()== addNewReceptionist){
            Receptionist rcp = new Receptionist();
            rcp.setEmployeeId(Integer.parseInt(rIdText.getText()));
            rcp.setEmployeeName(rNameText.getText());
            rcp.setBasicPay(Integer.parseInt(rPayText.getText()));
            rcp.setOvertime(Integer.parseInt(extractInt(rOvertimeText.getText())));

            HMS.receptionists.add(rcp);

            rIdText.setText("");
            rNameText.setText("");
            rPayText.setText("");
            rOvertimeText.setText("");
        }

        if(e.getSource()==backButton){
            this.dispose();
            NewWindow newWindow = new NewWindow();
            newWindow.newFileMenu();
        }
    }
}
