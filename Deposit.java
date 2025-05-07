import javax.swing.*;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.*;
public class Deposit extends JFrame implements ActionListener {
    JButton submit,back;
    JLabel Deposit;
    JTextField money;
    String pin;
    public Deposit(String pinnumber)
    {
        pin=pinnumber;
        setLayout(null);
        Deposit = new JLabel("DEPOSIT");
        Deposit.setForeground(Color.white);
        Deposit.setFont(new Font("Raleway",Font.BOLD,40));
        Deposit.setBounds(265,40,400,30);
        add(Deposit);

        JLabel amount = new JLabel("Enter Amount    ");
        amount.setForeground(Color.white);
        amount.setFont(new Font("Raleway",Font.BOLD,24));
        amount.setBounds(65,215,200,36);
        add(amount);

        money = new JTextField();
        money.setBounds(240,220,200,25);
        money.setFont(new Font("Arial",Font.BOLD,14));
        add(money);

        submit = new JButton("Submit");
        submit.setBounds(290,280,100,30);
        submit.setFont(new Font("Ralway",Font.BOLD,16));
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);

        //back
        back = new JButton("Back");
        back.setBounds(60,400,100,30);
        back.setBackground(new Color(29,100,128));
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Osward", Font.BOLD, 18));
        add(back);
        back.addActionListener(this);

        // For Deposit BackGround Photo
        ImageIcon i1 = new ImageIcon("final/result/dwicon.jpg");
        Image i2 = i1.getImage().getScaledInstance(700,500,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(0,0,700,500);
        add(label);

        setSize(700,500);
        setLocation(350,170);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==back)
        {
            setVisible(false);
            new Transaction(pin).setVisible(true);
        }
    try
    {
        String amount = money.getText();
        Date date = new Date();
        if (e.getSource() == submit) {
            String s1 = money.getText();
            if (s1.equals("")) {
                JOptionPane.showMessageDialog(null, "Enter amount for deposit");
            } else if (s1.matches("[0.0-9.0]*")) {

                connect1 c1 = new connect1();
                c1.s.executeUpdate("insert into bank values('"+pin+"', '"+date+"', 'Deposit', '"+amount+"')");
                JOptionPane.showMessageDialog(null, money.getText() + " Deposited Successfully ");
                setVisible(false);
                new MainAccount(pin).setVisible(true);

            } else {
                JOptionPane.showMessageDialog(null, "Invalid Entry");
            }

        }
    }
    catch (Exception eiu)
    {
        System.out.println(eiu);
    }
    }
    public static void main(String[] args)
    {
        new Deposit("");
    }

}

