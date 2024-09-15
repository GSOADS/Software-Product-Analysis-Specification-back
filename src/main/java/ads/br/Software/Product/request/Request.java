package ads.br.Software.Product.request;

import ads.br.Software.Product.Db.DbLista;
import ads.br.Software.Product.Db.DbNomeDaLista;
import lombok.Data;
import lombok.NonNull;

import java.util.List;

@Data
public class Request {
    private DbNomeDaLista dbNomeDaLista;
    private List<DbLista> dbLista;
    private DbNomeDaLista delvolveDbNomeDaLista = new DbNomeDaLista();
    private DbLista delvolveDbLista = new DbLista();


}
