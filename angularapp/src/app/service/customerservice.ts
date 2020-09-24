import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Customer } from '../model/customer';

@Injectable()
export class CustomerService{
urlPath="http://localhost:8585/customers";

constructor(private http:HttpClient){

}

addCustomer(customer:Customer):Observable<Customer>{
    let url=this.urlPath+"/add";
    let observable:Observable<Customer>=this.http.post<Customer>(url,customer);
    return observable;
}

getCustomer(id:number):Observable<Customer>{
    let url=this.urlPath+"/get/"+id;
    let observable:Observable<Customer>=this.http.get<Customer>(url);
    return observable;
}

getAll():Observable<Customer[]>{
    let url=this.urlPath;
    let observable:Observable<Customer[]>=this.http.get<Customer[]>(url);
    return observable;
}

}