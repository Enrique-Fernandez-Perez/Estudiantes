package com.example.appBack;


import com.example.appBack.Student.Entity.branch;
import com.example.appBack.Student.Entity.Student;
import com.example.appBack.Student.Entity.branch;
import com.example.appBack.Student.repositorio.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.sql.Date;
import java.util.Optional;

@SpringBootApplication
@EnableSwagger2
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
		studentRepository.saveAndFlush(new Student("1","Carlos","Garcia","dam06.2020@gmail.com", new Date(2021,4,27), "Logroño", 40, "BackEnd",true, "","",new Date(2031,4,27), branch.FRONT));
		studentRepository.saveAndFlush(new Student("2","Manuel","Perez","dam12.2020@gmail.com", new Date(2021,4,27), "Logroño", 40, "BackEnd",true, "","",new Date(2031,4,27),branch.BACK));
		studentRepository.saveAndFlush(new Student("3","Marta","Fernandez","dam2.2020@gmail.com", new Date(2021,4,28), "Logroño", 40, "FrontEnd",true, "","",new Date(2031,4,27),branch.BACK));
		studentRepository.saveAndFlush(new Student("4","Luis","Ruiz","dam8.2020@gmail.com", new Date(2021,4,29), "Logroño", 40, "BacktEnd",true, "","",new Date(2031,4,27),branch.FRONT));

		studentRepository.saveAndFlush(new Student("5","Elsa","Perez","dam7.2020@gmail.com", new Date(20201,5,1), "Logroño", 40, "Business Intelligence",true, "","",new Date(2031,4,27),branch.DEVOPS));
		studentRepository.saveAndFlush(new Student("6","Mario","Lazaro","dam4.2020@gmail.com", new Date(2021,5,1), "Logroño", 40, "DevOps",false, "","",new Date(2031,4,27),branch.UNASIGNED));
		studentRepository.saveAndFlush(new Student("7","Lucia","Navarro","daw11.2020@gmail.com", new Date(2021,5,1), "Logroño", 40, "Recursos Humanos",false, "","",new Date(2031,4,27),branch.FRONT));
		studentRepository.saveAndFlush(new Student("8","Alejandro","Martinez","daw02.2020@gmail.com", new Date(2021,5,2), "Logroño", 40, "Sistemas",true, "","",new Date(2031,4,27),branch.DEVOPS));

		/*studentRepository.saveAndFlush(new Student("1","Carlos","Garcia","dam06.2020@gmail.com", new Date(2021,4,27), "Logroño", 40, "BackEnd","Activo", "","",new Date(2031,4,27), branch.FRONT));
		studentRepository.saveAndFlush(new Student("2","Manuel","Perez","dam12.2020@gmail.com", new Date(2021,4,27), "Logroño", 40, "BackEnd","Activo", "","",new Date(2031,4,27),branch.BACK));
		studentRepository.saveAndFlush(new Student("3","Marta","Fernandez","dam2.2020@gmail.com", new Date(2021,4,28), "Logroño", 40, "FrontEnd","Activo", "","",new Date(2031,4,27),branch.BACK));
		studentRepository.saveAndFlush(new Student("4","Luis","Ruiz","dam8.2020@gmail.com", new Date(2021,4,29), "Logroño", 40, "BacktEnd","Activo", "","",new Date(2031,4,27),branch.FRONT));

		studentRepository.saveAndFlush(new Student("5","Elsa","Perez","dam7.2020@gmail.com", new Date(20201,5,1), "Logroño", 40, "Business Intelligence","Activo", "","",new Date(2031,4,27),branch.DEVOPS));
		studentRepository.saveAndFlush(new Student("6","Mario","Lazaro","dam4.2020@gmail.com", new Date(2021,5,1), "Logroño", 40, "DevOps","Inactivo", "","",new Date(2031,4,27),branch.UNASIGNED));
		studentRepository.saveAndFlush(new Student("7","Lucia","Navarro","daw11.2020@gmail.com", new Date(2021,5,1), "Logroño", 40, "Recursos Humanos","Inactivo", "","",new Date(2031,4,27),branch.FRONT));
		studentRepository.saveAndFlush(new Student("8","Alejandro","Martinez","daw02.2020@gmail.com", new Date(2021,5,2), "Logroño", 40, "Sistemas","Activo", "","",new Date(2031,4,27),branch.DEVOPS));*/
	}
}
