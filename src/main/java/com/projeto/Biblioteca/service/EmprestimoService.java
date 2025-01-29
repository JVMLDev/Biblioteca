/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projeto.Biblioteca.service;

import com.projeto.Biblioteca.models.Emprestimo;
import com.projeto.Biblioteca.repository.EmprestimoRepository;
import java.time.LocalDate;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author aluno.lauro
 */
@Service
public class EmprestimoService {
    private final EmprestimoRepository emprestimoRepository;
    
    public EmprestimoService(EmprestimoRepository emprestimoRepository){
        this.emprestimoRepository = emprestimoRepository;
    }
    
    public List<Emprestimo> listarTodosEmprestimos(){
        return this.emprestimoRepository.findAll();
    }
    
    public Emprestimo inserir (String id_usuario, int id_livro){
        LocalDate data_emprestimo = LocalDate.now();
        if(!id_usuario.isBlank() && !id_usuario.isEmpty()){
            Emprestimo ep = new Emprestimo();
            ep.getId_livro();
            ep.getId_usuario();
            ep.setData_emprestimo(data_emprestimo);
            ep.setData_devolucao(data_emprestimo.plusDays(15));
            return this.emprestimoRepository.save(ep);
        }else{
            System.out.println("Usuario ou livro nao encontrado");            
        }
        return null;   
    }
    
    public Emprestimo atualizar(int id){
        Emprestimo emp = this.emprestimoRepository.findById(id).orElseThrow(()-> new RuntimeException
        ("Emprestimo nao encontrado"));
        emp.setData_devolucao(emp.getData_devolucao().plusDays(15));
        return this.emprestimoRepository.save(emp);
    }
    
    public void deletar(int id){
        this.emprestimoRepository.deleteById(id);
    }
    
}
