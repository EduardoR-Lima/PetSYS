package petsys.database.models;

public class NotaFiscal implements Model{
	private int id;
	private String tipo;
	private String dataEmissao;
	private String cpfCliente;
	private double valorTotal;


	public NotaFiscal() {
	}

	public NotaFiscal(int id, String tipo, String dataEmissao, String cpfCliente, double valorTotal) {
			this.id = id;
			this.tipo = tipo;
			this.dataEmissao = dataEmissao;
			this.cpfCliente = cpfCliente;
			this.valorTotal = valorTotal;
	}		
	
	@Override
	public String toString() {
		return "NotaFiscal [id=" + id + ", tipo=" + tipo + ", dataEmissao=" + dataEmissao + ", cpfCliente=" + cpfCliente
				+ ", valorTotal=" + valorTotal + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDataEmissao() {
		return dataEmissao;
	}

	public void setDataEmissao(String dataEmissao) {
		this.dataEmissao = dataEmissao;
	}

	public String getCpfCliente() {
		return cpfCliente;
	}

	public void setCpfCliente(String cpfCliente) {
		this.cpfCliente = cpfCliente;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}
	
}