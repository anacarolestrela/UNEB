import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GerenciaEmail 
{
    private Map<Integer, Email> cEmail = new HashMap<>();
    private Map<String,Usuario> cUsuario = new HashMap<>();

    boolean adicionaContato(Usuario u)
    {
        if(!cUsuario.containsKey(u.getEmail()))
        {
            cUsuario.put(u.getEmail(), u);
            return true; //adicionado
        }
        return false;// nao adiciona
    }

    boolean adicionaEmail(Email e, String emailDe, String emailPara)
    {
        Usuario de = cUsuario.get(emailDe);
        if(de == null) 
            return false;
        e.setDe(de);//aqui define o email do remetente

        String[] auxPara = emailPara.split(";");
        for(String email : auxPara)
        {
            Usuario para= cUsuario.get(email);
            if (para != null) 
            {
             e.adicionaListaPara(para);   
            }
        }
        cEmail.put(e.getId(), e);
        return true;
    }

    //retorna emails dos destinatarios de um email
    ArrayList<Email> listaPara(String emailPara)
    {
        ArrayList<Email> emails = new ArrayList<>();
        for( Email e: cEmail.values())
        {
            if(e.existeEmail(emailPara))
            {
                emails.add(e);
            }
        }
        return emails;
     }

     ArrayList<Email> listaEmailNomePara(String nome) {
        ArrayList<Email> emails = new ArrayList<>();
        for (Email e : cEmail.values()) {
            for (Usuario u : e.getListaPara()) {
                if (u.getNome().equals(nome)) {
                    emails.add(e);
                    break;
                }
            }
        }
        return emails;
    }
 }
    

