-- phpMyAdmin SQL Dump
-- version 4.4.14
-- http://www.phpmyadmin.net
--
-- 主機: 127.0.0.1
-- 產生時間： 2017-02-26 19:18:40
-- 伺服器版本: 5.6.26
-- PHP 版本： 5.6.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- 資料庫： `eldertour2`
--

-- --------------------------------------------------------

--
-- 資料表結構 `category`
--

CREATE TABLE IF NOT EXISTS `category` (
  `categoryID` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `category_name` varchar(20) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- 資料表結構 `landscape`
--

CREATE TABLE IF NOT EXISTS `landscape` (
  `landscapeID` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `landscape_name` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `longitude` double(10,10) NOT NULL,
  `latitude` double(10,10) DEFAULT NULL,
  `address` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL,
  `introduce` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `property` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- 資料表結構 `member`
--

CREATE TABLE IF NOT EXISTS `member` (
  `memberID` int(20) unsigned NOT NULL,
  `member_account` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `member_password` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `name` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `sex` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `phone` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `mail` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `point` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- 資料表結構 `mysuit`
--

CREATE TABLE IF NOT EXISTS `mysuit` (
  `mysuitID` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `date` date DEFAULT NULL,
  `memberID` int(20) unsigned DEFAULT NULL,
  `suitID` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- 資料表結構 `property`
--

CREATE TABLE IF NOT EXISTS `property` (
  `propertyID` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `property_name` varchar(20) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- 資料表結構 `suit`
--

CREATE TABLE IF NOT EXISTS `suit` (
  `suitID` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `suit_name` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `category` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `introduce` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- 資料表結構 `suit_landscape`
--

CREATE TABLE IF NOT EXISTS `suit_landscape` (
  `suit_landscapeID` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `landscapeID` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `suitID` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- 已匯出資料表的索引
--

--
-- 資料表索引 `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`categoryID`);

--
-- 資料表索引 `landscape`
--
ALTER TABLE `landscape`
  ADD PRIMARY KEY (`landscapeID`),
  ADD KEY `property` (`property`);

--
-- 資料表索引 `member`
--
ALTER TABLE `member`
  ADD PRIMARY KEY (`memberID`);

--
-- 資料表索引 `mysuit`
--
ALTER TABLE `mysuit`
  ADD PRIMARY KEY (`mysuitID`),
  ADD KEY `memberID` (`memberID`),
  ADD KEY `suitID` (`suitID`);

--
-- 資料表索引 `property`
--
ALTER TABLE `property`
  ADD PRIMARY KEY (`propertyID`);

--
-- 資料表索引 `suit`
--
ALTER TABLE `suit`
  ADD PRIMARY KEY (`suitID`),
  ADD KEY `category` (`category`);

--
-- 資料表索引 `suit_landscape`
--
ALTER TABLE `suit_landscape`
  ADD PRIMARY KEY (`suit_landscapeID`),
  ADD KEY `landscapeID` (`landscapeID`),
  ADD KEY `suitID` (`suitID`);

--
-- 在匯出的資料表使用 AUTO_INCREMENT
--

--
-- 使用資料表 AUTO_INCREMENT `member`
--
ALTER TABLE `member`
  MODIFY `memberID` int(20) unsigned NOT NULL AUTO_INCREMENT;
--
-- 已匯出資料表的限制(Constraint)
--

--
-- 資料表的 Constraints `landscape`
--
ALTER TABLE `landscape`
  ADD CONSTRAINT `landscape_ibfk_1` FOREIGN KEY (`property`) REFERENCES `property` (`propertyID`);

--
-- 資料表的 Constraints `mysuit`
--
ALTER TABLE `mysuit`
  ADD CONSTRAINT `mysuit_ibfk_1` FOREIGN KEY (`memberID`) REFERENCES `member` (`memberID`),
  ADD CONSTRAINT `mysuit_ibfk_2` FOREIGN KEY (`suitID`) REFERENCES `suit` (`suitID`);

--
-- 資料表的 Constraints `suit`
--
ALTER TABLE `suit`
  ADD CONSTRAINT `suit_ibfk_1` FOREIGN KEY (`category`) REFERENCES `category` (`categoryID`);

--
-- 資料表的 Constraints `suit_landscape`
--
ALTER TABLE `suit_landscape`
  ADD CONSTRAINT `suit_landscape_ibfk_1` FOREIGN KEY (`landscapeID`) REFERENCES `landscape` (`landscapeID`),
  ADD CONSTRAINT `suit_landscape_ibfk_2` FOREIGN KEY (`suitID`) REFERENCES `suit` (`suitID`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
