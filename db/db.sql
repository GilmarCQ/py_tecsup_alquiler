
select * from vehiculo;
select * from marca;
select * from tipo_vehiculo;
select * from tipo_combustible;

insert into marca (descripcion, estado, date_create, usua_create)
values
('TOYOTA', 1, now(), 'GCAMPANAQ'),
('BMW', 1, now(), 'GCAMPANAQ'),
('FORD', 1, now(), 'GCAMPANAQ'),
('MAZDA', 1, now(), 'GCAMPANAQ'),
('SUBARU', 1, now(), 'GCAMPANAQ'),
('VOLKSWAGEN', 1, now(), 'GCAMPANAQ'),
('JEEP', 1, now(), 'GCAMPANAQ');

insert into tipo_vehiculo (descripcion, estado, date_create, usua_create)
values
('AUTO', 1, now(), 'GCAMPANAQ'),
('CAMIONETA', 1, now(), 'GCAMPANAQ'),
('LIMOSINA', 1, now(), 'GCAMPANAQ');

insert into tipo_combustible (descripcion, estado, date_create, usua_create)
values
('GASOLINA', 1, now(), 'GCAMPANAQ'),
('PETROLEO', 1, now(), 'GCAMPANAQ'),
('GAS', 1, now(), 'GCAMPANAQ');
