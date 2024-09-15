package ads.br.Software.Product.repository;

import ads.br.Software.Product.Db.DbNomeDaLista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DbDonoDaListaRepository extends JpaRepository <DbNomeDaLista, Long>
{


}
