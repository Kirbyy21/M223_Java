delete from Item;
insert into Item (id, code, type, name, price, item_count)
values (NEXT VALUE FOR garden_seq, 'agh-21', 'Person', 'Ciocci', 69.69, 1),
       (NEXT VALUE FOR garden_seq, 'kaw-12', 'Food', 'Broccolo', 21.21, 32),
       (NEXT VALUE FOR garden_seq, 'daa-12', 'Not food', 'Fake Broccolo', 12.12, 67);
