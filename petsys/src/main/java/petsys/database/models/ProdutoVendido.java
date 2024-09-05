package petsys.database.models;

public class ProdutoVendido implements Model {
		private int id;
		private NotaFiscal nf;
		private Produto produto;
		private int quantidade;
		private double valorTotal;

		public ProdutoVendido() {
		}

		public ProdutoVendido(int id, NotaFiscal nf, Produto produto, int quantidade, double valorTotal) {
				this.id = id;
				this.nf = nf;
				this.produto = produto;
				this.quantidade = quantidade;
				this.valorTotal = valorTotal;
		}
		@Override
		public String toString() {
			return "ProdutoVendido [sequencia=" + id + ", nf=" + nf + ", produto=" + produto + ", quantidade="
					+ quantidade + ", valorTotal=" + valorTotal + "]";
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public NotaFiscal getNf() {
			return nf;
		}

		public void setNf(NotaFiscal nf) {
			this.nf = nf;
		}

		public Produto getProduto() {
			return produto;
		}

		public void setProduto(Produto produto) {
			this.produto = produto;
		}

		public int getQuantidade() {
			return quantidade;
		}

		public void setQuantidade(int quantidade) {
			this.quantidade = quantidade;
		}

		public double getValorTotal() {
			return valorTotal;
		}

		public void setValorTotal(double valorTotal) {
			this.valorTotal = valorTotal;
		}
		
}
