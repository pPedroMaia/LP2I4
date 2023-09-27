/*
* Pedro Henrique de Oliveira Maia dos Santos CB3013197
*/


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EX1 extends Frame implements ActionListener
{
    String s0, s1, s2;

    EX1()
    {
        s0 = s1 = s2 = "";
    }

    static JTextField l;

    public static void main(String[] args)
    {

        JFrame frame = new JFrame("Calculadora");

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JPanel panel0 = new JPanel(new GridLayout(6,1, 4,4));
        JPanel panel1 = new JPanel(new GridLayout(1,1,4,4));
        JPanel panel2 = new JPanel(new GridLayout(1,4,4,4));
        JPanel panel3 = new JPanel(new GridLayout(1,4,4,4));
        JPanel panel4 = new JPanel(new GridLayout(1,4,4,4));
        JPanel panel5 = new JPanel(new GridLayout(1,4,4,4));
        JPanel panel6 = new JPanel(new GridLayout(1,4,4,4));
        frame.setSize(256, 350);
        frame.setMinimumSize(new Dimension(256, 350));
        l = new JTextField();
        l.setText("0");
        l.setHorizontalAlignment(SwingConstants.RIGHT);
        panel1.add(l);

        JButton btn7 = new JButton(String.valueOf(7));

        JButton btn8 = new JButton(String.valueOf(8));

        JButton btn9 = new JButton(String.valueOf(9));

        JButton btndiv = new JButton(String.valueOf("/"));



        JButton btn4 = new JButton(String.valueOf(4));

        JButton btn5 = new JButton(String.valueOf(5));

        JButton btn6 = new JButton(String.valueOf(6));

        JButton btnmult = new JButton(String.valueOf("*"));



        JButton btn1 = new JButton(String.valueOf(1));

        JButton btn2 = new JButton(String.valueOf(2));

        JButton btn3 = new JButton(String.valueOf(3));

        JButton btnsub = new JButton(String.valueOf("-"));



        JButton btn0 = new JButton(String.valueOf(0));

        JButton btnpont = new JButton(String.valueOf("."));

        JButton btniqual = new JButton(String.valueOf("="));

        JButton btnsom = new JButton(String.valueOf("+"));



        JButton btnclear = new JButton(String.valueOf("C"));

        JButton btn_p_5_2 = new JButton();
        btn_p_5_2.setVisible(false);

        JButton btn_p_5_3 = new JButton();
        btn_p_5_3.setVisible(false);

        JButton btn_p_5_4 = new JButton();
        btn_p_5_4.setVisible(false);

        EX1 c;
        c = new EX1();

        btnmult.addActionListener(c);
        btndiv.addActionListener(c);
        btnsub.addActionListener(c);
        btnsom.addActionListener(c);
        btn9.addActionListener(c);
        btn8.addActionListener(c);
        btn7.addActionListener(c);
        btn6.addActionListener(c);
        btn5.addActionListener(c);
        btn4.addActionListener(c);
        btn3.addActionListener(c);
        btn2.addActionListener(c);
        btn1.addActionListener(c);
        btn0.addActionListener(c);
        btnpont.addActionListener(c);
        btnclear.addActionListener(c);
        btniqual.addActionListener(c);


        panel2.add(btn7);
        panel2.add(btn8);
        panel2.add(btn9);
        panel2.add(btndiv);
        panel3.add(btn4);
        panel3.add(btn5);
        panel3.add(btn6);
        panel3.add(btnmult);
        panel4.add(btn1);
        panel4.add(btn2);
        panel4.add(btn3);
        panel4.add(btnsub);
        panel5.add(btn0);
        panel5.add(btnpont);
        panel5.add(btniqual);
        panel5.add(btnsom);
        panel6.add(btnclear);
        panel6.add(btn_p_5_2);
        panel6.add(btn_p_5_3);
        panel6.add(btn_p_5_4);



        panel0.add(panel1);
        panel0.add(panel2);
        panel0.add(panel3);
        panel0.add(panel4);
        panel0.add(panel5);
        panel0.add(panel6);
        frame.setContentPane(panel0);
        frame.setVisible(true);
    }


    public void actionPerformed(ActionEvent e)
    {
        String s = e.getActionCommand();

        if ((s.charAt(0) >= '0' && s.charAt(0) <= '9') || s.charAt(0) == '.') {

            if (!s1.equals(""))
                s2 = s2 + s;
            else
                s0 = s0 + s;

            l.setText(s0 + s1 + s2);
        }
        else if (s.charAt(0) == 'C') {

            s0 = s1 = s2 = "";


            l.setText(s0 + s1 + s2);
        }
        else if (s.charAt(0) == '=') {

            double te;

            if (s1.equals("+"))
                te = (Double.parseDouble(s0) + Double.parseDouble(s2));
            else if (s1.equals("-"))
                te = (Double.parseDouble(s0) - Double.parseDouble(s2));
            else if (s1.equals("/"))
                te = (Double.parseDouble(s0) / Double.parseDouble(s2));
            else
                te = (Double.parseDouble(s0) * Double.parseDouble(s2));


            l.setText(s0 + s1 + s2 + "=" + te);


            s0 = Double.toString(te);

            s1 = s2 = "";
        }
        else {

            if (s1.equals("") || s2.equals(""))
                s1 = s;

            else {
                double te;


                if (s1.equals("+"))
                    te = (Double.parseDouble(s0) + Double.parseDouble(s2));
                else if (s1.equals("-"))
                    te = (Double.parseDouble(s0) - Double.parseDouble(s2));
                else if (s1.equals("/"))
                    te = (Double.parseDouble(s0) / Double.parseDouble(s2));
                else
                    te = (Double.parseDouble(s0) * Double.parseDouble(s2));


                s0 = Double.toString(te);

                s1 = s;

                s2 = "";
            }

            l.setText(s0 + s1 + s2);
        }
    }
}