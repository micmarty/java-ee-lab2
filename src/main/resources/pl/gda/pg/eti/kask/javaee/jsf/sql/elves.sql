delete from LASY;
delete from ELFY;

insert into LASY (ilosc_drzew) values (111);
insert into LASY (ilosc_drzew) values (222);
insert into LASY (ilosc_drzew) values (333);

insert into ELFY (name, liczba_strzal, rodzaj_luku, las_id) values ('Random Elf', 11, 'LONG', 1);
insert into ELFY (name, liczba_strzal, rodzaj_luku, las_id) values ('Iorweth', 22, 'RECURVE', 1);
insert into ELFY (name, liczba_strzal, rodzaj_luku, las_id) values ('Legolas', 33, 'COMPOUND', 2);
insert into ELFY (name, liczba_strzal, rodzaj_luku, las_id) values ('Dmitrij', 44, 'LONG', 3);

select * from ELFY;
select * from LASY;