package petsys.database.models;

import java.util.HashMap;

public class Cliente implements Model {
	private Integer id;
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

	public static class ClienteSearchKey extends AbstractSearchKey<Cliente> {
		public static final ClienteSearchKey ID;
		public static final ClienteSearchKey CPF;
		public static final ClienteSearchKey NOME;
		public static final ClienteSearchKey ENDERECO;
		public static final ClienteSearchKey TELEFONE_CEL;
		public static final ClienteSearchKey EMAIL;
		public static final ClienteSearchKey DATA_ADICAO;

		private ClienteSearchKey(String name, String... keys) {
			super(keys, name);
		}

		static {
			ID = new ClienteSearchKey("Id", "id");
			CPF = new ClienteSearchKey("CPF", "cpf");
			NOME = new ClienteSearchKey("Nome", "nome");
			ENDERECO = new ClienteSearchKey("Endereço", "endereco");
			TELEFONE_CEL = new ClienteSearchKey("Tel./Cel.", "tel_cel");
			EMAIL = new ClienteSearchKey("E-mail", "email");
			DATA_ADICAO = new ClienteSearchKey("Data de A.", "data_adicao"); 
		}
	}

}
