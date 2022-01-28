package br.org.generation.farmacia.model;


	import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

		@Entity
		@Table(name = "tb_produto")
		public class produto {

			@Id
			@GeneratedValue(strategy = GenerationType.IDENTITY)
			private Long id;
			
			@NotBlank(message = "O atributo título é obrigatório!!")
			@Size(min = 5, max = 100, message = "O atributo nome deve conter entre 5 a 100 caracteres")
			private String nome;
			
			@NotBlank(message = "O atributo descrião é obrigatório!!")
			@Size(min = 10, max = 200, message = "O atributo descrição deve conter entre 10 a 200 caracteres")	
			private String descricao;
			

			@JsonFormat(shape = JsonFormat.Shape.STRING)
			@NotNull(message = "Preço é obrigatório!")
			@Positive(message = "O preço deve ser maior que zero!")
			private BigDecimal preco;
			
			@Column(name = "data_Validade")
			@JsonFormat(pattern = "yyyy-MM-dd")
			private LocalDateTime dataVencimento;
			
			@ManyToOne
			@JsonIgnoreProperties("produto")
			public categoria categoria;

			public Long getId() {
				return id;
			}

			public void setId(Long id) {
				this.id = id;
			}

			public String getNome() {
				return nome;
			}

			public void setNome(String nome) {
				this.nome = nome;
			}

			public String getDescricao() {
				return descricao;
			}

			public void setDescricao(String descricao) {
				this.descricao = descricao;
			}

			public BigDecimal getPreco() {
				return preco;
			}

			public void setPreco(BigDecimal preco) {
				this.preco = preco;
			}

			public LocalDateTime getDataVencimento() {
				return dataVencimento;
			}

			public void setDataVencimento(LocalDateTime dataVencimento) {
				this.dataVencimento = dataVencimento;
			}

			public categoria getCategoria() {
				return categoria;
			}

			public void setCategoria(categoria categoria) {
				this.categoria = categoria;
			}

	}




