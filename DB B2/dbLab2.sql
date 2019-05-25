-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th5 25, 2019 lúc 11:40 AM
-- Phiên bản máy phục vụ: 10.1.36-MariaDB
-- Phiên bản PHP: 7.2.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `testans`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `questions`
--

CREATE TABLE `questions` (
  `id` int(11) NOT NULL,
  `content` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `answer_a` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `answer_b` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `answer_c` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `answer_d` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `correct` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Đang đổ dữ liệu cho bảng `questions`
--

INSERT INTO `questions` (`id`, `content`, `answer_a`, `answer_b`, `answer_c`, `answer_d`, `correct`) VALUES
(1, 'Lịch nào dài nhất?', 'Lịch sử', 'Lịch treo tường', 'Lịch trình', 'Lịch Vạn Niên', 'a'),
(2, 'Con đường dài nhất là đường nào?', 'Đường HCM', 'Đường Trần Duy Hưng', 'Đường đời', 'Đường Thanh Xuân', 'c'),
(3, 'Con gì đập thì sống, không đập thì chết?', 'Con tim', 'Con gà', 'Con vịt', 'Con chó', 'a'),
(4, 'Xã đông nhất là xã nào?', 'Xã Vạn Linh', 'Xã Hòa Bình', 'Xã Bằng Hữu', 'Xã hội', 'd'),
(5, 'Môn gì càng thắng càng thua?', 'Môn đá bóng', 'Môn đua xe', 'Môn chạy bền', 'Môn bơi', 'b'),
(6, 'Chuột nào đi bằng hai chân?', 'Chuột nhà', 'Chuột đồng', 'Chuột Mickey', 'Chuột cống', 'c'),
(7, 'Vịt nào đi bằng hai chân?', 'Vịt trời', 'Vịt Donan', 'Vịt nuôi', 'Tất cả con vịt', 'd'),
(8, 'Cái gì của chồng mà vợ thích cầm nhất?', 'Tiền', 'Tay', 'Xe', 'Nhà', 'a'),
(9, 'Cái gì tay trái cầm được còn tay phải cầm không được?', 'Bút', 'Tay phải', 'Chân', 'Đầu', 'b'),
(10, 'Sở thú bị cháy, con gì chạy ra đầu tiên?', 'Con hổ', 'Con khỉ', 'con người', 'Con báo', 'c');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `student`
--

CREATE TABLE `student` (
  `id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `pass` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Đang đổ dữ liệu cho bảng `student`
--

INSERT INTO `student` (`id`, `name`, `email`, `pass`) VALUES
(1, 'Lâm Thông', 'lamthong@gmail.com', 'lamthong123'),
(2, 'Huân Tr?n', 'huantran@gmail.com', 'huantran123');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `questions`
--
ALTER TABLE `questions`
  ADD PRIMARY KEY (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
