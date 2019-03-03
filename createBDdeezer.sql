drop table ABONNE;
CREATE TABLE ABONNE
   (
    idAbonne NUMBER(6)  NOT NULL,
    nom VARCHAR2(30) NULL,
    prenom VARCHAR2(30) NULL,
    pseudo VARCHAR2(30) NULL,
    passwd VARCHAR2(30) NULL,
	CONSTRAINT PK_ABONNE PRIMARY KEY (idAbonne)  
   ) ;

drop table PLAYLIST;
CREATE TABLE PLAYLIST
   (
    idPlaylist NUMBER(6)  NOT NULL,
    nom VARCHAR2(30) NULL,
	CONSTRAINT PK_PLAYLIST PRIMARY KEY (idPlaylist)  
   ) ;

drop table ABONNE_PLAYLIST;
CREATE TABLE ABONNE_PLAYLIST
   (
    ABONNE_idAbonne NUMBER(6)  NOT NULL,
	lesPlaylist_idPlaylist NUMBER(6)  NOT NULL,
	CONSTRAINT PK_ABONNE_PLAYLIST PRIMARY KEY (ABONNE_idAbonne, lesPlaylist_idPlaylist)  
   ) ;

drop table MORCEAU;
CREATE TABLE MORCEAU
   (
    idMorceau NUMBER(6)  NOT NULL,
    artiste VARCHAR2(30) NULL,
    titre VARCHAR2(30) NULL,
	CONSTRAINT PK_MORCEAU PRIMARY KEY (idMorceau)  
   ) ;

drop table PLAYLIST_MORCEAU;
CREATE TABLE PLAYLIST_MORCEAU
   (
    PLAYLIST_idPlaylist NUMBER(6)  NOT NULL,
	lesMorceaux_idMorceau NUMBER(6)  NOT NULL,
	CONSTRAINT PK_PLAYLIST_MORCEAU PRIMARY KEY (PLAYLIST_idPlaylist, lesMorceaux_idMorceau)  
   ) ;

insert into MORCEAU values(1, 'HOLLYWOOD MON AMOUR', 'CALL ME');
insert into MORCEAU values(2, 'LUDO PIN', 'MA QUETE M A QUITTE');
insert into MORCEAU values(3, 'THE QUANTIC SOUL ORCHESTRA',   'FATHER');
insert into MORCEAU values(4, 'KASSAV',   'NOU PA BIZWEN SA');
insert into MORCEAU values(5, 'JIMMY CLIFF', 'THE HARDER THEY COME');
insert into MORCEAU values(6, 'JIMMY CLIFF', 'THE HARDER THEY COME');
insert into MORCEAU values(7, 'JOE JACKSON', 'THE HARDER THEY COME');
insert into MORCEAU values(8, 'WILLIE NELSON', 'THE HARDER THEY COME');
commit;




