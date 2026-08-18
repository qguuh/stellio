package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

// Importação de database
import database.Database;
// importação do modelo de dados
import model.Fornecedor;

public class FornecedorController {
	// Instanciar o banco de dados
	private Database database;

	// Construtor
	public FornecedorController() {
		// Reutilizar o database no CRUD
		database = new Database();

	} // fim do construtor

	// Métodos (Funções) CRUD

	// =====================================================
	// Adicionar Fornecedor (Crud Create)
	// =====================================================

	public void Adicionar(Fornecedor fornecedor) throws SQLException {
		// Comando sql (passo1)
		String sql = """
				insert into fornecedores (nome, fone, email)
				values (?,?,?)
				""";
		// Abrir conexão com o banco (passo 2)
		Connection con = database.conectar();
		
		// executar o comando sql (passo 3)
		PreparedStatement stmt = con.prepareStatement(sql);
		// 1, 2, 3 = (?,?,?)
		stmt.setString(1, fornecedor.getNome());
		stmt.setString(2, fornecedor.getFone());
		stmt.setString(3, fornecedor.getEmail());
		stmt.executeUpdate();
		
		// Fechar a conexão (passo 4)
		stmt.close();
		con.close();
	} 
	
	// Fim CRUD Create =========================================================
	
	
}
