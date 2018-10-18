CREATE TABLE IF NOT EXISTS version (
    version integer primary key
);

insert into version values (0);

create table if not exists players (
    id integer primary key autoincrement,
    firstName varchar(30) not null,
    lastName varchar(30) not null,
    pin tinyint not null
);