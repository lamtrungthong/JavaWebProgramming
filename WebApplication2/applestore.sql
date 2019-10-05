-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Oct 02, 2019 at 05:22 PM
-- Server version: 10.4.6-MariaDB
-- PHP Version: 7.1.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `applestore`
--

-- --------------------------------------------------------

--
-- Table structure for table `advertise`
--

CREATE TABLE `advertise` (
  `id` int(11) NOT NULL,
  `prod_id` int(11) DEFAULT NULL,
  `images` varchar(1000) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `created_at` datetime DEFAULT current_timestamp(),
  `updated_at` datetime DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `advertise`
--

INSERT INTO `advertise` (`id`, `prod_id`, `images`, `state`, `created_at`, `updated_at`) VALUES
(2, 9338, '637042428793730975_FS1 (1).png', 1, '2019-09-17 18:25:38', '2019-09-17 18:25:38');

-- --------------------------------------------------------

--
-- Table structure for table `info`
--

CREATE TABLE `info` (
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `address` varchar(1000) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `created_at` datetime DEFAULT current_timestamp(),
  `updated_at` datetime DEFAULT current_timestamp(),
  `user_id` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `info`
--

INSERT INTO `info` (`name`, `phone`, `address`, `created_at`, `updated_at`, `user_id`) VALUES
('Lam thong', '0965147758', 'Thanh Xuan Tung, Thanh Xuan', '2019-09-23 22:17:11', '2019-09-23 22:17:11', 'U533569'),
('', '', '', '2019-09-24 11:39:11', '2019-09-24 11:39:11', NULL),
('Admin', '987654321', 'Ha Noi', '2019-09-27 08:01:14', '2019-09-27 08:01:14', 'ADMIN');

-- --------------------------------------------------------

--
-- Table structure for table `kind_prod`
--

CREATE TABLE `kind_prod` (
  `id` int(11) NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `created_at` datetime DEFAULT current_timestamp(),
  `updated_at` datetime DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `kind_prod`
--

INSERT INTO `kind_prod` (`id`, `name`, `created_at`, `updated_at`) VALUES
(1, 'MacBook', '2019-09-12 10:49:22', '2019-09-12 10:49:22'),
(2, 'iPad', '2019-09-12 10:49:22', '2019-09-12 10:49:22'),
(3, 'iPhone', '2019-09-12 10:49:22', '2019-09-12 10:49:22'),
(4, 'AppleWatch', '2019-09-12 10:49:23', '2019-09-12 10:49:23'),
(5, 'Phụ kiện', '2019-09-14 15:43:27', '2019-09-14 15:43:27');

-- --------------------------------------------------------

--
-- Table structure for table `orders`
--

CREATE TABLE `orders` (
  `id` varchar(50) NOT NULL,
  `user_id` varchar(50) DEFAULT NULL,
  `pay_id` int(11) DEFAULT NULL,
  `order_status` int(11) DEFAULT NULL,
  `ordered_at` datetime DEFAULT current_timestamp(),
  `updated_at` datetime DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `orders`
--

INSERT INTO `orders` (`id`, `user_id`, `pay_id`, `order_status`, `ordered_at`, `updated_at`) VALUES
('ORDER479999', 'U533569', 1, 4, '2019-10-01 12:04:01', '2019-10-01 00:00:00'),
('ORDER530999', 'U533569', 1, 5, '2019-10-01 00:25:49', '2019-10-01 00:00:00'),
('ORDER650999', 'U533569', 1, 5, '2019-10-01 00:13:20', '2019-10-01 00:00:00');

-- --------------------------------------------------------

--
-- Table structure for table `order_items`
--

CREATE TABLE `order_items` (
  `id` int(11) NOT NULL,
  `order_id` varchar(50) DEFAULT NULL,
  `prod_id` int(11) DEFAULT NULL,
  `color` varchar(50) DEFAULT NULL,
  `amount` int(11) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `order_items`
--

INSERT INTO `order_items` (`id`, `order_id`, `prod_id`, `color`, `amount`, `quantity`) VALUES
(39, 'ORDER650999', 9338, 'Pink', 179700000, 3),
(40, 'ORDER530999', 9144, 'Gray', 14900000, 1),
(41, 'ORDER479999', 9338, 'Gray', 59900000, 1);

-- --------------------------------------------------------

--
-- Table structure for table `order_status`
--

CREATE TABLE `order_status` (
  `id` int(11) NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `order_status`
--

INSERT INTO `order_status` (`id`, `name`) VALUES
(1, 'Đang xử lý'),
(2, 'Đã tiếp nhận đơn hàng'),
(3, 'Đã giao hàng'),
(4, 'Đã hủy'),
(5, 'Đã hoàn thành');

-- --------------------------------------------------------

--
-- Table structure for table `pays`
--

CREATE TABLE `pays` (
  `id` int(11) NOT NULL,
  `name` varchar(500) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `products`
--

CREATE TABLE `products` (
  `id` int(11) NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `kind_id` int(11) DEFAULT NULL,
  `price_store` int(11) DEFAULT NULL,
  `quantity_store` int(11) DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  `discount` int(11) DEFAULT NULL,
  `description` varchar(1000) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `images` varchar(1000) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `actived` int(11) DEFAULT NULL,
  `sell` int(11) DEFAULT NULL,
  `created_at` datetime DEFAULT current_timestamp(),
  `updated_at` datetime DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `products`
--

INSERT INTO `products` (`id`, `name`, `kind_id`, `price_store`, `quantity_store`, `price`, `discount`, `description`, `images`, `actived`, `sell`, `created_at`, `updated_at`) VALUES
(9144, 'iPad Mini', 2, 10000000, 108, 15000000, 100000, '   iPad Mini 5 7.9 Wi-Fi 4G 64GB', '636923894581665280_ipad-mini5-4g-gold-1.png', 1, 0, '2019-09-29 21:58:40', '2019-09-29 21:58:40'),
(9338, 'MacBook Pro 2019', 1, 40000000, 13, 60000000, 100000, 'MacBook Pro 2019 SSD 512 GB', '636778883213369758_macbook-air-13-2018-Gold-1.png', 1, 1, '2019-09-29 08:23:58', '2019-10-01 00:00:00'),
(9612, 'Tai nghe', 5, 500000, 100, 800000, 100000, 'Apple Tai nghe Earpods with Lightning Connection', '636283805547273121_HMPK-TAI-NGHE-EARPODS-WITH-LIGHTNING-CONNECTION-00281530-1.jpg', 0, 0, '2019-09-29 21:39:01', '2019-09-29 21:39:01');

-- --------------------------------------------------------

--
-- Table structure for table `prod_detail`
--

CREATE TABLE `prod_detail` (
  `id` int(11) NOT NULL,
  `prod_id` int(11) DEFAULT NULL,
  `display` decimal(10,2) DEFAULT NULL,
  `os` varchar(255) DEFAULT NULL,
  `ram` int(11) DEFAULT NULL,
  `rom` int(11) DEFAULT NULL,
  `f_camera` int(11) DEFAULT NULL,
  `b_camera` int(11) DEFAULT NULL,
  `battery` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `prod_detail`
--

INSERT INTO `prod_detail` (`id`, `prod_id`, `display`, `os`, `ram`, `rom`, `f_camera`, `b_camera`, `battery`) VALUES
(5, 9338, '15.00', 'macOS', 8, 512, 7, 0, 4000),
(6, 9144, '8.00', 'iOS 12', 3, 64, 7, 8, 5124);

-- --------------------------------------------------------

--
-- Table structure for table `prod_images`
--

CREATE TABLE `prod_images` (
  `id` int(11) NOT NULL,
  `prod_id` int(11) DEFAULT NULL,
  `image` varchar(1000) DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `prod_images`
--

INSERT INTO `prod_images` (`id`, `prod_id`, `image`, `name`) VALUES
(6, 9338, '636778883213369758_macbook-air-13-2018-Gold-1.png', 'Pink'),
(7, 9338, '636330306635691141_800-1.jpg', 'Gray'),
(8, 9144, '636923894581665280_ipad-mini5-4g-gold-1.png', 'Gold'),
(9, 9144, '636923890241399350_ipad-mini5-4g-grey-1.png', 'Gray');

-- --------------------------------------------------------

--
-- Table structure for table `role`
--

CREATE TABLE `role` (
  `id` int(11) NOT NULL,
  `role` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `created_at` datetime DEFAULT current_timestamp(),
  `updated_at` datetime DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `role`
--

INSERT INTO `role` (`id`, `role`, `created_at`, `updated_at`) VALUES
(1, 'admin', '2019-09-22 11:41:29', '2019-09-22 11:41:29'),
(2, 'employee', '2019-09-22 11:41:29', '2019-09-22 11:41:29'),
(3, 'guest', '2019-09-22 11:41:29', '2019-09-22 11:41:29');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` varchar(50) NOT NULL,
  `uname` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `pwd` varchar(1000) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `actived` int(11) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  `created_at` datetime DEFAULT current_timestamp(),
  `updated_at` datetime DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `uname`, `pwd`, `name`, `actived`, `role_id`, `created_at`, `updated_at`) VALUES
('ADMIN', 'applestore@gmail.com', '21232f297a57a5a743894a0e4a801fc3', NULL, 1, 1, '2019-09-25 22:18:44', '2019-09-25 22:18:44'),
('U533569', 'lds2hc@gmail.com', 'd16fb36f0911f878998c136191af705e', 'Lam Thong', 1, 3, '2019-09-23 22:17:11', '2019-09-23 22:17:11');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `advertise`
--
ALTER TABLE `advertise`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `kind_prod`
--
ALTER TABLE `kind_prod`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `order_items`
--
ALTER TABLE `order_items`
  ADD PRIMARY KEY (`id`),
  ADD KEY `order_fk` (`order_id`);

--
-- Indexes for table `order_status`
--
ALTER TABLE `order_status`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `pays`
--
ALTER TABLE `pays`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `prod_detail`
--
ALTER TABLE `prod_detail`
  ADD PRIMARY KEY (`id`),
  ADD KEY `prod_fk` (`prod_id`);

--
-- Indexes for table `prod_images`
--
ALTER TABLE `prod_images`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `advertise`
--
ALTER TABLE `advertise`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `order_items`
--
ALTER TABLE `order_items`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=42;

--
-- AUTO_INCREMENT for table `prod_detail`
--
ALTER TABLE `prod_detail`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `prod_images`
--
ALTER TABLE `prod_images`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `role`
--
ALTER TABLE `role`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `order_items`
--
ALTER TABLE `order_items`
  ADD CONSTRAINT `order_fk` FOREIGN KEY (`order_id`) REFERENCES `orders` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `prod_detail`
--
ALTER TABLE `prod_detail`
  ADD CONSTRAINT `prod_fk` FOREIGN KEY (`prod_id`) REFERENCES `products` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
