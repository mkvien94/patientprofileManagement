create database adminservice;
use adminservice;


insert into personal(address,dob,fullname,occupation) values
('HCM','03/31/1994','MAI KY VIEN', 'Doctor'),
('HN','02/21/2000','CAO THUY NGA', 'Nurser');

insert into account (password,role,status,username,person_id) values
('123','admin',1,'maikivien',1),
('123','user',1,'caothuynga',2);
