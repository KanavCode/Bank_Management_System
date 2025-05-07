import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import com.toedter.calendar.JDateChooser;
import java.sql.*;
public class signuptwo extends JFrame implements ActionListener {

    JTextField pan,aadhar;
    JButton next;
    String formno;
    JRadioButton syes,sno,cno,cyes;
    JComboBox religion,category,occupation,education,income;
    signuptwo(String formno)
    {
        this.formno=formno;
        setLayout(null);
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");

        JLabel additionaldetails = new JLabel("Page 2 : Additional Details");
        additionaldetails.setFont(new Font("Raleway",Font.BOLD,22));
        additionaldetails.setBounds(290,80,400,30);
        add(additionaldetails);

        JLabel name = new JLabel("Religion : ");
        name.setFont(new Font("Raleway",Font.BOLD,20));
        name.setBounds(100,140,100,30);
        add(name);

        String valReligion[]={"Hindu","Muslim","Sikh","Christian","Other"};

         religion = new JComboBox(valReligion);
        religion.setBounds(300,140,400,30);
        religion.setBackground(Color.white);
        add(religion);


        JLabel fname = new JLabel("Category: ");
        fname.setFont(new Font("Raleway",Font.BOLD,20));
        fname.setBounds(100,190,200,30);
        add(fname);

        String valCategory[]={"General","OBC","ST","SC","Others"};
         category = new JComboBox(valCategory);
        category.setBounds(300,190,400,30);
        category.setBackground(Color.white);
        add(category);

        JLabel dob = new JLabel("Income ");
        dob.setFont(new Font("Raleway",Font.BOLD,20));
        dob.setBounds(100,240,200,30);
        add(dob);

        String incomecategory[]={"NULL","< 1,50,000"," < 2,50,000 " ," < 5,00,00 "," Upto 10,00,00 "};
         income = new JComboBox(incomecategory);
        income.setBounds(300,240,400,30);
        income.setBackground(Color.white);
        add(income);

        JLabel gender = new JLabel("Educational : ");
        gender.setFont(new Font("Raleway",Font.BOLD,20));
        gender.setBounds(100,290,200,30);
        add(gender);


        String educationValues[]={"Non-Graduation","Graduate","Post-Graduate" ,"Doctrate","Others"};
         education = new JComboBox(educationValues);
        education.setBounds(300,315,400,30);
        education.setBackground(Color.white);
        add(education);

        JLabel email  = new JLabel("Qualification : ");
        email.setFont(new Font("Raleway",Font.BOLD,20));
        email.setBounds(100,330,200,30);
        add(email);


        JLabel martial  = new JLabel("Occupation : ");
        martial.setFont(new Font("Raleway",Font.BOLD,20));
        martial.setBounds(100,390,200,30);
        add(martial);

        String occupationValues[]={"Salaried","Self-Employed","Bussiness" ,"Student","Retired"};
         occupation = new JComboBox(occupationValues);
        occupation.setBounds(300,390,400,30);
        occupation.setBackground(Color.white);
        add(occupation);


        JLabel address  = new JLabel("PAN Number : ");
        address.setFont(new Font("Raleway",Font.BOLD,20));
        address.setBounds(100,440,200,30);
        add(address);

        pan = new JTextField();
        pan.setFont(new Font("Raleway",Font.BOLD,14));
        pan.setBounds(300,440,400,30);
        add(pan);

        JLabel city  = new JLabel("Aadhar Number : ");
        city.setFont(new Font("Raleway",Font.BOLD,20));
        city.setBounds(100,490,200,30);
        add(city);

        aadhar = new JTextField();
        aadhar.setFont(new Font("Raleway",Font.BOLD,14));
        aadhar.setBounds(300,490,400,30);
        add(aadhar);

        JLabel state  = new JLabel("Senior Citizen: ");
        state.setFont(new Font("Raleway",Font.BOLD,20));
        state.setBounds(100,540,200,30);
        add(state);

        syes = new JRadioButton("Yes");
        syes.setBounds(300,540,100,30);
        syes.setBackground(Color.white);
        add(syes);

        sno = new JRadioButton("No");
        sno.setBounds(400,540,100,30);
        sno.setBackground(Color.white);
        add(sno);

        ButtonGroup maritalgroup = new ButtonGroup();
        maritalgroup.add(syes);
        maritalgroup.add(sno);


        JLabel pincode  = new JLabel("Existing Account: ");
        pincode.setFont(new Font("Raleway",Font.BOLD,20));
        pincode.setBounds(100,590,200,30);
        add(pincode);

        cyes = new JRadioButton("Yes");
        cyes.setBounds(300,590,100,30);
        cyes.setBackground(Color.white);
        add(cyes);

        cno = new JRadioButton("No");
        cno.setBounds(400,590,100,30);
        cno.setBackground(Color.white);
        add(cno);

        ButtonGroup emaritalgroup = new ButtonGroup();
        emaritalgroup.add(cyes);
        emaritalgroup.add(cno);


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
        String sreligion  = (String)religion.getSelectedItem();
        String scategory = (String)category.getSelectedItem();
        String sincome = (String)income.getSelectedItem();
        String seducation = (String)education.getSelectedItem();
        String soccupation =(String)occupation.getSelectedItem();
        String senior = null;
        if (syes.isSelected())
        {
            senior="Yes";
        }
        else if (sno.isSelected())
        {
            senior="No";
        }
        String existingaccount = null;
        if(cyes.isSelected())
        {
            existingaccount="Yes";
        }
        else
        {
            existingaccount="No";
        }

        String span = pan.getText();
        String saadhar = aadhar.getText();

        try {

            if(span.equals(""))
            {
                JOptionPane.showMessageDialog(null,"Pan number  is required");
            } else if (saadhar.equals("")) {
                JOptionPane.showMessageDialog(null,"Aadhar number is required");
            }
            else if (saadhar.matches("[A-Za-z]*"))
            {
                JOptionPane.showMessageDialog(null,"Aadhar number should be in numbers");
            }
            else
            {
                connect1 c1 = new connect1();
                String query = "insert into signuptwo values ('" + formno + "', '" + sreligion + "' , '" + scategory + "' , '" + sincome + "' , '" + seducation + "' , '" + soccupation + "', '" + span + "','" + saadhar + "','" + senior + "' , '" + existingaccount + "')";
                c1.s.executeUpdate(query);
                new signupthree(formno).setVisible(true);
                setVisible(false);
            }
        }
        catch (Exception eppc)
        {
            System.out.println(eppc);
        }
    }
    public static void main(String[] args) {
        new signuptwo("");
    }
}
