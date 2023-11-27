-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 29, 2021 at 03:04 PM
-- Server version: 10.4.19-MariaDB
-- PHP Version: 8.0.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `gradingdb`
--

-- --------------------------------------------------------

--
-- Table structure for table `gradinginfo`
--

CREATE TABLE `gradinginfo` (
  `sid` int(10) NOT NULL,
  `sname` varchar(50) NOT NULL,
  `sgender` varchar(10) NOT NULL,
  `sprelim` float NOT NULL,
  `smidterm` float NOT NULL,
  `sprefinal` float NOT NULL,
  `sfinal` float NOT NULL,
  `saverage` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `gradinginfo`
--

INSERT INTO `gradinginfo` (`sid`, `sname`, `sgender`, `sprelim`, `smidterm`, `sprefinal`, `sfinal`, `saverage`) VALUES
(10017, 'Dex', 'Male', 40, 40, 40, 40, 40),
(10018, 'Dwanne Gideon', 'Male', 90, 90, 90, 90, 90),
(10019, 'Kalma Migos', 'Male', 80, 85, 89, 93, 86.8),
(10020, 'Waning-ning', 'Female', 89, 95, 98, 98, 95),
(10021, 'Maring', 'Female', 89, 89, 90, 90, 89.5),
(10022, 'Romeo', 'Male', 90, 90, 95, 95, 92.5),
(10023, 'Danny', 'Male', 90, 60, 50, 80, 70),
(10024, 'Mhel', 'Male', 70, 70, 80, 80, 75),
(10025, 'Arlene', 'Female', 80, 90, 97, 99, 91.5),
(10026, 'Cres', 'Female', 70, 80, 80, 90, 80),
(10027, 'Ester', 'Female', 80, 80, 80, 80, 80),
(10028, 'Gideon', 'Male', 95, 95, 95, 95, 95),
(10029, 'Florante', 'Male', 95, 91, 92, 80, 89.5),
(10030, 'Laura', 'Female', 70, 70, 80, 80, 75),
(10031, 'Shaira', 'Female', 80, 90, 88, 89, 86.8),
(10032, 'Stephen', 'Male', 80, 67, 77, 89, 78.3),
(10033, 'Darwin', 'Male', 80, 87, 79, 89, 83.8),
(10034, 'Nathaniel', 'Male', 80, 80, 80, 89, 82.3),
(10035, 'Devyn', 'Male', 80, 60, 70, 73, 70.8),
(10036, 'Dexter', 'Male', 80, 90, 90, 99, 89.8),
(10037, 'Swannie', 'Female', 99, 95, 95, 95, 96),
(10038, 'Sarah', 'Female', 91, 85, 85, 84, 86.3),
(10039, 'Jacob', 'Male', 85, 84, 85, 84, 84.5),
(10040, 'Jacob', 'Male', 85, 84, 85, 80, 83.5),
(10041, 'Joseph', 'Male', 80, 84, 80, 89, 83.3);

-- --------------------------------------------------------

--
-- Table structure for table `register`
--

CREATE TABLE `register` (
  `id` int(50) NOT NULL,
  `full_name` varchar(50) NOT NULL,
  `contact` varchar(50) NOT NULL,
  `gender` varchar(20) NOT NULL,
  `address` varchar(50) NOT NULL,
  `email` varchar(60) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `register`
--

INSERT INTO `register` (`id`, `full_name`, `contact`, `gender`, `address`, `email`, `username`, `password`) VALUES
(1, '0', '', '', '', '', 'dext', '1234'),
(3, 'dd', '33', 'MALE', 'rr', 'rr', 'rr', 'rr'),
(4, 'test', '333', 'MALE', 'tetetete', 'test1', 'testing', '1234'),
(5, 'Dexter Alvarado', '548575947465', 'MALE', 'Dalaguete', 'Dex@gmail.com', 'dexter', '1234'),
(6, 'dd', '4', 'MALE', 'dd', 'dd', 'dd', '1'),
(7, 'dd', '333', 'MALE', 'dddd', 'ddd', 'ex', '12'),
(8, 'dd', '333', 'MALE', 'eee', 'eee', 'eee', 'eee'),
(9, 'ttt', '123', 'MALE', 'ddd', 'fff', 'fff', '12'),
(10, 'test', '12', 'MALE', 'data', 'data', 'data', '1234'),
(11, 'dddddd', '333', 'MALE', 'dddw', 'ggg', 'ggg', 'ggg'),
(12, 'ddd', '333', 'MALE', 'rrrrr', 'rrrrrrrr', 'rrr', 'rrr'),
(13, 'dddddd', '3333', 'MALE', 'rrrr', 'ttttt', 'tt', 't'),
(14, 'ffff', '444', 'FEMALE', 'ffff', 'cccccc', 'cc', 'vv'),
(15, 'ddddd', '3333', 'MALE', 'ddd', 'dddd', 'ddrrr', '1'),
(16, 'fffffffffffff', '564', 'FEMALE', 'ryry', 'tyt', 'hhhhh', 'w'),
(17, 'dh', '55', 'MALE', 'g', 'g', 'g', 'g'),
(18, 'dddddddddddddd', '3243', 'MALE', 'ddddddddddddd', 'dddddddddddddddd', 'dddddddddddddddd', '1'),
(19, 'dddd', '444', 'MALE', 'ff', 'ff', 'ff', 'ff'),
(20, 'Dexter', '3333', 'FEMALE', 'rrrr', 'rrr', 'rrt', 'rr'),
(21, 'dddd', '333', 'MALE', 'ttt', 'tttt', 'ttttttt', 't'),
(22, 'ddd', '333', 'MALE', 'ddd', 'dd', 'dtd', '1'),
(23, 'asdfsf', '2134335', 'FEMALE', 'aaaa', 'aaaa', 'ddddd', 'we'),
(24, 'wdw', '222', 'MALE', 'dsfdf', 'fdffff', 'gggg', '1'),
(25, 'ewtewr', '3333', 'MALE', 'rrr', 'rrrrrt', 'rtrt', '1'),
(26, 'werewr', '3444', 'MALE', '34324', '435455', 'errer34', '1'),
(27, 'eertet', '34535', 'MALE', 'tttt', 'tttt', 'wwww', '12'),
(28, 'werewr', '3333', 'FEMALE', 'rrr', 'ffff', 'gghgh', '1'),
(29, 'Sdfsedf', '3333', 'MALE', 'erer', 'ererererere', 'rere', '1'),
(30, 'ertretret', '3434', 'MALE', 'ett', 'ddsgd', 'ggggt', '1'),
(31, 'sdegFSDG', '324324', 'MALE', 'fffff', 'ewtrewt', 'wetwerwtrewt', '1');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `gradinginfo`
--
ALTER TABLE `gradinginfo`
  ADD PRIMARY KEY (`sid`);

--
-- Indexes for table `register`
--
ALTER TABLE `register`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `gradinginfo`
--
ALTER TABLE `gradinginfo`
  MODIFY `sid` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10042;

--
-- AUTO_INCREMENT for table `register`
--
ALTER TABLE `register`
  MODIFY `id` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=32;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
