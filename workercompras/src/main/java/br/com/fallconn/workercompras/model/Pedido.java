package br.com.fallconn.workercompras.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Pedido implements Serializable {

    private Long id;
    private String nome;
    private String email;
    private Long produto;
    private BigDecimal valor;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dataPedido;
    private String cpfCliente;
    private String cep;

}
