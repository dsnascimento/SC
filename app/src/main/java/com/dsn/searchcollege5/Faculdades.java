package com.dsn.searchcollege5;

public class Faculdades {
    private String nome;
    private String sobre;
    private int imagem; // vai armazenar o identificador do recurso
    private String endereco;
    private String cidade;
    private String curso;

    public Faculdades(String nome, String endereco, int imagem, String cidade,String sobre,String curso) {

        this.nome = nome;
        this.endereco = endereco;
        this.imagem = imagem;
        this.cidade = cidade;
        this.sobre = sobre;
        this.curso = curso;
    }
// métodos getters e setters


    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getSobre() {
        return sobre;
    }

    public void setSobre(String sobre) {
        this.sobre = sobre;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getImagem() {
        return imagem;
    }

    public void setImagem(int imagem) {
        this.imagem = imagem;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
}

