import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import com.toedter.calendar.JDateChooser;

public class signupOne extends JFrame implements ActionListener {


    JTextField nameTextField,fnameTextField,emailTextField,addressTextField,stateTextField,cityTextField,pinTextField;
   JButton next;
   JRadioButton male,female,other,married,unmarried;
    JDateChooser dateChooser;
    Random ran = new Random();
    long first4 = (ran.nextLong() % 9000L) + 1000l;
    String first = ""+Math.abs(first4);
    signupOne()
    {
        setLayout(null);


        JLabel additionalDetails = new JLabel("APPLICATION FORM . " + first4 );
        additionalDetails.setFont(new Font("Raleway",Font.BOLD,38));
        additionalDetails.setBounds(140,20,600,40);
        add(additionalDetails);

        JLabel personDetails = new JLabel("Page 1 : Personal Details");
        personDetails.setFont(new Font("Raleway",Font.BOLD,22));
        personDetails.setBounds(290,80,400,30);
        add(personDetails);

        JLabel name = new JLabel("Name : ");
        name.setFont(new Font("Raleway",Font.BOLD,20));
        name.setBounds(100,140,100,30);
        add(name);

         nameTextField  = new JTextField();
        nameTextField.setFont(new Font("Raleway",Font.BOLD,14));
        nameTextField.setBounds(300,140,400,30);
        add(nameTextField);

        JLabel fname = new JLabel("Father's Name : ");
        fname.setFont(new Font("Raleway",Font.BOLD,20));
        fname.setBounds(100,190,200,30);
        add(fname);

        fnameTextField  = new JTextField();
        fnameTextField.setFont(new Font("Raleway",Font.BOLD,14));
        fnameTextField.setBounds(300,190,400,30);
        add(fnameTextField);

        JLabel dob = new JLabel("Date of Birth");
        dob.setFont(new Font("Raleway",Font.BOLD,20));
        dob.setBounds(100,240,200,30);
        add(dob);

        dateChooser = new JDateChooser();
        dateChooser.setBounds(300,240,400,30);
       dateChooser.setForeground(new Color(105,105,105));
        add(dateChooser);

        JLabel gender = new JLabel("Gender");
        gender.setFont(new Font("Raleway",Font.BOLD,20));
        gender.setBounds(100,290,200,30);
        add(gender);

         male = new JRadioButton("Male");
        male.setBounds(300,290,60,30);
        male.setBackground(Color.white);
        add(male);

         female = new JRadioButton("Female");
        female.setBounds(400,290,120,30);
        female.setBackground(Color.white);
        add(female);

        ButtonGroup gendergroup = new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);

        JLabel email  = new JLabel("Email Address : ");
        email.setFont(new Font("Raleway",Font.BOLD,20));
        email.setBounds(100,340,200,30);
        add(email);

         emailTextField  = new JTextField();
        emailTextField.setFont(new Font("Raleway",Font.BOLD,14));
        emailTextField.setBounds(300,340,400,30);
        add(emailTextField);

        JLabel martial  = new JLabel("Maritial Status : ");
        martial.setFont(new Font("Raleway",Font.BOLD,20));
        martial.setBounds(100,390,200,30);
        add(martial);

         married = new JRadioButton("Married");
        married.setBounds(300,390,100,30);
        married.setBackground(Color.white);
        add(married);

         unmarried = new JRadioButton("UnMarried");
        unmarried.setBounds(400,390,100,30);
        unmarried.setBackground(Color.white);
        add(unmarried);

         other = new JRadioButton("Other");
        other.setBounds(500,390,100,30);
        other.setBackground(Color.white);
        add(other);
        ButtonGroup maritalgroup = new ButtonGroup();
        maritalgroup.add(married);
        maritalgroup.add(unmarried);
        maritalgroup.add(other);

        JLabel address  = new JLabel("Address : ");
        address.setFont(new Font("Raleway",Font.BOLD,20));
        address.setBounds(100,440,200,30);
        add(address);

