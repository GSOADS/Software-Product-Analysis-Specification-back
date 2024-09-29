package ads.br.Software.Product.response;

import ads.br.Software.Product.Db.DbLista;
import ads.br.Software.Product.Db.DbNomeDaLista;
import lombok.Data;

import java.util.List;

@Data
public class Response
{
    private DbNomeDaLista dbNomeDaLista;
    private List <DbLista> dbLista;

}
