-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1:3307
-- Thời gian đã tạo: Th5 29, 2019 lúc 05:04 PM
-- Phiên bản máy phục vụ: 10.1.38-MariaDB
-- Phiên bản PHP: 5.6.40

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `dblab2quiz`
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `student`
--

INSERT INTO `student` (`id`, `name`, `email`, `pass`) VALUES
(1, 'Lâm Thông', 'lamthong@gmail.com', 'lamthong123'),
(2, 'Huân Tr?n', 'huantran@gmail.com', 'huantran123');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `student_questions`
--

CREATE TABLE `student_questions` (
  `student_id` int(11) NOT NULL,
  `question_id` int(11) NOT NULL,
  `answer` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Đang đổ dữ liệu cho bảng `student_questions`
--

INSERT INTO `student_questions` (`student_id`, `question_id`, `answer`) VALUES
(1, 1, 'a'),
(1, 2, 'a'),
(1, 3, 'a'),
(1, 4, 'a'),
(1, 5, 'a'),
(1, 6, 'a'),
(1, 7, 'a'),
(1, 8, 'a'),
(1, 9, 'a'),
(1, 10, 'a');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `questions`
--
ALTER TABLE `questions`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `student_questions`
--
ALTER TABLE `student_questions`
  ADD PRIMARY KEY (`student_id`,`question_id`),
  ADD KEY `question_id` (`question_id`);

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `student_questions`
--
ALTER TABLE `student_questions`
  ADD CONSTRAINT `student_questions_ibfk_1` FOREIGN KEY (`student_id`) REFERENCES `student` (`id`),
  ADD CONSTRAINT `student_questions_ibfk_2` FOREIGN KEY (`question_id`) REFERENCES `questions` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
