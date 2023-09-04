/*
* Pedro Henrique de Oliveira Maia dos Santos CB3013197
*/

import java.util.UUID;

public class Aluno {

	private String endereco;
	private int idade;
	private String nome;
	private UUID uuid;

	public String getEndereco() {
		return this.endereco;
	}

	public int getIdade() {
		return this.idade;
	}

	public String getNome() {
		return this.nome;
	}

	public UUID getUuid() {
		return this.uuid;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}
}