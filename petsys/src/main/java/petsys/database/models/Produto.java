package petsys.database.models;

public class Produto implements Model {

	private int id;
	private String nome;
	private String categoria;
	private String especificacoes;
	private double preco;
	private String dataAdicao;
	private int estoque;

	public Produto() {
	}

	public Produto(int id, String nome, String categoria, String especificacoes, double preco, String dataAdicao,
			int estoque) {
		this.id = id;
		this.nome = nome;
		this.categoria = categoria;
		this.especificacoes = especificacoes;
		this.preco = preco;
		this.dataAdicao = dataAdicao;
		this.estoque = estoque;
	}

	@Override
	public String toString() {
		return "Produto [id=" + id + ", nome=" + nome + ", categoria=" + categoria + ", especificacoes="
				+ especificacoes + ", preco=" + preco + ", dataAdicao=" + dataAdicao + ", estoque=" + estoque + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getEspecificacoes() {
		return especificacoes;
	}

	public void setEspecificacoes(String especificacoes) {
		this.especificacoes = especificacoes;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public String getDataAdicao() {
		return dataAdicao;
	}

	public void setDataAdicao(String dataAdicao) {
		this.dataAdicao = dataAdicao;
	}

	public int getEstoque() {
		return estoque;
	}

	public void setEstoque(int estoque) {
		this.estoque = estoque;
	}
}
