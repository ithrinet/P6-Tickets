-- phpMyAdmin SQL Dump
-- version 3.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 24-07-2013 a las 03:33:00
-- Versión del servidor: 5.5.24-log
-- Versión de PHP: 5.3.13

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `tickets`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estado`
--

CREATE TABLE IF NOT EXISTS `estado` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Volcado de datos para la tabla `estado`
--

INSERT INTO `estado` (`id`, `descripcion`, `nombre`) VALUES
(1, 'ABIERTO', 'ABIERTO'),
(2, 'CONTESTADO', 'CONTESTADO'),
(3, 'CERRADO', 'CERRADO'),
(4, 'ESPERANDO', 'ESPERANDO');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `mensaje`
--

CREATE TABLE IF NOT EXISTS `mensaje` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `asunto` varchar(255) DEFAULT NULL,
  `cuerpo` varchar(255) DEFAULT NULL,
  `mensaje` date DEFAULT NULL,
  `ticket_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK9BDD22BF2ED7CF7D` (`ticket_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=24 ;

--
-- Volcado de datos para la tabla `mensaje`
--

INSERT INTO `mensaje` (`id`, `asunto`, `cuerpo`, `mensaje`, `ticket_id`) VALUES
(1, 'User Tickets', 'User Tickets User TicketsUser Tickets User Tickets User Tickets ', '2013-07-21', 1),
(2, 'HOla de nuwbo', 'gfgdfg dg', '2013-07-21', 1),
(3, 'user tickets 3', 'user tickets 3 user tickets 3 user tickets 3 user tickets 3', '2013-07-21', 2),
(4, 'dfgdfg', 'dgdfgdf', '2013-07-21', 2),
(5, 'fffs safsafsa f', 'fasfasfsa saffs', '2013-07-21', 3),
(6, 'Usuer2 Usuer2 U', 'Usuer2 Usuer2 suer2 Usuer2 Usuer2 suer2 Usuer2 Usuer2 suer2 Usuer2 Usuer2 ', '2013-07-21', 4),
(7, 'suer2 Usuer2233', 'suer2 Usuer2 Usuer2 suer2 Usuer2 Usuer2 suer2 Usuer2 Usuer2 ', '2013-07-21', 5),
(8, 'fsdfsdfsfsdf', 'ffsf sdffsd', '2013-07-21', 2),
(9, 'vvxxvcvcxvxcvvfdsvvxvxcvxcvxcv', 'vxvcxvxcxcvxcvxcvx', '2013-07-21', 2),
(10, 'sii sii', 'siisiisiisii siisiisiisii siisiisiisii siisiisiisii siisiisiisii siisiisiisii siisiisiisii siisiisiisii siisiisiisii siisiisiisii siisiisiisii siisiisiisii siisiisiisii siisiisiisii siisiisiisii siisiisiisii siisiisiisii siisiisiisii siisiisiisii ', '2013-07-21', 3),
(11, 'sfdsfsdfsdf', 'sfdsfsdfsdfsfdsfsdfsdfsfdsfsdfsdfsfdsfsdfsdfsfdsfsdfsdf', '2013-07-21', 3),
(12, 'ffddfdfd fd ffdd df fdf', 'ffddfdfd fd ffdd df fdfffddfdfd fd ffdd df fdfffddfdfd fd ffdd df fdfffddfdfd fd ffdd df fdfffddfdfd fd ffdd df fdf', '2013-07-22', 6),
(13, 'fsfsdf sdfsdf ', 'sdfsdfsdfsd sdf', '2013-07-22', 2),
(14, 'Tickets 5', 'Tickets 5Tickets 5Tickets 5Tickets 5', '2013-07-23', 10),
(15, 'Tickets 5Tickets 5', 'Tickets 5Tickets 5Tickets 5Tickets 5Tickets 5', '2013-07-23', 11),
(16, 'fsfsafaf', 'asfsafsafsaf', '2013-07-23', 12),
(17, 'ghgdffdg fd', 'ghgdffdg fdghgdffdg fdghgdffdg fdghgdffdg fdghgdffdg fdghgdffdg fdghgdffdg fdghgdffdg fdghgdffdg fdghgdffdg fdghgdffdg fdghgdffdg fdghgdffdg fdghgdffdg fd', '2013-07-23', 13),
(18, 'ghgdffdg fd', 'ghgdffdg fdghgdffdg fdghgdffdg fdghgdffdg fdghgdffdg fdghgdffdg fdghgdffdg fdghgdffdg fdghgdffdg fdghgdffdg fd', '2013-07-23', 14),
(19, 'ghgdffdg fd', 'ghgdffdg fdghgdffdg fdghgdffdg fdghgdffdg fdghgdffdg fdghgdffdg fd', '2013-07-23', 15),
(20, 'sffsdfsd', 'sffsdfsdsffsdfsdsffsdfsdsffsdfsdsffsdfsdsffsdfsdsffsdfsd', '2013-07-23', 16),
(21, 'sffsdfsdsffsdfsdsffsdfsd', 'sffsdfsdsffsdfsdsffsdfsdsffsdfsdsffsdfsdsffsdfsd', '2013-07-23', 17),
(22, 'sffsdfsdsffsdfsd', 'sffsdfsdsffsdfsd sffsdfsdsffsdfsd sffsdfsdsffsdfsdsffsdfsd', '2013-07-23', 18),
(23, 'cyxc', 'cycy', '2013-07-24', 19);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rol`
--

CREATE TABLE IF NOT EXISTS `rol` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Volcado de datos para la tabla `rol`
--

INSERT INTO `rol` (`id`, `descripcion`, `nombre`) VALUES
(1, 'Administrador', 'Administrador'),
(2, 'Tecnico', 'Tecnico'),
(3, 'User', 'User');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ticket`
--

