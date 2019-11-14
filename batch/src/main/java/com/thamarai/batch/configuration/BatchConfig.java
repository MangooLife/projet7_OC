package com.thamarai.batch.configuration;

import com.thamarai.batch.entity.Loan;
import com.thamarai.batch.entity.Person;
import com.thamarai.batch.exception.BatchNotFoundException;
import com.thamarai.batch.proxies.MicroserviceLoanBatchProxy;
import com.thamarai.batch.tasklet.LoanTasklet;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.DefaultBatchConfigurer;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


@Configuration
@ComponentScan("com")
@EnableBatchProcessing
public class BatchConfig extends DefaultBatchConfigurer {

    private static final Logger LOGGER = LogManager.getLogger(BatchConfig.class);

    @Autowired
    public JobBuilderFactory jobs;

    @Autowired
    public StepBuilderFactory steps;

    @Autowired
    MicroserviceLoanBatchProxy microserviceLoanBatchProxy;

    @Autowired
    JavaMailSender javaMailSender;

    @Bean
    public Step stepOne(){
        List<Person> persons = microserviceLoanBatchProxy.getAllLoansPersonsLate();
        return steps.get("stepOne")
                .tasklet(new LoanTasklet(persons, javaMailSender))
                .build();
    }

    @Bean
    public Job demoJob(){
        return jobs.get("demoJob")
                .incrementer(new RunIdIncrementer())
                .start(stepOne())
                .build();
    }

}
