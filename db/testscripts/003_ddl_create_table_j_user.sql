create table if not exists j_user (
    id serial primary key,
    name text,
    role_id int references j_role(id)
);