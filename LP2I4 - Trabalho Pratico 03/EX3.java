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

public class EX3 extends Frame implements ActionListener {

    static JFormattedTextField t1;
    static JComboBox c1;
    static JFormattedTextField t3;
    static JFormattedTextField t4;
    private MaskFormatter ftmtxt1;
    static JFrame frame;

    ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();

    public static void main(String[] args) throws ParseException {

        EX3 captura = new EX3();
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

        // array of string containing cities
        String s1[] = { "M", "F" };

        // create checkbox
        c1 = new JComboBox(s1);

        t1 = new JFormattedTextField();
        t3 = new JFormattedTextField();
        t4 = new JFormattedTextField();
        t4.setValue(pessoas.size());




        EX3 c;
        c = new EX3();

        b1.addActionListener(c);
        b2.addActionListener(c);
        b3.addActionListener(c);
        b4.addActionListener(c);



        panel2.add(l4);
        panel2.add(t4);
        panel3.add(l1);
        panel3.add(t1);
        panel4.add(l2);
        panel4.add(c1);
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
            String nome = t1.getText();
            char sexo = c1.getSelectedItem().toString().charAt(0);
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