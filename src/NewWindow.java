import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewWindow extends JFrame implements ActionListener {
    JButton patient;
    JButton doctor;
    JButton nurse;
    JButton receptionist;
    JPanel upperPanel;
    JPanel lowerPanel;
    JPanel logoPanel;
    JLabel logoLabel;
    JButton backButton;

    JTextField pIdText;
    JTextField empTypeText;
    JButton searchEmp;
    JButton searchPatient;
    JLabel resultEmp;

    JLabel patientId;
    JLabel patientName;
    JLabel patientAge;
    JLabel patientDisease;
    JLabel patientSeverity;
    JLabel doctorTreating;
    JLabel nurseOverlooking;
    JLabel bedAlloted;

    NewWindow(){
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

    public void newFileMenu(){
        patient = new JButton("Patient");
        patient.setBounds(200,150,120,40);
        patient.setBackground(new Color(35,82,124));
        patient.setForeground(Color.white);
        patient.setFocusable(false);
        patient.addActionListener(this);

        doctor = new JButton("Doctor");
        doctor.setBounds(200,200,120,40);
        doctor.setBackground(new Color(35,82,124));
        doctor.setForeground(Color.white);
        doctor.setFocusable(false);
        doctor.addActionListener(this);

        nurse = new JButton("Nurse");
        nurse.setBounds(200,250,120,40);
        nurse.setBackground(new Color(35,82,124));
        nurse.setForeground(Color.white);
        nurse.setFocusable(false);
        nurse.addActionListener(this);

        receptionist = new JButton("Receptionist");
        receptionist.setBounds(200,300,120,40);
        receptionist.setBackground(new Color(35,82,124));
        receptionist.setForeground(Color.white);
        receptionist.setFocusable(false);
        receptionist.addActionListener(this);

        this.add(patient);
        this.add(doctor);
        this.add(nurse);
        this.add(receptionist);
    }

    public void viewEmployees(){
        JLabel empLabel = new JLabel("EMPLOYEE");
        empLabel.setFont(new Font(null,Font.PLAIN,20));
        empLabel.setForeground(Color.white);
        empLabel.setBounds(120,35,150,30);

        JLabel inputIdLabel = new JLabel("Enter Employee ID");
        inputIdLabel.setFont(new Font(null,Font.PLAIN,15));
        inputIdLabel.setForeground(new Color(51,122,183));
        inputIdLabel.setBounds(120,130,200,30);
        pIdText = new JTextField();
        pIdText.setBounds(270,130,100,25);
        pIdText.setText("1");
        pIdText.setForeground(Color.GRAY);

        JLabel inputEmpTypeLabel = new JLabel("Enter Employee Type");
        inputEmpTypeLabel.setFont(new Font(null,Font.PLAIN,15));
        inputEmpTypeLabel.setForeground(new Color(51,122,183));
        inputEmpTypeLabel.setBounds(120,160,200,30);
        empTypeText = new JTextField();
        empTypeText.setBounds(270,160,100,25);
        empTypeText.setText("Doctor");
        empTypeText.setForeground(Color.GRAY);

        searchEmp = new JButton("Search");
        searchEmp.setBounds(120,200,250,30);
        searchEmp.setForeground(Color.white);
        searchEmp.setBackground(new Color(35,82,124));
        searchEmp.setFocusable(false);
        searchEmp.addActionListener(this);

        resultEmp = new JLabel();
        resultEmp.setFont(new Font(null,Font.BOLD,15));
        resultEmp.setForeground(new Color(46,61,73));
        resultEmp.setBounds(120,250,300,30);


        resultEmp.setVisible(false);

        upperPanel.add(empLabel);
        this.add(inputIdLabel);
        this.add(inputEmpTypeLabel);
        this.add(pIdText);
        this.add(empTypeText);
        this.add(searchEmp);
        this.add(resultEmp);

    }

    public void viewPatient(){
        JLabel patientLabel = new JLabel("PATIENT");
        patientLabel.setFont(new Font(null,Font.PLAIN,20));
        patientLabel.setForeground(Color.white);
        patientLabel.setBounds(120,35,150,30);

        JLabel inputIdLabel = new JLabel("Enter Patient ID");
        inputIdLabel.setFont(new Font(null,Font.PLAIN,15));
        inputIdLabel.setForeground(new Color(51,122,183));
        inputIdLabel.setBounds(120,130,200,30);
        pIdText = new JTextField();
        pIdText.setBounds(270,130,100,25);
        pIdText.setText("1");
        pIdText.setForeground(Color.GRAY);

        searchPatient = new JButton("Search");
        searchPatient.setBounds(120,170,250,30);
        searchPatient.setForeground(Color.white);
        searchPatient.setBackground(new Color(35,82,124));
        searchPatient.setFocusable(false);
        searchPatient.addActionListener(this);

        Patient p = searchPatient(Integer.parseInt(pIdText.getText()));
        String id = Integer.toString(p.getPatientId());
        String name = p.getPatientName();
        String age = Integer.toString(p.getPatientAge());
        String disease = p.getDisease();
        String severity = p.getSeverity();
        String doctorId = Integer.toString(p.getDoctorId());
        String nurseId = Integer.toString(p.getNurseId());
        String bedNum = Integer.toString(p.getBedNumber());

        patientId = new JLabel();
        patientId.setFont(new Font(null,Font.PLAIN,15));
        patientId.setForeground(new Color(46,61,73));
        patientId.setBounds(120,220,250,20);
        patientId.setText("Patient id: "+ id);

        patientName = new JLabel();
        patientName.setFont(new Font(null,Font.PLAIN,15));
        patientName.setForeground(new Color(46,61,73));
        patientName.setBounds(120,240,250,20);
        patientName.setText("Patient Name: "+name);

        patientAge = new JLabel();
        patientAge.setFont(new Font(null,Font.PLAIN,15));
        patientAge.setForeground(new Color(46,61,73));
        patientAge.setBounds(120,260,250,20);
        patientAge.setText("Patient Age: "+age);

        patientDisease = new JLabel();
        patientDisease.setFont(new Font(null,Font.PLAIN,15));
        patientDisease.setForeground(new Color(46,61,73));
        patientDisease.setBounds(120,280,250,20);
        patientDisease.setText("Patient Disease: "+disease);

        patientSeverity = new JLabel();
        patientSeverity.setFont(new Font(null,Font.PLAIN,15));
        patientSeverity.setForeground(new Color(46,61,73));
        patientSeverity.setBounds(120,300,250,20);
        patientSeverity.setText("Patient Severity: "+ severity);

        doctorTreating = new JLabel();
        doctorTreating.setFont(new Font(null,Font.PLAIN,15));
        doctorTreating.setForeground(new Color(46,61,73));
        doctorTreating.setBounds(120,320,250,20);
        doctorTreating.setText("Doctor(ID) Treating: "+doctorId);

        nurseOverlooking = new JLabel();
        nurseOverlooking.setFont(new Font(null,Font.PLAIN,15));
        nurseOverlooking.setForeground(new Color(46,61,73));
        nurseOverlooking.setBounds(120,340,250,20);
        nurseOverlooking.setText("Nurse(ID) Overlooking: "+nurseId);

        bedAlloted = new JLabel();
        bedAlloted.setFont(new Font(null,Font.PLAIN,15));
        bedAlloted.setForeground(new Color(46,61,73));
        bedAlloted.setBounds(120,360,250,20);
        bedAlloted.setText("Bed Alloted: "+ bedNum);

        patientId.setVisible(false);
        patientName.setVisible(false);
        patientAge.setVisible(false);
        patientDisease.setVisible(false);
        patientSeverity.setVisible(false);
        doctorTreating.setVisible(false);
        nurseOverlooking.setVisible(false);
        bedAlloted.setVisible(false);

        upperPanel.add(patientLabel);
        this.add(inputIdLabel);
        this.add(pIdText);
        this.add(searchPatient);
        this.add(patientId);
        this.add(patientName);
        this.add(patientAge);
        this.add(patientDisease);
        this.add(patientSeverity);
        this.add(doctorTreating);
        this.add(nurseOverlooking);
        this.add(bedAlloted);
    }

    public Employee searchEmp(int id,String empType){
        switch (empType){
            case "Doctor":
                for(int i =0 ;i <HMS.doctors.size();i++){
                    if(HMS.doctors.get(i).getEmployeeId() == id){
                        return HMS.doctors.get(i);
                    }
                }
                break;
            case "Nurse":
                for(int i =0 ;i <HMS.nurses.size();i++){
                    if(HMS.nurses.get(i).getEmployeeId() == id){
                        return HMS.nurses.get(i);
                    }
                }
                break;
            case "Receptionist":
                for(int i =0 ;i <HMS.receptionists.size();i++){
                    if(HMS.receptionists.get(i).getEmployeeId() == id){
                        return HMS.receptionists.get(i);
                    }
                }
                break;
        }
        return null;
    }

    public Patient searchPatient(int id){
        for(int i=0;i<HMS.patients.size();i++){
            if(HMS.patients.get(i).getPatientId()==id){
                return HMS.patients.get(i);
            }
        }
        return null;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==patient){
            this.dispose();
            AddData patient = new AddData();
            patient.addPatient();
        }
        if(e.getSource()==doctor){
            this.dispose();
            AddData doctor = new AddData();
            doctor.addDoctor();
        }
        if(e.getSource()==nurse){
            this.dispose();
            AddData nurse = new AddData();
            nurse.addNurse();
        }
        if(e.getSource()==receptionist){
            this.dispose();
            AddData rcp = new AddData();
            rcp.addReceptionist();
        }
        if(e.getSource()== searchEmp){
            if(empTypeText.getText().equals("Doctor")){
                Doctor d = (Doctor) searchEmp(Integer.parseInt(pIdText.getText()) , empTypeText.getText());
                resultEmp.setText(d.getEmployeeName()+" earns Rs."+d.salary());
            }
            if(empTypeText.getText().equals("Nurse")){
                Nurse n = (Nurse) searchEmp(Integer.parseInt(pIdText.getText()) , empTypeText.getText());
                resultEmp.setText(n.getEmployeeName()+" earns Rs."+n.salary());
            }
            if(empTypeText.getText().equals("Receptionist")){
                Receptionist r = (Receptionist) searchEmp(Integer.parseInt(pIdText.getText()) , empTypeText.getText());
                resultEmp.setText(r.getEmployeeName()+" earns Rs."+r.salary());
            }
            resultEmp.setVisible(true);
        }
        if(e.getSource()==searchPatient){
            patientId.setVisible(true);
            patientName.setVisible(true);
            patientAge.setVisible(true);
            patientDisease.setVisible(true);
            patientSeverity.setVisible(true);
            doctorTreating.setVisible(true);
            nurseOverlooking.setVisible(true);
            bedAlloted.setVisible(true);
        }
        if(e.getSource()==backButton){
            this.dispose();
            MyFrame frame = new MyFrame();
        }
    }
}
