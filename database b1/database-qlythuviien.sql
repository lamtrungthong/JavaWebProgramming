drop database qlythuvien;

create database if not exists qlythuvien;
use qlythuvien;

create table if not exists sach (
masach varchar (10) primary key,
tensach varchar (100) not null,
tacgia varchar (100) not null,
nxb varchar (100) not null,
soluong int
);

create table if not exists docgia (
sothe varchar (10) primary key,
ten varchar (100) not null,
khoa varchar (100) not null,
khoahoc varchar (100) not null,
thoihanthe date
);

create table if not exists phieumuon (
masach varchar (10)  ,
sothe varchar (10)  ,
ngaymuon date,
ngaytra date,
ghichu varchar (255),
primary key (masach, sothe),
foreign key (masach) references sach(masach) on delete cascade,
foreign key (sothe) references docgia(sothe) on delete cascade
);

/* insert sach*/

insert into sach(masach, tensach, tacgia, nxb, soluong ) values ('S001', 'Toan', 'Nguyen Dinh Tri', 'GD VN', '100' );
insert into sach(masach, tensach, tacgia, nxb, soluong ) values ('S002', 'Java', 'Hoang Minh Nghiem', 'ACT', '200' );
insert into sach(masach, tensach, tacgia, nxb, soluong ) values ('S003', 'SQL', 'Nguyen Thi Huong', 'KMA', '100' );
insert into sach(masach, tensach, tacgia, nxb, soluong ) values ('S004', 'Web', 'Le Duc Thuan', 'KMA', '150' );
insert into sach(masach, tensach, tacgia, nxb, soluong ) values ('S005', 'Tin', 'Nguyen Hong Van', 'KMA', '200' );

/* insert docgia*/

insert into docgia(sothe, ten, khoa, khoahoc, thoihanthe) values ('CT001', 'Lam Trung Thong', 'CNTT', 'CT1', '2021/6/30'); 
insert into docgia(sothe, ten, khoa, khoahoc, thoihanthe) values ('CT002', 'Nguyen Nhat Anh', 'CNTT', 'CT1', '2021/6/30'); 
insert into docgia(sothe, ten, khoa, khoahoc, thoihanthe) values ('CT003', 'Duong Duc Luong', 'CNTT', 'CT1', '2021/6/30'); 
insert into docgia(sothe, ten, khoa, khoahoc, thoihanthe) values ('CT004', 'Giap Van Tho', 'CNTT', 'CT1', '2021/6/30'); 
insert into docgia(sothe, ten, khoa, khoahoc, thoihanthe) values ('CT005', 'Le Viet My', 'CNTT', 'CT1', '2021/6/30'); 

/* insert phieumuon*/

insert into phieumuon( masach, sothe, ngaymuon, ngaytra, ghichu ) values ( 'S001', 'CT005', '2018/1/1', '2018/3/1', 'Da tra' ) ;
insert into phieumuon( masach, sothe, ngaymuon, ngaytra, ghichu ) values ( 'S002', 'CT004', '2018/1/1', '2018/6/1', 'Da tra' ) ;
insert into phieumuon( masach, sothe, ngaymuon, ngaytra, ghichu ) values ( 'S003', 'CT003', '2018/7/11', '2018/11/11', 'Chua tra' ) ;
insert into phieumuon( masach, sothe, ngaymuon, ngaytra, ghichu ) values ( 'S004', 'CT002', '2018/8/1', '2018/12/1', 'Chua tra' ) ;
insert into phieumuon( masach, sothe, ngaymuon, ngaytra, ghichu ) values ( 'S005', 'CT001', '2018/1/21', '2018/3/21', 'Da tra' ) ;

/*  xóa, cập nhật*/
DELETE FROM docgia
WHERE sothe = 'CT002';

UPDATE docgia
SET ten='Nguyen Nhat Anh'
WHERE sothe = 'CT005';

/* Hiển thị tên, khoa của các độc giả và sắp xếp theo khoa*/
select ten, khoa from docgia order by khoa;

/* Tim những đọc giả mượn sách Toán vào ngày 1/1/2018
select docgia.* from docgia join phieumuon on docgia.sothe = phieumuon.sothe join sach on sach.masach  = phieumuon.masach
where sach.tensach like 'Toan' and phieumuon.ngaymuon like '2018-01-01' ;*/

/* Hiển thị tên, số thẻ, tên sách của tất cả đọc giả mượn sách trong
tháng 1/2018*/
select docgia.* from docgia join phieumuon on docgia.sothe = phieumuon.sothe join sach on sach.masach = phieumuon.masach
where year(phieumuon.ngaymuon) = 2018 and month(phieumuon.ngaymuon) = 1;

/* Danh sách các sách không ai mượn*/
select * from sach
where masach not in (select masach  from phieumuon);

/*Cho biết đọc giả tên Anh mượn sách bao nhiêu lần*/
select docgia.ten, count(masach) as 'sl sach muon' from phieumuon join docgia on phieumuon.sothe = docgia.sothe
where docgia.ten like '%Anh'
group by masach;

/*Danh sách tên, số thẻ, các độc giả chưa trả sách*/
select docgia.ten, docgia.sothe from docgia join phieumuon on docgia.sothe = phieumuon.sothe
where phieumuon.ghichu like 'Chua %';