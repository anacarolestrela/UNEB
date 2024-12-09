import java.util.List;
import java.util.ArrayList;

public class Email 
{
private Integer id;
private String assunto;
private String mensagem;
private Usuario de;
private List<Usuario> listaPara = new ArrayList<>();


public Integer getId() {
    return id;
}
public void setId(Integer id) {
    this.id = id;
}
public String getAssunto() {
    return assunto;
}
public void setAssunto(String assunto) {
    this.assunto = assunto;
}
public String getMensagem() {
    return mensagem;
}
public void setMensagem(String mensagem) {
    this.mensagem = mensagem;
}
public Usuario getDe() {
    return de;
}
public void setDe(Usuario de) {
    this.de = de;
}
public List<Usuario> getListaPara() {
    return listaPara;
}
public void setListaPara(List<Usuario> listaPara) {
    this.listaPara = listaPara;
}
public Email(Integer id, String assunto, String mensagem, Usuario de, List<Usuario> listaPara) {
    this.id = id;
    this.assunto = assunto;
    this.mensagem = mensagem;
    this.de = de;
    this.listaPara = listaPara;
}

public Email() {
    //TODO Auto-generated constructor stub
}
public boolean existeEmail(String email)
{
    for(Usuario usuario: listaPara)
    {
        if(usuario.getEmail().equals(email))
        {
            return true;
        }
    }
    return false;
}

public boolean adicionaListaPara(Usuario u)
{
    if(!listaPara.contains(u))
    {
        listaPara.add(u);
        return true;
    }
    return false;
}
@Override
public String toString() {
    return "\n\nDe:" + de + "\nPara:" + listaPara + "]\nAssunto:" + assunto + "\nMensagem:" + mensagem  ;
}



}
