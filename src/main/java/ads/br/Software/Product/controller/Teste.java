package ads.br.Software.Product.controller;

import ads.br.Software.Product.Db.DbLista;
import ads.br.Software.Product.repository.DbDonoDaListaRepository;
import ads.br.Software.Product.Db.DbNomeDaLista;
import ads.br.Software.Product.repository.DbListaRepository;
import ads.br.Software.Product.request.Request;
import ads.br.Software.Product.response.Response;
import ads.br.Software.Product.service.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/lista")
public class Teste {
    @Autowired
    private DbDonoDaListaRepository dbDonoDaListaRepository;
    @Autowired
    private DbListaRepository dbListaRepository;
    @Autowired
    private Services services;

    @GetMapping
    public List<DbNomeDaLista> listarProdutos() {
        System.out.println(dbDonoDaListaRepository.getById(1L));
        System.out.println(dbDonoDaListaRepository.findBynomeDaSuaLista("Lista de presente do Gabriel"));
        if (dbDonoDaListaRepository.findBynomeDaSuaLista("Lista de presente do Gabriel").isEmpty())
        {

        }

//        System.out.println(listRepository.findAll());
        return dbDonoDaListaRepository.findAll();
    }


    @PostMapping
    public DbNomeDaLista criarProduto(@RequestBody DbNomeDaLista produto) {

        return dbDonoDaListaRepository.save(produto);
    }

    @PostMapping("/lista")
    public ResponseEntity itenslista(@RequestHeader String headersDbLista, @RequestBody List<DbLista> dbLista) {

        System.out.println(headersDbLista);
        if (headersDbLista.equals("Yes"))
        {
            System.out.println(headersDbLista);
            System.out.println(dbLista.size());
            System.out.println(dbLista.get(5));




            return ResponseEntity.status(HttpStatus.OK).build();
        }
        return null;
    }



    @PostMapping("/criar")
    public ResponseEntity criarLista(@RequestHeader String headerLista, @RequestBody Request request)
    {
        if (headerLista.equals("Dado"))
        {
            System.out.println("dentro da lista "+ "request.getDbLista().get(0)" +"+" + request.getDbNomeDaLista().getNomeDaSuaLista());
            services.create(request);

//            System.out.println(request.getDbLista());
//            System.out.println(request.getDbNomeDaLista());
//            System.out.println(request.getDbNomeDaLista().getNomeDaSuaLista());
//            Optional<DbNomeDaLista> dbNomeDaLista1 = dbDonoDaListaRepository.findBynomeDaSuaLista(request.getDbNomeDaLista().getNomeDaSuaLista());
//            System.out.println(dbNomeDaLista1);
//            System.out.println("tamanho da lista " + request.getDbLista().size());
//
//            System.out.println("tamanho da lista elemento "+ request.getDbLista().get(0));
//            System.out.println("tamanho da lista elemento" + request.getDbLista().get(1));
//
//            for (int i = 0; i < request.getDbLista().size(); i++)
//            {
//                System.out.println("tamanho da lista elemento" + request.getDbLista().get(i));
//
//            }
//
//
//            System.out.println("tamanho da lista " + request.getDbLista().size());
//
//            DbNomeDaLista dbNomeDaLista = dbDonoDaListaRepository.findbynome(request.getDbNomeDaLista().getNomeDaSuaLista());
//            System.out.println("SERA QUE VAI AGORA "+ dbNomeDaLista.getNomeDaSuaLista());
//
//            System.out.println("sou o ultimo "+dbDonoDaListaRepository.findbynome(request.getDbNomeDaLista().getNomeDaSuaLista()));


//            String receive =  (dbDonoDaListaRepository.findBynomeDaSuaLista(request.getDbNomeDaLista().getNomeDaSuaLista()));
//            System.out.println( "ESTOU" + receive);
        }

        return null;
    }

    @GetMapping("/obterListaEItens/{nomeDaLista}")
    public ResponseEntity <Response> obterListaEItens(@PathVariable String nomeDaLista)
    {
        System.out.println("nome da lista  "+ nomeDaLista);

        Response response = services.obterNomeELista(nomeDaLista);
        System.out.println(response);

        return ResponseEntity.status(HttpStatus.OK).body(response);

    }

    @PutMapping("/alterarListaItens")
    public void alterarListaItens(@RequestBody Request request)
    {
        System.out.println("FUNÇÂO PUT "+request.getDbLista());
        services.atualizaItensLista(request);


    }

    @DeleteMapping("/deletaListaEItens")
    public ResponseEntity<String> deletaListaEItens(@RequestBody Request request)
    {
        System.out.println("FUNÇÂO Delete "+request.getDbNomeDaLista().getNomeDaSuaLista());
        services.deletaDbNomeDbLista(request);

        return new ResponseEntity<>("Deletedado", HttpStatus.ACCEPTED);


    }

    @GetMapping("/db")
    public ResponseEntity<String> verificarStatusDB() {
        try {
            long count = dbDonoDaListaRepository.count();
            return ResponseEntity.ok("Banco de dados está acessível. Total de registros: " + count);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao acessar o banco de dados: " + e.getMessage());
        }
    }
}

