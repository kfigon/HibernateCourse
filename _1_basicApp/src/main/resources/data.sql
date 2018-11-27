-- jpa nie wymaga tworzenia tego, jdbc tak
CREATE TABLE book(
  id integer not null,
  author varchar(30),
  title varchar(30),
  primary key (id)
);

insert into book (id, author, title)  values (1, 'Lem', 'asd');
insert into book (id, author, title)  values (2, 'Dick', 'SAD');
insert into book (id, author, title)  values (3, 'Tolkien', 'xxax');