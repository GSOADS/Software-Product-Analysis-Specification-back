package ads.br.Software.Product.Db;

import javax.persistence.*;

import javax.persistence.GeneratedValue;

import lombok.Data;

@Data
@Entity
public class DbLista {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",unique = true)
    private Long id;
    @Column(name = "idDbNomeLista")
    private Long idDbNomeLista;
    @Column(name = "nomeDaSuaLista", nullable = false, columnDefinition = "VARCHAR(255)")
    private String nomeDaSuaLista;
    @Column(name = "itemLista")
    private String itemLista;
    @Column(name = "quemVaiComprar")
    private String quemVaiComprar;
    @Column(name = "sugestaoDeLugar")
    private String sugestaoDeLugar;



}
