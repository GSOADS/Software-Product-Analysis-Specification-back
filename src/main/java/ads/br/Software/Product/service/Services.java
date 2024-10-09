package ads.br.Software.Product.service;

import ads.br.Software.Product.Db.DbLista;
import ads.br.Software.Product.Db.DbNomeDaLista;
import ads.br.Software.Product.repository.DbDonoDaListaRepository;
import ads.br.Software.Product.repository.DbListaRepository;
import ads.br.Software.Product.request.Request;
import ads.br.Software.Product.response.Response;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class Services {


    private Request request;

    @Autowired
    private DbListaRepository dbListaRepository;

    @Autowired
    private DbDonoDaListaRepository dbDonoDaListaRepository;


    private Response response = new Response();
    private DbNomeDaLista dbNomeDaLista = new DbNomeDaLista();
    private List<DbLista> dbListas;
    private DbLista dbLista = new DbLista();

    public void create(Request request)
    {
        try
        {//Verifica se o nome da lista existe se exitir pega o id e nome da lista cola na lista e salva
            dbNomeDaLista = dbDonoDaListaRepository.findbynome(request.getDbNomeDaLista().getNomeDaSuaLista());
            request.getDbLista().size();
            for (int i = 0; i < request.getDbLista().size(); i++)
            {
                request.getDbLista().get(i).setIdDbNomeLista(dbNomeDaLista.getId());
                request.getDbLista().get(i).setNomeDaSuaLista(dbNomeDaLista.getNomeDaSuaLista());
                dbListaRepository.save(request.getDbLista().get(i));

            }

//            System.out.println("tamanho da lista " + request.getDbLista().size());
//            System.out.println("tamanho da lista elemento "+ request.getDbLista().get(0));
//            System.out.println("tamanho da lista elemento" + request.getDbLista().get(1));

        }
        catch (Exception e)
        {
            dbNomeDaLista = dbDonoDaListaRepository.save(request.getDbNomeDaLista());
            for (int i = 0; i < request.getDbLista().size(); i++)
            {
                request.getDbLista().get(i).setIdDbNomeLista(dbNomeDaLista.getId());
                request.getDbLista().get(i).setNomeDaSuaLista(dbNomeDaLista.getNomeDaSuaLista());
                System.out.println("o que tem dentro " + request.getDbLista().get(i));
                dbListaRepository.save(request.getDbLista().get(i));

            }

            System.out.println("Deu bom");

        }

    }

    public Response obterNomeELista(String nomeDaLista)
    {

        try
        {
            dbNomeDaLista = dbDonoDaListaRepository.findbynome(nomeDaLista);
            dbListas=dbListaRepository.findbynomeDaSuaLista(dbNomeDaLista.getNomeDaSuaLista());
            response.setDbNomeDaLista(dbNomeDaLista);
            response.setDbLista(dbListas);

            return response;



        }catch (Exception e)

        {

        }


        return null;
    }

    public Response  atualizaItensLista(Request request)
    {
        for (int i = 0; i < request.getDbLista().size(); i++)
        {
            if(request.getDbLista().get(i).getItemLista().isEmpty()||request.getDbLista().get(i).getItemLista()==null)
            {
                long x = Long.parseLong(String.valueOf(request.getDbLista().get(i).getId()));
                System.out.println("Item nulo ou vazio --> "+x);
                dbListaRepository.deleteById(x);



            }else
            {
                long x = Long.parseLong(String.valueOf(request.getDbLista().get(i).getId()));
                System.out.println("Tem alguma coisa no item --> " +x);
                dbLista = request.getDbLista().get(i);
                dbListaRepository.save(dbLista);




            }
//
//            request.getDbLista().get(i).setIdDbNomeLista(dbNomeDaLista.getId());
//            request.getDbLista().get(i).setNomeDaSuaLista(dbNomeDaLista.getNomeDaSuaLista());
//            System.out.println("o que tem dentro " + request.getDbLista().get(i));
//            dbListaRepository.save(request.getDbLista().get(i));

        }



        return null;
    }





}
