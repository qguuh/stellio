package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
		// 1, 2, 3 = (?,?,?
		
		stmt.setString(1, fornecedor.getNome());
		stmt.setString(2, fornecedor.getFone());
		stmt.setString(3, fornecedor.getEmail());
		stmt.executeUpdate();
		
		// Fechar a conexão (passo 4)
		stmt.close();
		con.close();
	} 
	
	// Fim CRUD Create =========================================================
	
	// ==================================================================================
	// CRUD Read - Buscar fornecedor (PELO NOME) >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	// ==================================================================================
	
	public Fornecedor buscar(String nome) {
		try {
			String sql = """
				select idFornecedor, nome, fone, email
				from fornecedores
				where nome like ?
			""";
			// Iniciar um objeto fornecedor como nulo
			Fornecedor fornecedor = null;
			
			//JDBC (connection e PreparedStatement)
			Connection con = database.conectar();
			PreparedStatement stmt = con.prepareStatement(sql);
			
			// setar a consulta
			stmt.setString(1, "%" + nome + "%");
			
			//JDBC (ResultSet) = "Trazer os dados do banco"
			ResultSet rs = stmt.executeQuery();
			
			// se existir um fornecedor com o nome pesquisado
			if (rs.next()) {
				// setar o model
				fornecedor = new Fornecedor();
				fornecedor.setIdFornecedor(rs.getInt("idFornecedor"));
				fornecedor.setNome(rs.getString("nome"));
				fornecedor.setFone(rs.getString("fone"));
				fornecedor.setEmail(rs.getString("email"));
			}

			// Fechar as conexões
			rs.close();
			stmt.close();
			con.close();
			
			return fornecedor;
			
			} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	// ==================================================================================
	// CRUD Read - Buscar fornecedor (PELO ID) >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	// ==================================================================================
	
	public Fornecedor buscarID(int idFornecedor) {
		try {
			String sql = """
				select idFornecedor, nome, fone, email
				from fornecedores
				where idFornecedor = ?
			""";
			// Iniciar um objeto fornecedor como nulo
			Fornecedor fornecedor = null;
			
			//JDBC (connection e PreparedStatement)
			Connection con = database.conectar();
			PreparedStatement stmt = con.prepareStatement(sql);
			
			// setar a consulta
			stmt.setInt(1, idFornecedor);
			
			//JDBC (ResultSet) = "Trazer os dados do banco"
			ResultSet rs = stmt.executeQuery();
			
			// se existir um fornecedor com o nome pesquisado
			if (rs.next()) {
				// setar o model
				fornecedor = new Fornecedor();
				fornecedor.setIdFornecedor(rs.getInt("idFornecedor"));
				fornecedor.setNome(rs.getString("nome"));
				fornecedor.setFone(rs.getString("fone"));
				fornecedor.setEmail(rs.getString("email"));
			}

			// Fechar as conexões
			rs.close();
			stmt.close();
			con.close();
			
			return fornecedor;
			
			} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	// =====================================================
	// Editar Fornecedor (Crud Update)
	// =====================================================

	public void Editar(Fornecedor fornecedor) throws SQLException {
		// Comando sql (passo1)
		String sql = """	
				update fornecedores
					set nome = 	?, fone = ?, email = ?
					where idFornecedor = ?
				""";
		// Abrir conexão com o banco (passo 2)
		Connection con = database.conectar();
		
		// executar o comando sql (passo 3)
		PreparedStatement stmt = con.prepareStatement(sql);
		// 1, 2, 3 = (?,?,?)
		stmt.setString(1, fornecedor.getNome());
		stmt.setString(2, fornecedor.getFone());
		stmt.setString(3, fornecedor.getEditmail());
		stmt.setInt(4, fornecedor.getIdFornecedor());
		stmt.executeUpdate();
		
		// Fechar a conexão (passo 4)
		stmt.close();
		con.close();
	} 
	
	// Fim CRUD EDIT =========================================================
	
	
	// =====================================================
	// Editar Fornecedor (Crud Delete)
	// =====================================================

	public boolean Excluir(int idFornecedor) {
	    try {
	        String sql = """
	            delete from fornecedores
	            where idFornecedor = ?
	        """;

	        Connection con = database.conectar();
	        PreparedStatement stmt = con.prepareStatement(sql);

	        stmt.setInt(1, idFornecedor);

	        int linhasAfetadas = stmt.executeUpdate();

	        stmt.close();
	        con.close();

	        return linhasAfetadas > 0;


	    } catch (Exception e) {
	        System.out.println(e);
	        return false;
	    }
	}
	
	// Fim CRUD Delete =========================================================
	
}
