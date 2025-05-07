import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainAccount extends JFrame implements ActionListener {
    JButton Account, Savings, Loan, Statement, Balance,exit;
    String pinnumber;
    public MainAccount(String pinnumber)
    {
        this.pinnumber=pinnumber;
    /*    // For Account Button
        Account = new JButton("Account");
        Account.setBounds(70,130,130,40);
        Account.setBackground(new Color(00,240,255));
        Account.setForeground(Color.BLACK);
        Account.setFont(new Font("Osward", Font.BOLD, 20));
        add(Account);
        Account.addActionListener(this);
    */
        // For Savings Button
        Savings = new JButton("Transaction");
        Savings.setBounds(500,130,130,40);
        Savings.setBackground(new Color(00,240,255));
        Savings.setForeground(Color.BLACK);
        Savings.setFont(new Font("Osward", Font.BOLD, 17));
        add(Savings);
        Savings.addActionListener(this);

        // For Loan Button
        Loan = new JButton("Loan");
        Loan.setBounds(70,310,130,40);
        Loan.setBackground(new Color(00,240,255));
        Loan.setForeground(Color.BLACK);
        Loan.setFont(new Font("Osward", Font.BOLD, 20));
        add(Loan);
        Loan.addActionListener(this);

        // For Statement Button
        Statement = new JButton("Statement");
        Statement.setBounds(500,310,130,40);
        Statement.setBackground(new Color(00,240,255));
        Statement.setForeground(Color.BLACK);
        Statement.setFont(new Font("Osward", Font.BOLD, 18));
        add(Statement);
        Statement.addActionListener(this);

        // For Balance Button
        Balance = new JButton("View Balance");
        Balance.setBounds(70,130,160,40);
        Balance.setBackground(new Color(00,240,255));
        Balance.setForeground(Color.BLACK);
        Balance.setFont(new Font("Osward", Font.BOLD, 20));
        add(Balance);
        Balance.addActionListener(this);

        exit = new JButton("Log Out");
        exit.setBounds(270,390,160,40);
        exit.setBackground(new Color(00,240,255));
        exit.setForeground(Color.BLACK);
        exit.setFont(new Font("Osward", Font.BOLD, 20));
        add(exit);
        exit.addActionListener(this);

        // For MainPage BackGround Photo
        ImageIcon i1 = new ImageIcon("final/result/Main.jpg");
        Image i2 = i1.getImage().getScaledInstance(700,500,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(0,0,700,500);
        add(label);

        setTitle("Main Page");
        setLayout(null);
        setSize(700,500);
        setLocation(350,170);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==exit) {
            setVisible(false);
            new login().setVisible(true);
        }
    /*    if (e.getSource()==Account)
        {
            setVisible(false);
            new Account().setVisible(true);
        }*/
        if (e.getSource()==Loan)
        {
            setVisible(false);
            new Loan(pinnumber).setVisible(true);
        }
        if (e.getSource()==Savings)
        {
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        }
        if (e.getSource()==Balance)
        {
            setVisible(false);
            new Balance(pinnumber).setVisible(true);
        }
        if (e.getSource()==Statement)
        {
            setVisible(false);
            new Statement(pinnumber).setVisible(true);
        }
    }
    public static void main(String[] args) {
        new MainAccount("");
    }
}
