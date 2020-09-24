import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Observable } from 'rxjs';
import { Customer } from '../model/customer';
import { CustomerService } from '../service/customerservice';

@Component({
  selector: 'addcustomer-codedriven',
  templateUrl: './addcustomer-codedriven.component.html',
  styleUrls: ['./addcustomer-codedriven.component.css']
})
export class AddcustomerCodedrivenComponent implements OnInit {
  customerForm:FormGroup;
  nameCtrl:FormControl;
  balanceCtrl:FormControl;
  customer: Customer;

  constructor(private customerService:CustomerService,fb:FormBuilder) {    
    this.nameCtrl=fb.control('',[Validators.minLength(4),Validators.required]);
    this.balanceCtrl=fb.control('',[Validators.required]);
    this.customerForm=fb.group({
    name:this.nameCtrl,
    balance:this.balanceCtrl
    });
   }

   addCustomer(){
     let name:string=this.nameCtrl.value;
     let balance:number= this.balanceCtrl.value;
     this.customer= new Customer(1,name,balance);
     let observable:Observable<Customer>= this.customerService.addCustomer(this.customer);
     observable.subscribe(
       customerArg=>{
       this.customer=customerArg;},
        err=>{
        console.log("add in customer code driven component, err is ="+err.message);
      })
    }

  ngOnInit(): void {
  }

}
 