import { Component, OnInit } from '@angular/core';
import { observable, Observable } from 'rxjs';
import { Customer } from '../model/customer';
import { CustomerService } from '../service/customerservice';

@Component({
  selector: 'customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.css']
})
export class CustomerListComponent {

  customers:Customer[];

  constructor(private customerService:CustomerService) {
   let observable:Observable<Customer[]>=customerService.getAll();
   observable.subscribe(
     customerArg=>{this.customers=customerArg;}
   )
   }

}
