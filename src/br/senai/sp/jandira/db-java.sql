CREATE SCHEMA bang_db;
USE bang_db;


CREATE TABLE clientes
(
id_cliente int primary key auto_increment not null,
nome varchar(45) not null,
email varchar (45) null,
telefone long not null,
endereco varchar (100) not null,
cpf long not null

);

INSERT INTO clientes VALUES
(0 , "Francisca da Silva", "silvafrancisca@gmail.com", 11988537879, "Jandira-SP, Parque St.Tereza, R.Osasco ", 62391072040),
(0 , "Luana Magalhães", "lulumagali@gmail.com", 11955735001, "Barueri-SP, Centro, Av.Guilherme Perereca", 05524299026),
(0 , "Guilherme Santino", "santigui@gmail.com", 11970914265, "Salvador-BA, Centro, R.dos Namorados", 90092723039),
(0 ,"Celio Firmino", "celio@gmail.com", 11910987348, "Recife-PE, Centro, Av.Barbosa Lima", 79045170000),
(0 , "Renata Adelaide", "adelerere@gmail.com", 11984737879, "Luis Eduardo Magalhães-BA, Centro, R.Pau Ferro", 94801578020),
(0, "Yara Pataxó", "ptxyara@gmail.com", 11908004266, "Manaus-AM, Aleixo, R.Aramã", 57701821058),
(0 ,"Matheus Teixeira", "txteteu@gmail.com", 11975490235, "Macapá-AP, Santa Rita, R.Paraná", 57845801089),
(0 ,"Cecilia dos Santos", "ceci@gmail.com", 11947829645, "Santos-SP, Gonzaga, Av.Ana Costa", 26792808067),
(0 ,"Tenêncio Domingues", "domtenencio@gmail.com", 11987467270, "Gramado-RS, Centro, R.Ernesto Volk", 22891362047),
(0 ,"Julio Cocielo", "juliocolielo@gmail.com", 11976438654, "Rio de Janeiro-RJ, Ipanema, Av.Vieira Souto", 72149255081);


SELECT * FROM clientes;

CREATE TABLE categorias
(
id_categoria int primary key auto_increment not null,
nome varchar(45) not null
);

INSERT INTO categorias VALUES
(0, "Mouse"),
(0, "Teclado"),
(0, "Monitor"),
(0, "Armazenamento"),
(0, "Processador"),
(0, "Memória RAM"),
(0, "Placa-mãe"),
(0, "Placa de Video"),
(0, "Cooler"),
(0, "Fonte");

SELECT * FROM categorias;

CREATE TABLE produtos
(
id_produto int primary key auto_increment not null,
nome varchar(45) not null,
marca varchar (45) not null,
descricao varchar (250) not null,
preco double not null,
quantidade_estoque int not null,
id_categoria int not null,

foreign key (id_categoria) references categorias (id_categoria)
);

INSERT INTO produtos VALUES
(0, "Mouse sem fio Magic Mouse", "Apple", "Mouse multi-touch recarregável, entrada lightning ", 810.99, 20, 1),
(0, "Processador Ryzen 7 5700X", "AMD", "Socket AM4, Suporte PCIe 4.0, 3.4GHz", 1149.84, 37, 5),
(0, "Processador Core I7 10700K", "Intel", "Socket FCLGA1200, 3.8GHz", 1762.87, 54, 5),
(0, "Processador Core I5 10400", "Intel", "Socket FCLGA1200, 2.9GHz", 999.99, 17, 5),
(0, "Monitor Odyssey G9", "Samsung", "49', HDMI, DisplayPort, 240Hz", 11000.00, 24, 3),
(0, "Monitor Studio Display", "Apple", "27', 5K, Câmera ultra-angular de 12 MP com Palco Central", 16000.00, 12, 3),
(0, "Monitor UltraGear", "LG", "24', 144Hz, HDMI, DisplayPort", 863.49, 13, 3),
(0, "SSD", "Kingston", "1TB, PCIe, NVMe", 309.10, 104, 4),
(0, "SDD", "SanDisk", "SATA III", 300, 56, 4),
(0, "Teclado com fio TC193", "Multilaser", "Preto, Usb", 30.99, 42, 2),
(0, "Teclado sem fio KB740", "Dell", "Bluetooth, Teclado numérico", 579.00, 15, 2);

SELECT * FROM produtos;



CREATE TABLE pedidos
(
id_pedido int primary key auto_increment not null,
id_cliente int not null,
data_pedido date not null,

foreign key (id_cliente) references clientes(id_cliente)
);

INSERT INTO pedidos VALUES
(0, 2, '2023-10-02'),
(0, 7, '2021-02-07'),
(0, 5, '2023-09-30'),
(0, 7, '2023-09-29'),
(0, 3, '2023-01-01'),
(0, 4, '2023-07-24'),
(0, 5, '2023-05-23'),
(0, 9, '2022-07-24');

CREATE TABLE vendas
(
id_venda int primary key auto_increment not null,
id_pedido int not null,
id_produto int not null,

foreign key (id_produto) references produtos (id_produto),
foreign key (id_pedido) references pedidos (id_pedido)
);

INSERT INTO vendas VALUES
(0, 1, 1),
(0, 2, 2),
(0, 3, 3),
(0, 4, 4),
(0, 5, 4),
(0, 6, 6),
(0, 6, 11),
(0, 8, 8),
(0, 1, 7),
(0, 8, 9);

SELECT * FROM vendas INNER JOIN pedidos ON pedidos.id_pedido = vendas.id_pedido INNER JOIN produtos ON produtos.id_produto = vendas.id_produto INNER JOIN clientes ON clientes.id_cliente = pedidos.id_cliente WHERE clientes.nome LIKE '%Luana%'

