delete from Customer;
insert into Customer (id, name, surname, age, city, cc_number, cc_expiration, cccvv)
values (NEXT VALUE FOR customer_seq, 'Mario', 'Rossi', 24, 'Lugano', '4111111111111111', '12/26', '123'),
       (NEXT VALUE FOR customer_seq, 'Guido', 'Bianchi', 34, 'Locarno', '5111111111111112', '05/27', '211'),
       (NEXT VALUE FOR customer_seq, 'Gino', 'Verdi', 57, 'Bellinzona', '6111111111111113', '09/28', '368');
