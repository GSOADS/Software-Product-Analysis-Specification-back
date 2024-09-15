package ads.br.Software.Product.controller;

import ads.br.Software.Product.Db.DbLista;
import ads.br.Software.Product.repository.DbDonoDaListaRepository;
import ads.br.Software.Product.Db.DbNomeDaLista;
import ads.br.Software.Product.repository.DbListaRepository;
import ads.br.Software.Product.request.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/produtos")
public class Teste {
    @Autowired
    private DbDonoDaListaRepository dbDonoDaListaRepository;
    @Autowired
    private DbListaRepository dbListaRepository;

    @GetMapping
    public List<DbNomeDaLista> listarProdutos() {
        System.out.println(dbDonoDaListaRepository.getById(3L));
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
    @PostMapping("/nome_lista")
    public ResponseEntity dados(@RequestHeader String headerLista, @RequestBody Request request)
    {
        if (headerLista.equals("Dado")) {
            System.out.println(request.getDbLista());
            System.out.println(request.getDbNomeDaLista());
        }

        return null;
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

