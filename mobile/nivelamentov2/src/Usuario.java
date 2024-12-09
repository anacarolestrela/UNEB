public class Usuario 
{
    private String nome;
    private String email;
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Usuario() {

    }
    

    // testa se o obj atual é igual ao passado no obj o)
    @Override
    public boolean equals(Object o)
    {
        if(this == o)
        return true;
        if (o == null || getClass() != o.getClass())
        return false;

        //cast para comprar os atributos especificos da classe usuario
        Usuario usuario = (Usuario) o;
        
        return email != null && email.equals(usuario.email);

    }
    
    @Override
    public String toString() {
        return "\nUsuario [nome:" + nome + "\nemail:" + email + "]\n";
    }
}