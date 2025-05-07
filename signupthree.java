import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class signupthree extends JFrame implements ActionListener {

    JRadioButton r1,r2,r3,r4;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton sumbit;
    String formno;
    String pin;
    signupthree( String formno)
    {
        setLayout(null);
        JLabel l1 = new JLabel("Page 3 : Account Details");
        l1.setFont(new Font("Raleway",Font.BOLD,22));
        l1.setBounds(280,40,400,40);
        add(l1);

        JLabel type = new JLabel("Account Type");
        type.setFont(new Font("Raleway",Font.BOLD,22));
        type.setBounds(100,120,200,30);
        add(type);

        r1  = new JRadioButton("Saving Account");
        r1.setBackground(Color.white);
        r1.setFont(new Font("Raleway",Font.BOLD,16));
        r1.setBounds(100,170,250,20);
        add(r1);

        r2  = new JRadioButton("Fixed Deposit Account");
        r2.setBackground(Color.white);
        r2.setFont(new Font("Raleway",Font.BOLD,16));
        r2.setBounds(350,170,250,20);
        add(r2);

        r3  = new JRadioButton("Current Account");
        r3.setBackground(Color.white);
        r3.setFont(new Font("Raleway",Font.BOLD,16));
        r3.setBounds(100,200,250,20);
        add(r3);

        r4  = new JRadioButton("Recurring Deposit Account");
        r4.setBackground(Color.white);
        r4.setFont(new Font("Raleway",Font.BOLD,16));
        r4.setBounds(350,200,250,20);
        add(r4);

        ButtonGroup groupaccount = new ButtonGroup();
        groupaccount.add(r1);
        groupaccount.add(r2);
        groupaccount.add(r3);
        groupaccount.add(r4);

        JLabel card = new JLabel("Card Number");
        card.setFont(new Font("Raleway",Font.BOLD,22));
        card .setBounds(100,250,200,30);
        add(card);

        JLabel number = new JLabel("XXXX-XXXX-XXXX-9999");
        number.setFont(new Font("Raleway",Font.BOLD,22));
        number.setBounds(330,250,300, 30);
        add(number);

        JLabel cardDetail = new JLabel("Your 16 Digit Card Number");
        cardDetail.setFont(new Font("Raleway",Font.BOLD,12));
        cardDetail.setBounds(100,280,300, 20);
        add(cardDetail);


        JLabel pin = new JLabel("PIN : ");
        pin.setFont(new Font("Raleway",Font.BOLD,22));
        pin.setBounds(100,310,200, 30);
        add(pin);

        JLabel pnnumber = new JLabel("XXXX");
        pnnumber.setFont(new Font("Raleway",Font.BOLD,22));
        pnnumber.setBounds(330,310,300, 30);
        add(pnnumber);

        JLabel pinDetail = new JLabel("Your Pin Number");
        pinDetail.setFont(new Font("Raleway",Font.BOLD,12));
        pinDetail.setBounds(100,340,300, 20);
        add(pinDetail);

        JLabel services = new JLabel("Service Required:");
        services.setFont(new Font("Raleway",Font.BOLD,22));
        services.setBounds(100,390,200, 30);
        add(services);

        c1= new JCheckBox("ATM CARD");
        c1.setBackground(Color.white);
        c1.setFont(new Font("Raleway",Font.BOLD,16));
        c1.setBounds(100,430,200,30);
        add(c1);



        c2= new JCheckBox("Internet Banking");
        c2.setBackground(Color.white);
        c2.setFont(new Font("Raleway",Font.BOLD,16));
        c2.setBounds(300,430,200,30);
        add(c2);


        c3= new JCheckBox("Mobile Banking");
        c3.setBackground(Color.white);
        c3.setFont(new Font("Raleway",Font.BOLD,16));
        c3.setBounds(100,460,200,30);
        add(c3);


        c4= new JCheckBox("Email/SMS Alerts");
        c4.setBackground(Color.white);
        c4.setFont(new Font("Raleway",Font.BOLD,16));
        c4.setBounds(300,460,200,30);
        add(c4);


        c5= new JCheckBox("Cheque Book");
        c5.setBackground(Color.white);
        c5.setFont(new Font("Raleway",Font.BOLD,16));
        c5.setBounds(100,490,200,30);
        add(c5);

        c6= new JCheckBox("E-Statement");
        c6.setBackground(Color.white);
        c6.setFont(new Font("Raleway",Font.BOLD,16));
        c6.setBounds(300,490,200,30);
        add(c6);

        c7= new JCheckBox("I declare that the above entered Details are correct");
        c7.setBackground(Color.white);
        c7.setFont(new Font("Raleway",Font.BOLD,12));
        c7.setBounds(100,570,600,30);
        add(c7);

        sumbit = new JButton("Submit");
        sumbit.setBackground(Color.black);
        sumbit.setForeground(Color.white);
        sumbit.setFont(new Font("Raleway",Font.BOLD,14));
        sumbit.setBounds(200,620,100,30);
        sumbit.addActionListener(this);
        add(sumbit);


        getContentPane().setBackground(Color.white);
        setSize(850,1000);
        setLocation(350,0);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent aee) {
        if (aee.getSource() == sumbit) {
            String accounttype = null;
            if (r1.isSelected()) {
                accounttype = "Saving Account";
            } else if (r2.isSelected()) {
                accounttype = "Fixed Deposit Account";
            } else if (r3.isSelected()) {
                accounttype = "Current Account";
            }
            else
            {
                accounttype = "Recurring Deposit Account";
            }
            Random random = new Random();
            String cardnumber = "" + Math.abs((random.nextLong() % 90000000l) + 5040936000000000l);
            String pinnumber = "" + Math.abs((random.nextLong() % 9000l) + 1000l);
            pin = pinnumber;
            String facility = "";
            if (c1.isSelected()) {
                facility = facility + " ATM CARD";
            } else if (c2.isSelected()) {
                facility = facility + " Internet Banking";
            } else if (c3.isSelected()) {
                facility = facility + "  Mobile Banking";
            } else if (c4.isSelected()) {
                facility = facility + "Email/SMS Alert";
            } else if (c5.isSelected()) {
                facility = facility + " Cheque Book";
            } else if (c6.isSelected()) {
                facility = facility + " E-Statement";
            }

            if (c7.isSelected()) {
                try {

                    connect1 c1 = new connect1();
                    String query1 = "insert into signupthree values('" + formno + "', '" + accounttype + "','" + cardnumber + "','" + pinnumber + "','" + facility + "')";
                    String query2 = "insert into login values('" + formno + "','" + cardnumber + "','" + pinnumber + "')";
                    c1.s.executeUpdate(query1);
                    c1.s.executeUpdate(query2);
                    JOptionPane.showMessageDialog(null, " Card Number : " + cardnumber + "\n Pin : " + pinnumber);
                    setVisible(false);
                } catch (Exception d) {
                    System.out.println(d);
                }
                new signupdeposit(pin).setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Confirmation Required");
            }
        }
    }
    public static void main(String[] args) {
        new signupthree("");
    }
}
