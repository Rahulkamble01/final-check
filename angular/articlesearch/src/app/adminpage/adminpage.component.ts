import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AdminpageService } from '../adminpage.service';

@Component({
  selector: 'app-adminpage',
  templateUrl: './adminpage.component.html',
  styleUrls: ['./adminpage.component.css']
})
export class AdminpageComponent implements OnInit {

  constructor(private adminService:AdminpageService, private router: Router) { }
  analyst1:any;
  isUser:boolean
  analyst2:any;
  

  ngOnInit() {
  }

  get(email){
    this.adminService.search(email).subscribe(
      data => {
        if(data!=null){
         this.isUser=true;
          this.analyst1=data;
        }
 
    
        console.log(this.analyst1)
      }
    );
  }
   changeStatus(){
    this.adminService.status(this.analyst1).subscribe(
      data=>{
        this.analyst1=data;
      }
    )

  } 

}
