import javax.swing.*;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.time.temporal.TemporalAmount;
import java.util.Date;

public class signupdeposit extends JFrame implements ActionListener {
    JButton submit;
    JTextField money;
    String pin;
    public signupdeposit(String pin)
    {
        this.pin=pin;
        setLayout(null);

        JLabel amount = new JLabel("Enter Amount    ");
        //amount.setForeground(Color.white);
        amount.setFont(new Font("Raleway",Font.BOLD,24));
        amount.setBounds(30,60,200,36);
        add(amount);

        money = new JTextField();
        money.setBounds(215,69,200,25);
        money.setFont(new Font("Arial",Font.BOLD,14));
        add(money);

        submit = new JButton("Submit");
        submit.setBounds(250,120,100,30);
        submit.setFont(new Font("Ralway",Font.BOLD,16));
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);


        setTitle("Deposit");
        setLayout(null);
        setSize(450,250);
        setLocation(500,200);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    try {

        Date date = new Date();
        String amount = money.getText();
        if (e.getSource() == submit) {
            if (amount.equals("")) {
                JOptionPane.showMessageDialog(null, "Enter the amount");
            } else if (amount.matches("[0.0-9.0]*")){
                boolean a = Integer.parseInt(money.getText()) >= 2000;
                if (a) {
                    connect1 c1 = new connect1();
                    c1.s.executeUpdate("insert into bank values('" + pin + "', '" + date + "', 'Deposit', '" + amount + "')");
                    JOptionPane.showMessageDialog(null, money.getText() + " Deposited Successfully ");
                    setVisible(false);
                    new login().setVisible(true);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Minimum 2000 required");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Invalid Entry");
            }
        }
    }
    catch (Exception e2)
    {
        System.out.println(e2);
    }
    }
    public static void main(String[] args) {
        new signupdeposit("");
    }

}

