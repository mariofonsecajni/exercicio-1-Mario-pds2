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
  `cd_artista` INT NOT NULL,
  `nm_artista` VARCHAR(45) NULL,
  PRIMARY KEY (`cd_artista`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `AlbumDeMusicas`.`MusicaArtista`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `AlbumDeMusicas`.`MusicaArtista` ;

CREATE TABLE IF NOT EXISTS `AlbumDeMusicas`.`MusicaArtista` (
  `cod_musica_artista` INT NOT NULL,
  `cd_artista` INT NOT NULL,
  `cod_musica` INT NOT NULL,
  PRIMARY KEY (`cod_musica_artista`),
  INDEX `fk_MusicaArtista_Artista1_idx` (`cd_artista` ASC),
  INDEX `fk_MusicaArtista_Musica1_idx` (`cod_musica` ASC),
  CONSTRAINT `fk_MusicaArtista_Artista1`
    FOREIGN KEY (`cd_artista`)
    REFERENCES `AlbumDeMusicas`.`Artista` (`cd_artista`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_MusicaArtista_Musica1`
    FOREIGN KEY (`cod_musica`)
    REFERENCES `AlbumDeMusicas`.`Musica` (`cod_musica`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
