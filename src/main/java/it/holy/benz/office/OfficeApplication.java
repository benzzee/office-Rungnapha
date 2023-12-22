package it.holy.benz.office;

import java.util.Arrays;

import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import it.holy.benz.office.model.Department;
import it.holy.benz.office.model.Employee;
import it.holy.benz.office.model.Project;
import it.holy.benz.office.repository.DepartmentRepository;
import it.holy.benz.office.repository.EmployeeRepository;
import it.holy.benz.office.repository.ProjecRepository;

@SpringBootApplication
public class OfficeApplication  implements CommandLineRunner{

	private static final org.slf4j.Logger logger = 
		LoggerFactory.getLogger(OfficeApplication.class);

	private final EmployeeRepository employeeRepository;
	private final DepartmentRepository departmentRepository;
	private final ProjecRepository projecRepository;

	public  OfficeApplication(EmployeeRepository employeeRepository, DepartmentRepository departmentRepository, ProjecRepository projecRepository){
		this.employeeRepository = employeeRepository;
		this.departmentRepository =departmentRepository;
		this.projecRepository = projecRepository;

	}

	@Override
	public void run (String... args) throws Exception{
		Department dm1 = new Department("ComSci");
		Department dm2 = new Department("Engineering");
		departmentRepository.saveAll(Arrays.asList(dm1,dm2));
		Project pj1 = new Project("Eat");
		Project pj2 = new Project("Sleep");
		projecRepository.saveAll(Arrays.asList(pj1,pj2));

		employeeRepository.save(new Employee("Achira", 45000, dm1, pj1));
		employeeRepository.save(new Employee("Rungnapha", 123457, dm2, pj2));

		for (Employee employee : employeeRepository.findAll()){
			logger.info("name : {}, salary : {}",
			employee.getName(),employee.getSalary());		
		}

		for (Employee employee : employeeRepository.findByName("Achira")){
			logger.info("name : {} , salary : {}",
			employee.getName(),employee.getSalary());
		}

		for (Employee employee : employeeRepository.findBysalary(900)){
			logger.info("Name : {} , salary : {}",
			employee.getName(),employee.getSalary());
		}

		for(Project project : projecRepository.findByNameContaining("")){
			logger.info("Project : {}",project.getName());
		}


	}

	public static void main(String[] args) {
		SpringApplication.run(OfficeApplication.class, args);
	}

}
