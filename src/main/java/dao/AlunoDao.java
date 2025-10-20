package dao;

import model.Aluno;

import javax.persistence.EntityManager;

public class AlunoDao {
    private EntityManager em;

    public AlunoDao(EntityManager em) {
        this.em = em;
    }

    public void save(Aluno aluno) {
        em.persist(aluno);
    }
}
