import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Transaction extends JFrame implements ActionListener {
    JButton Deposit, Withdrawal, back;
    String pinnumber;
    public Transaction(String pinnumber)
    {
        this.pinnumber=pinnumber;
        // Deposit Button
        Deposit = new JButton("Deposit");
        Deposit.setBounds(50,150,200,40);
        Deposit.setBackground(new Color(29,100,128));
        Deposit.setForeground(Color.WHITE);
        Deposit.setFont(new Font("Ralway", Font.BOLD, 26));
        Deposit.addActionListener(this);
        add(Deposit);

        // Withdrawal Button
        Withdrawal = new JButton("Withdrawal");
        Withdrawal.setBounds(50,250,200,40);
        Withdrawal.setBackground(new Color(29,100,128));
        Withdrawal.setForeground(Color.WHITE);
        Withdrawal.setFont(new Font("Raleway", Font.BOLD, 26));
        Withdrawal.addActionListener(this);
        add(Withdrawal);

        // Back Button
        back = new JButton("Back");
        back.setBounds(30,420,90,25);
        back.setBackground(new Color(29,100,128));
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Osward", Font.BOLD, 18));
        add(back);
        back.addActionListener(this);

        // Transaction BackGround Image
        ImageIcon icon = new ImageIcon("final/result/Transactionbg.jpg");
        Image icon2= icon.getImage().getScaledInstance(700,500,Image.SCALE_DEFAULT);
        ImageIcon icon3 = new ImageIcon(icon2);
        JLabel label1 = new JLabel(icon3);
        label1.setBounds(0,0,700,500);
        add(label1);

        setTitle("Account Details : ");
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setSize(700,500);
        setLocation(350,170);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==back) {
            setVisible(false);
            new MainAccount(pinnumber).setVisible(true);
        }
        if (e.getSource()==Deposit)
        {
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
        }
        if (e.getSource()==Withdrawal)
        {
            setVisible(false);
            new Withdraw(pinnumber).setVisible(true);
        }
    }

    public static void main(String[] args)
    {
        new Transaction("");
    }
}
