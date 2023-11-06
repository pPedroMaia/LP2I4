/* 
* Pedro Henrique de Oliveira Maia dos Santos CB3013197
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.ArrayList;
import java.util.List;

public class Layout implements ActionListener {

    private JFrame jf = new JFrame();

    private JLabel lblNomePesquisa, lblNome, lblSalario, lblCargo;

    private JTextField txtPesquisarNome, txtNome, txtSalario, txtCargo;

    private JButton btnPesquisar, btnProximo, btnAnterior;

    private List<Funcionario> funcionarios = new ArrayList<Funcionario>();

    private int contadorLayout = 0;

    public Layout() {
        super();

        JPanel p1 = new JPanel();

        p1.setLayout(new GridLayout(2, 1, 10, 10));

        lblNomePesquisa = new JLabel("Nome");
        txtPesquisarNome = new JTextField(20);
        btnPesquisar = new JButton("Pesquisar");
        btnPesquisar.setHorizontalAlignment(btnPesquisar.CENTER);
        btnPesquisar.setVerticalAlignment(btnPesquisar.CENTER);

        p1.add(lblNomePesquisa);
        p1.add(txtPesquisarNome);
        p1.add(btnPesquisar);

        btnPesquisar.addActionListener(this);

        JPanel p2 = new JPanel();
        p2.setLayout(new GridLayout(4, 2, 5, 5));

        lblNome = new JLabel("Nome:");
        txtNome = new JTextField(20);

        lblSalario = new JLabel("Salario:");
        txtSalario = new JTextField(20);

        lblCargo = new JLabel("Cargo:");
        txtCargo = new JTextField(20);

        btnAnterior = new JButton("Anterior");
        btnProximo = new JButton("Proximo");

        p2.add(lblNome);
        p2.add(txtNome);

        p2.add(lblSalario);
        p2.add(txtSalario);

        p2.add(lblCargo);
        p2.add(txtCargo);

        p2.add(btnAnterior);
        p2.add(btnProximo);

        btnAnterior.addActionListener(this);
        btnProximo.addActionListener(this);

        jf.add(p1, "North");
        jf.add(p2, "South");

        jf.setVisible(true);
        jf.setSize(400, 250);
        jf.setTitle("TRABALHO PRATICO 04");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnPesquisar) {
            Funcionario listFunc = new Funcionario();

            funcionarios = listFunc.listarFuncionarios(txtPesquisarNome.getText());

            if (funcionarios.size() <= 0) {
                JOptionPane.showMessageDialog(null, "Nenhum funcionario");
                return;
            }

            txtNome.setText(funcionarios.get(0).getNome());
            txtSalario.setText(Double.toString(funcionarios.get(0).getSalario()));
            txtCargo.setText(funcionarios.get(0).getCargo());
        }
    }
}