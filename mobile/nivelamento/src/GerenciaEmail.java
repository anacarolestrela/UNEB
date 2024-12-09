import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GerenciaEmail {
    private Map<String, Email> cEmail = new HashMap<>();
    private Map<String, Usuario> cUsuario = new HashMap<>();

    public boolean adicionaContato(Usuario u)
    {
        if(!cUsuario.containsKey(u.getEmail())){
            cUsuario.put(u.getEmail(), u);
            return true;
        }
        return false;
    }

    public boolean adicionaEmail(Email e, String emailDe,String emailPara)
    {
       Usuario userDe = cUsuario.get(emailDe);
       if (userDe!=null) 
       {
            e.setDe(userDe);

            String[] tempPara = emailPara. split(";");
            for(String email : tempPara)
            {
                Usuario usuarioPara = cUsuario.get(email);
                if(usuarioPara != null)
                {
                    e.adicionaListaPara(usuarioPara);
                }
            }
        cEmail.put(e.getId().toString(), e);
        return true;
       }
       return false;
    }

    public ArrayList<Email> listaEmailPara(String emailPara)
    {
        ArrayList<Email> emails = new ArrayList<>();
        for(Email e : cEmail.values()){
            if(e.existeEmail(emailPara))
            {
                emails.add(e);
            }
        }
        return emails;
    }

}
