drop database if exists DB_Tienda_IN5CM;
create database DB_Tienda_IN5CM;
use DB_Tienda_IN5CM;
 
create table Productos(
	codigo_producto int primary key auto_increment,
    nombre_producto varchar(60),
    precio decimal (10,2),
    stock int,
    estado int
);
 
create table Usuarios(
	codigo_usuario int primary key auto_increment,
    username varchar(45),
    password varchar(45),
    email varchar(60),
    rol varchar(45),
    estado int
);
 
create table Clientes(
	dpi_cliente int primary key auto_increment,
    nombre_cliente varchar(50),
    apellido_cliente varchar(50),
    direccion varchar(100),
    estado int
);
 
create table Ventas(
	codigo_venta int primary key auto_increment,
    fecha_venta date,
    total decimal(10,2),
    estado int,
    clientes_dpi_cliente int,
    usuarios_codigo_usuario int,
    constraint foreign key (clientes_dpi_cliente) references Clientes(dpi_cliente) on delete cascade,
    constraint foreign key (usuarios_codigo_usuario) references Usuarios(codigo_usuario) on delete cascade
);
 
create table Detalle_Venta(
	codigo_detalle_venta int primary key auto_increment,
    cantidad int,
    precio_unitario decimal(10,2),
    subtotal decimal(10,2),
    productos_codigo_producto int,
    ventas_codigo_venta int,
    constraint foreign key (productos_codigo_producto) references Productos(codigo_producto) on delete cascade,
    constraint foreign key (ventas_codigo_venta) references Ventas(codigo_venta) on delete cascade
);

-- --------------------------------------------------------------------------------------PROCEDIMIENTOS CREAR
delimiter $$
create procedure sp_insert_productos(
	in p_nombre_producto varchar(60),
	in p_precio decimal (10,2),
	in p_stock int,
	in p_estado int
)
begin
	insert into Productos(nombre_producto, precio, stock, estado)
	values(p_nombre_producto, p_precio, p_stock, p_estado);
end $$
delimiter ;

delimiter $$
create procedure sp_insert_usuarios(
    in p_username varchar(45),
    in p_password varchar(45),
    in p_email varchar(60),
    in p_rol varchar(45),
    in p_estado int
)
begin
    insert into Usuarios(username, password, email, rol, estado)
		values (p_username, p_password, p_email, p_rol, p_estado);
end $$
delimiter ;

delimiter $$
create procedure sp_insert_clientes(
    in p_nombre varchar(50),
    in p_apellido varchar(50),
    in p_direccion varchar(100),
    in p_estado int
)
begin
    insert into Clientes(nombre_cliente, apellido_cliente, direccion, estado)
		values (p_nombre, p_apellido, p_direccion, p_estado);
end $$
delimiter ;

delimiter $$
create procedure sp_insert_ventas(
    in p_fecha date,
    in p_total decimal(10,2),
    in p_estado int,
    in p_cliente int,
    in p_usuario int
)
begin
    insert into Ventas(fecha_venta, total, estado, clientes_dpi_cliente, usuarios_codigo_usuario)
    values (p_fecha, p_total, p_estado, p_cliente, p_usuario);
end $$
delimiter ;

delimiter $$
create procedure sp_insert_detalle_venta(
    in p_cantidad int,
    in p_precio decimal(10,2),
    in p_subtotal decimal(10,2),
    in p_producto int,
    in p_venta int
)
begin
    insert into Detalle_Venta(cantidad, precio_unitario, subtotal, productos_codigo_producto, ventas_codigo_venta)
		values (p_cantidad, p_precio, p_subtotal, p_producto, p_venta);
end $$
delimiter ;

-- --------------------------------------------------------------------------------------LLAMAR PROCEDIMIENTOS
call sp_insert_productos('filtro de aceite',45.00,50,1);
call sp_insert_productos('pastillas de freno',120.00,30,1);
call sp_insert_productos('bujias',30.00,100,1);
call sp_insert_productos('amortiguador',220.00,20,1);
call sp_insert_productos('radiador',450.00,15,1);
call sp_insert_productos('bateria 12v',380.00,25,1);
call sp_insert_productos('correa de tiempo',95.00,40,1);
call sp_insert_productos('disco de freno',160.00,35,1);
call sp_insert_productos('alternador',520.00,10,1);
call sp_insert_productos('filtro de aire',35.00,60,1);

call sp_insert_usuarios('admin','123','admin@mail.com','admin',1);
call sp_insert_usuarios('user1','123','user1@mail.com','user',1);
call sp_insert_usuarios('user2','123','user2@mail.com','user',1);
call sp_insert_usuarios('user3','123','user3@mail.com','user',1);
call sp_insert_usuarios('user4','123','user4@mail.com','user',1);
call sp_insert_usuarios('user5','123','user5@mail.com','user',1);
call sp_insert_usuarios('user6','123','user6@mail.com','user',1);
call sp_insert_usuarios('user7','123','user7@mail.com','user',1);
call sp_insert_usuarios('user8','123','user8@mail.com','user',1);
call sp_insert_usuarios('user9','123','user9@mail.com','user',1);

call sp_insert_clientes('juan','perez','zona 1',1);
call sp_insert_clientes('maria','lopez','zona 2',1);
call sp_insert_clientes('carlos','ramirez','zona 3',1);
call sp_insert_clientes('ana','gomez','zona 4',1);
call sp_insert_clientes('luis','hernandez','zona 5',1);
call sp_insert_clientes('sofia','martinez','zona 6',1);
call sp_insert_clientes('pedro','castillo','zona 7',1);
call sp_insert_clientes('lucia','morales','zona 8',1);
call sp_insert_clientes('diego','rojas','zona 9',1);
call sp_insert_clientes('elena','flores','zona 10',1);

call sp_insert_ventas('2024-05-01',150.00,1,1,1);
call sp_insert_ventas('2024-05-02',200.00,1,2,2);
call sp_insert_ventas('2024-05-03',300.00,1,3,3);
call sp_insert_ventas('2024-05-04',120.00,1,4,4);
call sp_insert_ventas('2024-05-05',500.00,1,5,5);
call sp_insert_ventas('2024-05-06',250.00,1,6,6);
call sp_insert_ventas('2024-05-07',175.00,1,7,7);
call sp_insert_ventas('2024-05-08',600.00,1,8,8);
call sp_insert_ventas('2024-05-09',90.00,1,9,9);
call sp_insert_ventas('2024-05-10',450.00,1,10,10);

call sp_insert_detalle_venta(2,75.00,150.00,1,1);
call sp_insert_detalle_venta(1,200.00,200.00,2,2);
call sp_insert_detalle_venta(3,100.00,300.00,3,3);
call sp_insert_detalle_venta(2,60.00,120.00,4,4);
call sp_insert_detalle_venta(5,100.00,500.00,5,5);
call sp_insert_detalle_venta(2,125.00,250.00,6,6);
call sp_insert_detalle_venta(1,175.00,175.00,7,7);
call sp_insert_detalle_venta(3,200.00,600.00,8,8);
call sp_insert_detalle_venta(1,90.00,90.00,9,9);
call sp_insert_detalle_venta(2,225.00,450.00,10,10);