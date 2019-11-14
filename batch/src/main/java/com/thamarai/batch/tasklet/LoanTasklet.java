package com.thamarai.batch.tasklet;

import com.thamarai.batch.entity.Person;
import com.thamarai.batch.proxies.MicroserviceLoanBatchProxy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LoanTasklet implements Tasklet {

    private static final Logger LOGGER = LogManager.getLogger(LoanTasklet.class);

    private JavaMailSender javaMailSender;

    private List<Person> persons;

    public LoanTasklet(List<Person> persons, JavaMailSender javaMailSender) {
        this.persons = persons;
        this.javaMailSender = javaMailSender;
    }

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext)
    {
        persons.stream().forEach(p -> {
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
            simpleMailMessage.setTo(p.getEmail());

            simpleMailMessage.setSubject("Retard dans vos emprunts");
            simpleMailMessage.setText(
                    "Bonjour "+p.getFirstname()+" "+p.getLastname()+" \n"
                            +"Vous avez des retards d'emprunt \n"
                            +"Veuillez faire le nécessaire pour être en règle. \n"
                            +"Cordialement, \n"
                            +"La direction de la bibliothèque."
            );
            javaMailSender.send(simpleMailMessage);
        });

        return RepeatStatus.FINISHED;
    }
}
