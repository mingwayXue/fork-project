@echo off

title erp_x

java -Xms1000m -Xmx2000m -cp .\conf;.\lib\*; -XX:+CreateMinidumpOnCrash com.xue.erp.ErpApplication
pause over