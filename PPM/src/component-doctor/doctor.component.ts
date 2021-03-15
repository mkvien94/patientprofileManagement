import { Component, OnInit } from '@angular/core';


@Component ({
  selector: 'doctor-app',
  templateUrl: './doctor.component.html',
  styleUrls: ['./doctor.component.css']
})

export class DoctorComponnet implements OnInit{

  constructor() {}

  ngOnInit(): void {
    throw new Error('Method not implemented.');
  }
  title = 'Doctor-app'

}
