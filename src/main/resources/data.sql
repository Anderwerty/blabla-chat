INSERT INTO users (name, surname,email,password)
VALUES ("Alex","Ivanov","alex@gmail.com","123456");

select users.id, users.name, deps.sum from users join deps on users.id=deps.user_id;

select count(id) from users where city in ('Kiev','Moscow');

