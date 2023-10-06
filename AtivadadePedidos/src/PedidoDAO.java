import java.sql.*;
//import java.util.*;
import java.util.ArrayList;

public class PedidoDAO {
	        Connection conn; 
	        Statement comandoSQL;

			// aqui você pode mudar os dados do bando de dados para funcionar no seu próprio ambiente
	public PedidoDAO() throws Exception{
		    String hostname ="localhost";
        	String port = "3306";
        	String database ="pedidostp1";
        	String username = "root";
        	String password = "xadrez10";
        	String dbURL ="jdbc:mysql://"+hostname+":"+port+"/"+database;
        try {
        	//DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			conn = DriverManager.getConnection(dbURL, username, password);
			comandoSQL = conn.createStatement();
		} 
        catch (Exception e) {
		
			System.err.println("ERRO AO CONECTAR COM O BANCO DE DADOS");
		}
       
	 }
	public Connection getConn() {
		return conn;
	}
	/*public void PedidoDAOclose()
	{
		try {
			conn.close();
		} 
		catch (Exception e) {
			System.err.println("ERRO");
		}
	}*/
	////////////////////////////////// CREATE  ok
	public void inserir(Pedido item) throws Exception {
		String sql = "INSERT INTO Pedidos (ID, DataInicio,DataEntrega,Descricao) VALUES (?, ?, ?, ?)";
        PreparedStatement statement = conn.prepareStatement(sql); 
        statement.setInt(1, item.getID());
        statement.setString(2, item.getDataInicio());
        statement.setString(3, item.getDataEntrega());
        statement.setString(4, item.getDescricao());
        statement.executeUpdate();
	}
	//////////////////////////////////////////////// READ ok
	public void obterTodos() throws Exception {
		ArrayList<Pedido> itens = new ArrayList<>();
		String sql = "SELECT * FROM Pedidos";
        PreparedStatement statement = conn.prepareStatement(sql);
        ResultSet registros = statement.executeQuery();
        while (registros.next()) {
            int id = registros.getInt("ID");
            String dataI = registros.getString("DataInicio");
            String dataE= registros.getString("DataEntrega");
            String Descricao = registros.getString("Descricao");
            Pedido item = new Pedido(id,dataI,dataE,Descricao);
            itens.add(item);
            System.out.println(item.toString());
        }
	}
	///////////////////////////////////////////////// READ ok
	public void obterItemPorId(int idItem) throws Exception {
		String sql = "SELECT * FROM Pedidos WHERE ID = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setInt(1, idItem);
        ResultSet registros = statement.executeQuery();
        Pedido item;
        if (registros.next()) {
        	int id = registros.getInt("ID");
            String dataI = registros.getString("DataInicio");
            String dataE= registros.getString("DataEntrega");
            String Descricao = registros.getString("Descricao");
            item = new Pedido(id,dataI,dataE,Descricao);
            System.out.println(item.toString());
        }
        else {
            return;
        }
	}
	////////////////////////////////////////////  UPDATE   
	public void alterar(Pedido item) throws Exception{
		String sql = "UPDATE Pedidos set DataInicio =?, DataEntrega = ? ,Descricao = ?  WHERE ID= ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, item.getDataInicio());
        statement.setString(2, item.getDataEntrega());
        statement.setString(3, item.getDescricao());
        statement.setInt(4, item.getID());
        statement.executeUpdate();
	}
	/////////////////////////////////////////////// ERASE 
	public void remover(Pedido item) throws Exception {
		String sql = "DELETE FROM Pedidos WHERE ID = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setInt(1, item.getID());
        statement.executeUpdate();
	}
	
}


