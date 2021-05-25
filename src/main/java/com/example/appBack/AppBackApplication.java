package com.example.appBack;

import com.example.appBack.Tablas.Student.domain.Student;
import com.example.appBack.Tablas.Student.domain.StudentJpa;
import com.example.appBack.Tablas.Student.infrastructure.repositorio.JPA.StudentRepository;
import com.example.appBack.noDatabase.BranchEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Date;

@SpringBootApplication
@EnableSwagger2
@EnableJpaRepositories
public class AppBackApplication implements CommandLineRunner
{
	public static void main(String[] args)
	{
		SpringApplication.run(AppBackApplication.class, args);
	}

	@Autowired
	StudentRepository studentRepository;

	@Override
	public void run(String... arg0) throws Exception
	{
		studentRepository.saveAndFlush(new StudentJpa(new Student("1","Carlos","Garcia","dam06.2020@gmail.com", new Date(2021-1900,4,27), "Logroño", 40, "BackEnd",true, "","",new Date(2031-1900,4,27), BranchEnum.FRONT,"")));
		studentRepository.saveAndFlush(new StudentJpa(new Student("2","Manuel","Perez","dam12.2020@gmail.com", new Date(2021-1900,4,27), "Logroño", 40, "BackEnd",true, "","",new Date(2031-1900,4,27),BranchEnum.BACK,"")));
		studentRepository.saveAndFlush(new StudentJpa(new Student("3","Marta","Fernandez","dam2.2020@gmail.com", new Date(2021-1900,4,28), "Logroño", 40, "FrontEnd",true, "","",new Date(2031-1900,4,27),BranchEnum.BACK,"")));
		studentRepository.saveAndFlush(new StudentJpa(new Student("4","Luis","Ruiz","dam8.2020@gmail.com", new Date(2021-1900,4,29), "Logroño", 40, "BacktEnd",true, "","",new Date(2031-1900,4,27),BranchEnum.FRONT,"")));

		studentRepository.saveAndFlush(new StudentJpa(new Student("5","Elsa","Perez","dam7.2020@gmail.com", new Date(2021-1900,5,1), "Logroño", 40, "Business Intelligence",true, "","",new Date(2031-1900,4,27),BranchEnum.DEVOPS,"")));
		studentRepository.saveAndFlush(new StudentJpa(new Student("6","Mario","Lazaro","dam4.2020@gmail.com", new Date(2021-1900,5,1), "Logroño", 40, "DevOps",false, "","",new Date(2031-1900,4,27),BranchEnum.UNASIGNED,"")));
		studentRepository.saveAndFlush(new StudentJpa(new Student("7","Lucia","Navarro","daw11.2020@gmail.com", new Date(2021-1900,5,1), "Logroño", 40, "Recursos Humanos",false, "","",new Date(2031-1900,4,27),BranchEnum.FRONT,"")));
		studentRepository.saveAndFlush(new StudentJpa(new Student("8","Alejandro","Martinez","daw02.2020@gmail.com", new Date(2021-1900,5,2), "Logroño", 40, "Sistemas",true, "","",new Date(2031-1900,4,27),BranchEnum.DEVOPS,"")));
	}
}
