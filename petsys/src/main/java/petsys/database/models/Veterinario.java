package petsys.database.models;

public class Veterinario {
	private int id;
	private String crmv;
	private String nome;
	private String endereco;
	private String telefoneCel;
	private String email;
	private String dataAdicao;

	public Veterinario() {
	}

	public Veterinario(int id, String crmv, String nome, String endereco, String telefoneCel, String email,
			String dataAdicao) {
		this.id = id;
		this.crmv = crmv;
		this.nome = nome;
		this.endereco = endereco;
		this.telefoneCel = telefoneCel;
		this.email = email;
		this.dataAdicao = dataAdicao;
	}

	@Override
	public String toString() {
		return "Veterinario [id=" + id + ", crmv=" + crmv + ", nome=" + nome + ", endereco=" + endereco
				+ ", telefoneCel=" + telefoneCel + ", email=" + email + ", dataAdicao=" + dataAdicao + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCrmv() {
		return crmv;
	}

	public void setCrmv(String crmv) {
		this.crmv = crmv;
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
