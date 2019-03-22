@ECHO OFF
SET SVR_HOME=C:\SocketServer
SET SVR_CLASSES_DIR=%SVR_HOME%\bin

setLocal EnableDelayedExpansion

SET JARPATH=
for /R "%SVR_HOME%/lib" %%a in (*.jar) do (
   SET JARPATH=!JARPATH!;%%a
)
SET JARPATH=!JARPATH!

SET CPATH=.;%CLASSPATH%;%SVR_CLASSES_DIR%;%JARPATH%
@ECHO ON
java -Xmx512m -cp "%CPATH%" com.multicampus.android.server.StartServer