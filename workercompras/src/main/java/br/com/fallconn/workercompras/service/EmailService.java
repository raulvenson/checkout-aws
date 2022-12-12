package br.com.fallconn.workercompras.service;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    public void notificarCliente(String email) {
        var msg = new SimpleMailMessage();
        msg.setTo(email);
        msg.setSubject("Compra recebida");
        msg.setText("Confirmação de compra recebida.");
        javaMailSender.send(msg);
        log.info("Cliente notificado com sucesso!");


    }
}
