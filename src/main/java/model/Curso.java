package model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "cursos")
public class Curso {
    private Long id;
    private String nome;
    private String descricao;
    private Integer cargaHoraria;
    private Professor professorId;

    public Curso() {
    }

    public Curso(String nome, String descricao, Integer cargaHoraria, Professor professorId) {
        this.nome = nome;
        this.descricao = descricao;
        this.cargaHoraria = cargaHoraria;
        this.professorId = professorId;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public Integer getCargaHoraria() {
        return cargaHoraria;
    }

    public Professor getProfessorId() {
        return professorId;
    }
}
