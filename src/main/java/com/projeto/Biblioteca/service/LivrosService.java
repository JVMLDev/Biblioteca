/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projeto.Biblioteca.service;

import com.projeto.Biblioteca.models.Livros;
import com.projeto.Biblioteca.repository.LivrosRepository;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author aluno.lauro
 */
@Service
public class LivrosService {
     private final LivrosRepository livrosRepository;

    public LivrosService(LivrosRepository livrosRepository){
        this.livrosRepository = livrosRepository;
    }
    
    public List<Livros> listarTodos(){
        return this.livrosRepository.findAll();
    }
    
    public Livros inserir(String nome, String autor){
        if(!nome.isBlank() && !autor.isEmpty()){
            Livros l = new Livros();
            l.setNome(nome);
            l.setAutor(autor);
            return this.livrosRepository.save(l);
        }
        return null;
    }
    
    public Livros atualizar(int id,String nome,String autor){
        Livros livro = this.livrosRepository.findById(id).orElseThrow(()-> new RuntimeException("Livro nao encontrado!"));
        livro.setNome(nome);
        livro.setAutor(autor);
        return this.livrosRepository.save(livro);
    }
    
    public void deletar(int id){
        this.livrosRepository.deleteById(id);
    }
}
