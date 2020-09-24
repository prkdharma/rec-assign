import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, ParamMap } from '@angular/router';
import { Observable } from 'rxjs';
import { Customer } from '../model/customer';
import { CustomerService } from '../service/customerservice';

@Component({
  selector: 'customer-details',
  templateUrl: './customer-details.component.html',
  styleUrls: ['./customer-details.component.css']
})
export class CustomerDetailsComponent {


    constructor(private route:ActivatedRoute, private customerService:CustomerService) {
      let observable=route.paramMap;
      observable.subscribe((params:ParamMap)=>{
        let idValue:string=params.get("id");
        let idNum:number=Number(idValue);
        this.findCustomerById(idNum);
      })
     }
  
    customer:Customer;
  
    findCustomerById(id:number){
      let observable:Observable<Customer>=this.customerService.getCustomer(id);
      observable.subscribe(
        customerArg=>{
          this.customer=customerArg;
        }
      )
    }
     findCustomer(form:any){
       let data=form.value;
       let id=data.customerid;
       this.findCustomerById(id);
     }
}
