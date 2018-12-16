-- jpa nie wymaga tworzenia schematu recznie (sterowane propertiesem)

-- regular entity
insert into course(id, name) values(1, 'praktyka programowania');
insert into course(id, name) values(2, 'matematyka');
insert into course(id, name) values(3, 'fizyka');

-- one to one unidirection
insert into student(id, name) values(1, 'Adam');
insert into student(id, name) values(2, 'Marek');

-- passport jest ownerem relacji (trzyma id drugiego). Tutaj adnotacja
insert into passport(id, student_id, passport_date) values(1, 1, sysdate());
insert into passport(id, student_id, passport_date) values(2, 2, sysdate());


-- dwukierunkowa relacja. owner - Owner. on trzyma dog ID
-- w encji dog trzeba dac wtedy co mapuje go w encji nadrzednej
insert into dog(id, name) values(1, 'Fafik');
insert into owner(id, name, dog_id) values(1, 'Jan',1);


-- one to many jednokierunkowe. post ma wiele komentarzy. Join column potrzebny
insert into post(id, topic) values (1, 'fizyka kwantowa');
insert into comment(id, content, post_id) values (1, 'very nice!', 1);
insert into comment(id, content, post_id) values (2, 'boooring', 1);
insert into comment(id, content, post_id) values (3, 'show photos pls', 1);

-- one to many dwukierunkowe. Join column potrzebny
insert into orderx(id, name) values(1, 'stuff');
insert  into order_item(id, description, order_id) values (1, 'some things', 1);
insert  into order_item(id, description, order_id) values (2, 'other things', 1);
insert  into order_item(id, description, order_id) values (3, 'stranger things', 1);


-- many to many
-- bez mappingu beda 2 join tablice
-- robimy owning (np. book) i dajemy adnotacje a drugiej (mappedBy)
insert into book(id, name) values (1, 'java in practice');
insert into book(id, name) values (2, 'JPA in practice');
insert into book(id, name) values (3, 'boring book');

insert into book_author(id, name) values (1, 'Joe');
insert into book_author(id, name) values (2, 'Jane');
insert into book_author(id, name) values (3, 'Bill');

insert into book_book_authors(books_id, book_authors_id) values (1,1);
insert into book_book_authors(books_id, book_authors_id) values (1,2);

insert into book_book_authors(books_id, book_authors_id) values (2,2);
insert into book_book_authors(books_id, book_authors_id) values (2,3);

insert into book_book_authors(books_id, book_authors_id) values (3,1);
insert into book_book_authors(books_id, book_authors_id) values (3,2);
insert into book_book_authors(books_id, book_authors_id) values (3,3);

-- // dziedziczenie
-- mappedSuperclass - baza nie jest encja, ale pola sie przenosza do dzieci
-- join table - baza jest joinowana
-- insert table - baza jest wsadzana do dzieci
-- single table