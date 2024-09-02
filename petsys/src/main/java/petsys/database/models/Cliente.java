package petsys.database.models;

public class Cliente {
	private int id;
	private String cpf;
	private String nome;
	private String endereco;
	private String telefoneCel;
	private String email;
	private String dataAdicao;
	
	public Cliente() {
	}
	
	public Cliente(int id, String cpf, String nome, String endereco, String telefoneCel, String email, String dataAdicao) {
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
	
}
