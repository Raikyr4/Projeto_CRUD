public class Pedido {
    private int ID;
    private String DataInicio;
    private String DataEntrega;
    private String Descricao;
    
  public Pedido(int iD, String dataInicio, String dataEntrega, String descricao) {
      ID = iD;
      DataInicio = dataInicio;
      DataEntrega = dataEntrega;
      Descricao = descricao;
  }
  public int getID() {
      return ID;
  }
  public void setID(int iD) {
      if(iD>=0) ID = iD;
  }
  public String getDataInicio() {
      return DataInicio;
  }
  public void setDataInicio(String dataInicio) {
      DataInicio = dataInicio;
  }
  public String getDataEntrega() {
      return DataEntrega;
  }
  public void setDataEntrega(String dataEntrega) {
      DataEntrega = dataEntrega;
  }
  public String getDescricao() {
      return Descricao;
  }
  public void setDescricao(String descricao) {
      Descricao = descricao;
  }
public String toString() {
	return "Pedido [ID=" + ID + ", DataInicio=" + DataInicio + ", DataEntrega=" + DataEntrega + ", Descricao="
			+ Descricao + "]";
}
    
    
}
