package petsys.database.models;

public class ProdutoVendido {
		private int sequencia;
		private NotaFiscal nf;
		private Produto produto;
		private int quantidade;
		private double valorTotal;

		public ProdutoVendido() {
		}

		public ProdutoVendido(int sequencia, NotaFiscal nf, Produto produto, int quantidade, double valorTotal) {
				this.sequencia = sequencia;
				this.nf = nf;
				this.produto = produto;
				this.quantidade = quantidade;
				this.valorTotal = valorTotal;
		}
		@Override
		public String toString() {
			return "ProdutoVendido [sequencia=" + sequencia + ", nf=" + nf + ", produto=" + produto + ", quantidade="
					+ quantidade + ", valorTotal=" + valorTotal + "]";
		}

		public int getSequencia() {
			return sequencia;
		}

		public void setSequencia(int sequencia) {
			this.sequencia = sequencia;
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
