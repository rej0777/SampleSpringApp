	drop table if exists publisher;
	drop table if exists book;
	drop table if exists author;

     create table publisher (
       id BIGINT(36) not null,
        publisherName varchar(50) not null,
        address varchar(50) not null,  
        city varchar(50) not null,
        state varchar(50) not null,
        zipCode varchar(50) not null,
        primary key (id)
    ) engine=InnoDB;
    
        create table book (
       id BIGINT(36) not null,
        titlw varchar(50) not null,
        isbn varchar(50) not null,        
        primary key (id)
    ) engine=InnoDB;
 
    create table author (
       id BIGINT(36) not null,
        firstName varchar(50) not null,
        lastName varchar(50) not null,        
        primary key (id)
    ) engine=InnoDB;