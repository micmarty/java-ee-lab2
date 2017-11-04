delete from LASY;
delete from ELFY;

insert into LASY (ilosc_drzew) values (111);
insert into LASY (ilosc_drzew) values (222);
insert into LASY (ilosc_drzew) values (333);

insert into ELFY (imie, liczba_strzal, rodzaj_luku, las_id) values ('Random Elf', 11, 'DREWNIANY', 1);
insert into ELFY (imie, liczba_strzal, rodzaj_luku, las_id) values ('Iorweth', 22, 'DREWNIANY', 1);
insert into ELFY (imie, liczba_strzal, rodzaj_luku, las_id) values ('Legolas', 33, 'DREWNIANY', 2);
insert into ELFY (imie, liczba_strzal, rodzaj_luku, las_id) values ('Dmitrij', 44, 'DREWNIANY', 3);

select * from ELFY;
select * from LASY;