package com.vitoriana.farma.controller;

import java.util.List;

import com.vitoriana.farma.model.Funcionario;
import com.vitoriana.farma.persistence.FuncionarioService;

public class FuncionarioController {

    private List<Funcionario> funcionarios;

    private FuncionarioService funcionarioService;

    public FuncionarioController() {
        this.funcionarioService = new FuncionarioService();

        this.funcionarios = (List<Funcionario>) funcionarioService.listar();
    }

    public boolean cadastrarFuncionario(Funcionario funcionario) {
        Funcionario cadastrado = funcionarioService.registrar(funcionario);

        if (cadastrado == null)
            return false;

        this.funcionarios.add(cadastrado);

        return true;
    }

    public boolean listarFuncionarios() {
        this.funcionarios = (List<Funcionario>) funcionarioService.listar();

        return true;
    }

    public boolean atualizarFuncionario(int index, Funcionario funcionario) {
        Funcionario atualizado = funcionarioService.atualizar(funcionario);

        if (atualizado == null)
            return false;

        this.funcionarios.set(index, atualizado);

        return true;
    }

    public boolean removerFuncionario(int index, Funcionario funcionario) {
        Funcionario removido = funcionarioService.deletar(funcionario);

        if (removido == null)
            return false;

        this.funcionarios.remove(index);

        return true;
    }
    
    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }
}
