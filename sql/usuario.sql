-- phpMyAdmin SQL Dump
-- version 3.3.2deb1
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 25-07-2013 a las 01:17:46
-- Versión del servidor: 5.1.63
-- Versión de PHP: 5.3.2-1ubuntu4.17

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `tickets`
--

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
-- Volcar la base de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`id`, `apellidos`, `baja`, `correo`, `fechaAlta`, `nombre`, `password`, `sexo`, `telefono`, `usuario`, `rol_id`) VALUES
(2, '', NULL, 'Admin@localhot', NULL, 'Administrador', 'admin', b'1', 212600408596, 'admin', 1),
(3, '', NULL, 'Tecnico@localhost', NULL, 'Tecnico', '123', b'1', 212600408596, 'Tecnico', 2),
(4, '', NULL, 'Usuario@localhot', NULL, 'Usuario', 'user', b'1', 212600408596, 'user', 3),
(5, '', NULL, '', NULL, 'Usuaroio2', 'user2', b'1', 212600408596, 'user2', 3),
(6, '', NULL, '', NULL, 'Tecnico2', '123', b'0', 212600408596, 'tecnico2', 2);

--
-- Filtros para las tablas descargadas (dump)
--

--
-- Filtros para la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD CONSTRAINT `FK5B4D8B0EE2E360F7` FOREIGN KEY (`rol_id`) REFERENCES `rol` (`id`);
