package com.example.appBack;

import com.example.appBack.Student.repositorio.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//import java.sql.Date;

@SpringBootApplication
public class AppBackApplication implements CommandLineRunner
{

	public static void main(String[] args)
	{
		/**Date fecha = new Date(2020,2,4);//new Date(2020,4,4);

		System.err.println(fecha.getDay());
		System.err.println(fecha.getMonth());
		System.err.println(fecha.getYear());*/


		/**fecha = new Date(Date.parse("2/10/2020"));

		System.err.println(fecha.getDay());
		System.err.println(fecha.getMonth());
		System.err.println(fecha.getYear());*/

		SpringApplication.run(AppBackApplication.class, args);
	}

	/**@Autowired
	StudentRepository studentRepository;*/

	@Autowired
	ProductoRepository productoRepository;

	@Override
	public void run(String... arg0) throws Exception
	{
		//studentRepository.saveAndFlush(new Student(1,'Carlos','Garcia','dam06.2020@gmail.com', new Date(20201,4,27), 'Logroño', 40, 'BackEnd','Activo'));
		//studentRepository.saveAndFlush(new Student(2,'Manuel','Perez','dam12.2020@gmail.com', new Date(20201,4,27), 'Logroño', 40, 'BackEnd','Activo'));
		//studentRepository.saveAndFlush(new Student(3,'Marta','Fernandez','dam2.2020@gmail.com', new Date(20201,4,28), 'Logroño', 40, 'FrontEnd','Activo'));
		// studentRepository.saveAndFlush(new Student(4,'Luis','Ruiz','dam8.2020@gmail.com', new Date(20201,4,29), 'Logroño', 40, 'BacktEnd','Activo'));

		//studentRepository.saveAndFlush(new Student(5,'Elsa','Perez','dam7.2020@gmail.com', new Date(20201,5,1), 'Logroño', 40, 'Business Intelligence','Activo'));
		//studentRepository.saveAndFlush(new Student(6,'Mario','Lazaro','dam4.2020@gmail.com', new Date(2021,5,1), 'Logroño', 40, 'DevOps','Inactivo'));
		//studentRepository.saveAndFlush(new Student(7,'Lucia','Navarro','daw11.2020@gmail.com', new Date(2021,5,1), 'Logroño', 40, 'Recursos Humanos','Inactivo'));
		//studentRepository.saveAndFlush(new Student(8,'Alejandro','Martinez','daw02.2020@gmail.com', new Date(2021,5,2), 'Logroño', 40, 'Sistemas','Activo'));
	}
}
