package br.com.alunoonline.api.repository;

import br.com.alunoonline.api.model.Disciplina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface DisciplinaRepository extends JpaRepository<Disciplina, Long> {

    // O Spring gera o SQL: SELECT * FROM disciplina WHERE professor_id = ?
    List<Disciplina> findByProfessorId(Long professorId);
}