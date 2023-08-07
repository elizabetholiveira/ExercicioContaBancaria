package com.exercicio.contaBancaria.dto;

import com.exercicio.contaBancaria.model.ContaModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.convert.DataSizeUnit;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Size;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContaDto {

    //uma conta deve possuir

    //id
    private Long id;

    //numero de conta
    @Max(9)
    private Long numConta;

    //agencia
    @Max(5)
    private Long numAgencia;

    //nome do usuario
    private String nomeUsuario;

    //valor atual da conta
    private Double valorAtual;

    //valor  final
    private Double valorFinal;

    //valor fornecido para saque ou deposito (valor a ser acrescido ou subtraído no valor final)
    private Double valorFornecido;

    //tipo de serviço (saque ou deposito)
    private String tipoServico;

    public ContaModel toModel(){return new ContaModel(id,numConta,numAgencia,nomeUsuario,valorAtual,valorFinal,valorFornecido,tipoServico);}
}