create table configuration (
    id serial primary key,
    score integer not null,
    direction varchar(20) not null,
    bitrate integer not null
);