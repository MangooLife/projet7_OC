package com.thamarai.batch.tasklet;

import com.thamarai.batch.entity.Loan;
import com.thamarai.batch.entity.Person;
import com.thamarai.batch.exception.BatchNotFoundException;
import com.thamarai.batch.service.LoanService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class LoanTasklet  implements Tasklet {

    private static final Logger LOGGER = LogManager.getLogger(LoanTasklet.class);

    @Autowired
    LoanService loanService;

    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception
    {
        LOGGER.info("LoanTasklet start..");

        List<Loan> allLoans = null;

        Date todayDate = new Date();

        try {
            allLoans = loanService.getAllLoans();

            allLoans.stream().forEach(loan -> {
                Date loanDate = loan.getDate();

                Calendar calendar = Calendar.getInstance();
                calendar.setTime(loanDate);

                calendar.add(Calendar.DATE, 30);

                Date loanEndingDate = calendar.getTime();

                if(loanDate.compareTo(loanEndingDate) > 0) {
                    LOGGER.info("Sending an email to user");
                    loan.getLoanPerson().stream().forEach(this::sendEmail);
                }
            });
        } catch (Exception e) {
            LOGGER.error("There isn't loan in database...");
            throw new BatchNotFoundException("There isn't loan in database..."+e);
        }

        LOGGER.info("LoanTasklet done..");

        return RepeatStatus.FINISHED;
    }

    private void sendEmail(Person person) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(person.getEmail());

        simpleMailMessage.setSubject("Retard dans vos emprunts");
        simpleMailMessage.setText(
                "Bonjour "+person.getFirstname()+" "+person.getLastname()+" \n"
                +"Vous avez des retards d'emprunt \n"
                +"Veuillez faire le nécessaire pour être en règle. \n"
                +"Cordialement, \n"
                +"La direction de la bibliothèque."
        );
    }

}
