package br.com.helti.checkout.service;

import br.com.helti.checkout.model.Pedido;
import br.com.helti.checkout.repository.PedidoRepository;
import br.com.helti.checkout.service.rabbitmq.Producer;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;
    private final Producer producer;
    public Pedido salvar(Pedido pedido){

        pedido = pedidoRepository.save(pedido);
        producer.enviarPedido(pedido);

        return pedido;
    }

}
