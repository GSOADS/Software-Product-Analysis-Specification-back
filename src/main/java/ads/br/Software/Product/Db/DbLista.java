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
    @Column(name = "nomeDaSuaLista",unique = true,nullable = false)
    private String nomeDaSuaLista;
    @Column(name = "itemLista")
    private String itemLista;
    @Column(name = "quemVaiComprar")
    private String quemVaiComprar;
    @Column(name = "sugestaoDeLugar")
    private String sugestaoDeLugar;



}
