/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projeto.Biblioteca.service;

import com.projeto.Biblioteca.models.Livros;
import com.projeto.Biblioteca.models.Usuario;
import com.projeto.Biblioteca.repository.LivrosRepository;
import com.projeto.Biblioteca.repository.UsuarioRepository;
import java.util.List;

/**
 *
 * @author aluno.lauro
 */
public class UsuarioService {
 
    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }
    
    public List<Usuario> listarTodos(){
        return this.usuarioRepository.findAll();
    }
    
    public Usuario inserir(String cpf, String nome, String email){
        if(!cpf.isBlank() && !nome.isBlank() && !email.isEmpty()){
            Usuario u = new Usuario();
            u.setCpf(cpf);
            u.setNome(nome);
            u.setEmail(email);
            return this.usuarioRepository.save(u);
        }
        return null;
    }
    
    public Usuario atualizar(String id,String nome,String email){
        Usuario usuario = this.usuarioRepository.findById(id).orElseThrow(()-> new RuntimeException("Livro nao encontrado!"));
        usuario.setNome(nome);
        usuario.setEmail(email);
        return this.usuarioRepository.save(usuario);
    }
    
    public void deletar(String id){
        this.usuarioRepository.deleteById(id);
    }
}
