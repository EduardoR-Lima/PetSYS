package petsys.database.models;

public class Atendimento {

		private int id;
		private String dataAtendimento;
		private Servico servico;
		private String motivoAtendimento;
		private Veterinario veterinario;
		private Pet pet;
		private Venda venda;

		public Atendimento() {
		}

		public Atendimento(int id, String dataAtendimento, Servico servico, String motivoAtendimento, Veterinario veterinario, Pet pet, Venda venda) {
			this.id = id;
			this.dataAtendimento = dataAtendimento;
			this.servico = servico;
			this.motivoAtendimento = motivoAtendimento;
			this.veterinario = veterinario;
			this.pet = pet;
			this.venda = venda;
		}

		@Override
		public String toString() {
			return "Atendimento [id=" + id + ", dataAtendimento=" + dataAtendimento + ", servico=" + servico
					+ ", motivoAtendimento=" + motivoAtendimento + ", veterinario=" + veterinario + ", pet=" + pet
					+ ", venda=" + venda + "]";
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getDataAtendimento() {
			return dataAtendimento;
		}

		public void setDataAtendimento(String dataAtendimento) {
			this.dataAtendimento = dataAtendimento;
		}

		public Servico getServico() {
			return servico;
		}

		public void setServico(Servico servico) {
			this.servico = servico;
		}

		public String getMotivoAtendimento() {
			return motivoAtendimento;
		}

		public void setMotivoAtendimento(String motivoAtendimento) {
			this.motivoAtendimento = motivoAtendimento;
		}

		public Veterinario getVeterinario() {
			return veterinario;
		}

		public void setVeterinario(Veterinario veterinario) {
			this.veterinario = veterinario;
		}

		public Pet getPet() {
			return pet;
		}

		public void setPet(Pet pet) {
			this.pet = pet;
		}

		public Venda getVenda() {
			return venda;
		}

		public void setVenda(Venda venda) {
			this.venda = venda;
		}
		
}
