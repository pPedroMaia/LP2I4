/*
* Pedro Henrique de Oliveira Maia dos Santos CB3013197
*/

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;

public class EX4 extends Frame implements ActionListener {

    static JFormattedTextField t1;
    static JRadioButton option1;
    static JRadioButton option2;
    static JFormattedTextField t3;
    static JFormattedTextField t4;
    private MaskFormatter ftmtxt1;
    static JFrame frame;

    ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();

    public static void main(String[] args) throws ParseException {

        EX4 captura = new EX4();
        captura.janela();

    }

    public void janela() throws ParseException {
        frame = new JFrame("Calculadora");

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JPanel panel0 = new JPanel(new GridLayout(5, 1, 4, 4));
        JPanel panel1 = new JPanel(new GridLayout(1, 1, 4, 4));
        JPanel panel2 = new JPanel(new GridLayout(1, 2, 4, 4));
        JPanel panel3 = new JPanel(new GridLayout(1, 2, 4, 4));
        JPanel panel4 = new JPanel(new GridLayout(1, 2, 4, 4));
        JPanel panel5 = new JPanel(new GridLayout(1, 2, 4, 4));

        frame.setSize(400, 180);
        frame.setMinimumSize(new Dimension(400, 180));


        JLabel l1 = new JLabel("Nome:");
        JLabel l2 = new JLabel("Sexo:");
        JLabel l3 = new JLabel("Idade:");
        JLabel l4 = new JLabel("Numero:");


        JButton b1 = new JButton("OK");
        JButton b2 = new JButton("Limpar");
        JButton b3 = new JButton("Mostrar");
        JButton b4 = new JButton("Sair");


        option1 = new JRadioButton("M");
        option2 = new JRadioButton("F");

        ButtonGroup group = new ButtonGroup();
        group.add(option1);
        group.add(option2);
    option1.doClick();
        setLayout(new FlowLayout());



        t1 = new JFormattedTextField();
        t3 = new JFormattedTextField();
        t4 = new JFormattedTextField();
        t4.setValue(pessoas.size());




        EX4 c;
        c = new EX4();

        b1.addActionListener(c);
        b2.addActionListener(c);
        b3.addActionListener(c);
        b4.addActionListener(c);



        panel2.add(l4);
        panel2.add(t4);
        panel3.add(l1);
        panel3.add(t1);
        panel4.add(l2);
        panel4.add(option1);
        panel4.add(option2);
        panel5.add(l3);
        panel5.add(t3);

        panel1.add(b1);
        panel1.add(b2);
        panel1.add(b3);
        panel1.add(b4);

        panel0.add(panel2);
        panel0.add(panel3);
        panel0.add(panel4);
        panel0.add(panel5);
        panel0.add(panel1);
        frame.setContentPane(panel0);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();

        if (s.equals("Mostrar")) {
            String text = "";
            int numero = 0;
            for (int i = 0; i < pessoas.size(); i++) {
                text += pessoas.get(i).toString() + "\n";
                numero = pessoas.get(i).getKp();
            }
            text += "Numero: " + numero;
            JOptionPane.showMessageDialog(null,text);
        } else if (s.equals("Limpar")) {
            t1.setText("");
            t3.setText("");
            t4.setValue(pessoas.size());
        } else if (s.equals("OK")) {
            char sexo = ' ';
            if(option1.isSelected())
                sexo = option1.getText().charAt(0);
            else if (option2.isSelected())
                sexo = option2.getText().charAt(0);

            String nome = t1.getText();
            int idade = Integer.parseInt(t3.getText());
            Pessoa p = new Pessoa(nome,sexo,idade);
            p.setKp(pessoas.size()+1);
            pessoas.add(p);
            t4.setValue(pessoas.size());
        } else if (s.equals("Sair")) {
            frame.dispose();
        }
    }
}