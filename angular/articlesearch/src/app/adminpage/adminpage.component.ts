import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AdminpageService } from '../adminpage.service';

@Component({
  selector: 'app-adminpage',
  templateUrl: './adminpage.component.html',
  styleUrls: ['./adminpage.component.css']
})
export class AdminpageComponent implements OnInit {

  constructor(private adminService: AdminpageService, private router: Router) { }
  analysts: any;
  isUser: boolean
  analyst2: any;


  ngOnInit() {
  }

  get(name) {
    this.adminService.search(name).subscribe(
      data => {
        if (data != null) {
          this.isUser = true;
          this.analysts = data[0];
          console.log(this.analysts)
        }


        // console.log(this.analysts)
      }
    );
  }
  changeStatus() {
    this.adminService.status(this.analysts).subscribe(
      data => {
        this.analysts = data;
      }
    )

  }

}
