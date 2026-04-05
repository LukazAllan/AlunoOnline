package br.com.alunoonline.api.controller;

import br.com.alunoonline.api.model.Aluno;
import br.com.alunoonline.api.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    AlunoService alunoService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Aluno> getAllAlunos(){
        return alunoService.getAllAlunos();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Aluno> getAlunoById(@PathVariable Long id){
        return alunoService.getAlunoById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void newAluno(@RequestBody Aluno aluno){
        alunoService.newAluno(aluno);
    }
}
