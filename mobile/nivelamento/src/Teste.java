public class Teste {
    public static void main(String[] args) {
        GerenciaEmail ge = new GerenciaEmail();
        
        Usuario[] u = new Usuario[3];
        u[0] = new Usuario(); u[0].setEmail("carla@gmail.com"); u[0].setNome("carla"); ge.adicionaContato(u[0]);
        u[1] = new Usuario(); u[1].setEmail("pedro@gmail.com"); u[1].setNome("pedro"); ge.adicionaContato(u[1]);
        u[2] = new Usuario(); u[2].setEmail("maria@gmail.com"); u[2].setNome("maria"); ge.adicionaContato(u[2]);

        Email[] e = new Email[3];
        e[0] = new Email(); e[0].setId(1); e[0].setAssunto("Data da Prova"); e[0].setMensagem("Prezados, Data da prova dia 18/04/2008");
        ge.adicionaEmail(e[0], "pedro@gmail.com", "carla@gmail.com;maria@gmail.com");

        e[1] = new Email(); e[1].setId(2); e[1].setAssunto("Lista de Exercício"); e[1].setMensagem("Prezados, Segue anexo lista de exercício. Att, Maria");
        ge.adicionaEmail(e[1], "maria@gmail.com", "carla@gmail.com;pedro@gmail.com");

        e[2] = new Email(); e[2].setId(3); e[2].setAssunto("Festa"); e[2].setMensagem("Prezados, A festa sera dia 20/06 ás 18:00");
        ge.adicionaEmail(e[2], "pedro@gmail.com", "carla@gmail.com");

        System.out.println(ge.listaEmailPara("pedro"));
        System.out.println(ge.listaEmailPara("carla@gmail.com"));
    }
}