         addressTextField  = new JTextField();
        addressTextField.setFont(new Font("Raleway",Font.BOLD,14));
        addressTextField.setBounds(300,440,400,30);
        add(addressTextField);

        JLabel city  = new JLabel("City : ");
        city.setFont(new Font("Raleway",Font.BOLD,20));
        city.setBounds(100,490,200,30);
        add(city);

         cityTextField  = new JTextField();
        cityTextField.setFont(new Font("Raleway",Font.BOLD,14));
        cityTextField.setBounds(300,490,400,30);
        add(cityTextField);

        JLabel state  = new JLabel("State : ");
        state.setFont(new Font("Raleway",Font.BOLD,20));
        state.setBounds(100,540,200,30);
        add(state);

         stateTextField  = new JTextField();
        stateTextField.setFont(new Font("Raleway",Font.BOLD,14));
        stateTextField.setBounds(300,540,400,30);
        add(stateTextField);

        JLabel pincode  = new JLabel("Pincode : ");
        pincode.setFont(new Font("Raleway",Font.BOLD,20));
        pincode.setBounds(100,590,200,30);
        add(pincode);

         pinTextField  = new JTextField();
        pinTextField.setFont(new Font("Raleway",Font.BOLD,14));
        pinTextField.setBounds(300,590,400,30);
        add(pinTextField);

         next =  new JButton("Next");
        next.setBackground(Color.black);
        next.setForeground(Color.white);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBounds(620,640,80,30);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.white);

        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        String formno  = "" + first4;
        String name  = nameTextField.getText();
        String fname = fnameTextField.getText();
        String dob = ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if (male.isSelected())
        {
            gender="male";
        }
        else if (female.isSelected())
        {
            gender="Female";
        }
        String email = emailTextField.getText();
        String marital = null;
        if(married.isSelected())
        {
            marital="Married";
        }
        else if (unmarried.isSelected())
        {
            marital="Unmarried";
        }
        else if (other.isSelected())
        {
            marital="Other";
        }
        String address = addressTextField.getText();
        String city = cityTextField.getText();
        String state=stateTextField.getText();
        String pin = pinTextField.getText();

        try {
            if (name.equals(""))
            {
                JOptionPane.showMessageDialog(null,"Name is required");
            }
            else if (fname.equals("")) {
                JOptionPane.showMessageDialog(null,"Fathername is required");
            } 
            else if (dob.equals("")) {
                JOptionPane.showMessageDialog(null,"Date of Birth is required");
            } else if (gender.equals("")) {
                JOptionPane.showMessageDialog(null,"Gender is required");
            } else if (address.equals("")) {
                JOptionPane.showMessageDialog(null,"Address is required");
            } else if (city.equals("")) {
                JOptionPane.showMessageDialog(null,"City is required");
            } else if (state.equals("")) {
                JOptionPane.showMessageDialog(null,"State is required");    
            } else if (pin.equals("")) {
                JOptionPane.showMessageDialog(null,"Pinnumber is required");
            }
            else if (name.matches("[0-9]*"))
            {
                JOptionPane.showMessageDialog(null,"name should be in alpabets");
            }
            else if (fname.matches("[0-9]*"))
            {
                JOptionPane.showMessageDialog(null,"Fathername should be in alpabets");
            }
            else if (city.matches("[0-9]*"))
            {
                JOptionPane.showMessageDialog(null,"City should be in alpabets");
            }
            else if (state.matches("[0-9]*"))
            {
                JOptionPane.showMessageDialog(null,"State should be in alpabets");
            }
            else if (pin.matches("[A-Za-z]*"))
            {
                JOptionPane.showMessageDialog(null,"Pincode should be in numbers");
            }
            else
            {
                connect1 c1 = new connect1();
                String q1 = "insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+pin+"','"+state+"')";
                c1.s.executeUpdate(q1);
                new signuptwo(first).setVisible(true);
                setVisible(false);
            }
        }
        catch (Exception epppp)
        {
            System.out.println(epppp);
        }
    }
    public static void main(String[] args) {
        new signupOne();
    }
}
