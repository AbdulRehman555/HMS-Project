import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class MyFrame extends JFrame implements ActionListener {

    JMenuBar menuBar;
    JMenu fileMenu;
    JMenu editMenu;
    JMenu viewMenu;

    JMenuItem newItem;
    JMenuItem saveItem;
    JMenuItem exitItem;
    JMenuItem patientItem;
    JMenuItem doctorItem;
    JMenuItem nurseItem;
    JMenuItem receptionistItem;
    JMenuItem viewEmployee;
    JMenuItem viewPatient;

    JPanel topPanel;
    JPanel middlePanel;
    JPanel lowerPanel;
    JPanel subPanel1;
    JPanel subPanel2;
    JPanel subPanel3;

    JLabel logo;
    JLabel logoDesciption;
    JLabel offeringLabel;
    JLabel offeringLabel2;
    JLabel doctor1;
    JLabel doctor2;
    JLabel doctor3;
    JLabel department1;
    JLabel department2;
    JLabel department3;

    JButton emergencyButton;



    MyFrame(){
        this.setTitle("HMS");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(550,600);
        this.setResizable(false);
        this.setLayout(new BorderLayout());

        menuBar = new JMenuBar();
        menuBar.setBackground(new Color(46,61,73));
        fileMenu = new JMenu("File");
        fileMenu.setForeground(Color.white);
        editMenu = new JMenu("Edit");
        editMenu.setForeground(Color.white);
        viewMenu = new JMenu("View");
        viewMenu.setForeground(Color.white);


        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(viewMenu);

        newItem = new JMenuItem("New");
        saveItem = new JMenuItem("Save");
        exitItem = new JMenuItem("Exit");

        newItem.setMnemonic(KeyEvent.VK_N);
        saveItem.setMnemonic(KeyEvent.VK_S);
        exitItem.setMnemonic(KeyEvent.VK_E);


        newItem.addActionListener(this);
        saveItem.addActionListener(this);
        exitItem.addActionListener(this);


        fileMenu.add(newItem);
        fileMenu.add(saveItem);
        fileMenu.add(exitItem);

        patientItem = new JMenuItem("Patient");
        doctorItem = new JMenuItem("Doctor");
        nurseItem = new JMenuItem("Nurse");
        receptionistItem = new JMenuItem("Receptionist");

        patientItem.addActionListener(this);
        doctorItem.addActionListener(this);
        nurseItem.addActionListener(this);
        receptionistItem.addActionListener(this);

        editMenu.add(patientItem);
        editMenu.add(doctorItem);
        editMenu.add(nurseItem);
        editMenu.add(receptionistItem);

        viewEmployee = new JMenuItem("Employee Salaries");
        viewPatient = new JMenuItem("Patient Record");

        viewEmployee.addActionListener(this);
        viewPatient.addActionListener(this);

        viewMenu.add(viewEmployee);
        viewMenu.add(viewPatient);

        emergencyButton = new JButton("Emergency");
        emergencyButton.setBounds(390,27,100,25);
        emergencyButton.setBackground(new Color(35,82,124));
        emergencyButton.setForeground(Color.white);
        emergencyButton.setFocusable(false);
        emergencyButton.addActionListener(this);

        topPanel = new JPanel();
        topPanel.setLayout(null);
        middlePanel = new JPanel();
        middlePanel.setLayout(null);
        lowerPanel = new JPanel();
        lowerPanel.setLayout(null);

        subPanel1= new JPanel();
        //subPanel1.setLayout(null);
        subPanel2= new JPanel();
        //subPanel2.setLayout(null);
        subPanel3= new JPanel();
        //subPanel3.setLayout(null);

        topPanel.setBackground(Color.white);
        topPanel.setPreferredSize(new Dimension(90,90));
        middlePanel.setBackground(new Color(51,122,183));
        middlePanel.setPreferredSize(new Dimension(400,400));
        lowerPanel.setBackground(Color.white);
        lowerPanel.setPreferredSize(new Dimension(90,90));

        department1 = new JLabel();
        department1.setText("Department of");
        department1.setForeground(new Color(2,179,228));

        department2 = new JLabel();
        department2.setText("Department of");
        department2.setForeground(new Color(2,179,228));

        department3 = new JLabel();
        department3.setText("Department of");
        department3.setForeground(new Color(2,179,228));

        subPanel1.setBackground(Color.white);
        subPanel1.setPreferredSize(new Dimension(120,120));
        subPanel1.setBounds(70,190,120,120);
        doctor1 = new JLabel("  Surgeons");
        doctor1.setFont(new Font(null,Font.PLAIN,15));
        doctor1.setForeground(new Color(79,79,79));

        subPanel1.add(department1);
        subPanel1.add(doctor1);

        subPanel2.setBackground(Color.white);
        subPanel2.setPreferredSize(new Dimension(120,120));
        subPanel2.setBounds(205,190,120,120);
        doctor2 = new JLabel("Fever Specialists");
        doctor2.setFont(new Font(null,Font.PLAIN,15));
        doctor2.setForeground(new Color(79,79,79));
        subPanel2.add(department2);
        subPanel2.add(doctor2);

        subPanel3.setBackground(Color.white);
        subPanel3.setPreferredSize(new Dimension(120,120));
        subPanel3.setBounds(340,190,120,120);
        doctor3 = new JLabel("Dentists");
        doctor3.setFont(new Font(null,Font.PLAIN,15));
        doctor3.setForeground(new Color(79,79,79));
        subPanel3.add(department3);
        subPanel3.add(doctor3);

        offeringLabel = new JLabel();
        offeringLabel.setLayout(new FlowLayout());
        offeringLabel.setForeground(Color.white);
        offeringLabel.setText("Departments in our Hospital");
        offeringLabel.setFont(new Font(null,Font.PLAIN,20));
        offeringLabel.setBounds(70,60,500,50);

        offeringLabel2 = new JLabel();
        offeringLabel2.setLayout(new FlowLayout());
        offeringLabel2.setForeground(Color.white);
        offeringLabel2.setText("Only cases related to these specialized doctors are treated");
        offeringLabel2.setFont(new Font("Arial",Font.ITALIC,15));
        offeringLabel2.setBounds(70,120,500,30);

        middlePanel.add(offeringLabel);
        middlePanel.add(offeringLabel2);
        middlePanel.add(subPanel1);
        middlePanel.add(subPanel2);
        middlePanel.add(subPanel3);

        logo = new JLabel();
        logoDesciption = new JLabel();

        logo.setText("HMS");
        logo.setForeground(new Color(2,179,228));
        logo.setFont(new Font("MV Boli",Font.PLAIN,25));
        logo.setBounds(20,15,70,50);

        logoDesciption.setText("Hospital Management System");
        logoDesciption.setForeground(new Color(79,79,79));
        logoDesciption.setFont(new Font("Calbiri",Font.PLAIN,18));
        logoDesciption.setBounds(85,15,250,50);

        topPanel.add(logoDesciption);
        topPanel.add(logo);
        topPanel.add(emergencyButton);

        this.add(topPanel, BorderLayout.NORTH);
        this.add(middlePanel, BorderLayout.CENTER);
        this.add(lowerPanel, BorderLayout.SOUTH);

        this.setJMenuBar(menuBar);
        this.setVisible(true);


    }


    @Override
    public void actionPerformed(ActionEvent e) {
        //File Menu
        if(e.getSource()==newItem){
            this.dispose();
            NewWindow newWindow = new NewWindow();
            newWindow.newFileMenu();
        }
        if(e.getSource()==saveItem){
            HMS.saveToFiles();
            JOptionPane.showMessageDialog(null,"Data is saved to the Files Successfully!","Saving Data",JOptionPane.INFORMATION_MESSAGE);
        }
        if(e.getSource()==exitItem){
            System.exit(0);
        }

        //Edit Menu
        if(e.getSource()==patientItem){
            this.dispose();
            AddData patient = new AddData();
            patient.addPatient();
        }
        if(e.getSource()==doctorItem){
            this.dispose();
            AddData doctor = new AddData();
            doctor.addDoctor();
        }
        if(e.getSource()==nurseItem){
            this.dispose();
            AddData nurse = new AddData();
            nurse.addNurse();
        }
        if(e.getSource()==receptionistItem){
            this.dispose();
            AddData rcp = new AddData();
            rcp.addReceptionist();
        }

        //View Menu
        if(e.getSource()==viewEmployee){
            this.dispose();
            NewWindow viewEmp = new NewWindow();
            viewEmp.viewEmployees();
        }
        if(e.getSource()==viewPatient){
            this.dispose();
            NewWindow viewPatient = new NewWindow();
            viewPatient.viewPatient();
        }

        //Emergency Button
        if(e.getSource()==emergencyButton){
            this.dispose();
            AddData Patient = new AddData();
            Patient.addPatient();
        }
    }
}
