package br.org.generation.farmacia.model;


	import java.util.List;

	import javax.persistence.CascadeType;
	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
	import javax.persistence.OneToMany;
	import javax.persistence.Table;
	import javax.validation.constraints.NotBlank;

	import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

	@Entity
		@Table(name = "tb_categorias")
		public class categoria {

			@Id
			@GeneratedValue(strategy = GenerationType.IDENTITY)
			private Long id;
			
			@NotBlank(message = "O atributo setor é obrigatório!!")
			private String setor;
			
				
			@OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL)
			@JsonIgnoreProperties("categoria")
			private List<produto> produto;


			public Long getId() {
				return id;
			}


			public void setId(Long id) {
				this.id = id;
			}


			public String getSetor() {
				return setor;
			}


			public void setSetor(String setor) {
				this.setor = setor;
			}


			public List<produto> getProduto() {
				return produto;
			}


			public void setProduto(List<produto> produto) {
				this.produto = produto;
			}


			
	}


	



