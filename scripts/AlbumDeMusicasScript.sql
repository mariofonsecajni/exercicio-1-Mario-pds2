-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema AlbumDeMusicas
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema AlbumDeMusicas
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `AlbumDeMusicas` DEFAULT CHARACTER SET utf8 ;
USE `AlbumDeMusicas` ;

-- -----------------------------------------------------
-- Table `AlbumDeMusicas`.`Album`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `AlbumDeMusicas`.`Album` ;

CREATE TABLE IF NOT EXISTS `AlbumDeMusicas`.`Album` (
  `cod_album` INT NOT NULL,
  `nm_album` VARCHAR(45) NULL,
  `data` DATE NULL,
  PRIMARY KEY (`cod_album`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `AlbumDeMusicas`.`Musica`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `AlbumDeMusicas`.`Musica` ;

CREATE TABLE IF NOT EXISTS `AlbumDeMusicas`.`Musica` (
  `cod_musica` INT NOT NULL,
  `nm_musica` VARCHAR(45) NULL,
  `vl_duracao` DOUBLE NULL,
  `cod_album` INT NOT NULL,
  PRIMARY KEY (`cod_musica`),
  INDEX `fk_Musica_Album1_idx` (`cod_album` ASC),
  CONSTRAINT `fk_Musica_Album1`
    FOREIGN KEY (`cod_album`)
    REFERENCES `AlbumDeMusicas`.`Album` (`cod_album`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `AlbumDeMusicas`.`Artista`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `AlbumDeMusicas`.`Artista` ;

CREATE TABLE IF NOT EXISTS `AlbumDeMusicas`.`Artista` (
  `cod_artista` INT NOT NULL,
  `nm_artista` VARCHAR(45) NULL,
  PRIMARY KEY (`cod_artista`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `AlbumDeMusicas`.`MusicaArtista`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `AlbumDeMusicas`.`MusicaArtista` ;

CREATE TABLE IF NOT EXISTS `AlbumDeMusicas`.`MusicaArtista` (
  `cod_musica` INT NOT NULL,
  `cod_artista` INT NOT NULL,
  PRIMARY KEY (`cod_musica`, `cod_artista`),
  INDEX `fk_Musica_has_Artista_Artista1_idx` (`cod_artista` ASC),
  INDEX `fk_Musica_has_Artista_Musica_idx` (`cod_musica` ASC),
  CONSTRAINT `fk_Musica_has_Artista_Musica`
    FOREIGN KEY (`cod_musica`)
    REFERENCES `AlbumDeMusicas`.`Musica` (`cod_musica`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Musica_has_Artista_Artista1`
    FOREIGN KEY (`cod_artista`)
    REFERENCES `AlbumDeMusicas`.`Artista` (`cod_artista`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
INSERT INTO `albumdemusicas`.`artista` (`cod_artista`, `nm_artista`) VALUES ('1', 'Aline Barros');
INSERT INTO `albumdemusicas`.`artista` (`cod_artista`, `nm_artista`) VALUES ('2', 'Fernandinho');
INSERT INTO `albumdemusicas`.`artista` (`cod_artista`, `nm_artista`) VALUES ('3', 'Thalles Roberto');
INSERT INTO `albumdemusicas`.`artista` (`cod_artista`, `nm_artista`) VALUES ('4', 'Anderson Freire');
INSERT INTO `albumdemusicas`.`artista` (`cod_artista`, `nm_artista`) VALUES ('5', 'Oficina G3');

INSERT INTO `album` (`cod_album`,`nm_album`,`data`) VALUES (1,'Apaixonado','2013-01-10');
INSERT INTO `album` (`cod_album`,`nm_album`,`data`) VALUES (2,'Galileu','2015-12-10');
INSERT INTO `album` (`cod_album`,`nm_album`,`data`) VALUES (3,'Casa do Pai','2014-01-01');

