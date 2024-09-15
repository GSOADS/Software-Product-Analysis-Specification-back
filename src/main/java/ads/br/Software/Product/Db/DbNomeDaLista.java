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
    @Column(name = "nomeDaSuaLista" ,nullable = false, unique = true)
    private String nomeDaSuaLista;


}
