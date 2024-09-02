package petsys.database.models;

public class Venda {
	private int id;
	private String dataVenda;
	private String formaPagamento;
	private Cliente cliente;
	private NotaFiscal nf;

	public Venda() {
	}

	public Venda(int id, String dataVenda, String formaPagamento, Cliente cliente, NotaFiscal nf) {
		this.id = id;
		this.dataVenda = dataVenda;
		this.formaPagamento = formaPagamento;
		this.cliente = cliente;
		this.nf = nf;
	}

	@Override
	public String toString() {
		return "Venda [id=" + id + ", dataVenda=" + dataVenda + ", formaPagamento=" + formaPagamento + ", cliente="
				+ cliente + ", nf=" + nf + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDataVenda() {
		return dataVenda;
	}

	public void setDataVenda(String dataVenda) {
		this.dataVenda = dataVenda;
	}

	public String getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(String formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public NotaFiscal getNf() {
		return nf;
	}

	public void setNf(NotaFiscal nf) {
		this.nf = nf;
	}

}
