package com.exercicio.contaBancaria.controller;

import com.exercicio.contaBancaria.dto.ContaDto;
import com.exercicio.contaBancaria.model.ContaModel;
import com.exercicio.contaBancaria.service.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class ContaController {

    @Autowired
    ContaService contaService;

    //endpoint
    //GET - exibir todas as contas
    @GetMapping(path = "/contabancaria")
    public List<ContaModel> exibirTodasContas(){return contaService.exibirTodasContas();}

    //GET - exibir uma conta especifica
    @GetMapping(path = "/contabancaria/{id}")
    public Optional<ContaModel> exibirContaEspecifica(@PathVariable Long id){return contaService.exibirContaEspecifica(id);}

    //POST - cadastro de nova conta
    @PostMapping(path = "/contabancaria")
    @ResponseStatus(HttpStatus.CREATED)
    public ContaModel cadastrarNovaConta (@Valid @RequestBody ContaDto contaDto){return contaService.cadastrarNovaConta(contaDto.toModel());}

    //DELETE - deleção de uma conta
    @DeleteMapping(path = "/contabancaria/{id}")
    public void deletarConta(@PathVariable Long id){contaService.deletarConta(id);}

    //PUT - atualização do valor atual caso tenha um depósito ou saque
    @PutMapping(path = "/contabancaria/{id}")
    public ContaModel atualizarDepositoSaque(@PathVariable Long id, @RequestBody ContaModel contaModel){return contaService.atualizarDepositoSaque(id, contaModel);}

}
