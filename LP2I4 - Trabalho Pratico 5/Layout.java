/*
* Pedro Henrique de Oliveira Maia dos Santos CB3013197
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Layout implements ActionListener {

    private JFrame jf = new JFrame();
    private JLabel lblMaximo, lblPrioridade1, lblPrioridade2, lblFinal1, lblFinal2;
    private JTextField txtMaximo;
    private JButton btnIniciar, btnLimpar;
    private JScrollPane lstPane1, lstPanel2;
    private JSpinner spinner1, spinner2;

    JList<String> listBox = new JList<>();
    JList<String> listBox2 = new JList<>();

    public Layout() {
        super();

        JPanel p1 = new JPanel();
        p1.setLayout(new GridLayout(4, 2, 10, 10));
        Dimension tamanhoBotao = new Dimension(100, 30);

        lblMaximo = new JLabel("Maximo");
        txtMaximo = new JTextField(20);

        SpinnerModel model1 = new SpinnerNumberModel(1, 1, 10, 1);
        spinner1 = new JSpinner(model1);

        SpinnerModel model2 = new SpinnerNumberModel(1, 1, 10, 1);
        spinner2 = new JSpinner(model2);

        btnIniciar = new JButton("Iniciar");
        btnIniciar.addActionListener(this);
        btnIniciar.setPreferredSize(tamanhoBotao);

        p1.add(lblMaximo);
        p1.add(txtMaximo);
        p1.add(new JLabel("Prioridade 1"));
        p1.add(spinner1);
        p1.add(new JLabel("Prioridade 2"));
        p1.add(spinner2);
        p1.add(btnIniciar);

        jf.add(p1, BorderLayout.NORTH);

        JPanel p3 = new JPanel();
        p3.setLayout(new GridLayout(3, 2, 30, 10));

        lstPane1 = new JScrollPane(listBox);
        lstPanel2 = new JScrollPane(listBox2);

        lblFinal1 = new JLabel("");
        lblFinal2 = new JLabel("");

        btnLimpar = new JButton("Limpar");
        btnLimpar.setPreferredSize(tamanhoBotao);
        btnLimpar.addActionListener(this);

        p3.add(lstPane1);
        p3.add(lstPanel2);
        p3.add(lblFinal1);
        p3.add(lblFinal2);
        p3.add(btnLimpar);

        jf.add(p3, BorderLayout.SOUTH);

        jf.setVisible(true);
        jf.setSize(800, 800);
        jf.setTitle("Trabalho Pratico 5");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnIniciar) {
            int maximo = Integer.parseInt(txtMaximo.getText());
            int prioridade1 = (int) spinner1.getValue();
            int prioridade2 = (int) spinner2.getValue();

            Thread thread1 = new Thread(() -> {
                DefaultListModel<String> model1 = new DefaultListModel<>();
                for (int i = 0; i < maximo; i++) {
                    model1.addElement("Thread 1 - " + i);
                    listBox.setModel(model1);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }

                lblFinal1.setText("FINAL");

            });

            thread1.setPriority(prioridade1);

            Thread thread2 = new Thread(() -> {
                DefaultListModel<String> model2 = new DefaultListModel<>();
                for (int i = 0; i < maximo; i++) {
                    model2.addElement("Thread 2 - " + i);
                    listBox2.setModel(model2);
                    try {
                        Thread.sleep(800);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }

                lblFinal2.setText("FINAL");

            });
            thread2.setPriority(prioridade2);

            thread1.start();
            thread2.start();

        } else if (e.getSource() == btnLimpar) {
            DefaultListModel<String> model1 = new DefaultListModel<>();
            DefaultListModel<String> model2 = new DefaultListModel<>();
            listBox.setModel(model1);
            listBox2.setModel(model2);
            lblFinal1.setText("");
            lblFinal2.setText("");
            txtMaximo.setText("");
            spinner1.setValue(1);
            spinner2.setValue(1);
        }
    }

}