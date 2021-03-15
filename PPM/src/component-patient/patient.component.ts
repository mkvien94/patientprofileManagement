import { Component, OnInit } from '@angular/core';

@Component ({
    selector: 'patient-component',
    templateUrl: './patient.component.html',
    styleUrls: ['./patient.component.css']
})

export class PatientComponent implements OnInit {

   constructor() {}

    ngOnInit(): void {
        
    } 

    title ='Hello World'
}