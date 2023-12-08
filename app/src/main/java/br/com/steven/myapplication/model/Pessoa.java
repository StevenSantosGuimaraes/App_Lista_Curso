package br.com.steven.myapplication.model;

public class Pessoa {

    private String primeiroNome;
    private String sobrenome;
    private String cursoDesejado;
    private String telefoneContato;

    public Pessoa(String primeiroNome, String sobrenome, String cursoDesejado, String telefoneContato) {
        this.primeiroNome = primeiroNome;
        this.sobrenome = sobrenome;
        this.cursoDesejado = cursoDesejado;
        this.telefoneContato = telefoneContato;
    }

    @Override
    public String toString() {
        return primeiroNome + sobrenome;
    }

    public String getPrimeiroNome() {
        return primeiroNome;
    }

    public void setPrimeiroNome(String primeiroNome) {
        this.primeiroNome = primeiroNome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getCursoDesejado() {
        return cursoDesejado;
    }

    public void setCursoDesejado(String cursoDesejado) {
        this.cursoDesejado = cursoDesejado;
    }

    public String getTelefoneContato() {
        return telefoneContato;
    }

    public void setTelefoneContato(String telefoneContato) {
        this.telefoneContato = telefoneContato;
    }

}
