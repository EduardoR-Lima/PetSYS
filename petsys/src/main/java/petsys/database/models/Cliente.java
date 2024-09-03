package petsys.database.models;

public class Cliente implements Model {
	private int id;
	private String cpf;
	private String nome;
	private String endereco;
	private String telefoneCel;
	private String email;
	private String dataAdicao;

	public Cliente() {
	}

	public Cliente(int id, String cpf, String nome, String endereco, String telefoneCel, String email,
			String dataAdicao) {
		this.id = id;
		this.cpf = cpf;
		this.nome = nome;
		this.endereco = endereco;
		this.telefoneCel = telefoneCel;
		this.email = email;
		this.dataAdicao = dataAdicao;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", cpf=" + cpf + ", nome=" + nome + ", endereco=" + endereco + ", telefoneCel="
				+ telefoneCel + ", email=" + email + ", dataAdicao=" + dataAdicao + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefoneCel() {
		return telefoneCel;
	}

	public void setTelefoneCel(String telefoneCel) {
		this.telefoneCel = telefoneCel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDataAdicao() {
		return dataAdicao;
	}

	public void setDataAdicao(String dataAdicao) {
		this.dataAdicao = dataAdicao;
	}

	public static class ClienteSearchKeys extends AbstractSearchKeys<Cliente> {
		public static final ClienteSearchKeys ID;
		public static final ClienteSearchKeys CPF;
		public static final ClienteSearchKeys NOME;
		public static final ClienteSearchKeys ENDERECO;
		public static final ClienteSearchKeys TELEFONE_CEL;
		public static final ClienteSearchKeys EMAIL;
		public static final ClienteSearchKeys DATA_ADICAO;

		private ClienteSearchKeys(String[] keys, String name) {
			super(keys, name);
		}

		static {
			ID = new ClienteSearchKeys(new String[]{"id"}, "Id");
			CPF = new ClienteSearchKeys(new String[]{"cpf"}, "CPF");
			NOME = new ClienteSearchKeys(new String[]{"nome"}, "Nome");
			ENDERECO = new ClienteSearchKeys(new String[]{"endereco"}, "Endereço");
			TELEFONE_CEL = new ClienteSearchKeys(new String[]{"tel_cel"}, "Tel./Cel.");
			EMAIL = new ClienteSearchKeys(new String[]{"email"}, "E-mail");
			DATA_ADICAO = new ClienteSearchKeys(new String[]{"data_adicao"}, "Data de A."); 
		}
	}

}
