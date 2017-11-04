delete from forests;
delete from ELFY;

insert into forests (tree_number) values (111);
insert into forests (tree_number) values (222);
insert into forests (tree_number) values (333);

insert into ELFY (name, arrow_number, bow_category, forest_id) values ('Random Elf', 11, 'LONG', 1);
insert into ELFY (name, arrow_number, bow_category, forest_id) values ('Iorweth', 22, 'RECURVE', 1);
insert into ELFY (name, arrow_number, bow_category, forest_id) values ('Legolas', 33, 'COMPOUND', 2);
insert into ELFY (name, arrow_number, bow_category, forest_id) values ('Dmitrij', 44, 'LONG', 3);

select * from ELFY;
select * from forests;