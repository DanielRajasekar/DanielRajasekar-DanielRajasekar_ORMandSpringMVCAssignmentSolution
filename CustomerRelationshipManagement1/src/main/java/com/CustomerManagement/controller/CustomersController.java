package com.CustomerManagement.controller;

//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import com.CustomerManagement.entity.Customer;
//import com.CustomerManagement.service.CustomerService;
//
//
//@Controller
//@RequestMapping("/customers")
//public class CustomerController {
//
//	@Autowired
//	private CustomerService customerService;
//	
//	//LIST
//	
//	@RequestMapping("/list")
//	public String listCustomers(Model theModel) {
//		
//		List<Customer> theCustomers = customerService.findAll();
//		
//		theModel.addAttribute("Customers", theCustomers);
//		
//		return "list-Customers";
//		}
//	
//	//ADD
//	
//	@RequestMapping("/Add")
//	public String showFormForAdd(Model model)
//	{
//		Customer customer=new Customer();
//		
//		model.addAttribute("customer",customer);
//		
//		return "Customer-form";
//	}
//
//	
//	//UPDATE
//	
//	@RequestMapping("Update")
//	public String showFormForUpdate(@RequestParam("customerId")int theId ,Model theModel) {
//	
//		Customer theCustomer = customerService.findById(theId);
//		
//		theModel.addAttribute("Customer", theCustomer);
//		
//		return "Customer-form";
//	}
//	
//	//SAVE
//	
//	@PostMapping("/save")
//	public String save(@RequestParam("id")int id, @RequestParam("firstname")String firstname,
//			@RequestParam("lastname")String lastname,@RequestParam("email")String email) {
//		
//		System.out.println(id);
//		Customer theCustomer;
//		if (id !=0) {
//			theCustomer = customerService.findById(id);
//			theCustomer.setFirstname(firstname);
//			theCustomer.setLastname(lastname);
//			theCustomer.setEmail(email);
//			}
//		else
//			theCustomer = new Customer(firstname,lastname,email);
//		
//		customerService.save(theCustomer);
//		
//		return "redirect:/customers/list";
//	}
//	
//	//DELETE
//	
//	@RequestMapping("/delete")
//	public String delete(@RequestParam("customerId")int theId) {
//		
//		customerService.deleteById(theId);
//		
//		return "redirect:/customers/list";
//	}
//}

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.CustomerManagement.entity.Customer;
import com.CustomerManagement.service.CustomerService;


@Controller
@RequestMapping("/customers")
public class CustomersController {
	@Autowired
	private CustomerService customerService;

	@RequestMapping("/list")
	public String showCustomers(Model model)
	{
		List<Customer> customers=customerService.findAll();
		model.addAttribute("customers", customers);
		return "list-Customers";
	}
	@RequestMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId") int id){
		customerService.deleteById(id);
		return "redirect:/customers/list";
	}
	@RequestMapping("/update")
	public String updateCustomer(@RequestParam("customerId") int id,Model model)
	{
		Customer customer=customerService.findById(id);
		model.addAttribute("customer",customer);
		return "Customer-form";

	}

	@RequestMapping("/save")
	public String saveCustomer(@RequestParam("id") int id,
			@RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName,
			@RequestParam("email") String email)
	{
		Customer customer;
		if(id==0)
		{
			customer=new Customer(firstName,lastName,email);
		}
		else {
			customer=customerService.findById(id);
			customer.setFirstname(firstName);
			customer.setLastname(lastName);
			customer.setEmail(email);
		}
		customerService.save(customer);
		return "redirect:/customers/list";
	}

	@RequestMapping("/showFormForAdd")
	public String addCustomer(Model model)
	{
		Customer customer=new Customer();
		model.addAttribute("customer",customer);
		return "Customer-form";
	}

}