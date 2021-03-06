--Create the Test schema  
CREATE SCHEMA Test ;  
GO  

CREATE SEQUENCE Test.CountBy1  
    START WITH 1  
    INCREMENT BY 1 ;  
GO

select * from proveedor

SELECT ID_PROVEEDOR,RAZ_SOC,RUC,DIRECCION,TELEFONO,ESTADO,FECHCREA,TIPO FROM PROVEEDOR


INSERT INTO PROVEEDOR(ID_PROVEEDOR,RAZ_SOC,RUC,DIRECCION,TELEFONO,ESTADO,FECHCREA,TIPO) 
VALUES (NEXT VALUE FOR Test.CountBy1,'CLARO','20467534026','LOS ALAMOS',933805027,1,SYSDATETIME(),'CELULARES')

INSERT INTO PROVEEDOR(ID_PROVEEDOR,RAZ_SOC,RUC,DIRECCION,TELEFONO,ESTADO,FECHCREA,TIPO) 
VALUES (NEXT VALUE FOR Test.CountBy1,'MOVISTAR','20467555526','LA PAZ',955305027,1,SYSDATETIME(),'CELULARES')


UPDATE PROVEEDOR SET RAZ_SOC = 'BITEL', RUC = '20467534026', DIRECCION = 'LOS ALAMOS', TELEFONO = 933805027, TIPO = 'CELULARES'
WHERE ID_PROVEEDOR = 2

