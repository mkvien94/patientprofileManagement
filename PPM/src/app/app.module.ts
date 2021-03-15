import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from 'src/component-login/login.component';
import { NurserComponent } from 'src/nurser-component/nurser.component';
import { DoctorComponnet } from 'src/component-doctor/doctor.component';
import { AdminComponent } from 'src/admin/admin-component/admin.component';
import { admindoctor } from 'src/admin/admin-doctor/admin-doctor.component';
import { AdminNurser } from 'src/admin/admin-nurser.component/admin-nurser.component';
import { RouterModule, Routes } from '@angular/router';
import { AdminMedical } from 'src/admin/admin-medical/admin-medical.component';
import { AdminPatient } from 'src/admin/admin-patient/admin-patient.component';


const appRoutes: Routes = [
  { path: 'admin-doctor', component: admindoctor },
  { path: 'admin-nurser', component: AdminNurser },
  { path : 'admin-medical', component : AdminMedical },
  { path: 'admin-patient', component: AdminPatient }
];


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    NurserComponent,
    DoctorComponnet,
    AdminComponent,
    admindoctor,
    AdminNurser,
    AdminMedical,
    AdminPatient

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    RouterModule.forRoot(
      appRoutes,
      { enableTracing: true } // <-- debugging purposes only
    )
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
