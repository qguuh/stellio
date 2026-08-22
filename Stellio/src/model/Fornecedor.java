package model;

public class Fornecedor {
	// Modelo de dados da tabela fornecedor
	private int idFornecedor;
	private String nome;
	private String fone;
	private String email;

	
	// gerar getters e setters de forma automática
	// botão direito -> source -> generate getters and setters
	public int getIdFornecedor() {
		return idFornecedor;
	}
	public void setIdFornecedor(int idFornecedor) {
		this.idFornecedor = idFornecedor;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getFone() {
		return fone;
	}
	public void setFone(String fone) {
		this.fone = fone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEditmail() {
		return email;
	}
	public void setEditmail(String email) {
		this.email = email;
	}
	
	
	
}
