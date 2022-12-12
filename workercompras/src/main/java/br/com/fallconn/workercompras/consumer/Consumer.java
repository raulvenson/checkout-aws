package br.com.fallconn.workercompras.consumer;

import br.com.fallconn.workercompras.model.Pedido;
import br.com.fallconn.workercompras.service.EmailService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Component
public class Consumer {

    private EmailService emailService;
//    private final ObjectMapper mapper;
    @RabbitListener(queues = {"${queue.name}"})
    public void consumer(@Payload Message message) throws IOException {
//        var pedido = mapper.readValue(message.getBody(), Pedido.class);
        Gson gson = new GsonBuilder().create();

        Pedido pedido = gson.fromJson(new String(message.getBody(), StandardCharsets.UTF_8),
                 Pedido.class);

        emailService.notificarCliente("raulvenson@gmail.com");
        log.info("Mensagem recebida: " + pedido);
    }

}
