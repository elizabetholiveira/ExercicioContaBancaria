package com.exercicio.contaBancaria.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.convert.DataSizeUnit;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Size;

@Entity
@Table(name = "TB_CONTAS")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContaModel {

    //uma conta deve possuir

    //id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //numero de conta
    @Column(nullable = false)
    @Max(9)
    private Long numConta;

    //agencia
    @Column(nullable = false)
    @Max(5)
    private Long numAgencia;

    //nome do usuario
    @Column(length = 50, nullable = false)
    private String nomeUsuario;

    //valor atual da conta
    @Column
    private Double valorAtual;

    //valor  final
    @Column
    private Double valorFinal;

    //valor fornecido para saque ou deposito (valor a ser acrescido ou subtraído no valor final)
    @Column
    private Double valorFornecido;

    //tipo de serviço (saque ou deposito)
    @Column(length = 8)
    private String tipoServico;
}
