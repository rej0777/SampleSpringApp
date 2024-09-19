
    alter table author_book 
       drop 
       foreign key FKg7j6ud9d32ll232o9mgo90s57;

    alter table author_book 
       drop 
       foreign key FKn8665s8lv781v4eojs8jo3jao;

    alter table book 
       drop 
       foreign key FKgtvt7p649s4x80y6f4842pnfq;

    drop table if exists author;

    drop table if exists author_book;

    drop table if exists author_seq;

    drop table if exists beer;

    drop table if exists book;

    drop table if exists book_seq;

    drop table if exists customer;

    drop table if exists publisher;

    drop table if exists publisher_seq;

    create table author (
        id bigint not null,
        first_name varchar(255),
        last_name varchar(255),
        primary key (id)
    ) engine=InnoDB;

    create table author_book (
        author_id bigint not null,
        book_id bigint not null,
        primary key (author_id, book_id)
    ) engine=InnoDB;

    create table author_seq (
        next_val bigint
    ) engine=InnoDB;

    insert into author_seq values ( 1 );

    create table beer (
        beer_style tinyint not null,
        price decimal(38,2) not null,
        quantity_on_hand integer,
        version integer,
        created_date datetime(6),
        update_date datetime(6),
        id varchar(36) not null,
        beer_name varchar(50) not null,
        upc varchar(255) not null,
        primary key (id)
    ) engine=InnoDB;

    create table book (
        id bigint not null,
        publisher_id bigint,
        isbn varchar(255),
        title varchar(255),
        primary key (id)
    ) engine=InnoDB;

    create table book_seq (
        next_val bigint
    ) engine=InnoDB;

    insert into book_seq values ( 1 );

    create table customer (
        version integer,
        created_date datetime(6),
        update_date datetime(6),
        id varchar(36) not null,
        email varchar(255),
        name varchar(255),
        primary key (id)
    ) engine=InnoDB;

    create table publisher (
        id bigint not null,
        address varchar(255),
        city varchar(255),
        publisher_name varchar(255),
        state varchar(255),
        zip_code varchar(255),
        primary key (id)
    ) engine=InnoDB;

    create table publisher_seq (
        next_val bigint
    ) engine=InnoDB;

    insert into publisher_seq values ( 1 );

    alter table author_book 
       add constraint FKg7j6ud9d32ll232o9mgo90s57 
       foreign key (author_id) 
       references author (id);

    alter table author_book 
       add constraint FKn8665s8lv781v4eojs8jo3jao 
       foreign key (book_id) 
       references book (id);

    alter table book 
       add constraint FKgtvt7p649s4x80y6f4842pnfq 
       foreign key (publisher_id) 
       references publisher (id);
