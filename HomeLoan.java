import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class HomeLoan extends JFrame implements ActionListener {
    JButton back;
    String pin;
    JLabel home;
    JCheckBox a;
    JCheckBox b;
    JLabel amount1;
    JTextField money;
    JButton submit;
    public HomeLoan(String pinnumber)
    {
        pin=pinnumber;
         home = new JLabel("HOME LOAN");
        home.setForeground(Color.BLACK);
        home.setFont(new Font("Osward",Font.BOLD,28));
        home.setBounds(235, 20, 250, 30);
        add(home);

        // set the checkbox

        a = new JCheckBox(" I Agree the statement that I have  to return  money in 1 financial year");
        a.setForeground(Color.black);
        a.setFont(new Font("Arial", Font.BOLD, 13));
        a.setBounds(50, 80, 600, 30);
        add(a);

        // set checkbox
        b = new JCheckBox(" I Agree the statement Home Loan is at Interest Rate of 8.00 % per annum .");
        b.setForeground(Color.black);
        b.setFont(new Font("Arial", Font.BOLD, 13));
        b.setBounds(50, 120, 600, 28);
        add(b);

        // amount
        amount1 = new JLabel("Enter Amount    ");
        amount1.setForeground(Color.BLACK);
        amount1.setFont(new Font("Raleway", Font.BOLD, 24));
        amount1.setBounds(65, 195, 200, 36);
        add(amount1);

        money = new JTextField();
        money.setBounds(240, 200, 200, 25);
        money.setFont(new Font("Arial", Font.BOLD, 14));
        add(money);

        submit = new JButton("Submit");
        submit.setBounds(290, 250, 100, 30);
        submit.setFont(new Font("Ralway", Font.BOLD, 16));
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);


        // Back Button
        back = new JButton("Back");
        back.setBounds(30,420,90,25);
        back.setBackground(new Color(29,100,128));
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Osward", Font.BOLD, 18));
        add(back);
        back.addActionListener(this);

        // Home Loan BackGround Image
        ImageIcon icon = new ImageIcon("final/result/HomeLoan.jpg");
        Image icon2= icon.getImage().getScaledInstance(700,500,Image.SCALE_DEFAULT);
        ImageIcon icon3 = new ImageIcon(icon2);
        JLabel label1 = new JLabel(icon3);
        label1.setBounds(0,0,700,500);
        add(label1);

        setTitle("Home Loan : ");
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setSize(700,500);
        setLocation(350,170);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String amount = money.getText();
        Date date = new Date();
        if (e.getSource()==back)
        {
            setVisible(false);
            new Loan(pin).setVisible(true);
        }
        try {

            if (e.getSource() == submit) {
                if (a.isSelected() && b.isSelected()) {

                    if (amount.equals("")) {
                        JOptionPane.showMessageDialog(null, "Enter the amount");
                    } else if (amount.matches("[0.0-9.0]*")) {
                        boolean a = Integer.parseInt(money.getText()) <= 15000;

                        if (a) {
                            connect1 c1 = new connect1();
                            c1.s.executeUpdate("insert into bank values('" + pin + "', '" + date + "', 'Deposit', '" + amount + "')");
                            JOptionPane.showMessageDialog(null, money.getText() + " Deposited Successfully ");
                            setVisible(false);
                            new MainAccount(pin).setVisible(true);
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null,"Maximum limit is 15000");
                        }
                    }

                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Confirmation Required");
                }
            }
        }
        catch (Exception ef) {
            System.out.println(ef);
        }

    }
    public static void main(String[] args)
    {
        new HomeLoan("");
    }
}
