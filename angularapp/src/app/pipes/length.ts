import { Pipe, PipeTransform } from '@angular/core';

@Pipe(
    { 
        name:'length'
    }
)

export class LengthPipe implements PipeTransform{
    
    transform(input: number[]):number {
    console.log("inside length pipe ");
    return input.length;
    }
    
}
    
       
    