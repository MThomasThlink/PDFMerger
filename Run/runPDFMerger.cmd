@echo off

SETLOCAL enabledelayedexpansion
cd ..
for /r . %%g in (\target\PDFMerger*.jar) do set s=%%g 
echo %s%
"C:\Program Files\Java\jdk1.8.0_231\bin\java" -jar %s% %1 %2 %3 %4 %5

pause
