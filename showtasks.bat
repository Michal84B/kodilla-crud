call runcrud.bat
if "%ERRORLEVEL%" == "0" goto runwebsite
echo.
echo runcrud has errors
goto fail

:runwebsite
echo After tomcat start press any key
pause
start "C:\Program Files (x86)\Google\Chrome\Application\chrome.exe" http://localhost:8080/crud/v1/task/getTasks

:fail
echo.
echo There were errors.

:end
echo.
echo Website loaded.