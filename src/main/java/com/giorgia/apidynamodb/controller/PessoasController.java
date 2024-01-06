package com.giorgia.apidynamodb.controller;

import com.giorgia.apidynamodb.model.Pessoas;
import com.giorgia.apidynamodb.service.PessoasService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api")
public class PessoasController {
    private final PessoasService pessoasService;

    public PessoasController(PessoasService pessoasService) {
        this.pessoasService = pessoasService;
    }

    @GetMapping
    public Iterable<Pessoas> getAll(){
        return pessoasService.getAll();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> findById(@PathVariable String id){
        Pessoas pessoa = pessoasService.findById(id);
        return ResponseEntity.ok().body(pessoa);
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Pessoas pessoa){
        try {
            pessoasService.save(pessoa);
        }catch (Exception e){
            return ResponseEntity.badRequest().body("O cadastro falhou");
        }

        return ResponseEntity.ok().body("Cadastro realizado com sucesso.");
    }
}
