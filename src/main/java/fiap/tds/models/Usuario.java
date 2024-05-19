package fiap.tds.models;

public class Usuario {
    private String nome;
    private String sobrenome;
    private String cpf_usuario;
    private String cargo;
    private String email_usuario;
    private String telefone;
    private String empresa;
    private int nr_funcionarios;
    private String pais;
    private String idioma;
    private String senha;


    public Usuario() {
    }

    public Usuario(String nome, String sobrenome, String cpf_usuario, String cargo, String email_usuario, String telefone, String empresa, int nr_funcionarios, String pais, String idioma, String senha) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf_usuario = cpf_usuario;
        this.cargo = cargo;
        this.email_usuario = email_usuario;
        this.telefone = telefone;
        this.empresa = empresa;
        this.nr_funcionarios = nr_funcionarios;
        this.pais = pais;
        this.idioma = idioma;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getCpf_usuario() {
        return cpf_usuario;
    }

    public String getCargo() {
        return cargo;
    }

    public String getEmail_usuario() {
        return email_usuario;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmpresa() {
        return empresa;
    }

    public int getNr_funcionarios() {
        return nr_funcionarios;
    }

    public String getPais() {
        return pais;
    }

    public String getIdioma() {
        return idioma;
    }

    public String getSenha() {
        return senha;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public void setCpf_usuario(String cpf_usuario) {
        this.cpf_usuario = cpf_usuario;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public void setEmail_usuario(String email_usuario) {
        this.email_usuario = email_usuario;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public void setNr_funcionarios(int nr_funcionarios) {
        this.nr_funcionarios = nr_funcionarios;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
