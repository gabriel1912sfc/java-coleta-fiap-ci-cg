package br.com.fiap.coleta.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;


@Entity
@Table(name = "tb_coleta")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Coleta {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "SEQ_COLETA"
    )
    @SequenceGenerator(
            name = "SEQ_COLETA",
            sequenceName = "SEQ_COLETA",
            allocationSize = 1
    )
    @Column(name = "coleta_id")
    private Long id;

    @Column(name = "data_coleta")
    private String dateColeta;
    private String address;

    @Column(name = "type_of_residue")
    private String typeOfResidue;

}
