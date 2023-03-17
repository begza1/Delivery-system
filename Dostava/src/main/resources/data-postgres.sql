INSERT INTO users(id,first_name,last_name,gender,address,username,password,paycheck)
VALUES (nextval('users_sequence'),'Marko','Markovic','M','Tesanj12','marko','password',500.00),
       (nextval('users_sequence'),'Petar','Petrovic','M','Tesanj13','petar','password',600.00),
       (nextval('users_sequence'),'Milica','Milic','Ž','Tesanj14','milica','password',700.00),
       (nextval('users_sequence'),'Jovana','Ristic','Ž','Tesanj15','jovana','password',800.00);

INSERT INTO roles(id, name)
VALUES (nextval('roles_sequence'),'admin'),
       (nextval('roles_sequence'),'kupac'),
       (nextval('roles_sequence'),'zaposlenik');