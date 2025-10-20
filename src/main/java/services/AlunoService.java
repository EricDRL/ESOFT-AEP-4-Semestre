package services;

import dao.AlunoDao;
import model.Aluno;
import util.JPAUtil;

import javax.persistence.EntityManager;

public class AlunoService {

    public AlunoService() {}

    public void cadastrarAluno(Aluno aluno) {
        EntityManager em = JPAUtil.getEntityManager();
        AlunoDao alunoDao = new AlunoDao(em);

        try {
            em.getTransaction().begin();
            alunoDao.save(aluno);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new RuntimeException("Erro ao cadastrar aluno.", ex);
        } finally {
            if (em.isOpen()) {
                em.close();
            }
        }

    }
}
