package com.example.Exception_example;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
@Autowired
EmployeeRepository erepo;
@RequestMapping("/test")
public String test()
{
	return " test for exception example";
}
@RequestMapping("/save")
public String save(@RequestBody Employee emp)
{
	erepo.save(emp);
	return "data saved";
}
@RequestMapping("/all")
public List<Employee> all()
{
	return erepo.findAll();
}
@RequestMapping("/{id}")
public Optional<Employee> byid(@PathVariable int id)throws IdNotFoundException
{
	Optional<Employee> employee=erepo.findById(id);
	if(employee.isEmpty()) {
		throw new IdNotFoundException("id not found");
	}
	return employee;
}

//@RequestMapping("/by/{id}")
//public Employee hello(@PathVariable int id) throws IdNotFoundException
//{
//	Employee employee=erepo.findById(id).orElseThrow(()->
//	new IdNotFoundException());
//	return employee;
//}
@RequestMapping("/name/{name}")
public List<Employee> byname(@PathVariable String name)
{
	List<Employee> employ=erepo.findByName(name);
	if(employ.isEmpty())
	{
		throw new NameNotFoundException("name not found");
	}
	return employ;
}
@RequestMapping("/city/{city}")
public List<Employee> bycity(@PathVariable String city)
{
	List<Employee> employ=erepo.findByCity(city);
	if(employ.isEmpty())
	{
		throw new CityNotFoundException("city not found");
	}
	return employ;
}

}
