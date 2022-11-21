-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 20-Nov-2022 às 22:03
-- Versão do servidor: 10.4.25-MariaDB
-- versão do PHP: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `db_parking`
--
DROP DATABASE IF EXISTS db_parking;

CREATE DATABASE IF NOT EXISTS db_parking;
-- --------------------------------------------------------

USE db_parking;
--
-- Estrutura da tabela `blocos`
--

CREATE TABLE `blocos` (
  `id` int(11) NOT NULL,
  `descricao` varchar(16) NOT NULL,
  `operador` varchar(16) NOT NULL,
  `vagas_carros` int(11) NOT NULL,
  `vagas_motos` int(11) NOT NULL,
  `vagas_deficientes` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `blocos`
--

INSERT INTO `blocos` (`id`, `descricao`, `operador`, `vagas_carros`, `vagas_motos`, `vagas_deficientes`) VALUES
(33, 'Bloco D', 'conrad', 0, 0, 0),
(34, 'Bloco D', 'conrad', 0, 0, 0),
(35, 'Bloco D', 'augusto', 3, 5, 3),
(36, 'Bloco D', 'conrad', 0, 0, 0),
(37, 'Bloco D', 'conrad', 0, 0, 0),
(38, 'Bloco D', 'conrad', 0, 0, 0),
(39, 'Bloco D', 'conrad', 0, 0, 0),
(41, 'Bloco D', 'conrad', 0, 0, 0),
(42, 'Bloco D', 'conrad', 0, 0, 0),
(43, 'Bloco D', 'renan', 0, 0, 0),
(44, 'Bloco D', 'conrad', 0, 0, 0),
(45, 'Bloco D', 'conrad', 0, 0, 0),
(46, 'Bloco D', 'conrad', 0, 0, 0),
(47, 'Bloco D', 'conrad', 0, 0, 0),
(48, 'Bloco D', 'conrad', 0, 0, 0),
(49, 'Bloco D', 'conrad', 0, 0, 0),
(50, 'Bloco Z', 'conrad', 0, 0, 0),
(51, 'Bloco D', 'conrad', 0, 0, 0),
(52, 'Bloco D', 'conrad', 0, 0, 0),
(53, 'Bloco D', 'conrad', 0, 0, 0),
(54, 'Bloco D', 'conrad', 1, 3, 4),
(55, 'Bloco D', 'conrad', 0, 0, 0),
(56, 'Bloco D', 'conrad', 0, 0, 0),
(57, 'Bloco D', 'conrad', 0, 0, 0),
(58, 'Bloco D', 'conrad', 0, 0, 0),
(59, 'Bloco D', 'conrad', 0, 0, 0),
(60, 'Bloco D', 'conrad', 0, 0, 0),
(61, 'Bloco H', 'conrad', 0, 0, 0),
(62, 'Bloco D', 'conrad', 0, 0, 0),
(63, 'Bloco D', 'conrad', 0, 0, 0),
(64, 'Bloco D', 'conrad', 0, 0, 0),
(65, 'Bloco D', 'conrad', 0, 0, 0),
(66, 'Bloco D', 'conrad', 0, 0, 0),
(67, 'Bloco D', 'conrad', 0, 0, 0),
(68, 'Bloco F', 'augusto', 3, 2, 1),
(69, 'Bloco F', 'cesar', 2, 3, 2),
(70, 'Bloco F', 'cesar', 4, 3, 2),
(71, 'Bloco F', 'augusto', 2, 2, 1),
(72, 'Bloco G', 'augusto', 4, 4, 4),
(73, 'Bloco Y', 'augusto', 5, 4, 6);

-- --------------------------------------------------------

--
-- Estrutura da tabela `estacionamento`
--

CREATE TABLE `estacionamento` (
  `cnpj` int(14) NOT NULL,
  `nome` varchar(32) NOT NULL,
  `endereco` varchar(64) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estrutura da tabela `usuarios`
--

CREATE TABLE `usuarios` (
  `id` int(11) NOT NULL,
  `username` varchar(16) NOT NULL,
  `password` varchar(32) NOT NULL,
  `bloco` varchar(16) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `usuarios`
--

INSERT INTO `usuarios` (`id`, `username`, `password`, `bloco`) VALUES
(1, 'admin', '21232f297a57a5a743894a0e4a801fc3', '0'),
(31, 'joao', 'f85d9917d5a14dc2c7fe5cd9700303b4', 'Bloco D'),
(33, 'augusto', 'c7c4c04c9825e277a05b9c5bc29374af', 'Bloco A'),
(34, 'augusto', 'c7c4c04c9825e277a05b9c5bc29374af', 'Bloco A'),
(35, 'augusto', 'c7c4c04c9825e277a05b9c5bc29374af', 'Bloco A'),
(36, 'augusto', 'c7c4c04c9825e277a05b9c5bc29374af', 'Bloco A'),
(37, 'augusto', 'c7c4c04c9825e277a05b9c5bc29374af', 'Bloco A'),
(38, 'augusto', 'c7c4c04c9825e277a05b9c5bc29374af', 'Bloco A'),
(39, 'augusto', 'c7c4c04c9825e277a05b9c5bc29374af', 'Bloco A'),
(41, 'augusto', 'c7c4c04c9825e277a05b9c5bc29374af', 'Bloco A'),
(42, 'augusto', 'c7c4c04c9825e277a05b9c5bc29374af', 'Bloco A'),
(43, 'augusto', 'c7c4c04c9825e277a05b9c5bc29374af', 'Bloco A'),
(44, 'augusto', 'c7c4c04c9825e277a05b9c5bc29374af', 'Bloco A'),
(45, 'augusto', 'c7c4c04c9825e277a05b9c5bc29374af', 'Bloco A'),
(46, 'augusto', 'c7c4c04c9825e277a05b9c5bc29374af', 'Bloco A'),
(47, 'mariana', '2cb096973c3973431abef8708dcee352', 'Bloco A'),
(48, 'augusto', 'c7c4c04c9825e277a05b9c5bc29374af', 'Bloco A'),
(49, 'augusto', 'c7c4c04c9825e277a05b9c5bc29374af', 'Bloco A'),
(50, 'augusto', 'c7c4c04c9825e277a05b9c5bc29374af', 'Bloco A'),
(51, 'augusto', 'c7c4c04c9825e277a05b9c5bc29374af', 'Bloco A'),
(52, 'augusto', 'c7c4c04c9825e277a05b9c5bc29374af', 'Bloco A'),
(53, 'augusto', 'c7c4c04c9825e277a05b9c5bc29374af', 'Bloco A'),
(54, 'augusto', 'c7c4c04c9825e277a05b9c5bc29374af', 'Bloco A'),
(55, 'augusto', 'c7c4c04c9825e277a05b9c5bc29374af', 'Bloco A'),
(56, 'augusto', 'c7c4c04c9825e277a05b9c5bc29374af', 'Bloco A'),
(57, 'augusto', 'c7c4c04c9825e277a05b9c5bc29374af', 'Bloco A'),
(58, 'augusto', 'c7c4c04c9825e277a05b9c5bc29374af', 'Bloco A'),
(59, 'augusto', 'c7c4c04c9825e277a05b9c5bc29374af', 'Bloco A'),
(60, 'augusto', 'c7c4c04c9825e277a05b9c5bc29374af', 'Bloco A'),
(61, 'augusto', 'c7c4c04c9825e277a05b9c5bc29374af', 'Bloco A'),
(62, 'augusto', 'c7c4c04c9825e277a05b9c5bc29374af', 'Bloco A'),
(63, 'augusto', 'c7c4c04c9825e277a05b9c5bc29374af', 'Bloco A'),
(64, 'augusto', 'c7c4c04c9825e277a05b9c5bc29374af', 'null'),
(65, 'augusto', 'c7c4c04c9825e277a05b9c5bc29374af', 'null'),
(66, '', 'd41d8cd98f00b204e9800998ecf8427e', 'null'),
(67, '', 'd41d8cd98f00b204e9800998ecf8427e', 'null'),
(68, '', 'd41d8cd98f00b204e9800998ecf8427e', 'null'),
(69, 'cesar', '81dc9bdb52d04dc20036dbd8313ed055', 'null');

-- --------------------------------------------------------

--
-- Estrutura da tabela `vagas`
--

CREATE TABLE `vagas` (
  `id` int(11) NOT NULL,
  `categoria` tinyint(4) NOT NULL,
  `bloco` varchar(16) NOT NULL,
  `estado` tinyint(1) NOT NULL,
  `timestamp` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `vagas`
--

INSERT INTO `vagas` (`id`, `categoria`, `bloco`, `estado`, `timestamp`) VALUES
(22, 3, 'Bloco B', 1, '2022-11-21 17:58:25'),
(23, 1, 'Bloco B', 0, '2022-11-21 20:07:39'),
(24, 1, 'Bloco B', 0, '2022-11-21 20:05:41'),
(25, 1, 'Bloco B', 1, '2022-11-21 19:26:11'),
(26, 1, 'Bloco B', 0, '2022-11-21 19:28:45'),
(27, 1, 'Bloco B', 0, '2022-11-21 20:07:51'),
(28, 1, 'Bloco B', 1, '2022-11-21 20:07:44'),
(29, 1, 'Bloco B', 0, '2022-11-21 15:07:25'),
(30, 1, 'Bloco B', 0, '2022-11-21 15:07:25'),
(31, 1, 'Bloco B', 1, '2022-11-21 19:05:07'),
(32, 1, 'Bloco B', 0, '2022-11-21 15:07:25'),
(33, 1, 'Bloco B', 1, '2022-11-21 19:05:10'),
(34, 1, 'Bloco B', 0, '2022-11-21 15:07:25'),
(35, 1, 'Bloco B', 0, '2022-11-21 15:07:25'),
(36, 1, 'Bloco B', 1, '2022-11-21 17:59:29'),
(37, 1, 'Bloco B', 0, '2022-11-21 15:07:25'),
(38, 1, 'Bloco B', 0, '2022-11-21 15:07:25'),
(39, 1, 'Bloco B', 0, '2022-11-21 15:07:25'),
(40, 1, 'Bloco B', 0, '2022-11-21 15:07:25'),
(41, 1, 'Bloco B', 0, '2022-11-21 15:07:25'),
(42, 1, 'Bloco B', 0, '2022-11-21 15:07:25'),
(43, 1, 'Bloco B', 0, '2022-11-21 15:07:25'),
(44, 1, 'Bloco B', 0, '2022-11-21 15:07:25'),
(45, 1, 'Bloco B', 0, '2022-11-21 15:07:25'),
(46, 1, 'Bloco B', 0, '2022-11-21 15:07:25'),
(47, 1, 'Bloco B', 0, '2022-11-21 15:07:25'),
(48, 1, 'Bloco B', 0, '2022-11-21 15:07:25'),
(49, 1, 'Bloco B', 0, '2022-11-21 15:07:25'),
(50, 1, 'Bloco B', 0, '2022-11-21 15:07:25'),
(51, 1, 'Bloco B', 0, '2022-11-21 15:07:25'),
(52, 1, 'Bloco B', 0, '2022-11-21 15:07:25'),
(53, 1, 'Bloco B', 0, '2022-11-21 15:07:25'),
(54, 1, 'Bloco B', 0, '2022-11-21 15:07:25'),
(55, 1, 'Bloco B', 0, '2022-11-21 15:22:44'),
(56, 1, 'Bloco B', 0, '2022-11-21 15:26:39'),
(57, 1, 'Bloco F', 0, '2022-11-21 16:06:03'),
(58, 1, 'Bloco F', 0, '2022-11-21 16:06:03'),
(59, 1, 'Bloco F', 0, '2022-11-21 16:06:03'),
(60, 2, 'Bloco F', 0, '2022-11-21 16:06:03'),
(61, 2, 'Bloco F', 0, '2022-11-21 16:06:03'),
(62, 3, 'Bloco F', 0, '2022-11-21 16:06:03'),
(63, 1, 'Bloco F', 0, '2022-11-21 16:07:19'),
(64, 1, 'Bloco F', 0, '2022-11-21 16:07:19'),
(65, 2, 'Bloco F', 0, '2022-11-21 16:07:19'),
(66, 2, 'Bloco F', 0, '2022-11-21 16:07:19'),
(67, 2, 'Bloco F', 0, '2022-11-21 16:07:19'),
(68, 3, 'Bloco F', 0, '2022-11-21 16:07:19'),
(69, 3, 'Bloco F', 0, '2022-11-21 16:07:19'),
(70, 1, 'Bloco F', 0, '2022-11-21 16:12:09'),
(71, 1, 'Bloco F', 0, '2022-11-21 16:12:09'),
(72, 1, 'Bloco F', 0, '2022-11-21 16:12:09'),
(73, 1, 'Bloco F', 0, '2022-11-21 16:12:09'),
(74, 2, 'Bloco F', 0, '2022-11-21 16:12:09'),
(75, 2, 'Bloco F', 0, '2022-11-21 16:12:09'),
(76, 2, 'Bloco F', 0, '2022-11-21 16:12:09'),
(77, 3, 'Bloco F', 0, '2022-11-21 16:12:09'),
(78, 3, 'Bloco F', 0, '2022-11-21 16:12:09'),
(79, 1, 'Bloco G', 0, '2022-11-21 16:18:25'),
(80, 1, 'Bloco G', 0, '2022-11-21 16:18:25'),
(81, 1, 'Bloco G', 0, '2022-11-21 16:18:25'),
(82, 1, 'Bloco G', 0, '2022-11-21 16:18:25'),
(83, 2, 'Bloco G', 0, '2022-11-21 16:18:25'),
(84, 2, 'Bloco G', 0, '2022-11-21 16:18:25'),
(85, 2, 'Bloco G', 0, '2022-11-21 16:18:25'),
(86, 2, 'Bloco G', 0, '2022-11-21 16:18:25'),
(87, 3, 'Bloco G', 0, '2022-11-21 16:18:25'),
(88, 3, 'Bloco G', 0, '2022-11-21 16:18:25'),
(89, 3, 'Bloco G', 0, '2022-11-21 16:18:25'),
(90, 3, 'Bloco G', 0, '2022-11-21 16:18:25'),
(91, 1, 'Bloco Y', 0, '2022-11-21 19:25:09'),
(92, 1, 'Bloco Y', 0, '2022-11-21 19:25:09'),
(93, 1, 'Bloco Y', 0, '2022-11-21 19:25:09'),
(94, 1, 'Bloco Y', 0, '2022-11-21 19:25:09'),
(95, 1, 'Bloco Y', 0, '2022-11-21 19:25:09'),
(96, 2, 'Bloco Y', 0, '2022-11-21 19:25:09'),
(97, 2, 'Bloco Y', 0, '2022-11-21 19:25:09'),
(98, 2, 'Bloco Y', 0, '2022-11-21 19:25:09'),
(99, 2, 'Bloco Y', 0, '2022-11-21 19:25:09'),
(100, 3, 'Bloco Y', 0, '2022-11-21 19:25:09'),
(101, 3, 'Bloco Y', 0, '2022-11-21 19:25:09'),
(102, 3, 'Bloco Y', 0, '2022-11-21 19:25:09'),
(103, 3, 'Bloco Y', 0, '2022-11-21 19:25:09'),
(104, 3, 'Bloco Y', 0, '2022-11-21 19:25:09'),
(105, 3, 'Bloco Y', 0, '2022-11-21 19:25:09');

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `blocos`
--
ALTER TABLE `blocos`
  ADD PRIMARY KEY (`id`);

--
-- Índices para tabela `estacionamento`
--
ALTER TABLE `estacionamento`
  ADD PRIMARY KEY (`cnpj`);

--
-- Índices para tabela `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id`);

--
-- Índices para tabela `vagas`
--
ALTER TABLE `vagas`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `blocos`
--
ALTER TABLE `blocos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=74;

--
-- AUTO_INCREMENT de tabela `estacionamento`
--
ALTER TABLE `estacionamento`
  MODIFY `cnpj` int(14) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=70;

--
-- AUTO_INCREMENT de tabela `vagas`
--
ALTER TABLE `vagas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=106;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
