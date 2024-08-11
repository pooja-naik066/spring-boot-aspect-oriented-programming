package com.luv2code.aopdemo;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;
import com.luv2code.aopdemo.service.TrafficFortuneService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AopdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO accountDAO,
											   MembershipDAO membershipDAO,
											   TrafficFortuneService trafficFortuneService){
		return runner -> {

			//demoTheBeforeAdvice(accountDAO,membershipDAO);
			//demoTheAfterReturningAdvice(accountDAO);
			//demoTheAfterThrowAdvice(accountDAO);
			//demoTheAfterAdvice(accountDAO);
			//demoTheAroundAdvice(trafficFortuneService);
			demoTheAroundAdviceHandleException(trafficFortuneService);
			//demoTheAroundAdviceRethrowException(trafficFortuneService);

		};
	}

	private void demoTheAroundAdviceRethrowException(TrafficFortuneService trafficFortuneService) {

		System.out.println("\n Main Program: demoTheAroundAdviceRethrowException");
		System.out.println("Calling getFortune()");
		boolean tripWire=true;
		String data=trafficFortuneService.getFortune(tripWire);
		System.out.println("My fortune is "+data);
		System.out.println("Finished");
	}

	private void demoTheAroundAdviceHandleException(TrafficFortuneService trafficFortuneService) {
		System.out.println("\n Main Program: demoTheAroundAdviceHandleException");
		System.out.println("Calling getFortune()");
		boolean tripWire=true;
		String data=trafficFortuneService.getFortune(tripWire);
		System.out.println("My fortune is "+data);
		System.out.println("Finished");


	}

	private void demoTheAroundAdvice(TrafficFortuneService trafficFortuneService) {
		System.out.println("\n Main Program: demoTheAroundAdvice");
		System.out.println("Calling getFortune()");
		String data=trafficFortuneService.getFortune();
		System.out.println("My fortune is "+data);
		System.out.println("Finished");



	}

	private void demoTheAfterAdvice(AccountDAO accountDAO) {
		List<Account> accounts=null;
		try{
			//add a boolean flag to stimulate exceptions
			boolean tripWire=false;
			accounts=accountDAO.findAccounts(tripWire);
		}
		catch(Exception e){
			System.out.println("\n\nMain program-----caught exception "+e);
		}

		System.out.println("\n\n Main Program: demoTheAfterThrowingAdvice");
		System.out.println("-----");
		System.out.println(accounts);
		System.out.println("\n");

	}

	private void demoTheAfterThrowAdvice(AccountDAO accountDAO) {

		List<Account> accounts=null;
		try{
			//add a boolean flag to stimulate exceptions
			boolean tripWire=true;
           	accounts=accountDAO.findAccounts(tripWire);
		}
		catch(Exception e){
			System.out.println("\n\nMain program-----caught exception "+e);
		}

		System.out.println("\n\n Main Program: demoTheAfterThrowingAdvice");
		System.out.println("-----");
		System.out.println(accounts);
		System.out.println("\n");
	}

	private void demoTheAfterReturningAdvice(AccountDAO accountDAO) {

		//call method to find the accounts

		List<Account> accounts=accountDAO.findAccounts();

		System.out.println("\n\n Main Program: demoTheAfterReturningAdvice");
		System.out.println("-----");
		System.out.println(accounts);
		System.out.println("\n");


	}

	private void demoTheBeforeAdvice(AccountDAO accountDAO,MembershipDAO membershipDAO) {
		Account myAccount=new Account();
		myAccount.setName("John");
		myAccount.setLevel("Platinum");
		accountDAO.addAccount(myAccount,true);
		accountDAO.doWork();

		accountDAO.setName("Savings");
	 	accountDAO.setServiceCode("silver");

		String name=accountDAO.getName();
		String code=accountDAO.getServiceCode();

		membershipDAO.addAccount();
		membershipDAO.goToSleep();

	}


}






