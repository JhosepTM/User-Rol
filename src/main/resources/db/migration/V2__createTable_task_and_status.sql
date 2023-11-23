-- create status table
create table status (
                        id integer not null,
                        name_status varchar(50) not null,
                        primary key (id)
);

create sequence status_sequence as integer increment 1;

-- create task table
create table task (
                      id bigint not null,
                      description varchar(255) not null,
                      due_date timestamp not null,
                      status_id integer,
                      user_id bigint,
                      primary key (id)
);

alter table task add constraint FK_Task_RefUser foreign key (user_id)
    references user_table (id) on delete restrict on update restrict;

alter table task add constraint FK_Task_RefStatus foreign key (status_id)
    references status (id) on delete restrict on update restrict;

create sequence task_sequence as integer increment 1;