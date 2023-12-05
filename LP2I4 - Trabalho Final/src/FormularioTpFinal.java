/*
*Pedro Henrique de Oliveira Maia dos Santos CB3013197
*/

import com.google.gson.Gson;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
public class FormularioTpFinal {
    public static void main(String[] args) {
        final BancoDeDados banco = new BancoDeDados();

        final JFrame formulario = new JFrame("TP FINAL - LP2I4");

        formulario.setSize(300, 225);
        formulario.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        formulario.setLayout(new BorderLayout());

        final JTextField campoNome = new JTextField(15);
        final JTextField campoIdade = new JTextField(15);
        final JTextField campoPeso = new JTextField(15);
        final JTextField campoAltura = new JTextField(15);
        final JTextField campoObjetivo = new JTextField(15);

        final JLabel textoNome = new JLabel("Nome: ");
        final JLabel textoIdade = new JLabel("Idade: ");
        final JLabel textoPeso = new JLabel("Peso: ");
        final JLabel textoAltura = new JLabel("Altura: ");
        final JLabel textoObjetivo = new JLabel("Objetivo: ");

        final JPanel painelEsquerdo = new JPanel(new GridLayout(5, 2, 5, 5));
        painelEsquerdo.add(textoNome);
        painelEsquerdo.add(campoNome);
        painelEsquerdo.add(textoIdade);
        painelEsquerdo.add(campoIdade);
        painelEsquerdo.add(textoPeso);
        painelEsquerdo.add(campoPeso);
        painelEsquerdo.add(textoAltura);
        painelEsquerdo.add(campoAltura);
        painelEsquerdo.add(textoObjetivo);
        painelEsquerdo.add(campoObjetivo);

        formulario.add(painelEsquerdo, BorderLayout.NORTH);

        final JButton botaoIncluir = new JButton("Incluir");
        botaoIncluir.addActionListener(e -> {
            final Aluno aluno = new Aluno(
                    campoNome.getText(),
                    Integer.parseInt(campoIdade.getText()),
                    Float.parseFloat(campoPeso.getText()),
                    Float.parseFloat(campoAltura.getText()),
                    campoObjetivo.getText()
            );

            try {
                banco.inserirAluno(aluno);

                JOptionPane.showMessageDialog(formulario, "Aluno inserido");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(formulario, "Erro: " + ex.getMessage());
            }
        });

        final JButton botaoLimpar = new JButton("Limpar");
        botaoLimpar.addActionListener(e -> {
            campoNome.setText("");
            campoIdade.setText("");
            campoPeso.setText("");
            campoAltura.setText("");
            campoObjetivo.setText("");
        });

        final JButton botaoApresentarDados = new JButton("Apresentar Dados");
        botaoApresentarDados.addActionListener(e -> {
            if (campoIdade.getText().length() == 0) return;
            if (campoPeso.getText().length() == 0) return;
            if (campoAltura.getText().length() == 0) return;

            final Aluno aluno = new Aluno(
                    campoNome.getText(),
                    Integer.parseInt(campoIdade.getText()),
                    Float.parseFloat(campoPeso.getText()),
                    Float.parseFloat(campoAltura.getText()),
                    campoObjetivo.getText()
            );

            JOptionPane.showMessageDialog(formulario, new Gson().toJson(aluno));
        });

        final JButton botaoSair = new JButton("Sair");
        botaoSair.addActionListener(e -> {
            System.exit(0);
        });

        final JPanel painelInferior = new JPanel(new GridLayout(1, 2, 5, 5));

        final JPanel painelInferiorEsquerdo = new JPanel(new GridLayout(2, 1,5,5));
        painelInferiorEsquerdo.add(botaoIncluir);
        painelInferiorEsquerdo.add(botaoLimpar);

        final JPanel painelInferiorDireito = new JPanel(new GridLayout(2, 1,5,5));
        painelInferiorDireito.add(botaoApresentarDados);
        painelInferiorDireito.add(botaoSair);

        painelInferior.add(painelInferiorEsquerdo);
        painelInferior.add(painelInferiorDireito);

        formulario.add(painelInferior, BorderLayout.SOUTH);

        formulario.setVisible(true);
    }
}