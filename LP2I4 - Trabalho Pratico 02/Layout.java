/*
* Pedro Henrique de Oliveira Maia dos Santos CB3013197
*/

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.UUID;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Layout extends Frame implements ActionListener {

    Button btnOk, btnLimpar, btnMostrar, btnSair;
    ArrayList<Aluno> alunos = new ArrayList<>();
    TextField txtNome, txtIdade, txtEndereco;
    Frame f = new Frame("LP214 - TP02");

    public Layout() {
        super();

        f.setSize(400, 180);

        Color corCinzaClaro = new Color(220, 220, 220);
        f.setBackground(corCinzaClaro);


        Panel panel1 = new Panel();
        panel1.setLayout(new GridLayout(3, 2, 10, 10));
        f.addWindowListener(new FechaJanela());
        txtNome = new TextField("");
        txtIdade = new TextField("");
        txtEndereco = new TextField("");
        panel1.add(new Label("Nome"));
        panel1.add(txtNome);
        panel1.add(new Label(" Idade"));
        panel1.add(txtIdade);
        panel1.add(new Label("Endereço"));
        panel1.add(txtEndereco);


        Panel panel2 = new Panel();
        panel2.setLayout(new GridLayout(1, 4, 10, 10));

        btnOk = new Button("Ok");
        btnLimpar = new Button("Limpar");
        btnMostrar = new Button("Mostrar");
        btnSair = new Button("Sair");

        btnOk.addActionListener(this);
        btnLimpar.addActionListener(this);
        btnMostrar.addActionListener(this);
        btnSair.addActionListener(this);

        panel2.add(btnOk);
        panel2.add(btnLimpar);
        panel2.add(btnMostrar);
        panel2.add(btnSair);

        // colocando os paineis na janela e organizando.

        f.setLayout(new BorderLayout(10, 10));
        f.add(panel1, BorderLayout.CENTER);
        f.add(panel2, BorderLayout.SOUTH);

        f.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnOk) {
            Aluno aluno = new Aluno();

            aluno.setNome(txtNome.getText());
            aluno.setIdade(Integer.parseInt(txtIdade.getText()));
            aluno.setEndereco(txtEndereco.getText());
            UUID uuid = UUID.randomUUID();
            aluno.setUuid(uuid);

            alunos.add(aluno);

            return;
        } else if (e.getSource() == btnLimpar) {
            txtNome.setText("");
            txtIdade.setText("");
            txtEndereco.setText("");
            return;
        } else if (e.getSource() == btnMostrar) {
            JFrame jf = new JFrame();

            JOptionPane pane = new JOptionPane();

            String mensagem = "";

            for (Aluno aluno : alunos) {
                mensagem += "ID: " + aluno.getUuid() + " Nome: " + aluno.getNome() + "\n";
            }

            pane.showMessageDialog(jf, mensagem);

            return;
        } else if (e.getSource() == btnSair) {
            System.exit(0);
        }
    }

}