/*
*Pedro Henrique de Oliveira Maia dos Santos CB3013197
*/

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BancoDeDados {
    public void inserirAluno(Aluno aluno) throws SQLException {
        Connection conexao = DriverManager.getConnection(
                "jdbc:mysql://localhost:1433/TPFINAL","keye","123456"
        );

        PreparedStatement statement = conexao.prepareStatement(
                "INSERT INTO ALUNOSTABLE (NOME, IDADE, PESO, ALTURA, OBJETIVO) VALUES (?, ?, ?, ?, ?)"
        );

        statement.setString(1, aluno.getNome());
        statement.setInt(2, aluno.getIdade());
        statement.setFloat(3, aluno.getPeso());
        statement.setFloat(4, aluno.getAltura());
        statement.setString(5, aluno.getObjetivo());

        statement.executeUpdate();
    }
}
