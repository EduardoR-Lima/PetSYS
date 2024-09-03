package petsys.database.models;

public class Pet implements Model{
	private int id;
	private String nome;
	private String dataNascimento;
	private String especie;
	private String raca;
	private String sexo;
	private String dataAdicao;
	private Cliente dono;

	public Pet () {
	}

	public Pet (int id, String nome, String dataNascimento, String especie, String raca, String sexo, String dataAdicao, Cliente dono) {
			this.id = id;
			this.nome = nome;
			this.dataNascimento = dataNascimento;
			this.especie = especie;
			this.raca = raca;
			this.sexo = sexo;
			this.dataAdicao = dataAdicao;
			this.dono = dono;
	}

	@Override
	public String toString() {
		return "Pet [id=" + id + ", nome=" + nome + ", dataNascimento=" + dataNascimento + ", especie=" + especie
				+ ", raca=" + raca + ", sexo=" + sexo + ", dataAdicao=" + dataAdicao + ", dono=" + dono + "]";
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

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	public String getRaca() {
		return raca;
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getDataAdicao() {
		return dataAdicao;
	}

	public void setDataAdicao(String dataAdicao) {
		this.dataAdicao = dataAdicao;
	}

	public Cliente getDono() {
		return dono;
	}

	public void setDono(Cliente dono) {
		this.dono = dono;
	}		
	
	
}
