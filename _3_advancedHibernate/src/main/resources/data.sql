-- jpa nie wymaga tworzenia tego schematu

insert into course(id, name) values(1, 'praktyka programowania');
insert into course(id, name) values(2, 'matematyka');
insert into course(id, name) values(3, 'fizyka');

insert into student(id, name) values(1, 'Adam');
insert into student(id, name) values(2, 'Marek');

-- passport jest ownerem relacji. Jednokierunkowa relacja
insert into passport(id, student_id, passport_date) values(1, 1, sysdate());
insert into passport(id, student_id, passport_date) values(2, 2, sysdate());


-- dwukierunkowa relacja. owner - Owner. on trzyma dg ID
-- w encji dog trzeba dac wtedy co mapuje go w encji nadrzednej
insert into dog(id, name) values(1, 'Fafik');
insert into owner(id, name, dog_id) values(1, 'Jan',1);