package com.exercicio.contaBancaria.service;

import com.exercicio.contaBancaria.model.ContaModel;
import com.exercicio.contaBancaria.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service
public class ContaService {

    @Autowired
    ContaRepository contaRepository;

    //exibir todas as contas
    public List<ContaModel> exibirTodasContas() {return contaRepository.findAll();}

    //exibir uma conta especifica
    public Optional<ContaModel> exibirContaEspecifica(Long id) {return contaRepository.findById(id);}

    //cadastro de nova conta
    public ContaModel cadastrarNovaConta (ContaModel contaModel) {return contaRepository.save(contaModel);}

    //deleção de uma conta
    public void deletarConta(Long id) {contaRepository.deleteById(id);}

    //atualização do valor atual caso tenha um depósito ou saque
    public ContaModel atualizarDepositoSaque (Long id, ContaModel contaModel){

        ContaModel contaModel1 = exibirContaEspecifica(id).get();

        contaModel1.setValorFornecido(contaModel.getValorFornecido());

        if (contaModel.getTipoServico().equalsIgnoreCase("deposito")){
            contaModel1.setValorAtual(contaModel1.getValorAtual() + contaModel1.getValorFornecido());
        } if (contaModel.getTipoServico().equalsIgnoreCase("saque")){
            contaModel1.setValorAtual(contaModel1.getValorAtual() - contaModel1.getValorFornecido());
        }

        return contaRepository.save(contaModel);
    }
}
