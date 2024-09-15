package ads.br.Software.Product.repository;

import ads.br.Software.Product.Db.DbLista;
import ads.br.Software.Product.Db.DbNomeDaLista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DbDonoDaListaRepository extends JpaRepository <DbNomeDaLista, Long>
{
    @Query(value = "select p from DbNomeDaLista p where p.nomeDaSuaLista=:nomeDaSuaLista")
    Optional<DbNomeDaLista> findBynomeDaSuaLista(String nomeDaSuaLista);

    @Query(value = "select p from DbNomeDaLista p where p.nomeDaSuaLista=:nomeDaSuaLista")
    DbNomeDaLista findbynome(String nomeDaSuaLista);



}
