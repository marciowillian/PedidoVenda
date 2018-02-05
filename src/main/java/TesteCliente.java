import com.mwcc.pedidovenda.model.*;

import javax.persistence.*;
import java.math.BigDecimal;

public class TesteCliente {
    public static void main(String[]args){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("PedidoPU");
        EntityManager manager = factory.createEntityManager();

        EntityTransaction trx = manager.getTransaction();
        trx.begin();

        Cliente cliente = new Cliente();

        cliente.setNome("João das Couves");
        cliente.setEmail("joao@dascouves.com");
        cliente.setDocumentoReceitaFederal("123.133.123.12");
        cliente.setTipo(TipoPessoa.FISICA);

        Endereco en = new Endereco();
        en.setLogradouro("Rua das Aboboras Vermelhas");
        en.setNumero("111");
        en.setCidade("Uberlândia");
        en.setUf("MG");
        en.setCep("38400-000");
        en.setCliente(cliente);

        cliente.getEnderecos().add(en);

        manager.persist(cliente);

        trx.commit();

    }
}
