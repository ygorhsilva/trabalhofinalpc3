package br.com.prog3.Trabfinal.domain;

import javax.persistence.*;

@Entity

public class Categoria {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)

	
	private Integer codigo;
	private String nome;
	private Double desconto;
	

	public Categoria() {
		
	}
	
	
	public Integer getCodigo() {
		return codigo;
	}




	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}




	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public Double getDesconto() {
		return desconto;
	}


	public void setDesconto(Double desconto) {
		this.desconto = desconto;
	}
	
	@ManyToOne
	@JoinColumn(name="id_produto",nullable=true,updatable=true)
	private Produto produto;

}
