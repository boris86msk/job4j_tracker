create table if not exists j_user_notification (
    id serial primary key,
    messenger text,
    identify text
);