//import java.util.*;
public class Main {
     public static void main(String[] args) throws Exception {
    	 
		Pedido Raiky = new Pedido(1,"Dia 2","Dia 5","Mouse - 19.90");
    	Pedido Pedro = new Pedido(2,"Dia 6","Dia 8","Teclado - 29.90");
    	Pedido Rafael = new Pedido(3,"Dia 8","Dia 10","Monitor - 550.50");
    	
    	PedidoDAO X = new PedidoDAO(); //Connected with DATABASE
    	
    	X.inserir(Rafael);
    	X.inserir(Pedro);        // CREAT ok
    	X.inserir(Raiky);
    	
    	System.out.println("OBTER TODOS NO BANCO DE DADOS : ");
    	X.obterTodos();						// READ ok
    	System.out.println("\n");
    	
    	System.out.println("OBTER POR ID : ");
    	X.obterItemPorId(1);        // READ ok   
    	
    	Rafael.setDataEntrega("Dia 9");    
     	System.out.println();
    	System.out.println("ALTERANDO O PEDIDO DO RAFAEL !");
    	X.alterar(Rafael);                //UPDATE ok
    	
     	System.out.println();
    	System.out.println("REMOVENDO O PEDIDO DO PEDRO DO BANCO DE DADOS ! ");
     	System.out.println();
    	X.remover(Pedro);              // DELETE  ok
    	
        System.out.println("OBTER TODOS NO BANCO DE DADOS : ");
    	X.obterTodos(); 
    	
    
    	
    	//X.PedidoDAOclose(); 
	}
}
