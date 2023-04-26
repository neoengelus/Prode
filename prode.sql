-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 18-04-2023 a las 02:09:01
-- Versión del servidor: 10.4.21-MariaDB
-- Versión de PHP: 7.4.24

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `tp_final`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `equipo`
--

CREATE TABLE `equipo` (
  `codigo_iso` varchar(5) NOT NULL,
  `nombre` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `equipo`
--

INSERT INTO `equipo` (`codigo_iso`, `nombre`) VALUES
('ARG', 'Argentina'),
('AUS', 'Australia'),
('BEL', 'Bélgica'),
('BRA', 'Brasil'),
('CAN', 'Canadá'),
('CMR', 'Camerún'),
('CRC', 'Costa Rica'),
('CRO', 'Croacia'),
('DEN', 'Dinamarca'),
('ECU', 'Ecuador'),
('ESP', 'España'),
('FRA', 'Francia'),
('GBR', 'Inglaterra'),
('GER', 'Alemania'),
('GHA', 'Ghana'),
('GLS', 'Gales'),
('IRI', 'Irán'),
('JPN', 'Japón'),
('KOR', 'Corea'),
('KSA', 'Arabia Saudita'),
('MAR', 'Marruecos'),
('MEX', 'México'),
('NED', 'Países Bajos'),
('POL', 'Polonia'),
('POR', 'Portugal'),
('QAT', 'Catar'),
('SEN', 'Senegal'),
('SRB', 'Serbia'),
('SUI', 'Suiza'),
('TUN', 'Túnez'),
('URU', 'Uruguay'),
('USA', 'Estados Unidos');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `partido`
--

CREATE TABLE `partido` (
  `id_partido` int(11) NOT NULL,
  `equipoA` varchar(5) NOT NULL,
  `equipoB` varchar(5) NOT NULL,
  `golesA` int(11) DEFAULT NULL,
  `golesB` int(11) DEFAULT NULL,
  `id_ronda` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `partido`
--

INSERT INTO `partido` (`id_partido`, `equipoA`, `equipoB`, `golesA`, `golesB`, `id_ronda`) VALUES
(1, 'QAT', 'ECU', NULL, NULL, 1),
(2, 'SEN', 'NED', NULL, NULL, 1),
(3, 'QAT', 'SEN', NULL, NULL, 1),
(4, 'NED', 'ECU', NULL, NULL, 1),
(5, 'NED', 'QAT', NULL, NULL, 1),
(6, 'ECU', 'SEN', NULL, NULL, 1),
(7, 'GBR', 'IRI', NULL, NULL, 2),
(8, 'USA', 'GLS', NULL, NULL, 2),
(9, 'GBR', 'USA', NULL, NULL, 2),
(10, 'GLS', 'IRI', NULL, NULL, 2),
(11, 'GLS', 'GBR', NULL, NULL, 2),
(12, 'IRI', 'USA', NULL, NULL, 2),
(13, 'ARG', 'KSA', NULL, NULL, 3),
(14, 'MEX', 'POL', NULL, NULL, 3),
(15, 'ARG', 'MEX', NULL, NULL, 3),
(16, 'POL', 'KSA', NULL, NULL, 3),
(17, 'POL', 'ARG', NULL, NULL, 3),
(18, 'KSA', 'MEX', NULL, NULL, 3),
(19, 'FRA', 'AUS', NULL, NULL, 4),
(20, 'DEN', 'TUN', NULL, NULL, 4),
(21, 'FRA', 'DEN', NULL, NULL, 4),
(22, 'TUN', 'AUS', NULL, NULL, 4),
(23, 'TUN', 'FRA', NULL, NULL, 4),
(24, 'AUS', 'DEN', NULL, NULL, 4),
(25, 'ESP', 'CRC', NULL, NULL, 5),
(26, 'GER', 'JPN', NULL, NULL, 5),
(27, 'ESP', 'GER', NULL, NULL, 5),
(28, 'JPN', 'CRC', NULL, NULL, 5),
(29, 'JPN', 'ESP', NULL, NULL, 5),
(30, 'CRC', 'GER', NULL, NULL, 5),
(31, 'BEL', 'CAN', NULL, NULL, 6),
(32, 'MAR', 'CRO', NULL, NULL, 6),
(33, 'BEL', 'MAR', NULL, NULL, 6),
(34, 'CRO', 'CAN', NULL, NULL, 6),
(35, 'CRO', 'BEL', NULL, NULL, 6),
(36, 'CAN', 'MAR', NULL, NULL, 6),
(37, 'BRA', 'SRB', NULL, NULL, 7),
(38, 'SUI', 'CMR', NULL, NULL, 7),
(39, 'BRA', 'SUI', NULL, NULL, 7),
(40, 'CMR', 'SRB', NULL, NULL, 7),
(41, 'CMR', 'BRA', NULL, NULL, 7),
(42, 'SRB', 'SUI', NULL, NULL, 7),
(43, 'POR', 'GHA', NULL, NULL, 8),
(44, 'URU', 'KOR', NULL, NULL, 8),
(45, 'POR', 'URU', NULL, NULL, 8),
(46, 'KOR', 'GHA', NULL, NULL, 8),
(47, 'KOR', 'POR', NULL, NULL, 8),
(48, 'GHA', 'URU', NULL, NULL, 8);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pronostico`
--

CREATE TABLE `pronostico` (
  `id` int(11) NOT NULL,
  `id_partido` int(11) NOT NULL,
  `equipo` varchar(5) NOT NULL,
  `resultado` varchar(1) NOT NULL,
  `usuario` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `resultado`
--

CREATE TABLE `resultado` (
  `resultado` varchar(1) NOT NULL,
  `descripcion` varchar(30) NOT NULL,
  `puntaje` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `resultado`
--

INSERT INTO `resultado` (`resultado`, `descripcion`, `puntaje`) VALUES
('E', 'Empate', 1),
('G', 'Ganador', 3),
('P', 'Perdedor', 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ronda`
--

CREATE TABLE `ronda` (
  `id_ronda` int(11) NOT NULL,
  `descripcion` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `ronda`
--

INSERT INTO `ronda` (`id_ronda`, `descripcion`) VALUES
(1, 'Grupo A'),
(2, 'Grupo B'),
(3, 'Grupo C'),
(4, 'Grupo D'),
(5, 'Grupo E'),
(6, 'Grupo F'),
(7, 'Grupo G'),
(8, 'Grupo H'),
(9, 'Octavos'),
(10, 'Cuartos'),
(11, 'Semifinal'),
(12, 'Final');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `equipo`
--
ALTER TABLE `equipo`
  ADD PRIMARY KEY (`codigo_iso`);

--
-- Indices de la tabla `partido`
--
ALTER TABLE `partido`
  ADD PRIMARY KEY (`id_partido`),
  ADD UNIQUE KEY `equipoA` (`equipoA`,`equipoB`,`id_ronda`),
  ADD KEY `id_ronda` (`id_ronda`),
  ADD KEY `equipoB` (`equipoB`);

--
-- Indices de la tabla `pronostico`
--
ALTER TABLE `pronostico`
  ADD PRIMARY KEY (`id`),
  ADD KEY `resultado` (`resultado`),
  ADD KEY `equipo` (`equipo`),
  ADD KEY `id_partido` (`id_partido`);

--
-- Indices de la tabla `resultado`
--
ALTER TABLE `resultado`
  ADD PRIMARY KEY (`resultado`);

--
-- Indices de la tabla `ronda`
--
ALTER TABLE `ronda`
  ADD PRIMARY KEY (`id_ronda`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `partido`
--
ALTER TABLE `partido`
  MODIFY `id_partido` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=49;

--
-- AUTO_INCREMENT de la tabla `pronostico`
--
ALTER TABLE `pronostico`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `ronda`
--
ALTER TABLE `ronda`
  MODIFY `id_ronda` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `partido`
--
ALTER TABLE `partido`
  ADD CONSTRAINT `partido_ibfk_1` FOREIGN KEY (`equipoA`) REFERENCES `equipo` (`codigo_iso`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `partido_ibfk_2` FOREIGN KEY (`equipoB`) REFERENCES `equipo` (`codigo_iso`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `partido_ibfk_3` FOREIGN KEY (`id_ronda`) REFERENCES `ronda` (`id_ronda`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `pronostico`
--
ALTER TABLE `pronostico`
  ADD CONSTRAINT `pronostico_ibfk_1` FOREIGN KEY (`id_partido`) REFERENCES `partido` (`id_partido`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `pronostico_ibfk_2` FOREIGN KEY (`equipo`) REFERENCES `equipo` (`codigo_iso`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `pronostico_ibfk_3` FOREIGN KEY (`resultado`) REFERENCES `resultado` (`resultado`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
