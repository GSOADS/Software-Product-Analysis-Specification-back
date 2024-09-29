package ads.br.Software.Product.repository;

import ads.br.Software.Product.Db.DbLista;
import ads.br.Software.Product.Db.DbNomeDaLista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DbListaRepository extends JpaRepository <DbLista, Long>
{
    @Query(value = "select p from DbLista p where p.nomeDaSuaLista=:nomeDaSuaLista")
    List <DbLista> findbynomeDaSuaLista(String nomeDaSuaLista);


}
