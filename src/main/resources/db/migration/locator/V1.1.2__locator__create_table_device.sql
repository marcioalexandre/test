create table device (
    id serial primary key,
    id_model uuid not null,
    id_framework integer not null,
    id_fog integer null,
    CONSTRAINT fk_fog FOREIGN KEY(id_fog) REFERENCES fog(id)
);