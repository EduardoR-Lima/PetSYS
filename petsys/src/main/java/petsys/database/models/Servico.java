package petsys.database.models;

public class Servico implements Model {

		private int id;
		private String nome;
		private String categoria;
		private String especificacoes;
		private double valor;
		private String dataAdicao;

		public Servico() {
		}

		public Servico(int id, String nome, String categoria, String especificacoes, double valor, String dataAdicao) {
			this.id = id;
			this.nome = nome;
			this.categoria = categoria;
			this.especificacoes = especificacoes;
			this.valor = valor;
			this.dataAdicao = dataAdicao;
		}

		@Override
		public String toString() {
			return "Servico [id=" + id + ", nome=" + nome + ", categoria=" + categoria + ", especificacoes="
					+ especificacoes + ", valordoServico=" + valor + ", dataAdicao=" + dataAdicao + "]";
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

		public double getValor() {
			return valor;
		}

		public void setValor(double valordoServico) {
			this.valor = valordoServico;
		}

		public String getDataAdicao() {
			return dataAdicao;
		}

		public void setDataAdicao(String dataAdicao) {
			this.dataAdicao = dataAdicao;
		}




}
