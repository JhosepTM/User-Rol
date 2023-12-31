-- create user table
create table user_table (
                         id bigint,
                         user_name varchar(150) not null,
                         password varchar(150) not null,
                         email varchar(150) not null ,
                         created_at timestamp,
                         primary key (id)
);

-- create a sequence for user ide
create sequence user_sequence as integer increment 1;

-- create user rol
create table rol (
                      id integer not null,
                      name varchar(100) not null,
                      primary key (id)
);

-- create a sequence for rol ide
create sequence rol_sequence as integer increment 1;
-- create user_rol table
create table user_rol (
                      id integer not null,
                      active bool not null,
                      created_at timestamp not null,
                      user_id bigint,
                      rol_id integer,
                      primary key (id)
);

alter table user_rol add constraint FK_User_RefUserRoll foreign key (user_id)
    references user_table (id) on delete restrict on update restrict;

alter table user_rol add constraint FK_Rol_RefUserRoll foreign key (rol_id)
    references rol (id) on delete restrict on update restrict;

create sequence user_rol_sequence as integer increment 1;

-- create table user_detail

create table user_detail (
                          id bigint not null,
                          first_name varchar(100) not null,
                          last_name varchar(100) not null,
                          age integer,
                          birth_day date,
                          user_id bigint,
                          primary key (id)
);

alter table user_detail add constraint FK_UserDetail_RefUser foreign key (user_id)
    references user_table (id) on delete restrict on update restrict;

create sequence user_detail_sequence as integer increment 1;