CREATE TABLE IF NOT EXISTS `ticket` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `fechaApertura` date DEFAULT NULL,
  `fechaCierre` date DEFAULT NULL,
  `cliente_id` bigint(20) DEFAULT NULL,
  `estado_id` bigint(20) DEFAULT NULL,
  `tecnico_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK954D572CE6C5F93D` (`estado_id`),
  KEY `FK954D572CB83EC3CB` (`cliente_id`),
  KEY `FK954D572C469E06EC` (`tecnico_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=20 ;

--
-- Volcado de datos para la tabla `ticket`
--

INSERT INTO `ticket` (`id`, `fechaApertura`, `fechaCierre`, `cliente_id`, `estado_id`, `tecnico_id`) VALUES
(1, '2013-07-21', '2013-07-21', 4, 3, NULL),
(2, '2013-07-21', '2013-07-21', 4, 2, 3),
(3, '2013-07-21', NULL, 4, 4, 3),
(4, '2013-07-21', NULL, 5, 1, 3),
(5, '2013-07-21', NULL, 5, 1, 6),
(6, '2013-07-22', NULL, 5, 1, 6),
(10, '2013-07-23', NULL, 4, 1, 3),
(11, '2013-07-23', NULL, 4, 1, 6),
(12, '2013-07-23', NULL, 4, 1, 3),
(13, '2013-07-23', NULL, 4, 1, 3),
(14, '2013-07-23', NULL, 4, 1, 3),
(15, '2013-07-23', NULL, 4, 1, 3),
(16, '2013-07-23', NULL, 4, 1, 3),
(17, '2013-07-23', NULL, 4, 1, NULL),
(18, '2013-07-23', NULL, 4, 1, 3),
(19, '2013-07-24', NULL, 2, 1, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE IF NOT EXISTS `usuario` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `apellidos` varchar(255) DEFAULT NULL,
  `baja` bit(1) DEFAULT NULL,
  `correo` varchar(255) DEFAULT NULL,
  `fechaAlta` datetime DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `sexo` bit(1) DEFAULT NULL,
  `telefono` bigint(20) DEFAULT NULL,
  `usuario` varchar(255) DEFAULT NULL,
  `rol_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK5B4D8B0EE2E360F7` (`rol_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=10 ;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`id`, `apellidos`, `baja`, `correo`, `fechaAlta`, `nombre`, `password`, `sexo`, `telefono`, `usuario`, `rol_id`) VALUES
(2, '', NULL, 'Admin@localhot', NULL, 'Administrador', 'admin', b'1', 212600408596, 'admin', 1),
(3, '', NULL, 'Tecnico@localhost', NULL, 'Tecnico', '123', b'1', 212600408596, 'Tecnico', 2),
(4, '', NULL, 'Usuario@localhot', NULL, 'Usuario', 'user', b'1', 212600408596, 'user', 3),
(5, '', NULL, '', NULL, 'Usuaroio2', 'user2', b'1', 212600408596, 'user2', 3),
(6, '', NULL, '', NULL, 'Tecnico2', '123', b'0', 212600408596, 'tecnico2', 2);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `mensaje`
--
ALTER TABLE `mensaje`
  ADD CONSTRAINT `FK9BDD22BF2ED7CF7D` FOREIGN KEY (`ticket_id`) REFERENCES `ticket` (`id`);

--
-- Filtros para la tabla `ticket`
--
ALTER TABLE `ticket`
  ADD CONSTRAINT `FK954D572C469E06EC` FOREIGN KEY (`tecnico_id`) REFERENCES `usuario` (`id`),
  ADD CONSTRAINT `FK954D572CB83EC3CB` FOREIGN KEY (`cliente_id`) REFERENCES `usuario` (`id`),
  ADD CONSTRAINT `FK954D572CE6C5F93D` FOREIGN KEY (`estado_id`) REFERENCES `estado` (`id`);

--
-- Filtros para la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD CONSTRAINT `FK5B4D8B0EE2E360F7` FOREIGN KEY (`rol_id`) REFERENCES `rol` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
