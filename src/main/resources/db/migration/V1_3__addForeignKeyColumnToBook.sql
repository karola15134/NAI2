alter table books add author int(11) ;

alter table books add constraint author_book_key foreign key (author) references authors(id);
