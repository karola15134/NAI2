alter table mybatis_db.books add author int(11) ;

alter table mybatis_db.books add constraint author_book_key foreign key (author) references authors(id);
