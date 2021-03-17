package pl.sda.demo.service;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import pl.sda.demo.dto.CustomerDto;
import pl.sda.demo.dto.CustomerIncomeDto;
import pl.sda.demo.model.CustomerIncome;

@Component
@Aspect
public class AspectCustomerIncome {
//
//    @Before(value = "@annotation(AOPFirst)")
//    public CustomerIncome doCustomerIncome(CustomerIncomeDto customerIncomeDto){
//
//    }


    @Before("execution("Long pl.sda.demo.service.CustomerService.add(CustomerDto customerDto, CustomerIncomeDto customerIncomeDto, PropertyDto propertyDto)" EmployeeManager.getEmployeeById(..))")         //point-cut expression
    public void logBeforeV1(JoinPoint joinPoint)
    {
        System.out.println("EmployeeCRUDAspect.logBeforeV1() : " + joinPoint.getSignature().getName());
    }
}
}
