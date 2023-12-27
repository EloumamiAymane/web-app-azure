package com.iga.ac.ma.demo;

import com.iga.ac.ma.demo.Repository.PatientRepository;
import com.iga.ac.ma.demo.entities.Patient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
//@Bean
	CommandLineRunner commandLineRunner(PatientRepository patientRepository){
		return args->{
			patientRepository.save(new Patient(null,"Aymane Eloumami",new Date(),true,15));
			patientRepository.save(new Patient(null,"Oussama Eloumami",new Date(),false,10));
			patientRepository.save(new Patient(null,"Othmane Eloumami",new Date(),false,25));
			patientRepository.save(new Patient(null,"Nour Eloumami",new Date(),false,22));



		};
	}
}
