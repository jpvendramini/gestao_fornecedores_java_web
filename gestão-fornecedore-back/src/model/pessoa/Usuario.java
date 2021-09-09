package model.pessoa;

public class Usuario {
    private String login;
    private String senha;
    private Pessoa pessoa;

    public Usuario(String login, String senha, Pessoa pessoa) {
        this.login = login;
        this.senha = senha;
        this.pessoa = pessoa;
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }
}
