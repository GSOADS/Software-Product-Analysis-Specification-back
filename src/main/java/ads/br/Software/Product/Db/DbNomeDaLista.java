package ads.br.Software.Product.Db;

import javax.persistence.*;

import lombok.Data;


@Data
@Entity
@Table(name = "dbdonodalista")
public class DbNomeDaLista {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",unique = true)
    private Long id;
    @Column(name = "nomeDaSuaLista", nullable = false, columnDefinition = "VARCHAR(255)")
    private String nomeDaSuaLista;


}
