package br.com.molina.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_quiz")
public class Quiz {
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
    
    @Column(name = "nome", nullable = false)
	private String nome;
	
//    @OneToMany(
//            cascade = CascadeType.ALL,
//            orphanRemoval = true
//    )
//    private List<Enquete> enquetes = new ArrayList<>();

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
//	public List<Enquete> getEnquetes() {
//		return enquetes;
//	}
//	public void setEnquetes(List<Enquete> enquetes) {
//		this.enquetes = enquetes;
//	}

	

}
