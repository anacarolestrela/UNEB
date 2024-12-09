public class Usuario 
{
    private String nome;
    private String email;


    public Usuario()
    {
        
    }
    public Usuario(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    public String getNome() 
    {
        return nome; 
    }

    public void setNome(String nome) 
    {
        this.nome = nome;
    }    

    public String getEmail() 
    {
        return email;
    }

    public void setEmail(String email) 
    {
        this.email = email;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Usuario other = (Usuario) obj;
        if (email == null) {
            if (other.email != null)
                return false;
        } else if (!email.equals(other.email))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Usuario [nome=" + nome + ", email=" + email + "]";
    }

}
